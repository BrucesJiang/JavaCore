package com.bruce.generic.pair3;

/**
 * Created by bruce-jiang on 2016/2/22.
 */
public class Manager extends  Employee {
    private double bonus;

    public Manager(String name, double salary, int year, int month, int day){
        super(name,salary,year,month,day);
        bonus = 0;
    }

    public double getSalary(){
        double baseSalary = super.getSalary();
        return baseSalary+bonus;
    }

    public void setBonus(double bonus){
        this.bonus = bonus;
    }

    public double getBonus(){
        return bonus;
    }
}
