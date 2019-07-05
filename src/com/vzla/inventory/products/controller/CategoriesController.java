package com.vzla.inventory.products.controller;

import com.vzla.inventory.controller.MainController;
import com.vzla.inventory.controller.NavigationController;
import com.vzla.inventory.main.Main;
import com.vzla.inventory.products.models.Category;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisr
 */
public class CategoriesController extends MainController {

    public Object categories[];
    public Category category;

    public CategoriesController() {
    }

    public void viewCategories() {
        try {
            this.categories = Main.db.categoryDao.queryForAll().toArray();
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error ProductsController getCategories " + ex.getMessage());
        }
        NavigationController.goToView("categories_index", true, true);

    }
}
