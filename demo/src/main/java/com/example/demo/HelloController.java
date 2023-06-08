package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TableView<pizza> tableau;

    @FXML
    private TableColumn<pizza, Integer> prix;
    @FXML
    private TableColumn<pizza, String> recette;
    @FXML
    private TableColumn<pizza, Integer> nombre_ingredient;
    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnViderTableau;

    @FXML
    private TextField recetteForm;
    @FXML
    private TextField prixForm;
    @FXML
    private TextField ingredientForm;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        recette.setCellValueFactory(new PropertyValueFactory<>("recette"));
        nombre_ingredient.setCellValueFactory(new PropertyValueFactory<>("ingredient"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        getPizzas();
    }

    @FXML
    private void viderTableau() {
        // Supprimer toutes les pizzas de la base de données et vider le tableau
        PizzaDAO pizzaDAO = new PizzaDAO();
        pizzaDAO.viderTableau();
        tableau.getItems().clear();
    }

    @FXML
    private void ajouterPizza() {
        // Ajouter une pizza à la base de données et au tableau
        String recette = recetteForm.getText();
        int prix = Integer.parseInt(prixForm.getText());
        int ingredient = Integer.parseInt(ingredientForm.getText());
        pizza nouvellePizza = new pizza(recette, prix, ingredient);
        PizzaDAO pizzaDAO = new PizzaDAO();
        pizzaDAO.ajouterPizza(nouvellePizza);
        tableau.getItems().add(nouvellePizza);

        // Effacer les champs de formulaire après l'ajout de la pizza
        recetteForm.clear();
        prixForm.clear();
        ingredientForm.clear();
        getPizzas();
    }

    @FXML
    private void getPizzas() {
        PizzaDAO pizzaDAO = new PizzaDAO();
        List<pizza> pizzas = pizzaDAO.getPizzas();
        ObservableList<pizza> pizzaList = FXCollections.observableArrayList(pizzas);
        tableau.setItems(pizzaList);
    }



}




