package db;

import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Support {

    @PrimaryKey(autoIncrement = true)
    private int idSupport;

    private String nameSupport;

    public Support() {
    }
}
