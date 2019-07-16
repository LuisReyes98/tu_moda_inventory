package com.vzla.inventory.sales.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.ForeignCollectionField;

import java.util.Date;

/**
 *
 * @author luisr
 */
@DatabaseTable(tableName = "sale")
public class Sale {

    public final static String ID_FIELD_NAME = "id";
    public final static String TOTAL_PRICE_FIELD_NAME = "total_price";
    public final static String CREATED_FIELD_NAME = "created_at";
    public final static String UPDATED_FIELD_NAME = "updated_at";

    @DatabaseField(generatedId = true, columnName = ID_FIELD_NAME)
    private int id;

    @DatabaseField(canBeNull = false, columnName = TOTAL_PRICE_FIELD_NAME)
    private float totalPrice;

    @DatabaseField(canBeNull = true, columnName = CREATED_FIELD_NAME, dataType = DataType.DATE_LONG)
    private Date createdAt;

    @DatabaseField(canBeNull = true, columnName = UPDATED_FIELD_NAME, dataType = DataType.DATE_LONG)
    private Date updatedAt;

    @ForeignCollectionField
    private ForeignCollection<ProductsSaleRelation> productsSaleRelation;

    public Sale() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
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

    public ForeignCollection<ProductsSaleRelation> getProductsSaleRelation() {
        return productsSaleRelation;
    }

    public void setProductsSaleRelation(ForeignCollection<ProductsSaleRelation> productsSaleRelation) {
        this.productsSaleRelation = productsSaleRelation;
    }

    public Object[] getProductSalesRelationArray() {
        return productsSaleRelation.toArray();
    }

}
