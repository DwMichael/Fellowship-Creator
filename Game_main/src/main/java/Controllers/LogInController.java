package Controllers;

import Db.MemoryDataBase;
import Exeptions.InValidPasswordException;
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

public class LogInController {
    @FXML
    private Button MenuButton;
    @FXML
    private Button RegisterButton;
    @FXML
    private Button LoginButton;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;
    @FXML
    private TextField TbLog;
    @FXML
    private PasswordField Passwd;


    public void LoginButton(ActionEvent event) throws IOException {
        String clogin = TbLog.getText();
        String cPasswd = Passwd.getText();
        try {
            if (MemoryDataBase.LogIn(clogin, cPasswd)) {
                Parent root = FXMLLoader.load(getClass().getResource("/Controllers/Fellowship.fxml"));
                Stage window = (Stage) LoginButton.getScene().getWindow();
                window.setScene(new Scene(root, 1379, 773));
            }else
            {
                JOptionPane.showMessageDialog(null, "No such User", "Alert", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (InValidPasswordException e) {
            JOptionPane.showMessageDialog(null, "Invalid Password!", "Alert", JOptionPane.INFORMATION_MESSAGE);
            Passwd.clear();
        }


    }

    public void GoToRegisterPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Controllers/Register.fxml"));
        Stage window = (Stage) RegisterButton.getScene().getWindow();
        window.setScene(new Scene(root,1379, 773));
    }

    public void GoToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/program/game_main/menu.fxml"));
        Stage window = (Stage) MenuButton.getScene().getWindow();
        window.setScene(new Scene(root,1379, 773));

    }
}
