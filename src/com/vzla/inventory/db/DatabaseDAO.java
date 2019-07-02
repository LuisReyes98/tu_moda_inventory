/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vzla.inventory.db;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;

import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.vzla.inventory.products.controller.ProductsController;
import com.vzla.inventory.products.models.Category;
import com.vzla.inventory.products.models.Product;
import com.vzla.inventory.products.models.ProductDeleted;
import com.vzla.inventory.sales.models.ProductsSaleRelation;
import com.vzla.inventory.sales.models.Sale;
import com.vzla.inventory.sales.models.SaleDeleted;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisr
 */
public class DatabaseDAO {

    private final String DB = "inventory.sqlite3",
            DATABASE_URL = "jdbc:sqlite:" + DB;

    public ConnectionSource connectionSource;

    public Dao<Category, Integer> categoryDao;

    public Dao<Product, Integer> productDao;

    public Dao<ProductDeleted, Integer> productDeletedDao;

    public Dao<Sale, Integer> saleDao;

    public Dao<SaleDeleted, Integer> saleDeletedDao;

    public Dao<ProductsSaleRelation, Integer> productSalesRelationDao;

    public DatabaseDAO() {
    }

    public void startConnections() {

        try {
            //connect to the database
            connectionSource = new JdbcConnectionSource(DATABASE_URL);
        } catch (SQLException e) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Error DatabaseDAO connection" + e.getMessage());
        }

        try {
            //create the database tables
            //Category table
            TableUtils.createTableIfNotExists(connectionSource, Category.class);
            // Product Table
            TableUtils.createTableIfNotExists(connectionSource, Product.class);
            //Product Deleted
            TableUtils.createTableIfNotExists(connectionSource, ProductDeleted.class);
            //Sale
            TableUtils.createTableIfNotExists(connectionSource, Sale.class);
            //Sale Deleted
            TableUtils.createTableIfNotExists(connectionSource, SaleDeleted.class);
            //ProductsSaleRelation
            TableUtils.createTableIfNotExists(connectionSource, ProductsSaleRelation.class);

        } catch (SQLException e) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Error DatabaseDAO Tables" + e.getMessage());
        }

        try {
            //create the DAOs

            //Category Dao
            categoryDao = DaoManager.createDao(connectionSource, Category.class);

            // product Dao
            productDao = DaoManager.createDao(connectionSource, Product.class);
            //product deleted
            productDeletedDao = DaoManager.createDao(connectionSource, ProductDeleted.class);
            //sale dao
            saleDao = DaoManager.createDao(connectionSource, Sale.class);
            //sale deleted Dao
            saleDeletedDao = DaoManager.createDao(connectionSource, SaleDeleted.class);
            //products Sale Relation
            productSalesRelationDao = DaoManager.createDao(connectionSource, ProductsSaleRelation.class);

        } catch (SQLException e) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Error DatabaseDAO failed to create DAOs" + e.getMessage());
        }

    }
}
