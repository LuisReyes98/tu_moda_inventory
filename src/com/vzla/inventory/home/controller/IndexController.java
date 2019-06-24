/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vzla.inventory.home.controller;

import com.vzla.inventory.controller.MainController;
import com.vzla.inventory.controller.NavigationController;
import com.vzla.inventory.main.Main;

/**
 *
 * @author luisr
 */
public class IndexController extends MainController {

    public IndexController() {
        super();
    }

    public void viewIndex() {
        NavigationController.goToView("index");
    }

}
