/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author alina
 */
public abstract class DishDecorator implements Dish {
    private Dish dish;

    public DishDecorator(Dish dish) {
        this.dish = dish;
    }
    
    @Override
     public String getDescription(){
        return dish.getDescription();
    }
    
    @Override
    public int getPrice(){
        return dish.getPrice();
    }
    
}

