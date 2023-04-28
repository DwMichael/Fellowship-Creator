package program.game_main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        try{
            Parent root = FXMLLoader.load((getClass().getResource("menu.fxml")));
            Scene scene = new Scene(root,1379, 773);
            //Background image and icon image
            //Image icon = new Image("/Icon/logo.png");
            Image icon = new Image(getClass().getResource("/Icon/logo.png").toExternalForm());
            String css = this.getClass().getResource("/css/Main.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.getIcons().add(icon);
            //Title
            stage.setTitle("Fellowship Creator");
            //calling scene
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);




        }catch(Exception e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        MenuController controller= new MenuController();

        launch();
    }
}