package com.vzla.inventory.sales.models;

/**
 *
 * @author luisr
 */
public class SoldProduct {

    public int id;
    public int productId;
    public int amount;

    public SoldProduct(int id, int productId, int amount) {
        this.id = id;
        this.productId = productId;
        this.amount = amount;
    }

    public SoldProduct() {
    }

}
