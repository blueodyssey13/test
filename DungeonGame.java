import java.util.Scanner;


public class DungeonGame {
    /* Reference to the DungeonMap the Player is in */
    private DungeonMap map;

    /* Reference to the Player in the dungeon */
    private Player player;

    /* Initializes the size of the dungeon */
	public DungeonGame() {// no arguments
        this.map = new DungeonMap();

	}

    public DungeonGame(int mapHeight, int mapWidth){
        this.map = new DungeonMap(mapHeight, mapWidth);

    }
	
	/* Main loop of the game, which handles
	non-combat related user input. Continues
	until the Player either wins or loses. */
    public void play() {

        Scanner getUserInput = new Scanner(System.in);

        this.player = new Player();

        System.out.println("\n============================================================\n");

        System.out.println("Welcome to the dungeon game.\n Before we begin, I need to know a little about you...\n");

        System.out.println("Is your character an intrepid and brawny Warrior? Or Perhaps a sly and cunning thief?\n Enter '1' for Warrior, and '2' for thief.");

        boolean validClass = false;

        while (!validClass){
            player.newPlayerSetup(getUserInput.nextLine());
            if (player.getPlayerClass().equals("1")|| player.getPlayerClass().equals("2")){
                validClass = true;
            }
        }


        

        if(player.getPlayerClass().equals("1")){
            System.out.println("Very well! You shall be a mighty warrior.\n");
        }
        else{
            System.out.println("A fine choice! You shall be a sleek and sneaky thief.\n");
        }

        System.out.println("You find yourself in a deep, dark dungeon... ");


        boolean gameOver = false; //keeps loop of game running until win or loss


        while (!gameOver){

            printMapGoldHealth();
            move(getUserInput);

            if (player.getHealth() <=0){
                gameOver = true;
            }

            if(player.getGold() >= 100){
                System.out.println("Congratulations! You have collected 100 gold and escaped the dungeon!");
                System.out.println("Thank you for playing!");
                gameOver = true;
            }









        }

    }

    public void move(Scanner getMove){
        System.out.println("Where would you like to go? Type 'W' for up, 'A' for left, 'S' for down, or 'D' for right.");
        boolean validMove = false;
        while(!validMove){
            String nextMove = getMove.nextLine();
            validMove = map.Move(nextMove);
        }

        map.getRoom().enter(player);
    }

    public void printMapGoldHealth(){
        map.PrintMap(player);
        System.out.printf("\n Health:%d   Gold:%d \n",player.getHealth(),player.getGold());
        System.out.println(" ");
    }


}
