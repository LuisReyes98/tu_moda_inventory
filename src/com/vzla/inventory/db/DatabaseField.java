/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vzla.inventory.db;

/**
 *
 * @author luisr
 */
public class DatabaseField {

    public String name;
    public String type;

    public boolean notNull;
    public boolean unique;
    public boolean id;
    public boolean autoincrement;

    public boolean references;

    public DatabaseField referencedField;

}
