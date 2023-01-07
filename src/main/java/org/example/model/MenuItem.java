package org.example.model;

import javax.persistence.*;
import java.util.List;
//@Entity
public class MenuItem {
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    private int itemId;
    private String itemName;
    private boolean veg;
    private int calories;
    private float price;
    private boolean isAvailable;
//    private int orderId;

    public MenuItem() {
    }
    public MenuItem(String name) {
        this.itemName = name;
    }
}
