package com.example.joean.cryptoinfo.Helpers;

import android.os.AsyncTask;
import android.util.Log;

import com.example.joean.cryptoinfo.Interfaces.JsonResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class Network extends AsyncTask<Void, Void, JSONArray> {

    public JsonResponse delegate = null;
    private String urlString;

    public Network(String url){
        this.urlString = url;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected JSONArray doInBackground(Void... params) {
        URLConnection urlConn = null;
        BufferedReader bufferedReader = null;

        // Perform the request.
        try {
            URL url = new URL(urlString);
            urlConn = (URLConnection) url.openConnection();
            urlConn.connect();
            InputStream stream = urlConn.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer stringBuffer = new StringBuffer();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }

            return new JSONArray(stringBuffer.toString());
        }
        catch(Exception ex)
        {
            Log.e("App", "yourDataTask", ex);
            return null;
        }
        finally
        {
            if(bufferedReader != null) {
                try {
                    bufferedReader.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onPostExecute(JSONArray response) {
        delegate.Success(response);
    }
}
