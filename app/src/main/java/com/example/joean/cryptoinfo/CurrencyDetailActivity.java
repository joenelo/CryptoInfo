package com.example.joean.cryptoinfo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.TextView;
import com.example.joean.cryptoinfo.Helpers.Network;
import com.example.joean.cryptoinfo.Interfaces.JsonResponse;
import org.json.JSONObject;


/**
 * An activity representing a single Currency detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link CurrencyListActivity}.
 */
public class CurrencyDetailActivity extends AppCompatActivity {
    // Global variables.
    TextView textViewCoinRank;
    TextView textViewCoinName;
    TextView textViewSymbolText;
    TextView textViewCoinWorth;
    TextView textViewPriceInBCText;
    TextView textViewTotalSupply;
    TextView textViewMaxSupply;
    TextView textViewAvailableSupply;
    TextView textViewVolumeChange;
    TextView textViewPercentChange1hr;
    TextView textViewPercentChange24hr;
    TextView textViewPercentChange7day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        // Show the Back button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        // Grab extras
        Bundle extras = getIntent().getExtras();
        String coinRank = extras.getString("COIN_RANK");
        String coinName = extras.getString("COIN_NAME");
        String symbolText = extras.getString("SYMBOL_TEXT");
        String coinWorth = extras.getString("COIN_WORTH");
        String priceInBC = extras.getString("PRICE_IN_BC");
        String totalSupply = extras.getString("TOTAL_SUPPLY");
        String maxSupply = extras.getString("MAX_SUPPLY");
        String availSupply = extras.getString("AVAIL_SUPPLY");
        String volChange = extras.getString("VOLUME_CHANGE");
        String percentChange1hr = extras.getString("PERCENT_1HR");
        String percentChange24hr = extras.getString("PERCENT_24HR");
        String percentChange7Day = extras.getString("PERCENT_7DAY");

        // Grab views and plug in extras.
        textViewCoinRank = (TextView) findViewById(R.id.coinRank);
        textViewCoinRank.setText(coinRank);
        textViewCoinName = (TextView) findViewById(R.id.coinName);
        textViewCoinName.setText(coinName);
        textViewSymbolText = (TextView) findViewById(R.id.symbolText);
        textViewSymbolText.setText(symbolText);
        textViewCoinWorth = (TextView) findViewById(R.id.coinWorth);
        textViewCoinWorth.setText(coinWorth);
        textViewPriceInBCText = (TextView) findViewById(R.id.priceInBCText);
        textViewPriceInBCText.setText(priceInBC);
        textViewTotalSupply = (TextView) findViewById(R.id.totalSupplyText);
        textViewTotalSupply.setText(totalSupply);
        textViewMaxSupply = (TextView) findViewById(R.id.maxSupplyText);
        textViewMaxSupply.setText(maxSupply);
        textViewAvailableSupply = (TextView) findViewById(R.id.availableSupplyText);
        textViewAvailableSupply.setText(availSupply);
        textViewVolumeChange = (TextView) findViewById(R.id.volumeChangeText);
        textViewVolumeChange.setText(volChange);
        textViewPercentChange1hr = (TextView) findViewById(R.id.percentChange1hrText);
        textViewPercentChange1hr.setText(percentChange1hr);
        textViewPercentChange24hr = (TextView) findViewById(R.id.percentChange24hrText);
        textViewPercentChange24hr.setText(percentChange24hr);
        textViewPercentChange7day = (TextView) findViewById(R.id.percentChange7dText);
        textViewPercentChange7day.setText(percentChange7Day);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }
}
