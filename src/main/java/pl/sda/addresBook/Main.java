package pl.sda.addresBook;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sda.addresBook.controller.NewPersonViewController;
import pl.sda.addresBook.controller.RootViewController;
import pl.sda.addresBook.model.Person;



public class Main extends Application {

    private ObservableList<Person> personList = FXCollections.observableArrayList ();

    public Main() {
        personList.add(new Person ("Jan","Kowalski","adres","12345","72727272","Bydgoszcz"));
        personList.add(new Person ("Marian","Kwaśniewski","adres","12345","72727272","Bydgoszcz"));
        personList.add(new Person ("Karol","Adamczyk","adres","12345","72727272","Bydgoszcz"));
    }

    public ObservableList<Person> getPersonList(){
        return personList;
    }

    public static void main(String[] args) {
        launch (args);
    }
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader ();
        fxmlLoader.setLocation (getClass ().getResource ("/root.fxml"));
        fxmlLoader.load ();

        Parent root = fxmlLoader.getRoot ();
        RootViewController rootViewController = fxmlLoader.getController ();
        rootViewController.setMain (this);

        rootViewController.loadPerson();
        primaryStage.setTitle ("Programik");
        primaryStage.setScene (new Scene (root,600,400));
        primaryStage.show ();
        System.out.println (personList);
    }
}
