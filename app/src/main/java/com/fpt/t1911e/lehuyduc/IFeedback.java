package com.fpt.t1911e.lehuyduc;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface IFeedback {
    @Insert(onConflict = REPLACE)
    void Insert(Feedback feedback);

    @Query("Select * from Feedback")
    List<Feedback> getAllFeedback();

    @Update
    void Update(Feedback feedback);

    @Delete
    void Delete(Feedback feedback);


    @Query("Select * from Feedback where Id = :Id")
    Feedback getFeedback(int Id);
}
