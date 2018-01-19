package cloud.thecode.mazenelzoor;

import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Mazen on 1/19/2018.
 */

public class Publisher {
    int publisherID;
    String name;
    String region, longitude, latitude;

    public Publisher(int publisherID) {
        this.publisherID = publisherID;
    }

    public String toString() {
        // Get publisher information using his ID and print his info



        return "Publisher: " + name + "\nRegion: " + region;
    }
}
