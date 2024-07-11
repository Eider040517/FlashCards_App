package com.utp.flashcard.entities;

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
    @ColumnInfo(name = "nick_name")
    public String nick_name;

    @NonNull
    @ColumnInfo(name = "created_at")
    public Date created_at;

    public User(@NonNull String name, @NonNull String nick_name, @NonNull Date created_at) {
        this.name = name;
        this.nick_name = nick_name;
        this.created_at = created_at;
    }
}