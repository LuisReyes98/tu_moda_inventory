package com.vzla.inventory.products.models;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;

/**
 *
 * @author luisr
 */
@DatabaseTable(tableName = "product")
public class Product {

    public final static String ID_FIELD_NAME = "id";
    public final static String CATEGORY_FIELD_NAME = "category_id";
    public final static String NAME_FIELD_NAME = "name";
    public final static String STOCK_FIELD_NAME = "stock";
    public final static String PRICE_FIELD_NAME = "price";

    public final static String CREATED_FIELD_NAME = "created_at";
    public final static String UPDATED_FIELD_NAME = "updated_at";

    @DatabaseField(generatedId = true, columnName = ID_FIELD_NAME)
    private int id;

    @DatabaseField(canBeNull = false, columnName = CATEGORY_FIELD_NAME, foreign = true, foreignAutoRefresh = true)
    private Category category;

    @DatabaseField(canBeNull = false, columnName = NAME_FIELD_NAME)
    private String name;

    @DatabaseField(canBeNull = false, columnName = STOCK_FIELD_NAME)
    private int stock;

    @DatabaseField(canBeNull = false, columnName = PRICE_FIELD_NAME)
    private float price;

    @DatabaseField(canBeNull = true, columnName = CREATED_FIELD_NAME, dataType = DataType.DATE_LONG)
    private Date createdAt;
    @DatabaseField(canBeNull = true, columnName = UPDATED_FIELD_NAME, dataType = DataType.DATE_LONG)
    private Date updatedAt;

    public Product() {

    }

    public Product(Category category) {
        this.category = category;
    }

    public Product(Category category, String name, int stock, float price) {
        this.category = category;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public Product(Category category, String name, int stock, float price, Date createdAt, Date updatedAt) {
        this.category = category;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
