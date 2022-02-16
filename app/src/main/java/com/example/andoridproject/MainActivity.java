package com.example.andoridproject;

import androidx.appcompat.app.AppCompatActivity;

//import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void btn_toAddForm(View view) {
        startActivity(new Intent(getApplicationContext(),AddForm.class));
    }

    public void btn_toUsers(View view) {
        startActivity(new Intent(getApplicationContext(),DisplayUsers.class));
    }

    public void btn_toDelUsers(View view) {
        startActivity(new Intent(getApplicationContext(),DeleteAccounts.class));
    }


    public void btn_toUpdateUsers(View view) {
        startActivity(new Intent(getApplicationContext(),UpdateUsers.class));
    }
}
