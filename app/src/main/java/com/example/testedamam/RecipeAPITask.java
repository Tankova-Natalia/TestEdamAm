package com.example.testedamam;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RecipeAPITask extends AsyncTask<Request, Void, Response> {
    final MainActivity activity;

    public RecipeAPITask(MainActivity activity) {
        this.activity = activity;
    }

    public Response requestToServer(Request req) {
        Gson gson = new Gson();

        String API_URL = "https://pixabay.com/api";

        try {
            String urlString = API_URL + "?" + req.formDataToString();
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // если сервер PixaBay переадресует нас на другой URL, сделать повторный запрос
            /*while (connection.getResponseCode() == 301) {
                Log.d("mytag", "HTTP code: " + connection.getResponseCode());
                String location = connection.getHeaderField("Location");
                Log.d("mytag", "Redirection to: " + connection.getHeaderField("Location"));
                url = new URL(location); connection = (HttpURLConnection) url.openConnection();
            }*/

            InputStream stream = connection.getInputStream();
            Response response = gson.fromJson(new InputStreamReader(stream), Response.class);
            return response;

        } catch (IOException e) {
            Log.d("mytag", e.getLocalizedMessage());
            return null; }
    }
    @Override
    protected Response doInBackground(Request... requests) {
        Request r = requests[0];
        return requestToServer(r);
    }
    protected void onPostExecute(Response response) {
        activity.displayResult(response.toString());
        }
}
