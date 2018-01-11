package com.example.amirz.appcinema;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amirz on 1/10/2018.
 */

public class MoviesActivity extends AppCompatActivity {
    RecyclerView recyclerView2;

    //  private static final String URL_DATA="http://188.166.60.39:8000/cinemas";
    private static final String URL_DATA ="http://188.166.60.39:8000/films/6";



    RecyclerView.Adapter adapter;
    List<MovieItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        recyclerView2 = (RecyclerView)findViewById(R.id.recycler_view_movies);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        listItems= new ArrayList<>();
        TakeDataFromJson();

    }

    private void TakeDataFromJson() {

        StringRequest requestData = new StringRequest(Request.Method.GET, URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {

                        try {
                        JSONArray array = new JSONArray(s);

                            for (int i = 0; i<array.length(); i++){
                                JSONObject o = array.getJSONObject(i);
                                MovieItem item = new MovieItem(
                                        o.getString("title"),
                                        o.getString("imgUrl")
                                );
                                listItems.add(item);
                            }

                            adapter = new MoviesAdapter(listItems,getApplicationContext());
                            recyclerView2.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(requestData);


    }
}
