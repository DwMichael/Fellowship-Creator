package program.game_main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {


    @FXML
    private Button LogInButton;

    @FXML
    private Button RegisterButton;

    @FXML
    private Button logoutButton;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private Stage stage;

    @FXML
    public void GoToLogInPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Controllers/LogIn.fxml"));
        Stage window=(Stage)LogInButton.getScene().getWindow();
        window.setScene(new Scene(root,1379, 773));
    }
    @FXML
    public void GoToRegisterPage(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/Controllers/Register.fxml"));
        Stage window=(Stage)RegisterButton.getScene().getWindow();
        window.setScene(new Scene(root,1379, 773));
    }
    @FXML
    public void logout(ActionEvent event){
        stage = (Stage) scenePane.getScene().getWindow();
        System.out.println("You successfully shut down program.");
        stage.close();
    }


}