package com.vzla.inventory.sales.controller;

import com.vzla.inventory.controller.MainController;
import com.vzla.inventory.controller.NavigationController;
import com.vzla.inventory.main.Main;
import com.vzla.inventory.products.models.Product;
import com.vzla.inventory.sales.models.Sale;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisr
 */
public class SalesController extends MainController {

    public Sale sale;
    public Object products[];
//    public Object productSalesRelation[];

    public SalesController() {
    }

    public void viewSales() {
        NavigationController.goToView("sales_index", true, true);

    }

    public void viewSalesCreate() {
        sale = new Sale();

        try {
            Main.db.saleDao.refresh(sale);

            products = Main.db.productDao.queryForAll().toArray();
        } catch (SQLException ex) {
            Logger.getLogger(SalesController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Products viewSalesCreate error: " + ex.getMessage());
        }

        NavigationController.goToView(
                "sales_create", true, true);
    }

    public Product getEmptyProduct() {
        return new Product();
    }

}
