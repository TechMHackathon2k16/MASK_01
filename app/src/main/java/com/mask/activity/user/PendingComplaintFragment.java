package com.mask.activity.user;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mask.R;

public class PendingComplaintFragment extends Fragment {

    ListView pendingComplaint;
    public PendingComplaintFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pending_complaint, container, false);
        pendingComplaint = (ListView)view.findViewById(R.id.listViewPendingComplaints);
        return view;
    }


}
