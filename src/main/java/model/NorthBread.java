/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author alina
 */
public class NorthBread extends DishDecorator {
    public NorthBread(Dish dish) {
        super(dish);
    }

    @Override
    public String getDescription() {
        return dish.getDescription() + " + Норвежская лепешка";
    }

    @Override
    public int getPrice() {
        return dish.getPrice() + 7;
    }

}
