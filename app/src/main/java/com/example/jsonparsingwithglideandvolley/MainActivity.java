package com.example.jsonparsingwithglideandvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.jsonparsingwithglideandvolley.Adopter.RecyclerViewAdapter;
import com.example.jsonparsingwithglideandvolley.Class.AboutMovies;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String JSON_URL =  "https://api.myjson.com/bins/m5ale";
    private JsonArrayRequest ArrayRequest ;
    private RequestQueue requestQueue ;
    private List<AboutMovies> list_movies_main;
    private RecyclerView recyclerView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_movies_main = new ArrayList<>();
        recyclerView = findViewById(R.id.movie_recyclerview);


        jsoncall();
    }

    public void jsoncall() {

        ArrayRequest = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for (int i =0 ; i<response.length() ; i++){

                    try {
                        jsonObject = response.getJSONObject(i);
                        AboutMovies aboutMovies_json = new AboutMovies();

                        aboutMovies_json.setName(jsonObject.getString("name"));
                        aboutMovies_json.setRating(jsonObject.getString("Rating"));
                        aboutMovies_json.setCategories(jsonObject.getString("categorie"));
                        aboutMovies_json.setEpisode(jsonObject.getInt("episode"));
                        aboutMovies_json.setDescription(jsonObject.getString("description"));
                        aboutMovies_json.setStudio(jsonObject.getString("studio"));
                        aboutMovies_json.setImg(jsonObject.getString("img"));

                        list_movies_main.add(aboutMovies_json);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setuprecyclerview(list_movies_main);

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(ArrayRequest);

    }

    private void setuprecyclerview(List<AboutMovies> list_movies_main) {

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this,list_movies_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);
    }

}
