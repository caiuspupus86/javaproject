package db;

import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Support {

    @PrimaryKey(autoIncrement = true)
    private int idSupport;

    private String nameSupport;

    public int getIdSupport() {
        return idSupport;
    }

    public void setIdSupport(int idSupport) {
        this.idSupport = idSupport;
    }

    public String getNameSupport() {
        return nameSupport;
    }

    public void setNameSupport(String nameSupport) {
        this.nameSupport = nameSupport;
    }

    public Support() {

    }
}
