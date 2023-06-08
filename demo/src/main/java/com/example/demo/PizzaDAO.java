package com.example.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PizzaDAO {
    private List<pizza> pizzas;


    public PizzaDAO() {
        this.pizzas = new ArrayList<>();
    }


    public void ajouterPizza(pizza pizza) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/BDD_INGREDIENT", "root", "root");
            PreparedStatement statement = con.prepareStatement("INSERT INTO ingredient(nom, prix, nb_ing) VALUES(?, ?, ?);");
            statement.setString(1, pizza.getNom());
            statement.setFloat(2, pizza.getPrix());
            statement.setInt(3, pizza.getNbIngredients());

            statement.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void viderTableau() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/BDD_INGREDIENT", "root", "root");
            PreparedStatement statement = con.prepareStatement("DELETE * FROM ingredient;");
            statement.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<pizza> getPizzas() {
        List<pizza> pizzas = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/BDD_INGREDIENT", "root", "root");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ingredient");
            while (rs.next()) {
                pizza pizza = new pizza(rs.getString("nom"), rs.getFloat("prix"), rs.getInt("nb_ing"));
                pizzas.add(pizza);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pizzas;
    }



}
