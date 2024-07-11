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



    public User(@NonNull String name, @NonNull String nickName) {
        this.name = name;
        this.nickName = nickName;
    }
}