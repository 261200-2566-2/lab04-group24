package code;

import code.Accessory;
import code.Equipment;
import code.RPGCharacter;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        // For testing
        RPGCharacter james = new WarriorCharacter("James");
        james.showCharacterInfo();
        System.out.println("======================================");
        Accessory blood = new Ring("Vampire's Ring", "Life steal", 0.155);
        Equipment sword = new SubWeapon("James's Legacy", 30, 10);

        james.equipAccessory(blood);
        james.equipEquipment(sword);
        System.out.println("======================================");
        james.levelUp();
        System.out.println("======================================");
        james.showCharacterInfo();
        System.out.println("======================================");

        System.out.println("Sword Damage : " + sword.getMainStat());
        sword.upgrade();
        System.out.println("Sword Damage : " + sword.getMainStat());
        System.out.println("======================================");

        blood.showStats();

    }
}