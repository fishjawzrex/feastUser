package org.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

//@Entity
public class Order {
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private LocalDateTime date;
    private int userId;
    private float totalPrice;
    private List<Integer> itemIdList;
    private int totalCalories;
    private boolean orderReady;

    public Order() {
    }
    public Order(int id) {
        this.userId = id;
        this.date = LocalDateTime.now();
    }



}
