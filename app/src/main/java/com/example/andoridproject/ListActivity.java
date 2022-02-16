package com.example.andoridproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private static final String TAG = ListActivity.class.getName();

    private static List<Gym> gymList = new ArrayList<>();

    private ListView gymListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Intent intent = getIntent();
        Gym gym = intent.getParcelableExtra("gymKey");
        if (gym != null)
            gymList.add(gym);

        gymListView = findViewById(R.id.lvGym);

        ArrayAdapter<Gym> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, gymList);

        gymListView.setAdapter(arrayAdapter);

        GymAdapter mAdapter = new GymAdapter(this, gymList);
        gymListView.setAdapter(mAdapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
