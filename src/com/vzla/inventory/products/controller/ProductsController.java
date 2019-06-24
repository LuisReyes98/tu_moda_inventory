package com.vzla.inventory.products.controller;

import com.vzla.inventory.controller.MainController;
import com.vzla.inventory.controller.NavigationController;
import com.vzla.inventory.products.models.Product;

/**
 *
 * @author luisr
 */
public class ProductsController extends MainController {

    public Product product;

    public void goToProductCreate() {
        product = new Product();
        NavigationController.goToView("products_create");
    }

    public void goToProducts() {
        NavigationController.goToView("products_index");

    }

}
