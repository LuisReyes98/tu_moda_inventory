package com.vzla.inventory.products.controller;

import com.vzla.inventory.controller.MainController;
import com.vzla.inventory.controller.NavigationController;
import com.vzla.inventory.main.Main;
import com.vzla.inventory.products.models.Category;
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
    public Object categories[];
    public String modelAction = "";
    public boolean isEditing;
    public Category category;

    public ProductsController() {
    }

    public void viewProductsCreate() {
        this.product = new Product(new Category());
        this.modelAction = "Crear";
        this.isEditing = false;
        prepareForm();

        NavigationController.goToView("products_create", true, true);
    }

    public void viewProductsEdit(int id) {
        this.modelAction = "Editar";
        this.isEditing = true;
        prepareForm();

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

    public boolean createProduct(String categoryName, int categoryId, String name, int stock, float cost) {
        this.category = prepareCategory(categoryName, categoryId);

        this.product = new Product(category, name, stock, cost);
        try {
            Main.db.productDao.create(product);
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error ProductsController saveNewProduct " + ex.getMessage());
        }
        this.viewProducts();
        return true;
    }

    public void updateProduct(String categoryName, int categoryId, String name, int stock, float price, int id) {
        this.category = prepareCategory(categoryName, categoryId);

        if (this.isEditing && this.product.getId() == id) {
            this.isEditing = false;
            this.product.setCategory(category);
            this.product.setName(name);
            this.product.setStock(stock);
            this.product.setPrice(price);

            try {
                Main.db.productDao.update(product);
            } catch (SQLException ex) {
                Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error ProductsController updateProduct " + ex.getMessage());

            }
        }
        this.viewProducts();
    }

    public void deleteProduct(int id) {
        try {

            Main.db.productDao.deleteById(id);
            this.viewProducts();
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error ProductsController deleteProduct " + ex.getMessage());

        }
    }

    /**
     * to set a new category it will take the categoryName and categoryId must
     * be 0. This is to prepare the category before saving a product
     *
     * @param categoryName
     * @param categoryId
     * @return
     */
    private Category prepareCategory(String categoryName, int categoryId) {
        Category categorieDumb = new Category();

        try {
            if (categoryId <= 0) {
                categorieDumb = new Category(categoryName);
                Main.db.categoryDao.create(categorieDumb);
            } else {
                categorieDumb = Main.db.categoryDao.queryForId(categoryId);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error ProductsController saveNewProduct creating category " + ex.getMessage());
        }
        return categorieDumb;
    }

    /**
     * Method to execute before creating or editing a product
     */
    private void prepareForm() {
        getCategories();
    }

    private void getCategories() {
        try {
            this.categories = Main.db.categoryDao.queryForAll().toArray();
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error ProductsController getCategories " + ex.getMessage());
        }
    }
}
