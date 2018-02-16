package db;

import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;
import java.sql.Date;

public class Oeuvre {

    @PrimaryKey(autoIncrement = true)
    private String idOeuvre;

    private Category category;
    private String titleOeuvre;
    private String editionDate;

    @ForeignKey(table = "", column = "")
    private int idSupport;

    public int getIdSupport() {
        return idSupport;
    }

    public void setIdSupport(int idSupport) {
        this.idSupport = idSupport;
    }

    public Oeuvre() {

    }

    public Oeuvre(String titleOeuvre, String editionDate, Category category) {
        this.titleOeuvre = titleOeuvre;
        this.editionDate = editionDate;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getIdOeuvre() {
        return idOeuvre;
    }

    public void setIdOeuvre(String idOeuvre) {
        this.idOeuvre = idOeuvre;
    }

    public String getTitleOeuvre() {
        return titleOeuvre;
    }

    public void setTitleOeuvre(String titleOeuvre) {
        this.titleOeuvre = titleOeuvre;
    }



    public String getEditionDate() {
        return editionDate;
    }

    public void setEditionDate(String editionDate) {
        this.editionDate = editionDate;
    }
}
