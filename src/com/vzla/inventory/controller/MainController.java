/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vzla.inventory.controller;

/**
 *
 * @author luisr
 */
public class MainController {

    public MainController() {
    }

    public void goToIndex() {
        NavigationController.goToView("index", new IndexController());
    }

}
