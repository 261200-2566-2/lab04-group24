package code;

public interface RPGCharacter {
    String getName();
    int getLevel();
    String getJobName();
    void levelUp();
    Accessory[] getEquippedAccessory();
    Equipment[] getEquippedEquipment();
    void equipAccessory(Accessory accessory);
    void equipEquipment(Equipment equipment);
    void showStats();
    default void showCharacterInfo(){
        System.out.println("Name : " + getName());
        System.out.println("Job : " + getJobName());
        showStats();
        System.out.println("Accessory : ");
        for( Accessory acc : getEquippedAccessory()){
            switch (acc) {
                case Amulet amulet -> System.out.println("  Amulet : " + amulet.getName());
                case Ring ring -> System.out.println("  Ring : " + ring.getName());
                case Earring earring -> System.out.println("  Earring : " + earring.getName());
                case null, default -> System.out.print("");
            }
        }
        System.out.println("Equipment : ");
        for( Equipment equ : getEquippedEquipment()){
            switch (equ) {
                case MainWeapon mainWeapon -> System.out.println("  Main Weapon : " + mainWeapon.getName() + " Lv." + mainWeapon.getLevel());
                case SubWeapon subWeapon -> System.out.println("  Sub Weapon : " + subWeapon.getName()+ " Lv." + subWeapon.getLevel());
                case null, default -> System.out.print("");
            }
        }
    }
}
interface Job extends RPGCharacter{
    String getJobName();
    String[] getAllAbility();
    default void showAllAbilities() {
        System.out.println("Job : " + getJobName());
        System.out.println("Abilities : ");
        for (String ability : getAllAbility()) {
            System.out.print(getJobName() + " ");
        }
    }
}
interface Warrior extends Job{
    void slash();
    void block();
    default String getJobName() {
        return "Warrior";
    }
    default String[] getAllAbility(){
        return new String[]{"Slash", "Black"};
    }

}
interface Mage extends  Job{
    void castSpell();
    void teleport();

    default String getJobName() {
        return "Mage";
    }
    default String[] getAllAbility(){
        return new String[]{"Cast Spell", "Teleport"};
    }
}
interface Archer extends  Job{
    void shot();
    void dodge();

    default String getJobName() {
        return "Archer";
    }
    default String[] getAllAbility(){
        return new String[]{"Shot", "Dodge"};
    }
}
abstract class BaseCharacter implements RPGCharacter{
    private final String name;
    private int level;
    private final double baseSpeed;
    private double hp, maxHp, mana, maxMana, speed, maxSpeed;
    MainWeapon mainHand;
    SubWeapon subHand;
    Amulet amulet;
    Ring ring;
    Earring earring;

    BaseCharacter(String name, int level, double maxHp, double maxMana, double baseSpeed){
        this.name = name;
        this.level = level;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.maxMana = maxMana;
        this.mana = maxMana;
        this.baseSpeed = baseSpeed;
        this.maxSpeed = baseSpeed + (1.5 * (level - 1));
        this.speed = this.maxSpeed;
        mainHand  = null;
        subHand = null;
        amulet = null;
        ring = null;
        earring = null;
    }

    public void showStats() {
        System.out.println("Level : " + level);
        System.out.println("Hp : " + hp + " / " + maxHp);
        System.out.println("Mana : " + mana + " / " + maxMana);
        System.out.println("Speed" + "(Base " + baseSpeed + ") : " + speed + " / " + maxSpeed );
    }
    public String getName(){
        return name;
    }
    public int getLevel(){
        return level;
    }
    public void levelUp(){
        level++;
        maxHp += 10;
        hp += 10;
        maxMana += 5;
        mana += 5;
        maxSpeed += 1.5;
        speed += 1.5;
        System.out.println("your level Up!");
    }
    public void equipAccessory(Accessory accessory){
        if(accessory instanceof Amulet){
            amulet = (Amulet) accessory;
            System.out.println("Equipped Amulet : " + accessory.getName());
        }else if(accessory instanceof  Ring) {
            ring = (Ring) accessory;
            System.out.println("Equipped Ring : " + accessory.getName());
        }else if(accessory instanceof Earring){
            earring = (Earring) accessory;
            System.out.println("Equipped Earring : " + accessory.getName());
        }
    }
    public void equipEquipment(Equipment equipment){
        if(equipment instanceof MainWeapon){
            mainHand = (MainWeapon) equipment;
            System.out.println("Equipped Amulet : " + equipment.getName());
        }else if(equipment instanceof  SubWeapon) {
            subHand = (SubWeapon) equipment;
            System.out.println("Equipped Ring : " + equipment.getName());
        }
    }
    public Accessory[] getEquippedAccessory(){
        Accessory[] accArr = new Accessory[3];
        accArr[0] = amulet;
        accArr[1] = ring;
        accArr[2] = earring;
        return accArr;
    }
    public Equipment[] getEquippedEquipment(){
        Equipment[] eqmArr = new Equipment[2];
        eqmArr[0] = mainHand;
        eqmArr[1] = subHand;
        return eqmArr;
    }
}
class WarriorCharacter extends BaseCharacter implements Warrior{
    WarriorCharacter(String name){
        super(name,1,150,25,100);
    }
    public void slash() {
        System.out.println(getName() + " Slash !!");
    }
    public void block() {
        System.out.println(getName() + " Block");
    }
}
class MageCharacter extends  BaseCharacter implements  Mage{
    MageCharacter(String name) {
        super(name, 1, 50, 125, 80);
    }
    public void castSpell() {
        System.out.println(getName() + " Cast Spell !!");
    }

    public void teleport() {
        System.out.println(getName() + " Teleport ");
    }
}
class ArcherCharacter extends BaseCharacter implements  Archer{
    ArcherCharacter(String name) {
        super(name, 1,100, 75, 150);
    }
    public void shot() {
        System.out.println(getName() + " Shot !!");
    }

    public void dodge() {
        System.out.println(getName() + " Dodge");
    }
}
