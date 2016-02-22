package com.bruce.generic.pair3;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by bruce-jiang on 2016/2/22.
 */
public class Employee {
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary, int year, int month, int day){
        this.name = name;
        this.salary = salary;
        GregorianCalendar calendar = new GregorianCalendar(year,month-1, day);
        hireDay = calendar.getTime();
    }

    public String getName(){
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDay(){
        return hireDay;
    }

    public void raiseSalary(double byPrecent){
        double raise = salary*byPrecent/100;
        salary += raise;
    }
}
