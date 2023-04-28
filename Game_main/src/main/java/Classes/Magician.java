package Classes;

import CreatorMenu.Hero;
import enumeration.Steath_level;

public class Magician extends Hero {
    private int magicPower;
    private int defencePower=10;
    private int health =70;
    private int speed = 25;



    public int getDefencePower() {
        return defencePower;
    }

    public void setDefencePower(int defencePower) {
        this.defencePower = defencePower;
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
    public Steath_level getStelth() {
        return stelth;
    }

    public void setStelth(Steath_level stelth) {
        this.stelth = stelth;
    }

    private Steath_level stelth=null;
    public Magician(String nameH, String FellowshipName, String race, int ageH, String Username, String Profession, int magicPower) {
        super(nameH, FellowshipName, race, ageH, Username, Profession);
        this.magicPower = magicPower;
        this.defencePower = getDefencePower();
        this.health = getHealth();
        this.speed = getSpeed();
        this.stelth=getStelth();
    }
    @Override
    public String toString(){
        return "Magician : "+"\nName : "+getNameH() +"\n"+"Race : "+getRace()+"\n"+"Age :"+getAgeH()+"\n"+"FellowshipName : "+getFellowshipName()+"\n"+"Profession : "+getProfession()+"\n"+"Magic Power : "+ magicPower +"\n"+"defencePower : "+defencePower+"\n"+"health : "+health+"\n"+"speed : "+speed+"\n"+"stelth : "+stelth;
    }
    @Override
    public String fight() {
        return getNameH()+" Magician throw FIREBOLL!";
    }
}
