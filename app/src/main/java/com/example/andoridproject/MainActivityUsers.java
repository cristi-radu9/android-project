package com.example.andoridproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivityUsers extends AppCompatActivity {
    private SharedPreferenceConfig preferenceConfig;
    //public static MyAppDatabase myAppDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_users);

        //myAppDatabase= Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"gymdb").allowMainThreadQueries().build();

        preferenceConfig=new SharedPreferenceConfig(getApplicationContext());
    }

    public void btn_userToAddForm(View view) {
        startActivity(new Intent(getApplicationContext(),AddForm.class));
    }

    public void btn_Logout(View view) {
        preferenceConfig.writeLoginStatus(false);
        startActivity(new Intent(getApplicationContext(),Login_Form.class));
        finish();

    }

    public void btn_userToJsonForm(View view) {
        startActivity(new Intent(getApplicationContext(),FoodTips_Json.class));
    }

    public void btn_userDisplayPrograms(View view) {
        startActivity(new Intent(getApplicationContext(),DisplayProgram.class));
    }

    public void btn_userToMap(View view) {
        startActivity(new Intent(getApplicationContext(),MapsClass.class));
    }
}
