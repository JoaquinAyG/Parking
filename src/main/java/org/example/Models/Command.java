package org.example.Models;

public class Command {

    private Roots root;
    private String[] args;
    private int length;

    public Command (String command){
        div(command);
    }

    public void div(String st){

        String[]strings = st.split(" ");

        this.root = Roots.valueOf(strings[0]);
        this.length = strings.length-1;

        args = new String[strings.length-1];
        System.arraycopy(strings, 1, args, 0, strings.length - 1);
    }

    public Roots getRoot() {
        return root;
    }

    public String[] getArgs() {
        return args;
    }

    public int getLength() {
        return length;
    }
}
