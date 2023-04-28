module Game_main {
    requires javafx.graphics;
    requires  javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires java.desktop;

    opens program.game_main;
    opens Users;
    opens Controllers;
    opens CreatorMenu;
    opens Db;


}