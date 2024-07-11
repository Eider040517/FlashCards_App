package com.utp.flashcard.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;//agregue esto para el date de la ultima linea
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

    @NonNull
    public Date created_at;

    public Collection(@NonNull String title, int id_user, @NonNull Date created_at) {
        this.title = title;
        this.id_user = id_user;
        this.created_at = created_at;
    }
}
