package com.app.inv;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.inv.designproject.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class LinkAccountFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private Button btn_linkAccountSubmit;
    private LinearLayout linear_linkAccountDetail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_link_account, container, false);
        btn_linkAccountSubmit = (Button)fragmentView.findViewById(R.id.btn_linkAccountSubmit);
        linear_linkAccountDetail = (LinearLayout) fragmentView.findViewById(R.id.linear_linkAccountDetail);
        MainActivity.toolbar_home.setText(R.string.title_linkAcount);
        linear_linkAccountDetail.setVisibility(View.GONE);

        //show dialog box
        showDialog();

        btn_linkAccountSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).replaceFragment(new ConfirmationFragment(), R.string.title_confirmation);
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

    public void showDialog(){
        View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_link_account, null);

        final Dialog dialog = new Dialog(getActivity(), android.R.style.Theme_Holo_Light_Dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(dialogView);
        dialog.setCancelable(false);
        dialog.show();

        Button btn_yes = (Button) dialogView.findViewById(R.id.btn_yes);
        Button btn_no = (Button) dialogView.findViewById(R.id.btn_no);

        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear_linkAccountDetail.setVisibility(View.VISIBLE);
                dialog.dismiss();
            }
        });

        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(new ConfirmationFragment(), R.string.title_confirmation);
                dialog.dismiss();
            }
        });
    }
}
