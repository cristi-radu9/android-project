package com.example.andoridproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteAccounts extends AppCompatActivity {
    EditText idtxt;
    Button del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_accounts);

        idtxt=findViewById(R.id.etID);
        del=findViewById(R.id.btnRemoveUser);

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id= Integer.parseInt(idtxt.getText().toString());
                User usr=new User();
                usr.setId(id);
                Login_Form.myAppDatabase.myDao().deleteUser(usr);
                Toast.makeText(DeleteAccounts.this, "User removed", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
