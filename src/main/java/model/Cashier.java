package model;

public class Cashier extends Employee{

    public Cashier (){
        super();
        this.options = new Option[] {};
    }

    @Override
    public int getJob() {
        return 1;
    }
}
