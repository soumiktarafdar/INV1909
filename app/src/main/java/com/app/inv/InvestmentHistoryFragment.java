package com.app.inv;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.inv.designproject.R;

import java.util.ArrayList;

public class InvestmentHistoryFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private ArrayList<InvestmentHistory_setterGetter> arrayList_investmentHistory= new ArrayList<InvestmentHistory_setterGetter>();
    private RecyclerView recyclerView;
    private RecyclerAdapterInvestmentHistory mRecyclerAdapterInvestmentHistory;
    private RecyclerView.LayoutManager layoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_investment_history, container, false);
        Button btn_investPrefSubmit = (Button)view.findViewById(R.id.btn_investPrefSubmit);
        MainActivity.toolbar_home.setText(R.string.title_investmentHistory);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipeRefreshLayout);

        arrayList_investmentHistory.add(new InvestmentHistory_setterGetter("ACK1234", "10,000", "5 Years", "1.6%", "Pending Verification"));
        arrayList_investmentHistory.add(new InvestmentHistory_setterGetter("ACK2345", "15,000", "6 Years", "1.4%", "Pending Payment"));
        arrayList_investmentHistory.add(new InvestmentHistory_setterGetter("ACK2143", "20,000", "7 Years", "1.7%", "Active"));
        arrayList_investmentHistory.add(new InvestmentHistory_setterGetter("ACK2153", "22,000", "8 Years", "1.6%", "Reinvestment"));

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerAdapterInvestmentHistory = new RecyclerAdapterInvestmentHistory(getActivity(), arrayList_investmentHistory);
        recyclerView.setAdapter(mRecyclerAdapterInvestmentHistory);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(swipeRefreshLayout.isRefreshing()){
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
      /*  // Set title
        getActivity().getActionBar()
                .setTitle(R.string.title_investmentHistory);*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
