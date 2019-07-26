package com.vzla.inventory.sales.controller;

import com.vzla.inventory.controller.MainController;
import com.vzla.inventory.controller.NavigationController;
import com.vzla.inventory.main.Main;
import com.vzla.inventory.products.models.Category;
import com.vzla.inventory.products.models.Product;
import com.vzla.inventory.sales.models.Sale;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisr
 */
public class SalesController extends MainController {

    public Sale sale;
    public Object products[];
    public HashMap<Integer, Product> productsHash;
//    public Object productSalesRelation[];

    public SalesController() {
    }

    public void viewSales() {
        NavigationController.goToView("sales_index", true, true);

    }

    public void viewSalesCreate() {
        sale = new Sale();
        productsHash = new HashMap<>();

        List<Product> productList;
        try {
            Main.db.saleDao.refresh(sale);

            productList = Main.db.productDao.queryForAll();
            products = productList.toArray();

            productList.forEach((pro) -> {
                productsHash.put(pro.getId(), pro);
            });
        } catch (SQLException ex) {
            Logger.getLogger(SalesController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Products viewSalesCreate error: " + ex.getMessage());
        }

        NavigationController.goToView(
                "sales_create", true, true);
    }

}
