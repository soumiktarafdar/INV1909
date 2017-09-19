package com.app.inv;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.app.inv.designproject.R;

import java.util.ArrayList;
import java.util.List;

public class MyPreferenceFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private List<String> spinner1Data = new ArrayList<String>();
    private List<String> spinner2Data = new ArrayList<String>();
    private List<String> spinner3Data = new ArrayList<String>();
    private ArrayList<PrefList_SetterGetter> arrayList_PrefList= new ArrayList<PrefList_SetterGetter>();
    private RecyclerView recyclerView;
    private RecyclerAdapterPrefList mRecyclerAdapterPrefList;
    private RecyclerView.LayoutManager layoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_preferences, container, false);
        Spinner spinner1 = (Spinner)view.findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner)view.findViewById(R.id.spinner2);
        Spinner spinner3 = (Spinner)view.findViewById(R.id.spinner3);
        Button btn_investPrefSubmit = (Button)view.findViewById(R.id.btn_investPrefSubmit);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipeRefreshLayout);

        MainActivity.toolbar_home.setText(R.string.title_myPreference);

        arrayList_PrefList.add(new PrefList_SetterGetter("12,000", "1.8%", "4-Years", "18 Feb, 2017"));
        arrayList_PrefList.add(new PrefList_SetterGetter("14,000", "1.7%", "6-Years", "14 Mar, 2017"));
        arrayList_PrefList.add(new PrefList_SetterGetter("15,000", "1.5%", "5-Years", "19 Apr, 2017"));

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerAdapterPrefList = new RecyclerAdapterPrefList(getActivity(), arrayList_PrefList);
        recyclerView.setAdapter(mRecyclerAdapterPrefList);

        spinner1Data.add("Investment");
        spinner2Data.add("From");
        spinner3Data.add("To");
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,
                android.R.id.text1, spinner1Data) {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextColor(getResources().getColor(R.color.black));
                textView.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
                textView.setTextSize(14f);
                return textView;
            }
        };

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,
                android.R.id.text1, spinner2Data) {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextColor(getResources().getColor(R.color.black));
                textView.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
                textView.setTextSize(14f);
                return textView;
            }
        };

        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,
                android.R.id.text1, spinner3Data) {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextColor(getResources().getColor(R.color.black));
                textView.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
                textView.setTextSize(14f);
                return textView;
            }
        };

        // attaching data adapter to spinner
        spinner1.setAdapter(dataAdapter1);
        spinner2.setAdapter(dataAdapter2);
        spinner3.setAdapter(dataAdapter3);

        btn_investPrefSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).replaceFragment(new PreferenceResultFragment(), R.string.title_prefResult);
            }
        });

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
