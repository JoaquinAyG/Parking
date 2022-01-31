package org.example.Models;

import java.util.Arrays;

public class Parking {

    private Car[] cars;
    private int length;

    public Parking(int length){
        cars = new Car[length];
        this.length = length;
    }

    public Parking(Car[] cars, int length){
        this.length = length;
        this.cars = new Car[length];
        stackCars(cars);
    }

    public void stackCars(Car[] cars) {

        if(length < resize(cars)){
            System.out.println("Can not handle this cars in the new parking");
            throw new IllegalStateException();
        }

        int temp = 0;
        for (Car car : cars) {
            if (car != null) {
                this.cars[temp] = car;
                temp++;
            }
        }
    }

    public int resize(Car[] cars){
        int count = 0;
        for (int i = 0; i < cars.length; i++) {
            if(cars[i] != null){
                count++;
            }
        }
        return count;
    }

    public boolean isFull(){
        for (Car car:cars) {
            if(car == null){
                return false;
            }
        }
        return true;
    }

    public void add(Car car){

        if(isFull()){
            System.out.println("The parking is full");
            return;
        }
        for (int i = 0; i < length; i++) {
            if(cars[i] == null){
                cars[i] = car;
                System.out.println("car parked on position " + (i+1));
                return;
            }
        }
    }

    public void remove(int index){

        if(index < 0 || cars[index ]== null){
            System.out.println("There was no car in the spot selected");
        }
        cars[index] = null;
        System.out.println("the car left the position"+ (index + 1));
    }

    public int getLength() {
        return length;
    }

    public Car[] getCars() {
        return cars;
    }



    public int searchSpotReg(String reg){
        for (int i = 0; i < cars.length; i++) {
            if(cars[i] == null){

            }else if(cars[i].getReg().equals(reg)){
                return i;
            }
        }
        return -1;
    }

    public int[] searchSpotColor(String color) {

        int count = 0;
        for (Car car : cars) {
            if(car == null){

            }else if(car.getColor().equals(color)){
                count++;
            }
        }

        int[] spots = new int[count];

        count = 0;
        for (int i = 0; i < cars.length; i++) {
            if(cars[i] == null){

            } else if(color.equals(cars[i].getColor())){
                spots[count] = i;
                count++;
            }
        }
        return spots;
    }

    public String searchColorReg(String reg) {

        for (Car c:cars) {
            if(c == null){

            } else if(c.getReg().equals(reg)){
                return c.getColor();
            }
        }

        return null;
    }

    public String[] searchRegColor(String color) {
        int count = 0;
        for (Car car : cars) {
            if(car == null){

            } else if (color.equals(car.getColor())) {
                count++;
            }
        }

        String[] regs = new String[count];

        count = 0;
        for (Car car : cars) {
            if(car == null){

            } else if (color.equals(car.getColor())) {
                regs[count] = car.getReg();
                count++;
            }
        }
        return regs;
    }

    public void sort() {

        StringBuilder st = new StringBuilder();
        Car temp;

        Car[] sorted = cars.clone();

        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(sorted[i] == null){

                } else if (sorted[i].getDate().compareTo(sorted[j].getDate()) < 0){
                    temp = sorted[j];
                    sorted[j] = sorted[i];
                    sorted[i] = temp;
                }
            }
        }

        for (Car c: sorted) {
            if(c != null){
                st.append(c.getReg()).append(" ").append(c.getDate()).append("\n");
            }
        }
        System.out.println(st);
    }

    @Override
    protected Car[] clone(){
        Car[] cloned = new Car[length];
        int count = 0;
        for (int i = 0; i < length; i++) {
            if(this.cars[i] != null){
                cloned[count] = cars[i];
            }
        }
        return cloned;
    }
}
