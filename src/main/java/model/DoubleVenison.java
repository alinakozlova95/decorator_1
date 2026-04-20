/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author alina
 */
public class DoubleVenison  extends DishDecorator {
    public DoubleVenison(Dish dish) {
        super(dish);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Двойная порция оленины";
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 20;
    }
}