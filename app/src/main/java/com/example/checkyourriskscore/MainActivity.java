package com.example.checkyourriskscore;

import android.os.Bundle;

import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.net.Network;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.checkyourriskscore.databinding.ActivityMainBinding;

import android.content.Intent;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    String jsonOutput = "";

    NetworkDAO networkDAO;
    public MainActivity() {
        networkDAO = new NetworkDAO();
    }
    ///networkDAO = new NetworkDAO();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        getSupportActionBar().setTitle("Check your Risk Score");

        Button btn = (Button)findViewById(R.id.button2);
        EditText sendText = findViewById(R.id.inputName);
        ///String url = "https://jsonplaceholder.typicode.com/todos/1";
        ///String url = "http://167.99.146.107:80";///http://167.99.146.107:80
        ///String url = "http://167.99.146.107:443";
        ///String url = "https://dummyjson.com/products/1";
        ///String url = "http://127.0.0.1:5000/?searchName=Adela%20Williams";
        ///String url = "http://144.167.230.11:5000";
        ///Log.d("bcd123","bcd1234");



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getName = sendText.getText().toString();
                Log.d("qwert",getName);
                //Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                Intent intent = new Intent(MainActivity.this,ActivityRecycler.class);
                ///intent.putExtra("name",getName);
                ///Log.d("abcd123","abcd1234");
                ///String jsonOutput = "hellobvh";
                ///Response.ErrorListener jsonRequest = null; Request.Method.GET
                ///String url = "https://jsonplaceholder.typicode.com/todos/1";
                ///String url = "http://127.0.0.1:2000/result"; Ollie Hooper API in 11 mins
                ///String url = "http://127.0.0.1:5000";
                //@Override
                //public void search(String searchTerm)  throws IOException {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                try {
                    //String url = "https://jsonplaceholder.typicode.com/todos/1";
                    //String url = "http://167.99.146.107:80/?searchName="+getName;
                    //String url = "http://127.0.0.1:5000/?searchName="+getName;
                    String url = "http://134.209.123.92:5000/?searchName="+getName;
                    Log.d("point", "abcd1234");
                    String rawJSON = networkDAO.request(url);
                    //String rawJSON = "hbvjhbj";
                    //rawJSON= "{\"Name\": \"Ricky Ponting\",\"Birth Place\":	\"Launceston, Tasmania\",\"Date_of_Birth\":	\"19-Dec-74\",\"Twitter ID\":	\"rickyponting\",\"Instagram ID\":	\"@rickyponting\"}";
                    String name = "{\"Name\": [\"" + getName + "\"],";
                    rawJSON = name + rawJSON.substring(1);
                    Log.d("asdf",rawJSON);
                    //rawJSON = "Birth Place Launceston, Tasmania\n";
                    intent.putExtra("name",rawJSON);
                    startActivity(intent);
                }
               catch(IOException e)
                {
                    Log.d("abcd123","abcd1234");
                }
            }
        });

    }

}