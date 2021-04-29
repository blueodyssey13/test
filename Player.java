
public class Player {

    // Warrior constants
    private final int WARRIOR_INTHEALTH = 100;
    private final int WARRIOR_INTGOLD = 0;
    private final int WARRIOR_INTDAMAGE = 15;
    private final double WARRIOR_LOOTMODIFIER = 1;

    // Thief Constants
    private final int THIEF_INTHEALTH = 70;
    private final int THIEF_INTGOLD = 0;
    private final int THIEF_INTDAMAGE = 10;
    private final double THIEF_LOOTMODIFIER = 1.2;

    /* Current health of this Player */
    private int health;

    /* Current gold of this Player */
    private int gold;

    /* Damage this Player inflicts */
    private int damage;

    /* Class of this Player */
    private String playerClass;

    /* Modifer to loot obtained by this Player */
    private double lootModifier;

    public void newPlayerSetup(String classInput) {
        playerClass = classInput;

        if (playerClass.equals("1")) {
            health = WARRIOR_INTHEALTH;
            gold = WARRIOR_INTGOLD;
            damage = WARRIOR_INTDAMAGE;
            lootModifier = WARRIOR_LOOTMODIFIER;

        }
        else if (playerClass.equals("2")) {
            health = THIEF_INTHEALTH;
            gold = THIEF_INTGOLD;
            damage = THIEF_INTDAMAGE;
            lootModifier = THIEF_LOOTMODIFIER;
        }
        else {
            System.out.println("Input not recognized. Please try again.");
            return;
        }


    }

    public String getPlayerClass() {
        return playerClass;
    }

    /* Hits the targeted Monster */
    public void attack(Monster target) {
        target.onHit(damage);

    }

    /*
     * Removes health from this Player when hit by a Monster
     */
    public void onHit(int damage) {
        health -= damage;
        System.out.println("You take " + damage + " damage. You are now at " + health + " health.");
        if (health <= 0) {
            System.out.println("Oh no! You are dead!");
        }

    }

    /* Adds health to this Player when healed */
    public void onHeal(int health) {

        if (playerClass.equals("1")) { // warrior class
            this.health += health;
            if (this.health + health >= WARRIOR_INTHEALTH) {
                this.health = WARRIOR_INTHEALTH;
            }
        } else if (playerClass.equals("2")) { // thief class
            this.health += health;
            if (this.health + health >= THIEF_INTHEALTH) {
                this.health = THIEF_INTHEALTH;
            }
        }
        System.out.println("You find a healing elixr and are healed for " + health + "hp. You are now at " + this.health+ " health.");

    }

    /* Adds gold to this Player when obtained */
    public void onLoot(int gold) {
        this.gold += (gold * lootModifier);
        System.out.println("Ooh, shiny! You recieve " + gold + " gold. You now have "+this.gold+" gold.");

    }
    public int getHealth(){
        return health;
    }
    public int getGold(){
        return gold;
    }
}
