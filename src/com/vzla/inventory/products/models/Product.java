/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vzla.inventory.products.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author luisr
 */
@DatabaseTable(tableName = "product")
public class Product {

    public final static String ID_FIELD_NAME = "id";
    public final static String CATEGORY_FIELD_NAME = "category";
    public final static String NAME_FIELD_NAME = "name";
    public final static String STOCK_FIELD_NAME = "stock";

    @DatabaseField(generatedId = true, columnName = ID_FIELD_NAME)
    private int id;

    @DatabaseField(canBeNull = false, columnName = CATEGORY_FIELD_NAME)
    private String category;

    @DatabaseField(canBeNull = false, columnName = NAME_FIELD_NAME)
    private String name;

    @DatabaseField(canBeNull = false, columnName = STOCK_FIELD_NAME)
    private int stock;

    public Product() {

    }

    public Product(String category, String name, int stock) {
        this.category = category;
        this.name = name;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
