package com.example.andoridproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateUsers extends AppCompatActivity {

    EditText uname,uemail,upass,uid;
    Button btnUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_users);
        uname=findViewById(R.id.etUpdateName);
        uid=findViewById(R.id.etUpdateId);
        uemail=findViewById(R.id.etUpdateEmail);
        upass=findViewById(R.id.etUpdatePassword);
        btnUp=findViewById(R.id.btnUpdate);

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id=Integer.parseInt(uid.getText().toString());
                String name=uname.getText().toString();
                String email=uemail.getText().toString();
                String pass=upass.getText().toString();

                User usr=new User();
                usr.setId(id);
                usr.setName(name);
                usr.setEmail(email);
                usr.setPassword(pass);

                Login_Form.myAppDatabase.myDao().updateUser(usr);
                Toast.makeText(UpdateUsers.this, "User Updated", Toast.LENGTH_SHORT).show();


            }
        });
    }
}
