package com.vzla.inventory.sales.controller;

import com.vzla.inventory.controller.MainController;
import com.vzla.inventory.controller.NavigationController;

/**
 *
 * @author luisr
 */
public class SalesController extends MainController {

    public void viewSales() {
        NavigationController.goToView("sales_index", true, true);

    }

}
