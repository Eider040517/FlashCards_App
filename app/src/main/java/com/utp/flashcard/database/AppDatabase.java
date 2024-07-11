package com.utp.flashcard.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.utp.flashcard.database.entities.Card;
import com.utp.flashcard.database.entities.Collection;
import com.utp.flashcard.database.entities.Pack;
import com.utp.flashcard.database.entities.User;
import com.utp.flashcard.database.entities.*;

@Database(entities = {Card.class, Collection.class, Pack.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CardDAO cardDAO();
    public abstract CollectionDAO collectionDAO();
    public abstract PackDAO packDAO();
    public abstract UserDAO userDAO();
}

