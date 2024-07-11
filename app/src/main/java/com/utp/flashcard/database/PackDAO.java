package com.utp.flashcard.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.utp.flashcard.database.entities.Pack;
import java.util.List;

@Dao
public interface PackDAO {
    @Insert
    void insert(Pack pack);

    @Update
    void update(Pack pack);

    @Delete
    void delete(Pack pack);

    @Query("SELECT * FROM packs")
    List<Pack> getAllPacks();

    @Query("SELECT * FROM packs WHERE id = :packId")
    Pack getPackById(int packId);

}

