package com.vzla.inventory.controller;

import com.vzla.inventory.main.Main;

/**
 * Parent class of all view
 *
 * @author luisr
 */
public class MainController {

    public MainController() {
    }

    public void log(String s) {
        System.out.println(s);
    }

    /**
     * Go to method index view
     */
    public void goToIndex() {
        Main.navController.indexController.viewIndex();
    }

    /**
     * Go to product index view
     */
    public void goToProducts() {
        Main.navController.productsController.viewProducts();

    }

    /**
     * Go to categories index view
     */
    public void goToCategories() {
        Main.navController.categoriesController.viewCategories();

    }

    /**
     * Go to method to sales index view
     */
    public void goToSales() {
        Main.navController.salesController.viewSales();

    }

}
