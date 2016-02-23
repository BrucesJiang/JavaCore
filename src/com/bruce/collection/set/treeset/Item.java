package com.bruce.collection.set.treeset;

import java.util.Objects;

/**
 * An item with a description and part number
 * Created by bruce-jiang on 2016/2/23.
 * @version  1.0
 */
public class Item implements Comparable<Item>{
    private String description;
    private int partNumber;

    /**
     * Constructs an item
     * @param aDescription the item's description
     * @param aPartNumber the item's part number
     */
    public Item(String aDescription , int aPartNumber){
        this.description = aDescription;
        this.partNumber = aPartNumber;
    }

    /**
     * Gets the description of this item
     * @return ths description
     */
    public String getDescription(){
        return description;
    }


    public String toString(){
        return "[description=" + description + ",partNumber="+partNumber+"]";
    }

    public boolean equals(Object otherObject){
        if(this == otherObject) return true;
        if(otherObject == null) return false;
        if(getClass() != otherObject.getClass()) return false;
        Item other = (Item)otherObject;
        return Objects.equals(description,other.description) && partNumber==other.partNumber;
    }
    public int hashCode(){
        return Objects.hash(description,partNumber);
    }

    public int compareTo(Item other){
        return Integer.compare(partNumber,other.partNumber);
    }
}
