package com.utp.flashcard.database.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "card",
        foreignKeys = @ForeignKey(entity = Pack.class,
                parentColumns = "id",
                childColumns = "id_pack",
                onDelete = ForeignKey.CASCADE),
                indices = {@Index(("id_pack"))})
public class Card {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @NonNull
    @ColumnInfo(name = "question")
    public String question;

    @NonNull
    @ColumnInfo(name = "answer")
    public String answer;

    @ColumnInfo(name = "id_pack")
    public int id_pack;

    @NonNull
    @ColumnInfo(name = "created_at")
    public String created_at;

    public Card(@NonNull String question, @NonNull String answer, int id_pack, @NonNull String created_at) {
        this.question = question;
        this.answer = answer;
        this.id_pack = id_pack;
        this.created_at = created_at;
    }

}
