package com.utp.flashcard.database.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "collections",
        foreignKeys = @ForeignKey(entity = User.class,
                parentColumns = "id",
                childColumns = "id_user",
                onDelete = ForeignKey.CASCADE))
public class Collection {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    public String title;

    @NonNull
    public int id_user;

    public Collection(@NonNull String title, int id_user) {
        this.title = title;
        this.id_user = id_user;
    }
}
