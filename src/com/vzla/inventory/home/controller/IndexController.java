/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vzla.inventory.home.controller;

import com.vzla.inventory.controller.MainController;
import com.vzla.inventory.controller.NavigationController;

/**
 *
 * @author luisr
 */
public class IndexController extends MainController {

    public IndexController() {
        super();
    }

    public void goToProducts() {
        NavigationController.goToView("products_index");

    }

    public void goToSales() {
        NavigationController.goToView("sales_index");
    }

}
