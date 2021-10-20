package com.fpt.t1911e.lehuyduc;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Feedback")
public class Feedback implements Serializable {

    public Feedback(int id, String name, String description, String email, String sex) {
        Id = id;
        Name = name;
        Description = description;
        Email = email;
        Sex = sex;
    }

    public Feedback() {
    }

    @PrimaryKey(autoGenerate = true)
    public int Id;
    public String Name;
    public String Description;
    public String Email;
    public String Sex;
}
