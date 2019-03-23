package pl.sda.addresBook.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.sda.addresBook.Main;
import pl.sda.addresBook.model.Person;


import java.net.URL;
import java.util.ResourceBundle;

public class NewPersonViewController implements Initializable {

    @FXML
    private TextField NameIn;
    @FXML
    private TextField LastNameIn;
    @FXML
    private TextField AddressIn;
    @FXML
    private TextField PostCodeIn;
    @FXML
    private TextField TelephoneIn;
    @FXML
    private TextField CityIn;
    @FXML
    private Button Save;
    @FXML
    private Button Cancel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void SaveNewPerson(){

        getMain ().getPersonList ().add ((new Person (NameIn.getText (),LastNameIn.getText (),AddressIn.getText (),PostCodeIn.getText (),
                TelephoneIn.getText (),CityIn.getText ())));
        closeButtonAction ();
    }

    @FXML
    private void closeButtonAction(){
        // get a handle to the stage
        Stage stage = (Stage) Cancel.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    private Main main;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
