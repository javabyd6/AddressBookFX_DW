package pl.sda.addresBook.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pl.sda.addresBook.Main;
import pl.sda.addresBook.model.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class EditPersonViewController implements Initializable {


    private Main main;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    private int IndexReadTable;
    public void setIndexReadTable(int indexReadTable) {
        IndexReadTable = indexReadTable;
    }

    public int getIndexReadTable() {
        return IndexReadTable;
    }

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

        System.out.println (getIndexReadTable ());

    }
}
