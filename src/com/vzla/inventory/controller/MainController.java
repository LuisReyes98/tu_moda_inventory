/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vzla.inventory.controller;

import com.vzla.inventory.main.Main;

/**
 *
 * @author luisr
 */
public class MainController {

    public MainController() {
    }

    public void sout(String s) {
        System.out.println(s);
    }

    public void goToIndex() {
        Main.navController.indexController.viewIndex();
    }

    public void goToProducts() {
        Main.navController.productsController.viewProducts();

    }

    public void goToSales() {
        Main.navController.salesController.viewSales();

    }

}
