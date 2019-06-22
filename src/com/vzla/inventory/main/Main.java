/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vzla.inventory.main;

import com.vzla.inventory.controller.IndexController;
import com.vzla.inventory.controller.NavigationController;
import com.vzla.inventory.db.DatabaseDAO;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author luisr
 */
public class Main extends Application {

    public static DatabaseDAO db = new DatabaseDAO();
    public static AnchorPane root = new AnchorPane();
    public static NavigationController navController = new NavigationController();
    private IndexController controller = new IndexController();
    private Scene scene;

    @Override

    public void start(Stage primaryStage) {
//        WebView browser = navController.loadView("index", controller);
//
//        root.getChildren().add(browser);//adding the view
        navController.goToView("index", controller, root);

        scene = new Scene(root);

        primaryStage.setTitle("Control de Inventario");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

//    private WebView loadIndex() {
//        WebView browser = new WebView();
//        WebEngine webEngine = browser.getEngine();
//        String url = this.getClass().getResource(INDEX_URL).toExternalForm();
//
//        webEngine.getLoadWorker()
//                .stateProperty()
//                .addListener((obs, old, neww)
//                        -> {
//                    if (neww == Worker.State.SUCCEEDED) {
//                        // Let JavaScript make calls to adder object,
//                        // this will execute once the file is loaded
//                        JSObject bridge = (JSObject) webEngine.executeScript("window");
//                        bridge.setMember("CONTROLLER", controller);
//                        webEngine.executeScript("load()");
//                    }
//                });
//
//        webEngine.load(url);
//        return browser;
//    }
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
