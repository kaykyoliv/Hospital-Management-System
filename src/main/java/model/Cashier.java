package model;

import java.util.Scanner;

public class Cashier extends Employee{

    public Cashier (){
        super();
        this.options = new Option[] {};
    }

    @Override
    public void showList(Scanner sc, Database database) {

    }

    @Override
    public int getJob() {
        return 1;
    }
}
