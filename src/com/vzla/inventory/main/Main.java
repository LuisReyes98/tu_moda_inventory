/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vzla.inventory.main;

import com.vzla.inventory.controller.NavigationController;
import com.vzla.inventory.db.DatabaseDAO;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author luisr
 */
public class Main extends Application {

    public static DatabaseDAO db = new DatabaseDAO();
    public static StackPane root = new StackPane();
    public static NavigationController navController = new NavigationController();

    private Scene scene;

    @Override

    public void start(Stage primaryStage) {

        navController.goToView("index", root, false, false);

        scene = new Scene(root);

        primaryStage.setTitle("Control de Inventario");
        primaryStage.setScene(scene);
        primaryStage.show();

        db.startConnections();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

//    private void ormTest() {
//        Product pro = new Product("Camisa", "negra", 12);
//        Product pro2 = null;
//        db.startConnections();
//        try {
//            db.productDao.create(pro);
//
//            pro2 = db.productDao.queryForId(pro.getId());
//
//            System.out.println(pro2.getCategory() + " " + pro2.getName() + " " + pro2.getStock());
//        } catch (SQLException e) {
//            System.out.println("Error Main" + e.getMessage());
//        }
//
//    }
}
