package finalProject;
import java.util.Scanner;

/**
 * A program adventureCPT.java that lets you play a unique game
 * @author C.Dong
 *
 */


public class adventureCPT {

    static String[] roomName;
    static String[] roomDescription;
    static int[][] roomDirection;

    public static void main(String[] args) {

        System.out.println("You are in a castle. Some monsters have kidnapped the king. \n" +
                "Your mission is to find the king, who is trapped somewhere in the castle \n" +
                "Your job is to navigate around the castle to find him, but be careful\n" +
                "there may be some hidden surprises along the way.\n" +
                "One wrong step could lead to your downfall. \n" +
                "type in << n >> to go north, << e >> for east, << s >> for south and << w >> for west. \n" +
                "Get it? Well if you don't that's too bad. Tough luck. \n" +
                "You are now going to begin your adventure. Good Luck!");

        roomName = new String[8];
        roomName[0] = "Entrance";
        roomName[1] = "Living Room";
        roomName[2] = "Main Hall";
        roomName[3] = "Dining Room";
        roomName[4] = "Bathroom";
        roomName[5] = "Treasure Room";
        roomName[6] = "Throne Room";
        roomName[7] = "Hidden Chamber";

        roomDescription = new String[8];
        roomDescription[0] = "Hmmmm, the Entrance huh? Well seems like you are at the starting point.\n" +
                "There seems to be a pathway towards the east. ";
        roomDescription[1] = "You are in Living Room. Doesn't seem like there is much here except for some old rusty furniture.\n" +
                "You can go back to the Entrance westwards, or try you luck going north or east into some other rooms";
        roomDescription[2] = "You are in Main Hall. Looks like a pretty nice place, but nothing seems to be here \n" +
                "You can continue north into another room, or go west back into the living room";
        roomDescription[3] = "Nice, you survived! Seems like there is a path to the east. ";
        roomDescription[4] = "You are in Bathroom. You want a nice steamy shower? Well too bad \n" +
                "You can go north, east, south or west, but warning, there seems to be an ominous chill coming from the east side";
        roomDescription[5] = "Nicejob defeating the monster!!!!\n" +
                "You are in Treasure Room. Well, there is no treasure left, \n" +
                "seems like the monsters took it all. You can go westwards back into the bathroom. ";
        roomDescription[6] = "You are in Throne Room";
        roomDescription[7] = "You are in the hidden chamber";

        roomDirection = new int[8][4];
        roomDirection[0] = new int[] {-1,1,-1,-1}; //north, east, south ,west
        roomDirection[1] = new int[] {3,2,-1,0};
        roomDirection[2] = new int[] {4,-1,-1,1};
        roomDirection[3] = new int[] {-1,4,1,-1};
        roomDirection[4] = new int[] {6,5,2,3};
        roomDirection[5] = new int[] {-1,-1,-1,4};
        roomDirection[6] = new int[] {7,-1,4,-1};
        roomDirection[7] = new int[] {-1,-1,4,-1};

        navigate();

    }

    /**
     * A method that allows your to navigate through the game based on the arrays
     *
     */

    public static void navigate() {

        int currentRoom = 0;
        int nextRoom = -1;
        String userSelectedRoom;
        String userSelectedDoor;
        String userSelectedFood;
        String userInput;
        String userFight;
        boolean done = false;
        Scanner scan = new Scanner(System.in);

        while(!done) {
            System.out.println("This is the " + roomName[currentRoom]);
            System.out.println(roomDescription[currentRoom]);
            nextRoom = -1;

            while(nextRoom == -1) {
                System.out.print("Which direction do you want to go?: ");
                userSelectedRoom = scan.nextLine();
                System.out.println("");

                if (userSelectedRoom.equals("n")) {
                    nextRoom = roomDirection[currentRoom][0];


                } else if (userSelectedRoom.equals("e")) {
                    nextRoom = roomDirection[currentRoom][1];


                } else if (userSelectedRoom.equals("s")) {
                    nextRoom = roomDirection[currentRoom][2];


                } else if (userSelectedRoom.equals("w")) {
                    nextRoom = roomDirection[currentRoom][3];


                }
                if (nextRoom == -1) {
                    System.out.println("What are you trying to do, break the game?!?! You can't go that way.");
                }
                if (nextRoom == 3) {
                    System.out.println("You are in Dining Room. Seems to be a piece of chicken and an apple on the table.\n" +
                            "You are incredibly hungry so you have to eat one of them....." +
                            "In a sketchy room with only 2 options, you know you have to make the right choice, or it's over.");
                    System.out.println("What do you want to eat? << c >> for chicken and << a >> for apple");
                    userSelectedFood = scan.nextLine();
                    if (userSelectedFood.equals("c")){
                        System.out.println("You feel no change, Everything seems to be good.");
                    }else if (userSelectedFood.equals("a")){
                        System.out.println("Your stomach has exploded...Tough luck. Better luck next time");
                        done = true;
                        break;
                    }

                }
                if (nextRoom == 5){
                    System.out.println("You have encountered a monster!\n" +
                            "You have no weapons on you. You have only 3 options attack with your fists,\n" +
                            "defend by running away, or play dead\n" +
                            "type <<a>> for attack, <<b>> for defend or <<c>> for play dead" );
                    userFight = scan.nextLine();
                    if (userFight.equals("a")){
                        System.out.println("attacking a 400 pound 8 foot tall monster with your fist..........\n"+
                                "Maybe not the best choice, your punch tickles him. The monster crushes you with his fists\n" +
                                "You have died");
                        done = true;
                        break;
                    }else if (userFight.equals("b")){
                        System.out.println("Before you even start running, the moster throws a giant rock at you.\n" +
                                "You have died");
                        done = true;
                        break;
                    }else if (userFight.equals("c")){
                        System.out.println("Well the monster just looked at you and walked away....\n" +
                                "does not seem like this guy is the brightest tool in the box. ");

                    }
                }

                if (nextRoom == 6) {
                    System.out.println("This seems to be the throne room, but the throne looks empty...\n" +
                            "There seems to be a hidden room. It says do not enter.\n" +
                            "Would you like to continue in a direction or open the door?\n" +
                            "<< o >> for open, or << c >> to continue");
                    System.out.println("What do you want to do?");
                    userSelectedDoor = scan.nextLine();
                    if (userSelectedDoor.equals("o")) {
                        System.out.println("A band of monsters is in the hidden room counting their treasure. \n" +
                                "They seem to be the one who kidnapped the king. \n" +
                                "Unfortunately for you, they all pounce on you when you come in. \n" +
                                "You have died");
                        done = true;
                        break;
                    }else if (userSelectedDoor.equals("c")){
                        nextRoom = roomDirection[6][0];
                    }
                }
                if (nextRoom == 7){
                    System.out.println("You are in the hidden chamber. The King is tied up in the corner");
                    System.out.println("You untie him and successfully take him and sneak \n" +
                            "back out of the castle. You have finished the game!! Congratulations!!!");
                    done = true;
                    break;
                }

            } //end of loop 2
            currentRoom = nextRoom;
            if (done == true) {
                System.out.println("Do you want to restart the game? << y >> for yes and << n >> for no");
                userInput = scan.nextLine();
                if (userInput.equals("y")) {
                    done = false;
                    currentRoom = 0;
                    continue;
                } else if (userInput.equals("n")) {
                    done = true;
                }
            }

        } //end of loop 1

    }
}

