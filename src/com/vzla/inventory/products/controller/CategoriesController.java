package com.vzla.inventory.products.controller;

import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.vzla.inventory.controller.MainController;
import com.vzla.inventory.controller.NavigationController;
import com.vzla.inventory.main.Main;
import com.vzla.inventory.products.models.Category;
import com.vzla.inventory.products.models.Product;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisr
 */
public class CategoriesController extends MainController {

    public Object categories[];
    public Category category;

    public CategoriesController() {
    }

    public void viewCategories() {
        try {
            this.categories = Main.db.categoryDao.queryForAll().toArray();
        } catch (SQLException ex) {
            Logger.getLogger(ProductsController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error CategoriesController viewCategories " + ex.getMessage());
        }
        NavigationController.goToView("categories_index", true, true);

    }

    /**
     * Safe Delete of a category
     *
     * @param id
     * @return
     */
    public boolean deleteCategory(int id) {
        GenericRawResults<String[]> rawResults;
        List<String[]> results;
        String[] resultArray;
        try {
            rawResults
                    = Main.db.productDao.queryRaw(
                            String.format(
                                    "select count(*) from product where %s = %d",
                                    Product.CATEGORY_FIELD_NAME,
                                    id)); //raw sql with orm with count, one value is expected
            results = rawResults.getResults();//list of results
            resultArray = results.get(0); // first array of the list of results

            if (Integer.parseInt(resultArray[0]) >= 1) { //if the count is greater than 0 then this category cannot be deleted
                return false;
            } else {
                //The category can be safely deleted
                Main.db.categoryDao.deleteById(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriesController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error CategoriesController deleteCategory " + ex.getMessage());
            return false; //error deleting
        }
        this.viewCategories(); //has been safely deleted then reload
        return true;
    }
}
