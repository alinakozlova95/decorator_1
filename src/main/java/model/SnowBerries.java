/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author alina
 */
public class SnowBerries extends DishDecorator {
    public SnowBerries(Dish dish) {
        super(dish);
    }

    @Override
    public String getDescription() {
        return dish.getDescription() + " + Снежные ягоды";
    }

    @Override
    public int getPrice() {
        return dish.getPrice() + 6;
    }
}