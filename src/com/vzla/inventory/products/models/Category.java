package com.vzla.inventory.products.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author luisr
 */
@DatabaseTable(tableName = "category")
public class Category {

    public final static String ID_FIELD_NAME = "id";
    public final static String NAME_FIELD_NAME = "name";

    @DatabaseField(generatedId = true, columnName = ID_FIELD_NAME)
    private int id;

    @DatabaseField(canBeNull = false, columnName = NAME_FIELD_NAME)
    private String name;

//    @ForeignCollectionField
//    private ForeignCollection<Product> products;
    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public ForeignCollection<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(ForeignCollection<Product> products) {
//        this.products = products;
//    }
}
