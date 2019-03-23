package pl.sda.addresBook.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pl.sda.addresBook.Main;
import pl.sda.addresBook.model.Person;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootViewController implements Initializable {

    @FXML
    private TableView<Person> personTableView;
    @FXML
    private TableColumn<Person,String> nameCol;
    @FXML
    private TableColumn<Person,String> lastNameCol;

    @FXML
    private Label nameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label telephoneLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Button newPerson;
    @FXML
    private Button edit;
    @FXML
    private Button save;
    @FXML
    private Button delete;



    private Main main;


    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }



    public int getIndexReadTable() {
        return personTableView.getSelectionModel ().getFocusedIndex ();
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
    public  void setColumn(){

    }

    public void loadPerson() {
        System.out.println (main.getPersonList ());
        personTableView.setItems (getMain ().getPersonList ());
        nameCol.setCellValueFactory (c->c.getValue ().nameProperty ());
        lastNameCol.setCellValueFactory (c->c.getValue ().lastNameProperty ());
    }

    public void ReadPerson() {

        Person person =  personTableView.getSelectionModel().getSelectedItem();
        nameLabel.setText(person.getName());
        lastNameLabel.setText(person.getLastName ());
        addressLabel.setText(person.getAddress ());
        cityLabel.setText(person.getCity());
        postalCodeLabel.setText(person.getPostalCode ());
        telephoneLabel.setText(person.getTelephone());
        /*System.out.println (personTableView.getSelectionModel ().getFocusedIndex ());*/

    }

    public void NewPersonScene() throws IOException {

        Stage newPersonStage = new Stage ();
        FXMLLoader fxmlLoader = new FXMLLoader ();
        fxmlLoader.setLocation (getClass ().getResource ("/NewPerson.fxml"));
        fxmlLoader.load ();
        Parent root = fxmlLoader.getRoot ();
        newPersonStage.setScene (new Scene (root,600,400));
        newPersonStage.show ();
        NewPersonViewController newPersonViewController = fxmlLoader.getController ();  // Przekazywanie meina do controlera
        newPersonViewController.setMain(this.getMain ());


    }

    public void EditPersonScene() throws IOException {
        Person person = personTableView.getSelectionModel ().getSelectedItem ();
        Stage editPersonStage = new Stage ();
        FXMLLoader fxmlLoader = new FXMLLoader ();
        fxmlLoader.setLocation (getClass ().getResource ("/EditPerson.fxml"));
        fxmlLoader.load ();

        Parent root = fxmlLoader.getRoot ();
        editPersonStage.setScene (new Scene (root,600,400));
        editPersonStage.show ();

        EditPersonViewController editPersonViewController= fxmlLoader.getController ();  // Przekazywanie meina do controlera
        editPersonViewController.setMain(this.getMain ());
        editPersonViewController.setIndexReadTable (getIndexReadTable ());
        editPersonViewController.showPerson (person);
    }

    public void delete(){
        getMain ().getPersonList ().remove (getIndexReadTable ());
    }




}
