package Classes;
import CreatorMenu.Hero;
import enumeration.Steath_level;

public class Hobbit extends Hero  {
    private int defencePower=35;
    private int health =50;

    public int getDefencePower() {
        return defencePower;
    }

    public void setDefencePower(int defencePower) {
        this.defencePower = defencePower;
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

    private int speed = 60;
    private Steath_level stelth;

    public Hobbit(String nameH, String FellowshipName, String race, int ageH, String Username, String Profession,Steath_level stelth) {
        super(nameH, FellowshipName, race, ageH, Username, Profession);
        this.defencePower = getDefencePower();
        this.health = getHealth();
        this.speed = getSpeed();
        this.stelth = stelth;
    }
    @Override
    public String toString(){
        return "Hobbit : "+"\nName : "+getNameH() +"\n"+"Race : "+getRace()+"\n"+"Age : "+getAgeH()+"\n"+"FellowshipName : "+getFellowshipName()+"\n"+"Profession : "+getProfession()+"\n"+"defencePower : "+defencePower+"\n"+"health : "+health+"\n"+"speed : "+speed+"\n"+"stelth : "+stelth;
    }

    @Override
    public String fight() {
        return getNameH()+" Hobbit not Fight, HOBBIT RUN!";
    }
}
