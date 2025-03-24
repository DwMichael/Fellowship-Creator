package Controllers;
import CreatorMenu.Fellowship;
import Db.DbObject;
import Exeptions.BlankFieldExeption;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static CreatorMenu.Fellowship.getMaxSizeFellowship;
import static Db.MemoryDataBase.CurrentUser;
import static Db.MemoryDataBase.DataBase;



public class FellowshipController implements Initializable {
    int i =0;
    int k=1;

    public static String getCurrentFellowship() {
        return CurrentFellowship;
    }

    public static void setCurrentFellowship(String currentFellowship) {
        CurrentFellowship = currentFellowship;
    }

    private static String CurrentFellowship;

    //------------------------------TableF
    @FXML
    private TextField FellowshipName;

    @FXML
    private TableView<DbObject> TableYCF;

    @FXML
    private TableColumn<Fellowship, String> Fname;
    @FXML
    private TableColumn<Fellowship, Integer> NumberF;
    //------------------------------TabelaH
    @FXML
    private TableView<DbObject> TableALL;
    @FXML
    private TableColumn<DbObject, Integer> IdObjec;
    @FXML
    private TableColumn<DbObject, String> ObjectName;


    //------------------------------Buttons
    @FXML
    private Button GoToSpec;
    @FXML
    private Button SYF;
    @FXML
    private Button LogOutB;
    @FXML
    private Button CH;
    @FXML
    private Button FiltrOb;
    @FXML
    private Button CFButton;

    //------------------------------Text
    @FXML
    private TextField searchF;
    @FXML
    private TextField searchedWord;
    @FXML
    private Text userN;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userN.setText(CurrentUser);
        //-----------------------------
        NumberF.setCellValueFactory(new PropertyValueFactory<>("numID"));
        Fname.setCellValueFactory(new PropertyValueFactory<>("nameF"));
        ArrayList<Fellowship> FSH = FindFelllow();
        ObservableList<DbObject> temp = FXCollections.observableArrayList(FSH);
        TableYCF.setItems(temp);
        //----------------------------
        IdObjec.setCellValueFactory(new PropertyValueFactory<>("Id"));
        ObjectName.setCellValueFactory(new PropertyValueFactory<>("TextValue"));
        ArrayList<DbObject> DB = FindDB();
        ObservableList<DbObject> temp2 = FXCollections.observableArrayList(DB);
        TableALL.setItems(temp2);
    }


    public void CreateFellowship(ActionEvent event) throws IOException{

        try{
            CF();
        }catch(BlankFieldExeption ex){
            JOptionPane.showMessageDialog(null, "Fill field of yoru fellowship name", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }    }
    @FXML
    void removeCustomer(ActionEvent event) throws IOException {
        try {
            T();
            ObservableList<DbObject> customers2 = FXCollections.observableArrayList(FindFelllow());
            TableYCF.getItems().remove(customers2);
            TableYCF.setItems(customers2);
            ObservableList<DbObject> customers3 = FXCollections.observableArrayList(FindDB());
            TableALL.setItems(customers3);
            k--;
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Chose Fellowship to delete", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void GoToH(ActionEvent actionEvent)throws IOException {
        try {
            CurrentFellowship = TableYCF.getSelectionModel().getSelectedItem().getTextValue();
            Parent root = FXMLLoader.load(getClass().getResource("/Controllers/Hero.fxml"));
            Stage window = (Stage) CH.getScene().getWindow();
            window.setScene(new Scene(root, 1379, 773));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "To Create Hero Chose Your Fellowship", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void LogOut(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/program/game_main/menu.fxml"));
        Stage window = (Stage) LogOutB.getScene().getWindow();
        window.setScene(new Scene(root,1379, 773));
    }

    public void Sp(ActionEvent actionEvent) throws IOException {
        DbObject Info =(DbObject)TableALL.getSelectionModel().getSelectedItem();
        if(Info!=null) {
            ImageIcon icon= new ImageIcon(HeroController.class.getResource("/Icon/LORD.png"));
            JOptionPane.showMessageDialog(null, Info, "Object Data", JOptionPane.INFORMATION_MESSAGE,icon);
        }else
        {
            ImageIcon icon= new ImageIcon(HeroController.class.getResource("/Icon/LORD.png"));
            JOptionPane.showMessageDialog(null,"Chose Object", "Object Data", JOptionPane.INFORMATION_MESSAGE,icon);
        }
    }
    public void CF() throws BlankFieldExeption {
        if (FellowshipName.getText().isBlank())
            throw new BlankFieldExeption();
        if (k<=getMaxSizeFellowship()) {
            Fellowship customer = new Fellowship(FellowshipName.getText(), CurrentUser);
            ObservableList<DbObject> customers = TableYCF.getItems();
            ObservableList<DbObject> tb = TableALL.getItems();
            customers.add(customer);
            tb.add(customer);
            DataBase.add(customer);
            TableYCF.setItems(customers);
            TableALL.setItems(tb);
            k++;
        }else
        {
            ImageIcon icon= new ImageIcon(HeroController.class.getResource("/Icon/F12.png"));
            JOptionPane.showMessageDialog(null, "You can have only 10 Fellowships!", "Alert", JOptionPane.INFORMATION_MESSAGE,icon);
        }
    }
    public ArrayList<Fellowship> FindFelllow(){
        ArrayList<Fellowship> FSH = new ArrayList<>();
        for(DbObject Do : DataBase ){
            if(Do instanceof Fellowship ){
                Fellowship u =(Fellowship) Do;
                if(u.getUsername().equals(CurrentUser)){
                    FSH.add(u);
                }
            }

        }
        return FSH;
    }
    public void T(){
        int name2 = TableYCF.getSelectionModel().getSelectedItem().getId();
        int pozycjadousuniecia=-1;
        for(int i = 0 ; i<DataBase.size(); i++) {
            if (DataBase.get(i) instanceof Fellowship) {
                Fellowship u = (Fellowship) DataBase.get(i);
                if (u.getId().equals(name2)) {
                    pozycjadousuniecia = i;
                }
            }
        }
        DataBase.remove(pozycjadousuniecia);

 }
    public ArrayList<DbObject> FindDB(){
        ArrayList<DbObject> DB = new ArrayList<>();
        for(DbObject DataBases : DataBase) {
            DB.add(DataBases);
        }
        return DB;
    }
    public void FilterOb() {
        ArrayList<DbObject> DB = new ArrayList<>();
        for(DbObject DataBases : DataBase) {
            String deviceToLower = DataBases.getTextValue().toLowerCase();
            if (deviceToLower.contains(searchedWord.getText().toLowerCase())) {
                DB.add(DataBases);
            }
            TableALL.getItems().setAll(DB);
        }
    }
    public void FilterFell() {
        ArrayList<DbObject> F = new ArrayList<>();
        for(DbObject Do : DataBase ){
            if(Do instanceof Fellowship ){
                Fellowship u =(Fellowship) Do;
                String ToLower = u.getTextValue().toLowerCase();
                if(u.getUsername().equals(CurrentUser) && ToLower.contains(searchF.getText().toLowerCase())){
                    F.add(u);
                }
                TableYCF.getItems().setAll(F);
            }

        }

    }


}
