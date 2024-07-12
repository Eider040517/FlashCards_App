package com.utp.flashcard.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.utp.flashcard.database.entities.User;

@Dao
public interface UserDAO {
    @Insert
    long insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM user LIMIT 1")
    User getAnyUser();
}
