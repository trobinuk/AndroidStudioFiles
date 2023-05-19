package com.example.checkyourriskscore;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ActivityRecycler extends AppCompatActivity {

    NetworkDAO networkDAO;
    public ActivityRecycler() {
        networkDAO = new NetworkDAO();}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        String receivedValue = getIntent().getStringExtra("name");
        //String url = "http://134.209.123.92:5000/?searchName="+receivedValue;
        //String rawJSON = networkDAO.request(url);
        Log.d("point123 ", receivedValue);

        List<Item> items = new ArrayList<Item>();
        //items.add(new Item("Name","Ricky Ponting"));
        //items.add(new Item("Birth Place","Launceston, Tasmania"));
        //items.add(new Item("Date_of_Birth","19-Dec-74"));
        //items.add(new Item("Twitter ID","rickyponting"));
        //items.add(new Item("Instagram ID","@rickyponting"));

        //items.add(new Item("Name","Madhu Tejaswi"));
        //items.add(new Item("Phone","(703) 462-8591"));
        //items.add(new Item("Facebook ID","Madhu-Tejaswi"));
        //items.add(new Item("Twitter ID","different_madhu_chandra"));
        //items.add(new Item("Instagram ID","@rickyponting"));
        //items.add(new Item("Linkedin ID","madhu-tejaswi-6b36411b4"));

        //items.add(new Item("Name","Franklin Maclin"));
        //items.add(new Item("Address","2643 Candlewood Road, Viola, AR 72583"));
        //items.add(new Item("Birth Place","Alabama"));
        //items.add(new Item("Date_of_Birth","23 Feb 1859"));
        //items.add(new Item("Phone","(870) 458-2180"));
        //items.add(new Item("Instagram ID","franklinmacklin"));
        //items.add(new Item("Email ID","service@maclinstudio.com"));

        //items.add(new Item("Name","Robinson Tamilselvan"));
        //items.add(new Item("Address","India"));
        //items.add(new Item("Date_of_Birth","23 Feb 1859"));
        //items.add(new Item("Phone","501-916-5645"));
        //items.add(new Item("LinkedIn Profile","robinson-tamilselvan-18a00812a"));
        //items.add(new Item("Email ID","service@maclinstudio.com"));



        // Assuming the JSON string is stored in a variable called jsonString
        //String jsonString = "{\"Location\": [\"UK\"], \"Phone\": [\"+44 (0)20 7786 6115\", \"+44 20 7786 6100\", \"+44 20 7786 6115\", \"+44 20 7330 7500\", \"212 318 2000\"], \"Email\": [\"adela.williams@arnoldporter.com\", \"Williams@arnoldporter.com\", \"Williams@adeleebeth48\"]}";

        try {
            JSONObject jsonObject = new JSONObject(receivedValue);

            // Get the keys in the JSON object
            JSONArray keys = jsonObject.names();

            // Loop through the keys
            for (int i = 0; i < keys.length(); i++) {
                String key = keys.getString(i);

                // Get the array of values for the current key
                JSONArray valuesArray = jsonObject.getJSONArray(key);

                // Get the first value from the values array
                String firstValue = valuesArray.getString(0);

                // Print the key and the first value
                Log.d("key ", key);
                Log.d("First Value: ",firstValue);
                //System.out.println("Key: " + key);
                //System.out.println("First Value: " + firstValue);

                items.add(new Item(key,firstValue));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //items.add(new Item("Name","Ningning Wu"));
        //items.add(new Item("Address","Little Rock"));
        //items.add(new Item("Date_of_Birth","23 Feb 1859"));
        //items.add(new Item("Phone","501-916-5232"));
        //items.add(new Item("LinkedIn Profile","dr-ningning-wu-53892a35"));
        //items.add(new Item("Email ID","nxwu@ualr.edu"));
        //items.add(new Item("Facebook ID","wu.xiaoning.3"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));
    }
}