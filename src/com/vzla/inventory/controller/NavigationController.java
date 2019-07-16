/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vzla.inventory.controller;

import com.vzla.inventory.home.controller.IndexController;
import java.util.HashMap;
import com.vzla.inventory.main.Main;
import com.vzla.inventory.products.controller.CategoriesController;
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
    public CategoriesController categoriesController;
    public SalesController salesController;

    private WebView browser;
    private WebEngine webEngine;

    public NavigationController() {
        loadUrlHash();
        loadControllers();
    }

    /**
     * Hash of the controllers to be able to call them by name
     */
    private void loadControllers() {
        indexController = new IndexController();
        productsController = new ProductsController();
        salesController = new SalesController();
        categoriesController = new CategoriesController();

        controllerHash.put("index", indexController);

        controllerHash.put("products_index", productsController);
        controllerHash.put("products_create", productsController);
        controllerHash.put("products_edit", productsController);
        controllerHash.put("categories_index", categoriesController);

        controllerHash.put("sales_index", salesController);
        controllerHash.put("sales_create", salesController);

    }

    /**
     * Hash of the views files to be able to call them by name
     */
    private void loadUrlHash() {
        urlHash.put("index", INDEX_URL);
        urlHash.put("products_index", PRODUCTS_INDEX_URL);
        urlHash.put("products_create", PRODUCTS_FORM_URL);
        urlHash.put("products_edit", PRODUCTS_FORM_URL);
        urlHash.put("categories_index", CATEGORIES_INDEX_URL);

        urlHash.put("sales_index", SALES_INDEX_URL);
        urlHash.put("sales_create", SALES_FORM_INDEX_URL);

    }

    /**
     * loader of html, js views willPreload == true will, execute preload
     * function willLoad == true will, execute load function
     *
     * @param urlName
     * @param willPreload
     * @param willLoad
     * @return JavaFX Node WebView containing the webpage to load
     */
    public WebView loadView(String urlName, boolean willPreload, boolean willLoad) {
        browser = new WebView();
        webEngine = browser.getEngine();

        String url = this.getClass().getResource(urlHash.get(urlName)).toExternalForm();

        webEngine.getLoadWorker()
                .stateProperty()
                .addListener((obs, old, neww)
                        -> {
                    if (neww == Worker.State.SUCCEEDED) {//once the page has loaded
                        // Let JavaScript make calls to adder object,
                        // this will execute once the file is loaded
                        JSObject bridge = (JSObject) webEngine.executeScript("window");
                        bridge.setMember("JAVA_CONTROLLER", controllerHash.get(urlName));
                        // overriding javascript console.log with JAVA_CONTROLLER.log()
                        webEngine.executeScript("console.log = function(message)\n"
                                + "{\n"
                                + "    JAVA_CONTROLLER.log('[js log]' + message);\n"
                                + "};");
                        webEngine.executeScript("console.info = function(message)\n"
                                + "{\n"
                                + "    JAVA_CONTROLLER.log('[js info]' + message);\n"
                                + "};");
                        webEngine.executeScript("console.debug = function(message)\n"
                                + "{\n"
                                + "    JAVA_CONTROLLER.log('[js debug]' + message);\n"
                                + "};");
                        webEngine.executeScript("console.warn = function(message)\n"
                                + "{\n"
                                + "    JAVA_CONTROLLER.log('[js warn]' + message);\n"
                                + "};");
                        webEngine.executeScript("console.error = function(message)\n"
                                + "{\n"
                                + "    JAVA_CONTROLLER.log('[js error]' + message);\n"
                                + "};");
                        if (willPreload) {
                            webEngine.executeScript("preload()");

                        }
                        if (willLoad) {
                            webEngine.executeScript("load()");

                        }

                    }
                });

        webEngine.load(url);
        return browser; //view to show
    }

    /**
     * urlName to use a register name of the view. "willPreload" to load vue,
     * "willLoad" to load vue data
     *
     * @param urlName
     * @param root
     * @param willPreload
     * @param willLoad
     */
    public void goToView(String urlName, StackPane root, boolean willPreload, boolean willLoad) {
        browser = this.loadView(urlName, willPreload, willLoad);

        root.getChildren().clear();
        root.getChildren().add(browser);//adding the view
    }

    /**
     * urlName to use a register name of the view ."willPreload" to load vue,
     * "willLoad" to load vue data
     *
     * @param urlName
     * @param willPreload
     * @param willLoad
     */
    public static void goToView(String urlName, boolean willPreload, boolean willLoad) {

        Main.navController.goToView(urlName, Main.root, willPreload, willLoad);

    }
}
