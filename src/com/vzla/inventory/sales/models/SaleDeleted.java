package com.vzla.inventory.sales.models;

import com.j256.ormlite.table.DatabaseTable;

/**
 *
 * @author luisr
 */
@DatabaseTable(tableName = "sale_deleted")
public class SaleDeleted extends Sale {

    public SaleDeleted() {
        super();
    }

}
