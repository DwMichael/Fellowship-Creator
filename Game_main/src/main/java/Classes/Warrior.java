package Classes;

import CreatorMenu.Hero;
import enumeration.Steath_level;

public class Warrior extends Hero {


    private int attackPower;
    private int defencePower=80;
    private int health =100;
    private int speed = 10;

    public int getDefencePower() {
        return defencePower;
    }

    public void setDefencePower(int defencePower) {
        this.defencePower = defencePower;
    }

    public Warrior(String nameH, String FellowshipName, String race, int ageH, String Username, String Profession, int attackPower) {
        super(nameH, FellowshipName, race, ageH, Username, Profession);
        this.attackPower = attackPower;
        this.defencePower = getDefencePower();
        this.health = getHealth();
        this.speed = getSpeed();
        this.stelth = getStelth();
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
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


    public Steath_level getStelth() {
        return stelth;
    }

    public void setStelth(Steath_level stelth) {
        this.stelth = stelth;
    }

    private Steath_level stelth=null;
    @Override
    public String toString(){
        return "Warrior : "+"\nName : "+getNameH() +"\n"+"Race : "+getRace()+"\n"+"Age : "+getAgeH()+"\n"+"FellowshipName : "+getFellowshipName()+"\n"+"Profession : "+getProfession()+"\n"+"defencePower : "+defencePower+"\n"+"health : "+health+"\n"+"speed : "+speed+"\n"+"stelth : "+stelth;
    }
    public String fight() {
        return getNameH()+" Warrior hit enemy with his BIG AXE!";
    }
}
