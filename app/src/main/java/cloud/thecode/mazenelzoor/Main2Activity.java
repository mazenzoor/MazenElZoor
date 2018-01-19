package cloud.thecode.mazenelzoor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ListView listView;
    private Button get_map;
    String topic;
    double minPrice, maxPrice;

    String pubName;
    String pubRegion;
    String pubLong;
    String pubLat;
    int id;

    Book temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = (ListView) findViewById(R.id.listview);
        get_map = (Button) findViewById(R.id.get_map);

        // Take the parameters from previous activity and create a query to get
        // books in that range

        DBHelper dbh = new DBHelper(getApplicationContext());


        minPrice = Double.parseDouble(getIntent().getStringExtra("min"));
        maxPrice = Double.parseDouble(getIntent().getStringExtra("max"));
        topic = getIntent().getStringExtra("topic");


        ArrayList<Book> beforePublisher = dbh.findBook(topic, minPrice, maxPrice);
        ArrayList<Book> afterPublisher = new ArrayList<>();


        for(int i=0; i<beforePublisher.size(); i++) {
            temp = beforePublisher.get(i);
            Toast.makeText(this, "i " + i, Toast.LENGTH_SHORT).show();

            id = temp.getID();

            Toast.makeText(this, "ID: " + id, Toast.LENGTH_SHORT).show();

            // Run Volley

            RequestQueue rq = Volley.newRequestQueue(getApplicationContext());

            JsonArrayRequest jr = new JsonArrayRequest("http://app-1515400395.000webhostapp.com/getPublisher.php", new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    for(int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);

                            if(id == Integer.parseInt(jsonObject.getString("PublisherID"))) {
                                pubLong = jsonObject.getString("Longitude");
                                pubLat = jsonObject.getString("Latitude");
                                pubName = jsonObject.getString("PublisherName");
                                pubRegion = jsonObject.getString("Region");
                                temp.setPublisherName(pubName);
                                temp.setPublisherRegion(pubRegion);
                                temp.setLatitude(pubLat);
                                temp.setLongitude(pubLong);
                            }


                        } catch (Exception ex) {
                            Toast.makeText(Main2Activity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                        }


                    }

                    //someArrayAdapter.notifyDataSetChanged();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Main2Activity.this, error.toString(), Toast.LENGTH_SHORT).show();
                }
            });

            rq.add(jr);


            Toast.makeText(this, "Got " + pubName, Toast.LENGTH_SHORT).show();
        } //end loop


        // Array adpater to fill list view
        temp = new Book(1, 1, "Introduction to java programming", "Daniel Liang", "Programming","Pearson Education", "London", "51.51", "0.13", 20);
        afterPublisher.add(temp);

        ArrayAdapter<Book> adapter = new ArrayAdapter<Book>(getApplicationContext(), android.R.layout.simple_list_item_1, afterPublisher);
        listView.setAdapter(adapter);


        get_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);
                i.putExtra("longitude", temp.getLongitude());
                i.putExtra("latitude", temp.getLatitude());
                startActivity(i);
            }
        });


    }




}
