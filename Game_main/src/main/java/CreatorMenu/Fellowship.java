package CreatorMenu;

import Db.DbObject;

public class Fellowship extends DbObject {
    private String nameF;
    private int numID ;
    private String Username;
    private static int maxSizeFellowship=10;

    public static int getMaxSizeFellowship() {
        return maxSizeFellowship;
    }
    public static void setMaxSizeFellowship(int maxSizeFellowship) {
        Fellowship.maxSizeFellowship = maxSizeFellowship;
    }






    public String getNameF() {
        return nameF;
    }

    public void setNameF(String nameF) {
        this.nameF = nameF;
    }

    public int getNumID() {
        return numID;
    }

    public void setNumID(int numID) {
        this.numID = numID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public Fellowship(String nameF, String Username) {
        super(nameF);
        this.nameF =nameF;
        this.numID=getId();
        this.Username = Username;

    }





    @Override
    public String toString(){
        return numID+ " "+"Fellowship :"+" "+ nameF +" "+ Username;
    }
}
