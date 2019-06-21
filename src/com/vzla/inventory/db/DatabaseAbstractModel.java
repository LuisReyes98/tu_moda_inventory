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
public abstract class DatabaseAbstractModel {

    public abstract void read();

    public abstract void write();

    public abstract void edit();

    public abstract void delete();

    public abstract void install();

}
