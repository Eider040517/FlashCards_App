package com.utp.flashcard.database.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
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
    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "id_user")
    public int id_user;

    @NonNull
    @ColumnInfo(name = "created_at")
    public String created_at;

    public Collection(@NonNull String title, int id_user, @NonNull String created_at) {
        this.title = title;
        this.id_user = id_user;
        this.created_at = created_at;
    }
}
