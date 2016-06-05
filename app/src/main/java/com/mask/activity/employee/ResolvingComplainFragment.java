package com.mask.activity.employee;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mask.R;

public class ResolvingComplainFragment extends Fragment {
    ListView resolvingComponant;
    public ResolvingComplainFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_resolving_complain, container, false);
        resolvingComponant = (ListView)view.findViewById(R.id.listViewResolvingComplaints);
        return view;
    }
}
