package com.vzla.inventory.sales.models;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.vzla.inventory.products.models.Product;

import java.util.Date;

/**
 *
 * @author luisr
 */
@DatabaseTable(tableName = "products_sale_relation")
public class ProductsSaleRelation {

    public final static String ID_FIELD_NAME = "id";
    public final static String AMOUNT_FIELD_NAME = "amount";
    public final static String TOTAL_PRICE_FIELD_NAME = "total_price";

    public final static String PRODUCT_FIELD_NAME = "product_id";

    public final static String SALE_FIELD_NAME = "sale_id";

    public final static String CREATED_FIELD_NAME = "created_at";
    public final static String UPDATED_FIELD_NAME = "updated_at";

    @DatabaseField(generatedId = true, columnName = ID_FIELD_NAME)
    private int id;

    @DatabaseField(canBeNull = false, columnName = AMOUNT_FIELD_NAME)
    private int amount;

    @DatabaseField(canBeNull = false, columnName = TOTAL_PRICE_FIELD_NAME)
    private float total_price;

    @DatabaseField(canBeNull = false, columnName = PRODUCT_FIELD_NAME, foreign = true)
    private Product product;

    @DatabaseField(canBeNull = false, columnName = SALE_FIELD_NAME, foreign = true)
    private Sale sale;

    @DatabaseField(canBeNull = true, columnName = CREATED_FIELD_NAME, dataType = DataType.DATE_LONG)
    private Date createdAt;

    @DatabaseField(canBeNull = true, columnName = UPDATED_FIELD_NAME, dataType = DataType.DATE_LONG)
    private Date updatedAt;

    public ProductsSaleRelation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
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
