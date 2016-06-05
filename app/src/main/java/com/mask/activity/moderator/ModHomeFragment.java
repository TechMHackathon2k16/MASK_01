package com.mask.activity.moderator;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mask.R;
import com.mask.activity.employee.EmployeeNewComplaintFragment;
import com.mask.activity.user.PendingComplaintFragment;
import com.mask.activity.user.ResolvedComplaintFragment;

public class ModHomeFragment extends Fragment implements ActionBar.TabListener {

    EmployeePagerAdapter pagerAdapter;
    ViewPager mViewPager;

    public ModHomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mod_home, container, false);
        pagerAdapter = new EmployeePagerAdapter(getFragmentManager());

//        final ActionBar actionBar = getActivity().getActionBar();

//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        mViewPager = (ViewPager) view.findViewById(R.id.employeePager);

        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
//                actionBar.setSelectedNavigationItem(position);
            }
        });

        for(int i=0; i<pagerAdapter.getCount(); i++) {
//            actionBar.addTab(actionBar.newTab().setText(pagerAdapter.getPageTitle(i)).setTabListener(ModHomeFragment.this));
        }

        return view;
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    public static class EmployeePagerAdapter extends FragmentPagerAdapter {
        public EmployeePagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return new EmployeeNewComplaintFragment();
                case 1:
                    return new ModAssignFragment();
                case 2:
                    return new ResolvedComplaintFragment();
            }
            return null;
        }
        public int getCount() {
            return 3;
        }
        public CharSequence getPageTitle(int position) {
            switch(position){
                case 0:
                    return "New";
                case 1:
                    return "Resolved";
                case 2:
                    return "Completed";
            }
            return null;
        }
    }
}
