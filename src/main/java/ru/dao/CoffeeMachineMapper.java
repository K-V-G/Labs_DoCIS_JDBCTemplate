package ru.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.models.CoffeeMachine;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoffeeMachineMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.setId(resultSet.getInt("id"));
        coffeeMachine.setNameOfTheDrink(resultSet.getString("nameOfTheDrink"));
        coffeeMachine.setSortOfCoffee(resultSet.getString("sortOfCoffee"));
        coffeeMachine.setKindOfMilk(resultSet.getString("kindOfMilk"));
        coffeeMachine.setAmountOfDrink(resultSet.getDouble("amountOfDrink"));
        coffeeMachine.setAmountOfCoffee(resultSet.getInt("amountOfCoffee"));
        return coffeeMachine;
    }
}
