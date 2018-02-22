package db;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.util.List;

public class Category {

    @PrimaryKey(autoIncrement = true)
    private int id;
    private String name;

    public Category() { }

    public Category(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}


