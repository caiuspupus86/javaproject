package db;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public enum Category {

    MUSIQUE (1),
    FILMS (2),
    LIVRES (3),
    JEUXVIDEO (4);

    @PrimaryKey (autoIncrement = true)
    private int idCategory;

    private int number;

    Category(int number) {
        this.number = number;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public int getNumber() {
        return number;
    }
}
