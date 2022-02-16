package com.example.andoridproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FoodTips_Json extends AppCompatActivity {

    public static TextView jsonData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_tips__json);

        jsonData=findViewById(R.id.JsonData);
        DownloadData downloadData=new DownloadData();
        downloadData.execute();
    }
}
