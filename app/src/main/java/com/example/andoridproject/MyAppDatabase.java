package com.example.andoridproject;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {User.class,Gym.class},version = 1,exportSchema = false)
public abstract class MyAppDatabase extends RoomDatabase {

    public abstract MyDao myDao();
    public abstract GymDao gymDao();
}
