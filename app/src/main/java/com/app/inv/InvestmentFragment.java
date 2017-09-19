package com.app.inv;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.inv.designproject.R;

public class InvestmentFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private Button btn_investmentHistory, btn_investPreference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_investment, container, false);
        btn_investmentHistory = (Button)fragmentView.findViewById(R.id.btn_investmentHistory);
        btn_investPreference = (Button)fragmentView.findViewById(R.id.btn_investPreference);

        MainActivity.toolbar_home.setText(R.string.title_investment);

        btn_investmentHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).replaceFragment(new InvestmentHistoryFragment(), R.string.title_investmentHistory);
            }
        });

        btn_investPreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).replaceFragment(new MyPreferenceFragment(), R.string.title_myPreference);
            }
        });

        // Inflate the layout for this fragment
        return fragmentView;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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

        /*// Set title
        getActivity().getActionBar()
                .setTitle(R.string.title_investment);*/

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
