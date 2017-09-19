package com.app.inv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.inv.designproject.R;

import java.util.ArrayList;

public class RecyclerAdapterInvestmentHistory extends RecyclerView.Adapter<RecyclerAdapterInvestmentHistory.MyViewHolder> {

    private ArrayList<InvestmentHistory_setterGetter> arrayList = new ArrayList<>();
    private Context context;

    public RecyclerAdapterInvestmentHistory(Context context, ArrayList<InvestmentHistory_setterGetter> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_investment_history, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.text_hisAcknowledgement.setText(arrayList.get(position).getAck());
        holder.text_hisAmount.setText(arrayList.get(position).getAmount());
        holder.text_hisTenure.setText(arrayList.get(position).getTenure());
        holder.text_hisInterest.setText(arrayList.get(position).getInterest());
        holder.text_hisStatus.setText(arrayList.get(position).getStatus());

        holder.btn_hisShowDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String status = holder.text_hisStatus.getText().toString();
                switch (status){
                    case "Pending Verification":
                        ((MainActivity)context).replaceFragment(new PendingVerificationFragment(), R.string.title_pendingVerification);
                    //    Toast.makeText(context, status, Toast.LENGTH_SHORT).show();
                        break;
                    case "Pending Payment":
                        ((MainActivity)context).replaceFragment(new PendingPaymentFragment(), R.string.title_pendingPayment);
                    //    Toast.makeText(context, status, Toast.LENGTH_SHORT).show();
                        break;
                    case "Active":
                        ((MainActivity)context).replaceFragment(new PaymentActiveFragment(), R.string.title_paymentActive);
                    //    Toast.makeText(context, status, Toast.LENGTH_SHORT).show();
                        break;
                    case "Reinvestment":
                        ((MainActivity)context).replaceFragment(new ReInvestmentFragment(), R.string.title_reInvestment);
                        //    Toast.makeText(context, status, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView text_hisAcknowledgement, text_hisAmount, text_hisTenure, text_hisInterest, text_hisStatus;
        private Button btn_hisShowDetails;

        public MyViewHolder(View itemView) {
            super(itemView);
            text_hisAcknowledgement = (TextView)itemView.findViewById(R.id.text_hisAcknowledgement);
            text_hisAmount = (TextView)itemView.findViewById(R.id.text_hisAmount);
            text_hisTenure = (TextView)itemView.findViewById(R.id.text_hisTenure);
            text_hisInterest = (TextView)itemView.findViewById(R.id.text_hisInterest);
            text_hisStatus = (TextView)itemView.findViewById(R.id.text_hisStatus);
            btn_hisShowDetails = (Button) itemView.findViewById(R.id.btn_hisShowDetails);
        }
    }
}

