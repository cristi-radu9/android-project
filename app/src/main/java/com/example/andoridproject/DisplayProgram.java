package com.example.andoridproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class DisplayProgram extends AppCompatActivity {

    TextView tvPrograms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_program);

        tvPrograms=findViewById(R.id.tvDisplayProgram);

        List<Gym> gyms=Login_Form.myAppDatabase.gymDao().findGymsForUser(Login_Form.globalUserId);

        String info = "";
        for(Gym gm : gyms){
            int id=gm.getId();
            String exercises=gm.getExercises();
            int diff=gm.getDifficulty();
            String purpose=gm.getPurpose();
            String meals=gm.getMeals();
            float rate=gm.getProgramRate();
            int userId=gm.getUserId();

            info += "\n\n" + "Program\n" + "ID: " + id + "\nExercises:" + exercises + "\nDifficulty: " + diff + "  Purpose: " + purpose + "\nMeals:" + meals + "\nRate: " + rate + "\nUser id: " + userId;
        }
        tvPrograms.setText(info);

    }
}
