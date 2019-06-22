/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vzla.inventory.main;

import com.vzla.inventory.db.DatabaseDAO;
import com.vzla.inventory.products.models.Product;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author luisr
 */
public class Main extends Application {

    public static DatabaseDAO db = new DatabaseDAO();

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        ormTest();

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

    private void ormTest() {
        Product pro = new Product("Camisa", "negra", 12);
        Product pro2 = null;
        db.startConnections();
        try {
            db.productDao.create(pro);

            pro2 = db.productDao.queryForId(pro.getId());

            System.out.println(pro2.getCategory() + " " + pro2.getName() + " " + pro2.getStock());
        } catch (SQLException e) {
            System.out.println("Error Main" + e.getMessage());
        }

    }

}
