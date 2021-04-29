

/* Contains the Rooms in the dungeon 
and logic for Player movement */
public class DungeonMap {

    private final String MAP_CORNER = "+";
    private final String MAP_SIDES = "|";
    private final String MAP_TOP_BOTTOM = "-";
    private final String THIEF_ICON = "T";
    private final String WARRIOR_ICON = "W";

    private final String WALL_MESSAGE="You try to walk forward and bump into a wall. You decide to turn around and try a different direction.";
	/* Rooms in the dungeon */
    private Room[][] rooms;

    /* Reference to the Player in the dungeon */
    private Player player;


    //player location
    private int playerLocationX = 0;
    private int playerLocationY = 0;

    /* Initializes the rooms and shared Player reference */
    public DungeonMap (int rows, int columns){
        rooms = new Room[rows][columns];
        for (int i=0; i<=rows-1; i++){
            for (int j = 0; j <= columns-1; j++){
                rooms[i][j] = new Room();
            }
        }

    }
    public DungeonMap(){ // no parameter dungeon/ default size
        rooms = new Room[10][10];
        for (int i=0; i<=9; i++){
            for (int j = 0; j <= 9; j++){
                rooms[i][j] = new Room();
            }
        }
    }


    /* Displays the dungeon's rooms, walls,
    and player's current location */
    public void PrintMap(Player player){

        //top
        System.out.print(MAP_CORNER);
        for (int i = 0; i <= rooms[0].length-1; i++){
            System.out.print(MAP_TOP_BOTTOM);
        }
        System.out.print(MAP_CORNER+"\n");

        //sides
        for(int i = 0; i < rooms[0].length-1; i++){
            System.out.print(MAP_SIDES);
            for (int j=0; j<= rooms[i].length-1; j++){
                if (playerLocationX == i && playerLocationY == j){
                    if (player.getPlayerClass().equals("1")){
                        System.out.print(WARRIOR_ICON);
                    }
                    else if( player.getPlayerClass().equals("2")){
                        System.out.print(THIEF_ICON);

                    }   
                }
                else if (!rooms[i][j].hasVisited()){
                    System.out.print(" ");

                }
                else{
                    System.out.print("*");
                }

            }
            System.out.print(MAP_SIDES+"\n");
        }

        //bottom
        System.out.print(MAP_CORNER);
        for (int i = 0; i <= rooms[0].length-1; i++){
            System.out.print(MAP_TOP_BOTTOM);
        }
        System.out.print(MAP_CORNER);

        System.out.println("");

        return;

    }
	
    public boolean Move(String movementInput){
       
            if (movementInput.equalsIgnoreCase("W")){ //up
                if (playerLocationX > 0){
                    playerLocationX -= 1;
                    return true;
                }
                else {
                    System.out.println(WALL_MESSAGE);
                    return false;
                }

            }

            else if (movementInput.equalsIgnoreCase("A")){//left
                if (playerLocationY > 0){
                    playerLocationY -= 1;
                    return true;
                }
                else {
                    System.out.println(WALL_MESSAGE);
                    return false;
                }
            }

            else if (movementInput.equalsIgnoreCase("S")){//down
                if (playerLocationX <= 8){
                    playerLocationX += 1;
                    return true;
                }
                else {
                    System.out.println(WALL_MESSAGE);
                    return false;
                }
            }
            else if (movementInput.equalsIgnoreCase("D")){//right
                if (playerLocationY <= 8){
                    playerLocationY += 1;
                    return  true;
                }
                else {
                    System.out.println(WALL_MESSAGE);
                    return false;
                }
            }

            else {
                System.out.println("Time is ticking! Choose a direction to walk!");
                return false;
            }

            
    }

    public Room getRoom(){
        return rooms[playerLocationX][playerLocationY];

    }

    public int getPlayerX(){
        return playerLocationX;
    }

    public int getPlayerY(){
        return playerLocationY;
    }
}
