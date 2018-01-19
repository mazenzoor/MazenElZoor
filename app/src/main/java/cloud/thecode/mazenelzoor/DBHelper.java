package cloud.thecode.mazenelzoor;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Mazen on 1/19/2018.
 */



public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "FinalExam", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE book (ID integer primary key autoincrement, name text, authors_name text, price double(10), topic text, publisherID integer)");
        db.rawQuery("INSERT INTO book(name, authors_name, price, topic, publisherID) VALUES ('Introduction to programming', 'Daniel Liang', 20, 'Programming', 1)", null);
        db.rawQuery("INSERT INTO book(name, authors_name, price, topic, publisherID) VALUES ('Complex networks', 'Olaf sporns', 25, 'Networking', 2)", null);
        db.rawQuery("INSERT INTO book(name, authors_name, price, topic, publisherID) VALUES ('Flexible manifold embedding', 'Fepping nie', 15, 'Machine learning', 2)", null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS book");
        onCreate(db);
    }

    public ArrayList<Book> findBook(String topic, double priceMin, double priceMax) {
        ArrayList<Book> books = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM book", null);

        Book b;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                b = new Book();

                if(cursor.getString(4).equalsIgnoreCase(topic) && cursor.getDouble(3) >= priceMin && cursor.getDouble(3) <= priceMax) {
                    b.setID(cursor.getInt(0));
                    b.setName(cursor.getString(1));
                    b.setAuthors_name(cursor.getString(2));
                    b.setPrice(cursor.getDouble(3));
                    b.setTopic(cursor.getString(4));
                    b.setPublishID(cursor.getInt(5));
                    books.add(b);
                }
            }
        }
        cursor.close();
        return books;

    }
}
