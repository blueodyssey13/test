import java.util.Random;

public class Monster {

    /* Current health of monster */
    private int health;

    /* Damage this monster inflicts */
    private int damage;

    /* Type of this monster */
    private String monsterType;

    /* ================================= */

    /* Monster Health */
    public static final int GOBLIN_HP = 6;
    public static final int ZOMBIE_HP = 12;
    public static final int ORC_HP = 18;
    public static final int DENEKE_HP = 55;

    /* Monster Damage */
    public static final int GOBLIN_DMG = 10;
    public static final int ZOMBIE_DMG = 15;
    public static final int ORC_DMG = 20;
    public static final int DENEKE_DMG = 5;

    /* ================================= */

    public Monster() {
        Random randomGenerator = new Random();
        int monsterType = randomGenerator.nextInt(4);

        switch (monsterType) {
            case 0:
                this.monsterType = "Goblin";
                this.damage = GOBLIN_DMG;
                this.health = GOBLIN_HP;
                break;
            case 1:
                this.monsterType = "Zombie";
                this.damage = ZOMBIE_DMG;
                this.health = ZOMBIE_HP;
                break;
            case 2:
                this.monsterType = "Orc";
                this.damage = ORC_DMG;
                this.health = ORC_HP;
                break;
            case 3:
                this.monsterType = "Deneke";
                this.damage = DENEKE_DMG;
                this.health = DENEKE_HP;
                break;
        }
    }

    /* ================================= */

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public String getMonsterType() {
        return monsterType;
    }

    /* ================================= */

    /* Hits the targeted Player */
    public int attack() {
        Random randomAttack = new Random();
        int dmg = randomAttack.nextInt(getDamage() + 1);
        return dmg;

    }

    /* ================================= */

    /* Removes health from this Monster when hit by a Player */
    public void onHit(int damage) {
        health -= damage;
        System.out.println("You attack and hit the " + monsterType + " for " + damage + ".");
        if (health <= 0) {
            System.out.println("The " + monsterType + " dies!");
        }
    }

}




