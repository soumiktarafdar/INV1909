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

public class PreferenceResultFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private ArrayList<PrefResult_SetterGetter> arrayList_PrefResultList= new ArrayList<PrefResult_SetterGetter>();
    private RecyclerView recyclerView;
    private RecyclerAdapterPrefResult mRecyclerAdapterPrefResult;
    private RecyclerView.LayoutManager layoutManager;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_preference_result, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipeRefreshLayout);

        MainActivity.toolbar_home.setText(R.string.title_prefResult);

        arrayList_PrefResultList.add(new PrefResult_SetterGetter(R.drawable.tienphong, "1.6% per anum 5 years", "1.5% per anum 4 years"));
        arrayList_PrefResultList.add(new PrefResult_SetterGetter(R.drawable.tienphong, "1.7% per anum 4 years", "1.3% per anum 7 years"));
        arrayList_PrefResultList.add(new PrefResult_SetterGetter(R.drawable.tienphong, "1.4% per anum 6 years", "1.2% per anum 5 years"));

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mRecyclerAdapterPrefResult = new RecyclerAdapterPrefResult(getActivity(), arrayList_PrefResultList);
        recyclerView.setAdapter(mRecyclerAdapterPrefResult);

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
