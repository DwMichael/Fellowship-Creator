package Controllers;

import Db.MemoryDataBase;
import Exeptions.BlankFieldExeption;
import Exeptions.InvalidAgeLengthExeption;
import Exeptions.InvalidLogNLengthExeption;
import Users.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class RegisterController {
    boolean valid = false;
    int age = 0, Temp = 0, UserNum = 1;
    String ageStr, FullName, Password;
    String name, login, password;

    public RegisterController() {
    }


    @FXML
    private TextField username;
    @FXML
    private TextField Fullname;
    @FXML
    private TextField ageid;
    @FXML
    private Button MenuButton;
    @FXML
    private PasswordField passwordField;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;
    @FXML
    private Button LogMenuButton;


    public void CreateUser(ActionEvent event) throws IOException {

        ageStr = ageid.getText();
        login = username.getText();
        try {
            CR();
            JOptionPane.showMessageDialog(null, "You have successfully created your account!\n Go back to LoginPage to LogIn.", "Alert", JOptionPane.INFORMATION_MESSAGE);
            Fullname.clear();
            ageid.clear();
            username.clear();
            passwordField.clear();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Age is number! Pleas write 2 digits!", "Alert", JOptionPane.INFORMATION_MESSAGE);
            ageid.clear();
        } catch (InvalidAgeLengthExeption ex) {
            JOptionPane.showMessageDialog(null, "This number is invalid ! Enter only 2 digits !", "Alert", JOptionPane.INFORMATION_MESSAGE);
            ageid.clear();
        } catch (BlankFieldExeption ex) {
            JOptionPane.showMessageDialog(null, "You left some fields blank!", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }catch(InvalidLogNLengthExeption ex)
        {
            JOptionPane.showMessageDialog(null, "Max number of characters is 9! \n enter 9-characters in login name field! ", "Alert", JOptionPane.INFORMATION_MESSAGE);
            username.clear();
        }



    }

    public void GoToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/program/game_main/menu.fxml"));
        Stage window = (Stage) MenuButton.getScene().getWindow();
        window.setScene(new Scene(root,1379, 773));
    }

    public void CR() throws NumberFormatException, InvalidAgeLengthExeption, BlankFieldExeption,InvalidLogNLengthExeption {
        if (ageStr.length() > 2 || ageStr.length() < 1)
            throw new InvalidAgeLengthExeption();
        if (login.length() > 9)
            throw new InvalidLogNLengthExeption();
        if (username.getText().isBlank() || passwordField.getText().isBlank() || Fullname.getText().isBlank() || ageid.getText().isBlank())
            throw new BlankFieldExeption();
        age = Integer.parseInt(ageStr);
        name = Fullname.getText();
        password = passwordField.getText();
        User u = new User(name, age, login, password);
        MemoryDataBase.DataBase.add(u);

    }
    public void GoToLogInPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Controllers/LogIn.fxml"));
        Stage window=(Stage)LogMenuButton.getScene().getWindow();
        window.setScene(new Scene(root,1379, 773));
    }


}
