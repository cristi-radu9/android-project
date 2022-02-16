package com.example.andoridproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class DisplayUsers extends AppCompatActivity {

    TextView txtInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_users);

        txtInfo=findViewById(R.id.tvUsers);

        List<User> users=Login_Form.myAppDatabase.myDao().getUsers();

        String info = "";
        for(User usr : users){
            int id=usr.getId();
            String name=usr.getName();
            String email=usr.getEmail();
            String pass=usr.getPassword();

            info=info+"\n\n"+"ID: "+id+"\nName: "+name
                    +"\nEmail: "+email+"\nPassword: "+pass;
        }
        txtInfo.setText(info);
    }
}
