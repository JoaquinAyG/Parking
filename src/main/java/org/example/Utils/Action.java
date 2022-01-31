package org.example.Utils;

import org.example.Models.Car;
import org.example.Models.Command;
import org.example.Models.Roots;
import org.example.Models.Parking;

public class Action {

    public static Parking parking;

    public static void gameLoop(){

        Command c = null;

        try {
            c = new Command(Input.command());
        } catch (Exception e){
            System.out.println("Illegal expression");
        }
        if(c != null) {
            Action.read(c);
        }
    }

    public static void read(Command command){

        Roots root = command.getRoot();
        String[] args = command.getArgs();

        switch (root){
            case EXIT:System.exit(0);
            case PARK: exceptionByLength(2, command.getLength()); parkCar(args); break;
            case LEAVE: exceptionByLength(1, command.getLength()); leave(args); break;
            case CREATE: exceptionByLength(1, command.getLength()); create(args); break;
            case SHOW_SPOT: exceptionByLength(1, command.getLength()); showSpot(args); break;
            case SPOT_BY_REG: exceptionByLength(1, command.getLength()); spotByReg(args); break;
            case SPOT_BY_COLOR: exceptionByLength(1, command.getLength()); spotByColor(args); break;
            case COLOR_BY_REG: exceptionByLength(1, command.getLength()); colorByReg(args); break;
            case REG_BY_COLOR: exceptionByLength(1, command.getLength()); regByColor(args); break;
            case SORT_BY_DATE: exceptionByLength(0, command.getLength()); sortByDate(); break;
        }
    }

    private static void sortByDate() {
        parking.sort();
    }

    private static void regByColor(String[] args) {
        String color = args[0];

        String[] regs = parking.searchRegColor(color);

        if(regs.length > 0){
            StringBuilder st = new StringBuilder("These cars have the color -");
            for (String i: regs){
                st.append(i).append(" ");
            }
            System.out.println(st);
        } else {
            System.out.println("There are no cars with this color");
        }
    }

    private static void colorByReg(String[] args) {

        String reg = args[0];

        String color = parking.searchColorReg(reg);

        if(color != null){
            System.out.println("The car is color -" + color);
        }
    }

    private static void spotByColor(String[] args) {

        String color = args[0];

        int[] spots = parking.searchSpotColor(color);

        if(spots.length > 0){
            StringBuilder st = new StringBuilder("These cars are on spots -");
            for (int i: spots){
                st.append(i+1).append(" ");
            }
            System.out.println(st);
        } else {
            System.out.println("There are no cars with this color");
        }

    }

    private static void spotByReg(String[] args) {

        String reg = args[0];

        int spot = parking.searchSpotReg(reg);

        if(spot != -1){
            System.out.println("The car is on spot -" + (spot+1));
        }
    }

    private static void showSpot(String[] args) {

        int index = Integer.parseInt(args[0])-1;
        try {
            System.out.println(parking.getCars()[index]);
        } catch (Exception e){
            System.out.println("Theres no car in that spot");
        }
    }

    private static void create(String[] args) {

        int length = Integer.parseInt(args[0]);
        if(parking == null) {
            parking = new Parking(length);
        } else {
            parking = new Parking(parking.getCars(), length);
        }
        System.out.println("new parking created with length " + length);
    }

    private static void parkCar(String[] args) {

        String reg = args[0];
        String color = args[1];

        Car c = new Car(reg, color);

        parking.add(c);
    }

    private static void leave(String[] args) {

        int index = Integer.parseInt(args[0]) - 1;

        parking.remove(index);
    }

    private static void exceptionByLength(int expected, int actual){

        if(expected != actual){
            throw new IllegalArgumentException();
        }
    }
}
