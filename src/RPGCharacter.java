public interface RPGCharacter {
    String getName();
    int getLevel();
    String getJobName();
    void levelUp();
    Accessory[] getEquippedAccessory();

    // ไม่ได้บอกให้เขียน class Equipment
    //Equipment[] getEquippedEquipment();
    default void showCharacterInfo(){
        System.out.println("name: " + getName());
        System.out.println("level: "+ getLevel());
        System.out.println("Job: "+ getJobName());
        System.out.println("Accessory : ");
        for( Accessory acc : getEquippedAccessory()){
            System.out.println(acc.getName()+" ");
        }

        // ไม่ได้บอกให้เขียน class Equipment
//        System.out.println("Equipment : ");
//        for( Equipment equ : getEquippedEquipment()){
//            System.out.println(equ.getName()+" ");
//        }
//


    }

}

interface Job extends RPGCharacter{
    String getJobName();
   String getAbility(int a);

    default void showAllAbilities() {
        System.out.println("Job : " + getJobName());
        System.out.println("Ability 1 : " + getAbility(1));
        System.out.println("Ability 2 : " + getAbility(2));


    }

}
interface Warrior extends Job{
    void slash();
    void block();

    default String getJobName() {
        return "Warrior";
    }
    default String getAbility(int a){
        return a == 1 ? "slash" : "block" ;
    }

}
interface Mage extends  Job{
    void castSpell();
    void teleport();

    default String getJobName() {
        return "Mage";
    }
    default String getAbility(int a){
        return a == 1 ? "castSpell" : "teleport" ;
    }
}

interface Archer extends  Job{
    void shot();
    void dodge();

    default String getJobName() {
        return "Archer";
    }
    default String getAbility(int a){
        return a == 1 ? "shot" : "dodge" ;
    }
}

abstract class BaseCharacter implements RPGCharacter{
    private  String name;
    private  int level;
    private double hp, maxHp, mana, maxMana, baseSpeed,speed, maxSpeed;

    //ไม่ได้บอกให้เขียน
    //    MainWeapon mainHand;
//    SubWeapon subHand;
    Amulet amulet;
    Ring ring;
    Earring earring;

    BaseCharacter(String name,double maxHp,double maxMana,double maxSpeed,int level,double baseSpeed){
        this.name = name;
        this.level = level;
        this.maxHp = maxHp;
        hp = maxHp;
        this.maxMana = maxMana;
        mana = maxMana;
        this.baseSpeed =baseSpeed;
        this.maxSpeed = maxSpeed;
        //mainHand  = null;
        // subHand = null;
         amulet = null;
         ring = null;
         earring = null;


    }

    public void showStats() {
        System.out.println("name :" + name);
        System.out.println("level :" + level);
        System.out.println("Hp :" + hp+"/"+ maxHp);
        System.out.println("mana : " + mana+"/"+ maxMana);
        System.out.println("speed : " +speed +"/"+ maxSpeed);
    }
    public String getName(){
        return name;

    }
    public int getLevel(){
        return level;
    }
    public void levelUp(){
        System.out.println("your level Up!");
    }

    void equipAccessory(Accessory mama){
        System.out.println("equiped accessory : " + mama);
    }

    //ไม่ได้บอกให้เขียน
//    void equipEquiment(Equipement ma){
//        System.out.println("quiped quuiment : " + ma);
//    }

}

class WarriorCharacter extends BaseCharacter implements Warrior{

    WarriorCharacter(String name, double maxHp, double maxMana, double maxSpeed, int level, double baseSpeed) {
        super(name, maxHp, maxMana, maxSpeed, level, baseSpeed);
    }

    public Accessory[] getEquippedAccessory() {
        return new Accessory[0];
    }

    public void slash() {
        System.out.println("slash !!");
    }

    public void block() {
        System.out.println("Block ");
    }
}
class MageCharacter extends  BaseCharacter implements  Mage{

    MageCharacter(String name, double maxHp, double maxMana, double maxSpeed, int level, double baseSpeed) {
        super(name, maxHp, maxMana, maxSpeed, level, baseSpeed);
    }


    public Accessory[] getEquippedAccessory() {
        return new Accessory[0];
    }

    public void castSpell() {
        System.out.println("castSpell !!");
    }

    public void teleport() {
        System.out.println("teleport ");
    }
}
class ArcherCharacter extends BaseCharacter implements  Archer{

    ArcherCharacter(String name, double maxHp, double maxMana, double maxSpeed, int level, double baseSpeed) {
        super(name, maxHp, maxMana, maxSpeed, level, baseSpeed);
    }


    public Accessory[] getEquippedAccessory() {
        return new Accessory[0];
    }

    public void shot() {
        System.out.println("Shot !!");
    }

    public void dodge() {
        System.out.println("dodge");
    }
}
