package com.vzla.inventory.products.controller;

import com.vzla.inventory.controller.MainController;
import com.vzla.inventory.controller.NavigationController;
import com.vzla.inventory.main.Main;
import com.vzla.inventory.products.models.Product;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisr
 */
public class ProductsController extends MainController {

    public Product product;
    public List<Product> products;

    public void viewProductsCreate() {
        product = new Product();
        NavigationController.goToView("products_create");
    }

    public void viewProducts() {
        try {
            products = Main.db.productDao.queryForAll();
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Products index error: " + ex.getMessage());
        }
        NavigationController.goToView("products_index");

    }

}
