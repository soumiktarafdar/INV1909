package com.app.inv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.inv.designproject.R;

import java.util.ArrayList;

public class RecyclerAdapterPrefResult extends RecyclerView.Adapter<RecyclerAdapterPrefResult.MyViewHolder> {

    private ArrayList<PrefResult_SetterGetter> arrayList = new ArrayList<>();
    private Context context;

    public RecyclerAdapterPrefResult(Context context, ArrayList<PrefResult_SetterGetter> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_pref_result, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.imageView_Logo.setImageResource(arrayList.get(position).getImage());
        holder.text_planOne.setText(arrayList.get(position).getPlanOne());
        holder.text_planTwo.setText(arrayList.get(position).getPlanTwo());

        holder.btn_makeRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //    ((MainActivity)context).replaceFragment(new InvestmentHistoryFragment(), R.string.title_investmentDetailHistory);
                ((MainActivity)context).replaceFragment(new InvestmentDetailsFragment(), R.string.title_investmentDetails);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView text_planOne, text_planTwo;
        private ImageView imageView_Logo;
        private Button btn_makeRequest;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView_Logo = (ImageView) itemView.findViewById(R.id.imageView_Logo);
            text_planOne = (TextView)itemView.findViewById(R.id.text_planOne);
            text_planTwo = (TextView)itemView.findViewById(R.id.text_planTwo);
            btn_makeRequest = (Button) itemView.findViewById(R.id.btn_makeRequest);
        }
    }
}

