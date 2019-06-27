package com.vzla.inventory.products.controller;

import com.vzla.inventory.controller.MainController;
import com.vzla.inventory.controller.NavigationController;
import com.vzla.inventory.main.Main;
import com.vzla.inventory.products.models.Product;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisr
 */
public class ProductsController extends MainController {

    public Product product;
    public Object products[];
    public String modelAction = "";
    public boolean isEditing;

    public void viewProductsCreate() {
        this.product = new Product();
        this.modelAction = "Crear";
        this.isEditing = false;
        NavigationController.goToView("products_create", true, true);
    }

    public void viewProductsEdit(int id) {
        this.modelAction = "Editar";
        this.isEditing = true;

        try {
            //find the product
            this.product = Main.db.productDao.queryForId(id);

        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Products edit error: " + ex.getMessage());
            this.product = new Product();
        }

        NavigationController.goToView("products_create", true, true);

    }

    public void viewProducts() {
        try {
            this.products = Main.db.productDao.queryForAll().toArray();
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Products index error: " + ex.getMessage());
        }

        NavigationController.goToView("products_index", true, true);

    }

    public void saveNewProduct(String category, String name, int stock, float cost) {
        this.product = new Product(category, name, stock, cost);
        try {
            Main.db.productDao.create(product);
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error ProductsController saveNewProduct " + ex.getMessage());
        }
        this.viewProducts();

    }

    public void updateProduct(String category, String name, int stock, float cost, int id) {
        if (this.isEditing && this.product.getId() == id) {
            this.isEditing = false;
            this.product.setCategory(category);
            this.product.setName(name);
            this.product.setStock(stock);
            this.product.setCost(cost);

            try {
                Main.db.productDao.update(product);
            } catch (SQLException ex) {
                Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error ProductsController updateProduct " + ex.getMessage());

            }
        }
        this.viewProducts();
    }

}
