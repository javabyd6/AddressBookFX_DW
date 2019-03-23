package pl.sda.addresBook.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
        this.IndexReadTable = indexReadTable;
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


    }

    public void save(){
        getMain ().getPersonList ().get (getIndexReadTable ()).setName (NameIn.getText ());
        getMain ().getPersonList ().get (getIndexReadTable ()).setLastName (LastNameIn.getText ());
        getMain ().getPersonList ().get (getIndexReadTable ()).setAddress (AddressIn.getText ());
        getMain ().getPersonList ().get (getIndexReadTable ()).setPostalCode (PostCodeIn.getText ());
        getMain ().getPersonList ().get (getIndexReadTable ()).setTelephone (TelephoneIn.getText ());
        getMain ().getPersonList ().get (getIndexReadTable ()).setCity (CityIn.getText ());
        closeButtonAction ();

    }
    public void showPerson(Person person){
        NameIn.setText (person.getName ());
        LastNameIn.setText (person.getLastName ());
        AddressIn.setText (person.getAddress ());
        PostCodeIn.setText (person.getPostalCode ());
        TelephoneIn.setText (person.getTelephone ());
        CityIn.setText (person.getCity ());
    }

    @FXML
    private void closeButtonAction() {
        // get a handle to the stage
        Stage stage = (Stage) Cancel.getScene ().getWindow ();
        // do what you have to do
        stage.close ();
    }
}
