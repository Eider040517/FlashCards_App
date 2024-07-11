package com.utp.flashcard.database.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;

import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

@Entity(tableName = "packs",
        foreignKeys = @ForeignKey(entity = Collection.class,
                parentColumns = "id",
                childColumns = "id_collection",
                onDelete = ForeignKey.CASCADE))
public class Pack {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    @ColumnInfo(name = "title")
    public String title;

    @NonNull
    @ColumnInfo(name = "id_collection")
    public int id_collection;



    public Pack(@NonNull String title, int id_collection ) {
        this.title = title;
        this.id_collection = id_collection;
    }
}