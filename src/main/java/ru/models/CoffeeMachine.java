package ru.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class CoffeeMachine {
    @NotEmpty(message = "id should not be empty")
    @Min(value = 0, message = "Id should be greater than 0")
    private int id;
    @NotEmpty(message = "Name of the drink should not be empty")
    private String nameOfTheDrink;
    @NotEmpty(message = "sort of coffee should not be empty")
    private String sortOfCoffee;
    private String kindOfMilk;
    @NotEmpty(message = "amount of drink should not be empty")
    private double amountOfDrink;
    @NotEmpty(message = "amount of coffee should not be empty")
    private int amountOfCoffee;

    CoffeeMachine(int id, String nameOfTheDrink, String sortOfCoffee, String kindOfMilk, double amountOfDrink,
                  int amountOfCofee){
        this.id = id;
        this.nameOfTheDrink = nameOfTheDrink;
        this.sortOfCoffee = sortOfCoffee;
        this.kindOfMilk = kindOfMilk;
        this.amountOfDrink = amountOfDrink;
        this.amountOfCoffee = amountOfCofee;
    }

    public CoffeeMachine(){

    }
    public void setId(int id){
        this.id = id;
    }
    public void setNameOfTheDrink(String nameOfTheDrink){
        this.nameOfTheDrink = nameOfTheDrink;
    }
    public void setSortOfCoffee(String sortOfCoffee){
        this.sortOfCoffee = sortOfCoffee;
    }
    public void setKindOfMilk(String kindOfMilk){
        this.kindOfMilk = kindOfMilk;
    }
    public void setAmountOfDrink(double amountOfDrink){
        this.amountOfDrink = amountOfDrink;
    }
    public void setAmountOfCoffee(int amountOfCofee){
        this.amountOfCoffee = amountOfCofee;
    }
    public int getId(){
        return id;
    }
    public String getNameOfTheDrink(){
        return nameOfTheDrink;
    }
    public String getSortOfCoffee(){
        return sortOfCoffee;
    }
    public String getKindOfMilk(){
        return kindOfMilk;
    }
    public double getAmountOfDrink(){
        return amountOfDrink;
    }
    public int getAmountOfCoffee(){
        return amountOfCoffee;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", Название напитка: " + nameOfTheDrink +
                ", сорт кофе: " + sortOfCoffee +
                ", вид молока: " + kindOfMilk +
                ", кол-во напитка: " + amountOfDrink +
                ", кол-во кофе: " + amountOfCoffee;
    }
}
