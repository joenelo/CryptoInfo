package com.example.joean.cryptoinfo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joean.cryptoinfo.Adapters.SimpleItemRecyclerViewAdapter;
import com.example.joean.cryptoinfo.Helpers.Network;
import com.example.joean.cryptoinfo.Interfaces.JsonResponse;
import com.example.joean.cryptoinfo.dummy.DummyContent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * An activity representing a list of Currencies. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link CurrencyDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class CurrencyListActivity extends AppCompatActivity implements JsonResponse {

    /**
     * Create variables.
     */
    private boolean mTwoPane;
    com.example.joean.cryptoinfo.Helpers.Network jsonRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());


        /**
         * DO the API call.
         */
        //jsonRequest = new Network("https://www.cryptocompare.com/api/data/coinlist/");

        // already calling this API Successfully
        jsonRequest = new Network("https://api.coinmarketcap.com/v1/ticker/");
        jsonRequest.delegate = this;
        jsonRequest.execute();


        if (findViewById(R.id.currency_detail_container) != null) {
            // The detail container view will be present only in the large-screen layouts (res/values-w900dp).
            mTwoPane = true;
        }


        // Add dummy items.
//        for(int i=0; i<25; i++) {
//            DummyContent.ITEMS.add(new DummyContent.DummyItem("rank", "Logo", "Name", "%", "2 dolla"));
//        }


    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void Success(JSONArray response) {
        try {
            //JSONArray arr = new JSONArray(response);
            for(int i=0; i<response.length(); i++) {
                JSONObject object = response.getJSONObject(i);

                // Grabbing data from API
                String rank = object.getString("rank");
                String name = object.getString("name");
                String symbol = object.getString("symbol");
                String price_usd = object.getString("price_usd");
                String price_btc = object.getString("price_btc");
                String volume_24hr = object.getString("24h_volume_usd");
                String available_supply = object.getString("available_supply");
                String total_supply = object.getString("total_supply");
                String max_supply = object.getString("max_supply");
                String percent_change_1h = object.getString("percent_change_1h");
                String percent_change_24h = object.getString("percent_change_24h");
                String percent_change_7d = object.getString("percent_change_7d");


                // Plugging API data into Items list which will get used by recycler view.
                DummyContent.ITEMS.add(new DummyContent.DummyItem(rank, name, symbol, price_usd, price_btc, volume_24hr, available_supply, total_supply, max_supply, percent_change_1h, percent_change_24h, percent_change_7d));
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }


        // Setup and initialize the recycler view which will display the items.
        View recyclerView = findViewById(R.id.currency_list);
        assert recyclerView != null;
        ((RecyclerView) recyclerView).setAdapter(new SimpleItemRecyclerViewAdapter(this, DummyContent.ITEMS, mTwoPane));
    }
}
