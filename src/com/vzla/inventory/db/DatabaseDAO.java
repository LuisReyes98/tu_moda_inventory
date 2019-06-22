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
import com.vzla.inventory.products.models.Product;
import java.sql.SQLException;

/**
 *
 * @author luisr
 */
public class DatabaseDAO {

    private final String DB = "inventory.sqlite3",
            DATABASE_URL = "jdbc:sqlite:" + DB;

    public ConnectionSource connectionSource;
    public Dao<Product, Integer> productDao;

    public DatabaseDAO() {
    }

    public void startConnections() {
        try {
            connectionSource = new JdbcConnectionSource(DATABASE_URL);

            // if you need to create the table
            TableUtils.createTable(connectionSource, Product.class);

            //create DAO
            productDao = DaoManager.createDao(connectionSource, Product.class);
        } catch (SQLException e) {
            System.out.println("Error DatabaseDAO" + e.getMessage());
        }
    }
}
