/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vzla.inventory.controller;

import com.vzla.inventory.home.controller.IndexController;
import java.util.HashMap;
import com.vzla.inventory.main.Main;
import com.vzla.inventory.products.controller.ProductsController;
import com.vzla.inventory.sales.controller.SalesController;
import javafx.concurrent.Worker;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

/**
 *
 * @author luisr
 */
public class NavigationController implements NavigationInterface {

    private static HashMap<String, String> urlHash = new HashMap<String, String>();
    private static HashMap<String, MainController> controllerHash = new HashMap<String, MainController>();

    public IndexController indexController;
    public ProductsController productsController;
    public SalesController salesController;

    public NavigationController() {
        loadUrlHash();
        loadControllers();
    }

    private void loadControllers() {
        indexController = new IndexController();
        productsController = new ProductsController();
        salesController = new SalesController();

        controllerHash.put("index", indexController);

        controllerHash.put("products_index", productsController);
        controllerHash.put("products_create", productsController);

        controllerHash.put("sales_index", salesController);

    }

    private void loadUrlHash() {
        urlHash.put("index", INDEX_URL);
        urlHash.put("products_index", PRODUCTS_INDEX_URL);
        urlHash.put("products_create", PRODUCTS_CREATE_URL);

        urlHash.put("sales_index", SALES_INDEX_URL);

    }

    public WebView loadView(String urlName) {
        WebView browser = new WebView();
        WebEngine webEngine = browser.getEngine();

        String url = this.getClass().getResource(urlHash.get(urlName)).toExternalForm();

        webEngine.getLoadWorker()
                .stateProperty()
                .addListener((obs, old, neww)
                        -> {
                    if (neww == Worker.State.SUCCEEDED) {
                        // Let JavaScript make calls to adder object,
                        // this will execute once the file is loaded
                        JSObject bridge = (JSObject) webEngine.executeScript("window");
                        bridge.setMember("JAVA_CONTROLLER", controllerHash.get(urlName));
                        webEngine.executeScript("load()");
                    }
                });

        webEngine.load(url);
        return browser;
    }

    public void goToView(String urlName, StackPane root) {
        WebView browser = this.loadView(urlName);

        root.getChildren().clear();
        root.getChildren().add(browser);//adding the view
    }

    public static void goToView(String urlName) {

        Main.navController.goToView(urlName, Main.root);

    }
}
