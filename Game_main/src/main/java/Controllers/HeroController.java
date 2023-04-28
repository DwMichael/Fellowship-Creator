package Controllers;
import Classes.Archer;
import Classes.Hobbit;
import Classes.Magician;
import Classes.Warrior;
import CreatorMenu.Hero;
import Db.DbObject;
import Exeptions.BlankFieldExeption;
import enumeration.Steath_level;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static Controllers.FellowshipController.getCurrentFellowship;
import static Db.MemoryDataBase.CurrentUser;
import static Db.MemoryDataBase.DataBase;


public class HeroController implements Initializable {


    public static Hero getHeroInf() {
        return HeroInf;
    }

    public static void setHeroInf(Hero heroInf) {
        HeroInf = heroInf;
    }

    private static Hero HeroInf;
    int k=1;
    int o=0;
    String CurrentFellowship;
    String HeroProfession;
    int age2;
    @FXML
    private TextField AgeHero;

    @FXML
    private ComboBox<Steath_level> SL;

    @FXML
    private CheckBox ArcherX;

    @FXML
    private Text FN;

    @FXML
    private Button GoBack;

    @FXML
    private Button HSButton;

    @FXML
    private TextField HeroName;

    @FXML
    private CheckBox HobbitX;
    @FXML
    private TextField searchH;
    @FXML
    private CheckBox MageX;

    @FXML
    private TextField RaceP;

    @FXML
    private CheckBox WarriorX;
    @FXML
    private Button viewFightButton;
    @FXML
    private Label LabelFight;
    @FXML
    private Text userN;
//---------------Table
    @FXML
    private Text userN1;
    @FXML
    private TableView<DbObject> TableH;
    @FXML
    private TableColumn<Hero, Integer> AgeHColumn;
    @FXML
    private TableColumn<Hero, String> HeroNameColumn;
    @FXML
    private TableColumn<Hero, Integer> NumberHColumn;
    @FXML
    private TableColumn<Hero, String> ProfessionColumn;

    @FXML
    private TableColumn<Hero, String> RaceHColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SL.getItems().addAll(Steath_level.values());
        NumberHColumn.setCellValueFactory(new PropertyValueFactory<>("numIDH"));
        HeroNameColumn.setCellValueFactory(new PropertyValueFactory<>("nameH"));
        AgeHColumn.setCellValueFactory(new PropertyValueFactory<>("ageH"));
        RaceHColumn.setCellValueFactory(new PropertyValueFactory<>("race"));
        ProfessionColumn.setCellValueFactory(new PropertyValueFactory<>("Profession"));
        userN.setText(CurrentUser);
        FN.setText(getCurrentFellowship());
        ArrayList<Hero> FH = FindHero();
        ObservableList<DbObject> temp = FXCollections.observableArrayList(FH);
        TableH.setItems(temp);

    }
    public void CreateHero(ActionEvent event) throws IOException {

        if (MageX.isSelected()) {
            o = o + 1;
            HeroProfession = "Mage";
        }
        if (WarriorX.isSelected()) {
            o = o + 1;
            HeroProfession = "Warrior";
        }
        if (ArcherX.isSelected()) {
            o = o + 1;
            HeroProfession = "Archer";
        }
        if (HobbitX.isSelected()) {
            o = o + 1;
            HeroProfession = "Hobbit";

        }
        try {
            age2 = Integer.parseInt(AgeHero.getText());
            CH();

        } catch (BlankFieldExeption ex) {
            JOptionPane.showMessageDialog(null, "Fill field of your fellowship name", "Alert", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Age is number! Pleas write digits!", "Alert", JOptionPane.INFORMATION_MESSAGE);
            AgeHero.clear();
        }
        o=0;
    }

    public void CF(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Controllers/Fellowship.fxml"));
        Stage window = (Stage) GoBack.getScene().getWindow();
        window.setScene(new Scene(root,1379, 773));
    }
    public void HS(ActionEvent actionEvent) throws IOException {
        Hero HeroInf =(Hero)TableH.getSelectionModel().getSelectedItem();
        if(HeroInf!=null) {
            ImageIcon icon= new ImageIcon(HeroController.class.getResource("/Icon/C1.png"));
            JOptionPane.showMessageDialog(null, HeroInf, "Hero Data", JOptionPane.INFORMATION_MESSAGE,icon);
        }else
        {
            ImageIcon icon= new ImageIcon(HeroController.class.getResource("/Icon/sauron.png"));
            JOptionPane.showMessageDialog(null,"Chose Hero", "Hero Data", JOptionPane.INFORMATION_MESSAGE,icon);
        }
    }
    public void CH() throws BlankFieldExeption,NumberFormatException {
        if (HeroName.getText().isBlank() || AgeHero.getText().isBlank() || RaceP.getText().isBlank())
            throw new BlankFieldExeption();
        if((MageX.isSelected() || WarriorX.isSelected() || ArcherX.isSelected() || HobbitX.isSelected()) && o==1){
        if (k<=9) {
            if(MageX.isSelected())
                CreateMage();
            if(WarriorX.isSelected())
                CreateWarrior();
            if(ArcherX.isSelected())
               CreateArcher();
            if(HobbitX.isSelected())
                CreateHobbit();

            k++;
        }else
        {
           JOptionPane.showMessageDialog(null, "You can have only 10 Fellowships!", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }
        }else
        {
           JOptionPane.showMessageDialog(null, "You can have only 1 Profession", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    @FXML
    void removeHero(ActionEvent event) throws IOException {
        try {
            T();
            ObservableList<DbObject> customers2 = FXCollections.observableArrayList(FindHero());
            TableH.getItems().remove(customers2);
            TableH.setItems(customers2);
            k--;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Chose Hero to delete", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void T(){
        int name2 = TableH.getSelectionModel().getSelectedItem().getId();
        int pozycjadousuniecia=-1;
        for(int i = 0 ; i<DataBase.size(); i++) {
            if (DataBase.get(i) instanceof Hero) {
                Hero u = (Hero) DataBase.get(i);
                if (u.getId().equals(name2)) {
                    pozycjadousuniecia = i;
                }
            }
        }
        DataBase.remove(pozycjadousuniecia);

    }

    //----------------------------------Creater Mage,Warrior,Archer,Hobbit
    private void CreateMage() {
        int rndNum =(int)(Math.random()*101);

        Magician magician = new Magician(HeroName.getText(),getCurrentFellowship(),RaceP.getText(),age2,CurrentUser,HeroProfession,rndNum);
        ObservableList<DbObject> magicians = TableH.getItems();
        magicians.add(magician);
        DataBase.add(magician);
        TableH.setItems(magicians);

    }
    private void CreateWarrior() {
        int rndNum =(int)(Math.random()*101);

        Warrior warrior = new Warrior(HeroName.getText(),getCurrentFellowship(),RaceP.getText(),age2,CurrentUser,HeroProfession,rndNum);
        ObservableList<DbObject> warriors  = TableH.getItems();
        warriors.add(warrior);
        DataBase.add(warrior);
        TableH.setItems(warriors);

    }
    private void CreateArcher() {
        int rndNum =(int)(Math.random()*101);
        int rndNum2 =(int)(Math.random()*23);
        Archer archer = new Archer(HeroName.getText(),getCurrentFellowship(),RaceP.getText(),age2,CurrentUser,HeroProfession,rndNum,rndNum2);
        ObservableList<DbObject> archers = TableH.getItems();
        archers.add(archer);
        DataBase.add(archer);
        TableH.setItems(archers);

    }
    private void CreateHobbit() {
        if(SL.getSelectionModel().getSelectedItem()!=null) {
            Hobbit hobbit = new Hobbit(HeroName.getText(), getCurrentFellowship(), RaceP.getText(), age2, CurrentUser, HeroProfession, SL.getSelectionModel().getSelectedItem());
            ObservableList<DbObject> hobbits = TableH.getItems();
            hobbits.add(hobbit);
            DataBase.add(hobbit);
            TableH.setItems(hobbits);
        }else
        {
            ImageIcon icon= new ImageIcon(HeroController.class.getResource("/Icon/house.png"));
            JOptionPane.showMessageDialog(null, "To Create Hero Hobbit Chose Steath_level!", "Alert", JOptionPane.INFORMATION_MESSAGE,icon);
        }
    }
    public ArrayList<Hero> FindHero(){

        ArrayList<Hero> FH = new ArrayList<>();
        for(DbObject Do : DataBase ){
            if(Do instanceof Hero ){
                Hero u =(Hero) Do;
                if(u.getFellowshipName().equals(getCurrentFellowship())){
                    FH.add(u);
                }
            }

        }
        return FH;
    }
    public void viewFight(ActionEvent actionEvent)throws IOException {
        try {
            Hero hero = (Hero) TableH.getSelectionModel().getSelectedItem();

            LabelFight.setText(hero.fight());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Chose Hero!", "Alert", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void FiltrHero() {
        ArrayList<DbObject> F = new ArrayList<>();
        for(DbObject Do : DataBase ){
            if(Do instanceof Hero){
                Hero u =(Hero) Do;
                String ToLower = u.getTextValue().toLowerCase();
                if(u.getUsername().equals(CurrentUser) && ToLower.contains(searchH.getText().toLowerCase())){
                    F.add(u);
                }
                TableH.getItems().setAll(F);
            }

        }

    }

}
