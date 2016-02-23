package com.bruce.collection.map;

import com.bruce.generic.pair3.Employee;

import java.util.HashMap;
import java.util.Map;

/**
 * This program demonstrates the use of a map with key type String and value type Employee
 * Created by bruce-jiang on 2016/2/23.
 * @version  1.0
 */
public class MapTest {
    public static void main(String[] args){
        Map<String,Employee> staff = new HashMap<>();
        staff.put("144-25-3443",new Employee("Amy Lee"));
        staff.put("143-25-3443",new Employee("Core Lee"));
        staff.put("145-25-3443",new Employee("Bruce Lee"));
        staff.put("146-25-3443",new Employee("Cool Lee"));
        staff.put("147-25-3443",new Employee("Ane Lee"));

        //print all entries
        System.out.println(staff);

        //remove an entry
        staff.remove("147-25-3443");

        //replace an entry
        staff.replace("143-25-3443",new Employee("Jhone"));

        //look up a value
        System.out.println(staff.get("143-25-3443"));

        //iterate through all entries
        for(Map.Entry<String, Employee> entry : staff.entrySet()){
            String key = entry.getKey();
            Employee value = entry.getValue();
            System.out.println("key = "+key+", value="+value);
        }
    }

}
