package ru.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.models.CoffeeMachine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CoffeeMachineDAO {
    /*private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Ca57wlzq";

    private static Connection connection;
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CoffeeMachineDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CoffeeMachine> index() {
        /*List<CoffeeMachine> coffeeMachines = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM coffeeMachine3";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()){
                CoffeeMachine coffeeMachine = new CoffeeMachine();

                coffeeMachine.setId(resultSet.getInt("id"));
                coffeeMachine.setNameOfTheDrink(resultSet.getString("nameOfTheDrink"));
                coffeeMachine.setSortOfCoffee(resultSet.getString("sortOfCoffee"));
                coffeeMachine.setKindOfMilk(resultSet.getString("kindOfMilk"));
                coffeeMachine.setAmountOfDrink(resultSet.getDouble("amountOfDrink"));
                coffeeMachine.setAmountOfCoffee(resultSet.getInt("amountOfCoffee"));

                coffeeMachines.add(coffeeMachine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coffeeMachines;*/
        return jdbcTemplate.query("SELECT * FROM coffeeMachine3", new CoffeeMachineMapper());
    }

    public CoffeeMachine show(int id) {
        /*CoffeeMachine coffeeMachine = null;
        try {
            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM coffeeMachine3 WHERE id=?");

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            coffeeMachine = new CoffeeMachine();
            coffeeMachine.setId(resultSet.getInt("id"));
            coffeeMachine.setNameOfTheDrink(resultSet.getString("nameOfTheDrink"));
            coffeeMachine.setSortOfCoffee(resultSet.getString("sortOfCoffee"));
            coffeeMachine.setKindOfMilk(resultSet.getString("kindOfMilk"));
            coffeeMachine.setAmountOfDrink(resultSet.getDouble("amountOfDrink"));
            coffeeMachine.setAmountOfCoffee(resultSet.getInt("amountOfCoffee"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coffeeMachine;*/
        return jdbcTemplate.query("SELECT * FROM coffeeMachine3 WHERE id=?", new Object[]{id},
                        new BeanPropertyRowMapper<>(CoffeeMachine.class))
                .stream().findAny().orElse(null);
    }

    public void save(CoffeeMachine coffeeMachine){
        /*try{
            PreparedStatement statement =
                    connection.prepareStatement("INSERT INTO coffeeMachine3 VALUES(1, ?, ?, ?, ?, ?)");

            statement.setString(1, coffeeMachine.getNameOfTheDrink());
            statement.setString(2, coffeeMachine.getSortOfCoffee());
            statement.setString(3, coffeeMachine.getKindOfMilk());
            statement.setDouble(4, coffeeMachine.getAmountOfDrink());
            statement.setInt(5, coffeeMachine.getAmountOfCoffee());

            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }*/
        jdbcTemplate.update("NSERT INTO coffeeMachine3 VALUES(1, ?, ?, ?, ?, ?)", coffeeMachine.getNameOfTheDrink(),
                coffeeMachine.getSortOfCoffee(),
                coffeeMachine.getKindOfMilk(),
                coffeeMachine.getAmountOfDrink(),
                coffeeMachine.getAmountOfCoffee());
    }
    public void update(int id, CoffeeMachine coffeeMachine){
        /*try {
            PreparedStatement statement =
                    connection.prepareStatement("UPDATE coffeeMachine3 SET nameOfTheDrink=?, sortOfCoffee=?," +
                            " kindOfMilk=?, amountOfDrink=?, amountOfCoffee=? WHERE id=?");
            statement.setString(1, coffeeMachine.getNameOfTheDrink());
            statement.setString(2, coffeeMachine.getSortOfCoffee());
            statement.setString(3, coffeeMachine.getKindOfMilk());
            statement.setDouble(4, coffeeMachine.getAmountOfDrink());
            statement.setInt(5, coffeeMachine.getAmountOfCoffee());
            statement.setInt(6, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        jdbcTemplate.update("UPDATE coffeeMachine3 SET nameOfTheDrink=?, sortOfCoffee=?," +
                        " kindOfMilk=?, amountOfDrink=?, amountOfCoffee=? WHERE id=?",  coffeeMachine.getNameOfTheDrink(),
                coffeeMachine.getSortOfCoffee(),
                coffeeMachine.getKindOfMilk(),
                coffeeMachine.getAmountOfDrink(),
                coffeeMachine.getAmountOfCoffee(), id);
    }

    public void delete(int id){
        /*PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM coffeeMachine3 WHERE id=?");
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        jdbcTemplate.update("DELETE FROM coffeeMachine3 WHERE id=?", id);
    }

}
