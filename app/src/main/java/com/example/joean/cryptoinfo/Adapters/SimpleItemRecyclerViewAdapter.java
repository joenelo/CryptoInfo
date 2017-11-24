package com.example.joean.cryptoinfo.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joean.cryptoinfo.CurrencyDetailActivity;
import com.example.joean.cryptoinfo.CurrencyListActivity;
import com.example.joean.cryptoinfo.R;
import com.example.joean.cryptoinfo.dummy.DummyContent;
import java.util.List;

public class SimpleItemRecyclerViewAdapter extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

    private final CurrencyListActivity mParentActivity;
    private final List<DummyContent.DummyItem> mValues;
    private final boolean mTwoPane;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DummyContent.DummyItem item = (DummyContent.DummyItem) view.getTag();

            Context context = view.getContext();
            Intent intent = new Intent(context, CurrencyDetailActivity.class);
            intent.putExtra("COIN_RANK", item.coinRank);
            intent.putExtra("COIN_NAME", item.coinName);
            intent.putExtra("SYMBOL_TEXT", item.symbolText);
            intent.putExtra("COIN_WORTH", item.coinWorth);
            intent.putExtra("PRICE_IN_BC", item.priceInBCText);
            intent.putExtra("TOTAL_SUPPLY", item.totalSupplyText);
            intent.putExtra("MAX_SUPPLY", item.maxSupplyText);
            intent.putExtra("AVAIL_SUPPLY", item.availableSupplyText);
            intent.putExtra("VOLUME_CHANGE", item.volumeChangeText);
            intent.putExtra("PERCENT_1HR", item.percentChange1hrText);
            intent.putExtra("PERCENT_24HR", item.coinChangePercent);
            intent.putExtra("PERCENT_7DAY", item.percentChange7dText);

            context.startActivity(intent);
        }
    };

    public SimpleItemRecyclerViewAdapter(CurrencyListActivity parent, List<DummyContent.DummyItem> items, boolean twoPane) {
        mValues = items;
        mParentActivity = parent;
        mTwoPane = twoPane;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.currency_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.rankNumber.setText(mValues.get(position).coinRank);
        holder.coinName.setText(mValues.get(position).coinName);
        holder.changePercent.setText(mValues.get(position).coinChangePercent);
        holder.worth.setText(mValues.get(position).coinWorth);


        double d = Double.parseDouble(String.valueOf(mValues.get(position).coinChangePercent));
        if(d > 0){
            holder.worth.setBackgroundResource( R.drawable.backblue);
           // holder.changePercent.setTextColor(getResources().getColorStateList(R.color.​));

        }else {
            holder.worth.setBackgroundResource( R.drawable.backred);

        }

        holder.itemView.setTag(mValues.get(position));
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView rankNumber;
        final TextView coinName;
        final TextView changePercent;
        final TextView worth;

        ViewHolder(View view) {
            super(view);
            rankNumber = (TextView) view.findViewById(R.id.rankNumber);
            coinName = (TextView) view.findViewById(R.id.coinName);
            changePercent = (TextView) view.findViewById(R.id.changePercent24hr);
            worth = (TextView) view.findViewById(R.id.amountWorth);
            worth.setSelected(true);
            changePercent.setSelected(true);
            coinName.setSelected(true);

        }
    }


}
