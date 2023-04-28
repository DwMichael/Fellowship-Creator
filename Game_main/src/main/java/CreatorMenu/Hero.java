package CreatorMenu;

import Classes.IVent;
import Db.DbObject;

public abstract class Hero extends DbObject implements IVent {
    private String race;
    private String nameH;
    private int ageH;
    private String FellowshipName;
    private String Username ;
    private int numIDH ;
    private String Profession;
    public String getProfession() {
        return Profession;
    }

    public void setProfession(String profession) {
        Profession = profession;
    }



    public String getFellowshipName() {
        return FellowshipName;
    }

    public void setFellowshipName(String fellowshipName) {
        FellowshipName = fellowshipName;
    }

    public int getNumIDH() {
        return numIDH;
    }

    public void setNumIDH(int numIDH) {
        this.numIDH = numIDH;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    /*public String getName() {
        return nameH;
    }

    public void setName(String nameH) {
        this.nameH = nameH;
    }*/

    public int getAgeH() {
        return ageH;
    }

    public void setAgeH(int ageH) {
        this.ageH = ageH;
    }


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getNameH() {
        return nameH;
    }

    public void setNameH(String nameH) {
        this.nameH = nameH;
    }

    public Hero(String nameH, String FellowshipName, String race, int ageH, String Username, String Profession) {
        super(nameH);
        this.nameH =nameH;
        this.race=race;
        this.ageH=ageH;
        this.numIDH=getId();
        this.FellowshipName=FellowshipName;
        this.Username = Username;
        this.Profession=Profession;

    }
    public String fight()
    {
        return getNameH()+" fight";
    }


}

