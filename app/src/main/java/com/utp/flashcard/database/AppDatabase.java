package com.utp.flashcard.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.utp.flashcard.entities.*;//pase por aqui actualice

@Database(entities = {Card.class, Collection.class, Pack.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CardDAO cardDAO();
    public abstract CollectionDAO collectionDAO();
    public abstract PackDAO packDAO();
    public abstract UserDAO userDAO();
}

