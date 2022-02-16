package com.example.andoridproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class AddForm extends AppCompatActivity {

    private static final String TAG=AddForm.class.getName();
    private EditText exercises;
    private SeekBar difficulty;
    private Spinner purpose;
    private EditText meals;
    private RatingBar rate;
    private AdapterView.OnItemSelectedListener itemSelectedListener=new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String genre=parent.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(),"Selected value "+genre,Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_form);

        exercises=findViewById(R.id.etExercises);
        difficulty=findViewById(R.id.sbDiff);
        purpose=findViewById(R.id.spPurpose);
        meals=findViewById(R.id.etMeals);
        rate=findViewById(R.id.ratingBar);


        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.scope,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        purpose.setAdapter(adapter);
        purpose.setOnItemSelectedListener(itemSelectedListener);

        difficulty.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d(TAG,"Value: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        rate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.d(TAG, "No. of stars: " + rate);
            }
        });

    }

    public void Submit(View view) {
        Gym gym = new Gym();
        String gExercises=exercises.getText().toString();
        gym.setExercises(gExercises);

        int diff=difficulty.getProgress();
        gym.setDifficulty(diff);

        String scope=purpose.getSelectedItem().toString();
        gym.setPurpose(scope);

        String gMeals=meals.getText().toString();
        gym.setMeals(gMeals);

        float gRate=rate.getRating();
        gym.setProgramRate(gRate);

        gym.setUserId(Login_Form.globalUserId);
        Login_Form.myAppDatabase.gymDao().AddGym(gym);
        Toast.makeText(AddForm.this, "Program added", Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(this,ListActivity.class);
        intent.putExtra("gymKey",gym);
        startActivity(intent);
    }
}
