package org.example.Models;

import java.util.Date;

public class Car {

    private String reg;
    private String color;
    private Date date;

    public Car(String reg, String color){
        this.reg = reg;
        this.color = color;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "Car{" +
                "reg='" + reg + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public String getReg() {
        return reg;
    }

    public String getColor() {
        return color;
    }

    public Date getDate() {
        return date;
    }
}
