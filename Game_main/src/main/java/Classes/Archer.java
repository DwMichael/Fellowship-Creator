package Classes;

import CreatorMenu.Hero;
import enumeration.Steath_level;

public class Archer extends Hero {

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getMagicPower() {
        return magicPower;
    }

    public void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private int attackPower;
    private int magicPower=10;
    private int defencePower=20;
    private int health =70;
    private int speed = 30;

    public Steath_level getStelth() {
        return stelth;
    }

    public void setStelth(Steath_level stelth) {
        this.stelth = stelth;
    }

    private Steath_level stelth=null;

    public Archer(String nameH, String FellowshipName, String race, int ageH, String Username, String Profession, int attackPower, int magicPower) {
        super(nameH, FellowshipName, race, ageH, Username, Profession);
        this.attackPower = attackPower;
        this.magicPower = getMagicPower();
        this.health = getHealth();
        this.speed = getSpeed();
        this.stelth=getStelth();
    }
    @Override
    public String toString(){
        return "Archer : "+"\nName :"+getNameH() +"\n"+"Race :"+getRace()+"\n"+"Age :"+getAgeH()+"\n"+"FellowshipName :"+getFellowshipName()+"\n"+"Profession :"+getProfession()+"\n"+"Magic Power :"+ magicPower +"\n"+"defencePower :"+defencePower+"\n"+"health :"+health+"\n"+"speed :"+speed+"\n"+"stelth :"+stelth;
    }
    public String fight() {
        return getNameH()+" Archer shoot arrow!";
    }
}
