package com.mask.activity.moderator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.mask.R;

public class ModAssignFragment extends AppCompatActivity {

    ListView listViewModAssignedComplaint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_assign);
        listViewModAssignedComplaint = (ListView)findViewById(R.id.listViewModAssignedComplaint);
    }
}
