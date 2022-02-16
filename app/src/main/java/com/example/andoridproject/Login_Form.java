package com.example.andoridproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Login_Form extends AppCompatActivity {
    public static MyAppDatabase myAppDatabase;
    public static int globalUserId;
    private SharedPreferenceConfig preferenceConfig;
    Button btnToMain;
    EditText etusername;
    EditText etpas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__form);
        myAppDatabase= Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"userdb").allowMainThreadQueries().build();

        preferenceConfig=new SharedPreferenceConfig(getApplicationContext());


        if(preferenceConfig.readLoginStatus()){
            startActivity(new Intent(getApplicationContext(), MainActivityUsers.class));
            finish();
        }

        //for admin make an account with name: root and password: toor

        btnToMain=findViewById(R.id.btnLogin);
        btnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etusername=findViewById(R.id.etLogName);
                etpas=findViewById(R.id.etLogPass);
                String pass=etpas.getText().toString();
                String username=etusername.getText().toString();
                List<User> users=Login_Form.myAppDatabase.myDao().getUsers();
                int valid=0;
                for(User usr:users){
                    String u=usr.getName();
                    String p=usr.getPassword();
                    if(u.equals(username) && p.equals(pass) && u.equals("root")){
                        valid=1;
                    }else if(u.equals(username) && p.equals(pass)) {
                        valid = 2;
                        globalUserId = usr.getId();
                    }
                }
                if(valid==0) {
                    Toast.makeText(Login_Form.this, "Incorect name or password", Toast.LENGTH_SHORT).show();
                    etusername.setText("");
                    etpas.setText("");
                }
                if(valid==1){
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));//admin
                }

                if(valid==2) {
                    startActivity(new Intent(getApplicationContext(), MainActivityUsers.class));
                    preferenceConfig.writeLoginStatus(true);
                    finish();
                }


            }
        });
    }



    public void btn_ToRegisterForm(View view) {
        startActivity(new Intent(getApplicationContext(),Register_Form.class));
    }
}
