package com.example.checkyourriskscore;

///package edu.uc.jonesbr.plantplaces.dao;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Perform common data-agnostic network operations.
 * Created by ucint on 3/1/2023.
 */

public class NetworkDAO {

    /**
     * Return the data found at the given URL
     * @param uri the location for the data
     * @return the raw data found at this location.
     */
    public String request(String uri ) throws IOException {
        StringBuilder sb = new StringBuilder();
        Log.d("url1", uri);
        // construct a URL in the correct format
        URL url = new URL(uri);
        Log.d("url2.0", uri);
        ///Log.d("url2", url);
        // open a connection to this URL
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            // get an input stream to read the bits
            InputStream inputStream = urlConnection.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            // get a reader to turn the bits into a String.
            InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            Log.d("url4","hello");
            // read one line at a time.
            String inputLine = bufferedReader.readLine();
            Log.d("inputLine1", inputLine);
            while (inputLine != null) {
                // add this to our running String Builder.
                sb.append(inputLine);

                // read the next line
                inputLine = bufferedReader.readLine();
            }
        }
        catch(Exception e){
            ///System.out.println(e.getMessgae())
            Log.d("error 234",e.getMessage());
        } finally {
            urlConnection.disconnect();
        }

        return sb.toString();
    }
}
