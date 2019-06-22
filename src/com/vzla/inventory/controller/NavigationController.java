/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vzla.inventory.controller;

import java.util.HashMap;
import com.vzla.inventory.main.Main;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
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

    public NavigationController() {
        loadUrlHash();
    }

    private void loadUrlHash() {
        urlHash.put("index", INDEX_URL);
        urlHash.put("products_index", PRODUCTS_INDEX_URL);
        urlHash.put("sales_index", SALES_INDEX_URL);

    }

    public WebView loadView(String urlName, MainController controller) {
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
                        bridge.setMember("CONTROLLER", controller);
                        webEngine.executeScript("load()");
                    }
                });

        webEngine.load(url);
        return browser;
    }

    public void goToView(String urlName, MainController controller, AnchorPane root) {
        WebView browser = this.loadView(urlName, controller);

        root.getChildren().clear();
        root.getChildren().add(browser);//adding the view

        AnchorPane.setBottomAnchor(root, 0.0);
        AnchorPane.setTopAnchor(root, 0.0);
        AnchorPane.setRightAnchor(root, 0.0);
        AnchorPane.setLeftAnchor(root, 0.0);
    }

    public static void goToView(String urlName, MainController controller) {

        Main.navController.goToView(urlName, controller, Main.root);

    }
}
