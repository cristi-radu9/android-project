package com.example.andoridproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register_Form extends AppCompatActivity {

    EditText userName,email,pass,confpass;
    Button btnReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__form);

        userName=findViewById(R.id.etName);
        email=findViewById(R.id.etEmail);
        pass=findViewById(R.id.etPassword);
        confpass=findViewById(R.id.etConfirmPass);
        btnReg=findViewById(R.id.btnRegister);


        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User usr=new User();

                String name=userName.getText().toString();
                usr.setName(name);
                String eml=email.getText().toString();
                usr.setEmail(eml);
                String passw=pass.getText().toString();
                usr.setPassword(passw);
                String cpass=confpass.getText().toString();

                if(passw.equals(cpass)) {
                    Login_Form.myAppDatabase.myDao().AddUser(usr);
                    Toast.makeText(Register_Form.this, "Registration succeed", Toast.LENGTH_SHORT).show();
                }else{
                    AlertDialog.Builder myAlert=new AlertDialog.Builder(Register_Form.this);
                    myAlert.setTitle("Error").setMessage("Password don't match!").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).setIcon(R.drawable.ericon).show();
                }
            }
        });


    }


}
