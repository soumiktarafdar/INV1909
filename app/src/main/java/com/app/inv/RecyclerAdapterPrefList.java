package com.app.inv;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.inv.designproject.R;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class RecyclerAdapterPrefList extends RecyclerView.Adapter<RecyclerAdapterPrefList.MyViewHolder> {

    private ArrayList<PrefList_SetterGetter> arrayList = new ArrayList<>();
    private Context context;

    public RecyclerAdapterPrefList(Context context, ArrayList<PrefList_SetterGetter> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_my_preference, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.text_amount.setText(arrayList.get(position).getAmount());
        holder.text_rate.setText(arrayList.get(position).getRate());
        holder.text_tenure.setText(arrayList.get(position).getTenure());
        holder.text_dateTime.setText(arrayList.get(position).getDate());


        holder.image_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Search Option", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView text_amount, text_rate, text_tenure, text_dateTime;
        private ImageView image_search;

        public MyViewHolder(View itemView) {
            super(itemView);
            text_amount = (TextView)itemView.findViewById(R.id.text_amount);
            text_rate = (TextView)itemView.findViewById(R.id.text_rate);
            text_tenure = (TextView)itemView.findViewById(R.id.text_tenure);
            text_dateTime = (TextView)itemView.findViewById(R.id.text_dateTime);
            image_search = (ImageView) itemView.findViewById(R.id.image_search);
        }
    }
}

