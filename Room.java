import java.util.Random;
import java.util.Scanner;

/* Represents a Room in the Dungeon, where
encounters with Monsters and Loot occur */
public class Room {
    /* Indicates whether or not this Room
    instance has been visited already */
    private boolean roomVisited;

    /* Handles encounter logic when a Player
    enters this Room. Includes combat resolution
    and obtaining loot. */
    public void enter(Player Player) {
        Random random = new Random();
        Scanner getUserInput = new Scanner(System.in);

        /* ============================================================ */

        if (roomVisited != true){

            int randomEvent = random.nextInt(2);

            //combat = 0, loot = 1

            if (randomEvent == 0){
                //sarah doing combat
                Monster monster = new Monster();
                System.out.println("A " + monster.getMonsterType() + "appears!");
                boolean isMonsterAlive = true;
                while (isMonsterAlive) {
                    System.out.println("Select an action: [1] Attack, [2] Run ");
                    String cbtAction = getUserInput.nextLine();

                    // If player attacks monster
                    if (cbtAction.equals("1") ) {
                        Player.attack(monster);
                        if(monster.getHealth()<=0){
                            roomVisited = true;
                            isMonsterAlive = false;
                        }
                        else{
                            int playerDamage = monster.attack();
                            Player.onHit(playerDamage);
                        }

                    }

                    // If player attempts to run
                    else if (cbtAction.equals("2")) {
                        System.out.println("You hightail it out of there in a desperate attempt to escape... ");
                        System.out.println("The wild " + monster.getMonsterType() + " lunges after you as you try to escape!");
                        int playerDamage = monster.attack();
                        Player.onHit(playerDamage);
                        roomVisited = true;
                        return;

                    } 
                    else if(!cbtAction.equals("1")||!cbtAction.equals("2") && isMonsterAlive) {
                        System.out.println("You flop around like a fish out of water. Hurry, you must decide! [1] Attack or [2] Run!");
                    }
                }
            }


            else if (randomEvent == 1){
                int randomLoot = random.nextInt(2);

                if(randomLoot == 0){ //gold

                    Player.onLoot(random.nextInt(45)+5); //min 5 gp max 50gp
                    roomVisited = true;

                }

                if(randomLoot == 1){ //heal

                    Player.onHeal(random.nextInt(30)+20); // min 20 hp max 50 hp
                    roomVisited = true;

                }

            }

        }

    }

    /* Accessor for the visited field */
    public boolean hasVisited() {
        return this.roomVisited;
    }
}