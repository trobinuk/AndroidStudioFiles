package com.example.checkyourriskscore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class activity_third extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    final ListView lView = (ListView) findViewById(R.id.lvMain);

    String[] from = {"name_item"};
    int[] to = {R.id.name_item};
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();
    HashMap<String, String> hashmap;

        /*try {
        JSONObject json = new JSONObject(rawJSON);
        Log.d("tgyu",json.toString());
        //JSONArray jArray = json.getJSONArray("Location");
        String nameOS = "";
        //for (int i = 0; i < json.length(); i++) {
        //JSONObject friend = json.getJSONObject(i);

        nameOS = json.getString("Location");
        Log.d("FOR_LOG", nameOS);

        hashmap = new HashMap<String, String>();
        hashmap.put("name_item", "" + nameOS);
        arrayList.add(hashmap);
        //}

        final SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, arrayList, R.layout.item, from, to);
        lView.setAdapter(adapter);

    } catch (
    JSONException e) {
        e.printStackTrace();
    }*/
}