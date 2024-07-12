package com.utp.flashcard.database.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "user")
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    @ColumnInfo(name = "name")
    public String name;

    @NonNull
    @ColumnInfo(name = "nickName")
    public String nickName;

    @NonNull
    @ColumnInfo(name = "created_at")
    public String created_at;

    public User(@NonNull String name, @NonNull String nickName, @NonNull String created_at) {
        this.name = name;
        this.nickName = nickName;
        this.created_at = created_at;
    }
}

