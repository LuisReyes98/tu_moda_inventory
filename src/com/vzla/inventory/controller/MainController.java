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
     * Go to method to travel from current view to
     */
    public void goToIndex() {
        Main.navController.indexController.viewIndex();
    }

    /**
     * Go to method to travel from current view to
     */
    public void goToProducts() {
        Main.navController.productsController.viewProducts();

    }

    /**
     * Go to method to travel from current view to
     */
    public void goToSales() {
        Main.navController.salesController.viewSales();

    }

}
