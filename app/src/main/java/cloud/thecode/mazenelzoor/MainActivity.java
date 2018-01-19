package cloud.thecode.mazenelzoor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner topics;
    private EditText min, max;
    private Button show;
    private String[] the_topics = {"Programming", "Networking", "Machine Learning"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topics = (Spinner) findViewById(R.id.topic);
        min = (EditText) findViewById(R.id.min);
        max = (EditText) findViewById(R.id.max);
        show = (Button) findViewById(R.id.show_books);



        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, the_topics);
        topics.setAdapter(arrayAdapter);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String minPrice = min.getText().toString();
                String maxPrice = max.getText().toString();

                if(minPrice != "" && maxPrice != "") {
                    Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                    i.putExtra("min", minPrice);
                    i.putExtra("max", maxPrice);
                    i.putExtra("topic", topics.getSelectedItem().toString());
                    startActivity(i);
                }
            }
        });

    }
}
