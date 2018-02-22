package db;

import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Oeuvre {

    @PrimaryKey(autoIncrement = true)
    private String idOeuvre;
    private String titleOeuvre;
    private String editionDate;


    @ForeignKey(table = "Category", column = "id", childReference = "category")
    protected int idCategory;
    private Category category;

    @ForeignKey(table = "Support", column = "idSupport", childReference = "support")
    private int idSupport;
    private Support support;

    public Oeuvre() { }

    public Oeuvre(String titleOeuvre, String editionDate, Category category) {
        this.titleOeuvre = titleOeuvre;
        this.editionDate = editionDate;
        setCategory(category);
    }

    public int getIdCategory() {
        return idCategory;
    }

    public String getTitleOeuvre() {
        return titleOeuvre;
    }

    public void setTitleOeuvre(String titleOeuvre) {
        this.titleOeuvre = titleOeuvre;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getIdSupport() {
        return idSupport;
    }

    public void setIdSupport(int idSupport) {
        this.idSupport = idSupport;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public String getEditionDate() {
        return editionDate;
    }

    public void setEditionDate(String editionDate) {
        this.editionDate = editionDate;
    }
}
