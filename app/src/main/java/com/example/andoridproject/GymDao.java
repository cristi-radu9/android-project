package com.example.andoridproject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GymDao {
    @Insert
    public void AddGym(Gym gym);

    @Query("select * from gym")
    public List<Gym> getGyms();

    @Delete
    public void deleteGym(Gym gym);

    @Update
    public void updateGym(Gym gym);

    @Query("SELECT * FROM gym WHERE userId=:userId")
    List<Gym> findGymsForUser(final int userId);
}
