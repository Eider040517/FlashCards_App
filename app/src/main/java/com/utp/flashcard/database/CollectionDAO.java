package com.utp.flashcard.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.utp.flashcard.database.entities.Collection;
import java.util.List;

@Dao
public interface CollectionDAO {
    @Query("SELECT * FROM collections")
    List<Collection> getAllCollections();

    @Query("SELECT * FROM collections WHERE id = :collectionId")
    Collection getCollectionById(int collectionId);

    @Insert
    long insert(Collection collection);

    @Update
    void update(Collection collection);

    @Delete
    void delete(Collection collection);


}