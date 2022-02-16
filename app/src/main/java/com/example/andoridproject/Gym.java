package com.example.andoridproject;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "id",
        childColumns = "userId",
        onDelete = CASCADE))
public class Gym implements Parcelable {
    @ColumnInfo(name ="gym_exercises")
    private String exercises; //multi line edit text
    @ColumnInfo(name ="gym_difficulty")
    private Integer difficulty; //seek bar
    @ColumnInfo(name ="gym_purpose")
    private String purpose;//spinner
    @ColumnInfo(name ="gym_meals")
    private String meals; //multi line edit text
    @ColumnInfo(name ="gym_rate")
    private Float programRate; //rating bar
    private int userId;
    @PrimaryKey(autoGenerate = true)
    private int id;

    public Gym() {
    }

    @Ignore
    public Gym(String exercises, Integer difficulty, String purpose, String meals, Float programRate, int userId, int id) {
        this.exercises = exercises;
        this.difficulty = difficulty;
        this.purpose = purpose;
        this.meals = meals;
        this.programRate = programRate;
        this.userId = userId;
        this.id = id;
    }

    public static final Creator<Gym> CREATOR = new Creator<Gym>() {
        @Override
        public Gym createFromParcel(Parcel in) {
            return new Gym(in);
        }

        @Override
        public Gym[] newArray(int size) {
            return new Gym[size];
        }
    };

    public String getExercises() {
        return exercises;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getMeals() {
        return meals;
    }

    public Float getProgramRate() {
        return programRate;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setExercises(String exercises) {
        this.exercises = exercises;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setMeals(String meals) {
        this.meals = meals;
    }

    public void setProgramRate(Float programRate) {
        this.programRate = programRate;
    }



    protected Gym (Parcel in){
        exercises=in.readString();
        if(in.readByte()==0){
            difficulty=null;
        }else{
            difficulty=in.readInt();
        }
        purpose=in.readString();
        meals=in.readString();
        if(in.readByte()==0){
            programRate=null;
        }else{
            programRate=in.readFloat();
        }
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(exercises);
        if (difficulty == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(difficulty);
        }
        dest.writeString(purpose);
        dest.writeString(meals);
        if (programRate == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(programRate);
        }
    }

    @NonNull
    @Override
    public String toString() {
        return "Program\n"+
                "Exercises:"+ exercises+
                "\nDifficulty: "+ difficulty+
                "  Purpose: "+ purpose+
                "\nMeals:"+meals+
                "\nRate: "+programRate;
    }
}
