/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vzla.inventory.controller;

import com.vzla.inventory.controller.NavigationController;
import com.vzla.inventory.products.controller.ProductsController;
import com.vzla.inventory.sales.controller.SalesController;

/**
 *
 * @author luisr
 */
public class IndexController extends MainController {

    public IndexController() {
        super();
    }

    public void goToProducts() {
        System.out.println("Producto");
        NavigationController.goToView("products_index", new ProductsController());

    }

    public void goToSales() {
        System.out.println("Sales");
        NavigationController.goToView("sales_index", new SalesController());
    }
}
