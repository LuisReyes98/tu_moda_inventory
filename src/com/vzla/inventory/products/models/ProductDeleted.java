package com.vzla.inventory.products.models;

import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author luisr
 */
@DatabaseTable(tableName = "product_deleted")
public class ProductDeleted extends Product {

    public ProductDeleted() {
        super();
    }

}
