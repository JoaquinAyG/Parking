package org.example;

import org.example.Utils.Action;

public class Main {

    public static void main(String[] args){

        while(true){
            try{
                Action.gameLoop();
            } catch(Exception ignored){

            }
        }
    }
}
