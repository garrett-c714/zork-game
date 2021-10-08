import java.util.ArrayList;
import java.util.Scanner;
/**
 * Class Game - the main class of the "Zork" game.
 *
 * Author:  Michael Kollingum
 * Version: 1.1
 * Date:    March 2000
 * 
 * Modified by: Kevin Good
 * Date:        October 2019
 * 
 *  This class is the main class of the "Zork" application. Zork is a very
 *  simple, text based adventure game.  Users can walk around some scenery.
 *  That's all. It should really be extended to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  routine.
 * 
 *  This main class creates and initializes all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates the
 *  commands that the parser returns.
 */

class Game 
{
    private boolean playedPuz = false;
    public Room prevRoom;
    private Parser parser;
    private Room currentRoom;
    private Room emptyRoom;
    private Room temp;
    private int moveCounter = 0;
    private ArrayList<Item> roomItems;
    private ArrayList<Item> gameItems;
    private Inventory inventory = new Inventory();
    private ArrayList<Room> allRooms = new ArrayList<Room>();
    private boolean win;

    /**
     * Create the game and initialize its internal ma
     */
    public Game() 
    {
        createRooms();
        //createItems();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, 
        entryHall, 
        upstairs, 
        balcony, 
        basement,
        meeting,
        brewery,
        dungeon,
        bathroom,
        stairWell,
        hole,
        stairRoom1,
        stairRoom2,
        stairRoom3,
        stairRoom4,
        poolHouse,
        cells,
        observatory,
        gauntlet,
        finalRoom,
        upsideDownBrewery,
        australia,
        empty;

        // create the rooms
        empty = new Room("this is empty", "empty");
        allRooms.add(empty);//0
        outside = new Room("a grassy field. In front of you is a metal door, rusted and in bad shape. There's words on the door that spell out \"The House of Spells\" in a magic language known only as Pig Latin.", "outside");
        allRooms.add(outside);//1
        entryHall = new Room("the entry hall. There's an exit directly in front of you. The path ahead seems promising. To the left, the room is in eternal darkness. To the right, there's a wall that's weak and crumbling. It may lead somewhere.", "entryHall");
        allRooms.add(entryHall);//2
        upstairs = new Room("a dark room. You can't see anything. Go back and find a light source.", "upstairs");
        allRooms.add(upstairs);//3
        balcony = new Room("a small balcony with a broken handrail. Next to a skeleton slumped on the ground is a coil of rope. Hey, this might be useful!", "balcony");
        allRooms.add(balcony);//4
        basement = new Room("the basement. The furniture and props down here seem like they come straight from the Rocky Horror Picture Show. It's quite odd; there's even a miniature Rocky in the corner of the room. The hallway extends further east.", "basement");
        allRooms.add(basement);//5
        meeting = new Room("the meeting room. In here is a small podium with a glowing scroll hovering slightly above it. Text to the right of the podium calls this the light spell. Wonder what that means. In the corner of the room, there's some text written in red. Maybe it's just ketchup?", "meeting");
        allRooms.add(meeting); //6
        brewery = new Room("a small shop-like area-- the brewery. Half-expecting an old man to tell you not to go alone, you enter the room cautiously. But there's nothing here, except for several empty flasks and test-tubes and a giant hole in the ceiling that seems to lead somewhere. It looks like this place has been deserted for some time.", "brewery");
        allRooms.add(brewery); //7
        upsideDownBrewery = new Room("the brewery again, but upside down? The floor has become the ceiling and the ceiling has become the floor! Using the gravity spell has really messed you up. At least you have free reign of that hole in the ceiling (the floor). Why don't you see where that goes instead of imagining yourself trapped in a Christopher Nolan movie?", "upsideDownBrewery");
        allRooms.add(upsideDownBrewery); //8
        dungeon = new Room("the dungeon! Lining the walls are several cells. All appear to be locked but peering inside shows skeletons chained to the walls and rats roaming the floors.  There is a doorway that leads to what apears to be a bathroom.  There is also a locked door to the east and a rotating maze puzzle that you can \"play\" on the wall.", "dungeon");
        allRooms.add(dungeon); //9
        bathroom = new Room("the bathroom. It's in pristine condition, despite a few graffiti symbols and that special S made out of lines. Suddenly, a figure emerges from the stalls in the back of the room. \"Halt!\" the man says. \"I'm the guardian of the water spell. They call me Tim the Enchanter. To pass, you must answer one simple question.\" You are stunned and clearly apprehensive, but that water spell could be good for you. He continues: \"What... floats on water like a witch?\"", "bathroom");
        allRooms.add(bathroom); //10
        stairWell = new Room("The room is quite baren with a podium in the middle", "stairWell");
        allRooms.add(stairWell); //11
        hole = new Room("the depths of the hole. Reaching the bottom gives you the sight of the bright light. I hope this doesn't put me in a blight, but it might. The rest of the hole is as dark as the night. The light seems to eminate from a bow and two arrows. You were never the archery type, but the more artillery you have, the better.", "hole");
        allRooms.add(hole); //12
        stairRoom1 = new Room("one of the stair rooms. It's barren, except for a narrow staircase that is... disappearing into the wall?", "stairRoom1");
        allRooms.add(stairRoom1); //13
        stairRoom2 = new Room("one of the stair rooms. It's barren, except for a narrow staircase that is... disappearing into the wall?", "stairRoom2");
        allRooms.add(stairRoom2); //14
        stairRoom3 = new Room("one of the stair rooms. It's barren, except for a narrow staircase that is... disappearing into the wall? On the far side you spot a small puzzle-like area, and the familiar sight of a podium with a new spell shines at the end. Next to the podium is a slice of cake.", "stairRoom3");
        allRooms.add(stairRoom3); //15
        stairRoom4 = new Room("one of the stair rooms. It's barren, except for a narrow staircase that is... disappearing into the wall? There's an exit to the north, and the smell of chlorine is lingering in the air.", "stairRoom4");
        allRooms.add(stairRoom4); //16
        poolHouse = new Room("the pool house. There's water slides and pool noodles lying around, but the pool is uh... full of snakes. You're surprised this room isn't an airport instead. There's a room farther north and the path is free of snakes.", "poolHouse");
        allRooms.add(stairRoom4); //17
        cells = new Room("the maximum security cells. There's a large beast roaming the hallways. Hiding behind a marble pillar, you're deciding your next move. Think carefully; this could be a matter life or death.", "cells");
        allRooms.add(cells); //18
        observatory = new Room("the observatory. The room gives you wonder. It contains multiple long range telescopes and a giant dome roof. It's one of the most beautiful landmarks you've ever seen. Farther on, a podium sits with an upside down totem and a small apple to the right.", "observatory");
        allRooms.add(observatory); //19
        gauntlet = new Room("the final stretch. It's dark, but you land on the ground somewhere. Good luck!", "gauntlet");
        allRooms.add(gauntlet);//20
        finalRoom = new Room("the final room. Good job, you've done it. You beat the game. Trumpets blare from somewhere and there's one final podium in front of you. This is the final spell, the one that's taken you a solid ten or fifteen minutes to obtain. Congratulations.", "finalRoom");
        allRooms.add(finalRoom); //21

        australia = new Room("You're on the ceiling. You're now upside down. Now what?", "australia");
        allRooms.add(australia); //22

        // initialise room exits (set in North, East, South, West orientation)
        empty.setExits(null, null, null, null);
        outside.setExits(entryHall, null, null, null);
        entryHall.setExits(meeting, null, outside, upstairs);
        balcony.setExits(null,upstairs, null, null);
        meeting.setExits(null, brewery, entryHall, null);
        upstairs.setExits(null, entryHall, null, null);
        basement.setExits(null, dungeon, null, entryHall);
        dungeon.setExits(bathroom, null, null, basement);
        bathroom.setExits(null, null, dungeon, null);
        stairWell.setExits(stairRoom1, null, null, dungeon);
        stairRoom1.setExits(stairRoom4, null, stairWell, stairRoom2);
        stairRoom2.setExits(stairRoom3, stairRoom1, null, null);
        stairRoom3.setExits(null, stairRoom4, stairRoom2, null);
        stairRoom4.setExits(poolHouse, null, stairRoom1, stairRoom3);
        poolHouse.setExits(null, null, stairRoom4, null);
        cells.setExits(null, null, null, observatory);
        observatory.setExits(null, cells, null, null);
        brewery.setExits(null, null, null, meeting);
        upsideDownBrewery.setExits(gauntlet, null, null, null);
        currentRoom = outside;  // start game outside
        emptyRoom = empty;

        Item rope, potion, bow; // declares items rope, potion, bow of plot progression
        Spell explode, light, water, teleport, gravity, snake, useless; // declares all game spells
        gameItems = new ArrayList<Item>(); // creates arraylist of items and adds items to gameItems once initialized
        rope = new Item("rope", "a coil of rope in the corner", balcony,2);
        gameItems.add(rope);//0
        potion = new Item("potion", "an ornate flask containing a nasty-looking potion", brewery,2);
        gameItems.add(potion);//1
        bow = new Item("the bow of plot progression", "an unimportant looking bow that progresses the plot", hole,2);
        gameItems.add(bow);//2



        explode = new Spell("explosion", "a red scroll with burned edges", empty,1, "crepitas");
        gameItems.add(explode);//3
        light = new Spell("light", "a scroll that is glowing faintly", meeting,1, "lumos");
        gameItems.add(light);//4
        water = new Spell("water", "a blue scroll that's kinda moist", emptyRoom,1, "cataracta");
        gameItems.add(water);//5 update in say if changed
        teleport = new Spell("teleportation", "a scroll that disappears and reappears", stairRoom3,1, "deprendo");
        gameItems.add(teleport);//6
        gravity = new Spell("gravity", "a scroll that's upside down", stairWell,1, "locus");
        gameItems.add(gravity);//7
        snake = new Spell("snake", "a green scroll that rattles when shaken", poolHouse,1, "serpentius");
        gameItems.add(snake);//8
        inventory.add(snake);
        useless = new Spell("useless", "a completely pointless spell with a useless purpose", finalRoom,1, "nothing");
        gameItems.add(useless);//9
    }
    //jacob moment
    public boolean createItems() {
      
      //rope = new Item("rope", "a pile of rope coiled in the corner", )
      return false;
    }
    /**
     *  Main play routine.  Loops until end of play.
     */
    public boolean play() 
    {           
        win = false;
        printWelcome(); 

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over. 
                
        boolean finished = false;
        while (!finished && !win)
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        return win;
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Thanks for playing our game!");
        System.out.println("This is based off of the 1979 MIT-programmed text-based adventure game, Zork.");
        System.out.println("Type 'help' if you need help. Or don't. That's cool too.");
        System.out.println();
        System.out.println(currentRoom.longDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    private boolean processCommand(Command command) 
    {
        if(command.isUnknown())
        {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help"))
        {
         printHelp(); 
        }
        else if (commandWord.equals("ls")) {
          for (int i=0; i<inventory.getInventoryLength(); i++) {
            if (!inventory.getItem(i).getIncantation().equals("peanut butter")) {
              System.out.println((i+1)+". "+inventory.getItem(i).getIncantation());
            }
          }
        }
        else if (commandWord.equals("go"))
        {
          goRoom(command);
        }  
        else if (commandWord.equals("cast"))
        {
          castSpell(command);
        }
        else if(commandWord.equals("grab"))
        {
          pickUp(command);
        }
        else if(commandWord.equals("drop"))
        {
          dropItem(command);
        }
        else if(commandWord.equals("inventory"))
        {
          printInventory();
        }
        else if (commandWord.equals("back"))
        {
          if(moveCounter != 0)
          {
            temp = currentRoom;
            currentRoom = prevRoom;
            prevRoom = temp;
            System.out.println(currentRoom.longDescription());
            moveCounter++;
          }
          else{System.out.println("There is no previous room.");}
        }
        else if (commandWord.equals("quit"))
        {
            if(command.hasSecondWord())
                System.out.println("Quit what?");
            else
                return true;  // signal that we want to quit
        }
        else if(commandWord.equals("say"))
        {
          return say(command);
        }
        else if(commandWord.equals("play"))
        {
          if(currentRoom.getName().equals(allRooms.get(9).getName()) && !(playedPuz))
          {
            playGrav();
          }
          else{System.out.println("There is nothing left to play in this room");}
          return false;
        }
        else if (commandWord.equals("wincondition")) {
          win = true;
        }
        return false;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You need help, the situation's dire.");
        System.out.println("I'll give you commands once I cool down from spittin' hot fire.");
        System.out.println("What? I won rap battles in college.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord())
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.nextRoom(direction);

        if (nextRoom == null)
            System.out.println("You can't go that way.");
        else 
        {
            prevRoom = currentRoom;
            currentRoom = nextRoom;
            //extra space when entering rooms
            System.out.println();
            System.out.println();
            // ------
            System.out.println(currentRoom.longDescription());
            printItemsInRoom();
            moveCounter++;

            
            //if we enter the final room, they win
            if (currentRoom.getName().equals("finalRoom")) {
              win = true;
              //System.out.println("Here");
            }
        }
    }




    public void printItemsInRoom()
    {            
      if(!(currentRoom.getDescription().equals("a dark room. You can't see anything. Go back and find a light source.")))
      {
      System.out.println("In the room there is: ");
            boolean check = true;
      for(Item item : gameItems)
            {
              if(item.getRoom().getName().equals(currentRoom.getName()))
              {
                System.out.println("•" + item.getDescription() + " -- called: " + item.getName());
                check = false;
              }
            }
            if(check){System.out.println("Nothing currently in this room.");}}
    }



    public void castSpell(Command command)
    {
      if(!command.hasSecondWord())
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Cast what?");
            return;
        }
      else {
          //logic for spells
          //if have spell tomb then use it 
            //if in this room then update exits, update desciption etc
          //else dont use spell
          String words = "lumosserpentiuslocuscataractadeprendocrepitas";
          String spell = command.getSecondWord();
          boolean inList = false;
          for (int i=0; i<inventory.getInventoryLength(); i++) {
            if (inventory.getItem(i).getIncantation().equals(command.getSecondWord())) {
              inList = true;
            }
          }
          if (words.indexOf(spell) >= 0 && inList) {
            switch(spell) {
              case "lumos":
                //light
                System.out.println("Blinding light bursts from your palms.");
                if (currentRoom.getName().equals("upstairs")) {
                  System.out.println("The room around you has been revealed");
                  currentRoom.setDescription("a small loft. The hallway continues on further, but in front of you is a podium with the explosive spell on top. You hear an AC/DC song playing from... somewhere. Unfortunately, you can't identify it because all AC/DC songs sound the same.");
                  gameItems.get(3).setRoom(allRooms.get(3));
                  printItemsInRoom();
                  currentRoom.unlockExit(allRooms.get(4),"west");
                  System.out.println(currentRoom.exitString());
                  printItemsInRoom();
                }
                else if (currentRoom.getName().equals("gauntlet")) {
                  System.out.println("The once dark room becomes lightened and the sight isn't pretty. Ahead of you is a river of molten lava, and across from that is a giant, crumbling wall. Just like that driving instructor taught you years ago, you may need to pull out all the stops.");
                }
                break;
              case "serpentius":
                System.out.println("You have summoned a hostile snake. The snake bites you.");
                break;
              case "locus":
                System.out.println("You have altered gravity. Somewhere above, Newton falls on the apple.");
                if (currentRoom.getName().equals("brewery")) {
                  currentRoom.setDescription("the brewery again, but upside down? The floor has become the ceiling and the ceiling has become the floor! Using the gravity spell has really messed you up. At least you have free reign of that hole in the ceiling (the floor). Why don't you see where that goes instead of imagining yourself trapped in a Christopher Nolan movie?");
                  gameItems.get(8).setRoom(allRooms.get(8));
                  currentRoom.unlockExit(allRooms.get(20), "north");
                } 
                else if(currentRoom.getName().equals("australia"))
                {
                  processCommand(new Command("back","this should be able to to be anything I want...right??"));
                }
                else if (currentRoom.getName().equals("gauntlet")) {
                  System.out.println("Inverting gravity may be bad for everyone else, but hey, it helped you. You run across the ceiling before the magma has a chance to catch up with you. Great, you're now past the sea of magma. But what about this wall?");
                }
                else {
                  prevRoom = currentRoom;
                  currentRoom = allRooms.get(22);
                  System.out.println(currentRoom.getDescription());
                }
                break;
              case "cataracta":
                System.out.println("You have created water. Children in Africa can use that right about now.");
                if(currentRoom.getName().equals("gauntlet"))
                {
                  System.out.println("Throwing your water on the river of magma does nothing but make steam. Hmmm. Maybe find another way to cross.");
                }
                break;
              case "deprendo":
                System.out.println("You have teleported to another room. The cake is a lie.");
                break;
              case "crepitas":
                if(currentRoom.getName().equals("entryHall"))
                {
                  System.out.println("The crumbling wall to the east is forcefully blown back, revealing a new exit.");
                  currentRoom.unlockExit(allRooms.get(5),"east");
                  currentRoom.setDescription("You are in the entry hall. There's an exit directly in front of you. The path ahead seems promising. To the left, the room is in eternal darkness. To the right,there is the hole that you blasted through the wall");
                }
                else if (currentRoom.getName().equals("gauntlet")) {
                  System.out.println("Breaking the wall with the self-infused dynamite leads to another door. It's just a plain, metal door with the word 'fin' labeled in white letters. Do you choose to enter?");
                  gameItems.get(9).setRoom(allRooms.get(21));
                }
                else
                {
                  System.out.println("A small explosion occures in front of you");
                }
                break;
              default:
                //if anyone breaks my algorithm we kill them.
                break;
            }
          } else {
            System.out.println("You can't cast that!");
          }
      }
    }
    public void pickUp(Command command)
    {
      if(!(command.hasSecondWord()))
      {
        System.out.println("Grab what?");
        return;
      }
      boolean checkk = false;
      for(Item item : gameItems)
      {
        //can implement logic for weight here
        if (item.getRoom().getName().equals(currentRoom.getName()) && command.getSecondWord().equals(item.getName()))
        {
          checkk = true;
          if(inventory.getWeight() + item.getWeight() <= inventory.getMax())
          {
          inventory.add(item);
          System.out.println("You grabbed: " + item.getName());
          printInventory();
          item.setRoom(emptyRoom);
          printItemsInRoom();
          System.out.println("Your weight is: " + inventory.getWeight());
          }
          else{System.out.println("Your hands are currently full, you need to drop an item");}
        } else {
          //System.out.println("That item is not here!");
        }
      }
      if(!checkk)
      {
        System.out.println("That item is not here!");
      }
    }
    public void dropItem(Command command)
    {
      if(!(command.hasSecondWord()))
      {
        System.out.println("Drop what?");
        return;
      }
      for(Item item : gameItems)
      {
        if(item.getName().equals(command.getSecondWord()) && inventory.containsItem(item))
        {
          inventory.remove(item);
          System.out.println("You dropped: " + item.getName());
          printInventory();
          item.setRoom(currentRoom);
          printItemsInRoom();
        }
        
      }
    }

    public boolean say(Command c)
    {
      if(!(c.hasSecondWord()))
      {
        System.out.println("Say what?");
        return false;
      }
      else
      {
        System.out.println("You said: " + c.getSecondWord());
      }
      if(currentRoom.getName().equals("bathroom"))
      {
          if(c.getSecondWord().equals("duck"))
          {
            System.out.println("The man says \"She turned me into a newt! Here is the scroll.\"");
            gameItems.get(5).setRoom(currentRoom);
            pickUp(new Command("grab","water"));

          }
          else
          {
            System.out.println("Shrieking in anger, the man thrusts you into the air and well... you died.");
            return true;

          }
      }
      
      if(currentRoom.getName().equals("gauntlet"))
      {
        if (c.getSecondWord().equals("yes"))
        {
          System.out.println("You open the door and step inside.");
          currentRoom.unlockExit(allRooms.get(21), "north");
          processCommand(new Command("go", "north"));
        }
        else if (c.getSecondWord().equals("no"))
        {
          System.out.print("Well, what next? Are we just going to stand here... awkward...? I kinda need you to do something, man.");
        }
        else
        {
          System.out.println("I don't follow. It's a yes or no question. Please... I have kids.");
        }
      }
      return false;
    }
    public void printInventory()
    {
      if(!(inventory.getInventoryLength() > 0))
      {
        System.out.println("Nothing is in your inventory");
      }
      else
      {
        System.out.println("Inventory: ");
      for(int i = 0; i < inventory.getInventoryLength(); i++)
      {
        System.out.println(i+1 + ". " + inventory.getItem(i).getName());
      }
      }
    }
    public void playGrav()
    {
      playedPuz = true;
    Scanner input = new Scanner(System.in);
    String[][] test = {
    {"□","□","□","□","□","□","□","□","□","□","□"},
    {"□"," "," "," "," "," "," ","□","□","□","□"},
    {"□"," ","□","□","□","□"," "," "," ","X","□"},
    {"□"," ","□","□","□","□","□","□","□"," ","□"},
    {"□"," ","□","□","□","□","□","□","□"," ","□"},
    {"□","o"," "," "," "," ","□","□","□"," ","□"},
    {"□","□","□","□","□"," ","□","□","□"," ","□"},
    {"□","□","□","□","□"," ","□","□","□"," ","□"},
    {"□","□","□","□","□"," ","□","□","□"," ","□"},
    {"□","□","□","□","□"," "," "," "," "," ","□"},
    {"□","□","□","□","□","□","□","□","□","□","□"},
    };
    System.out.println("Use a + enter or d + enter to rotate the board");
    GravPuz puz = new GravPuz(test);
    while(!(puz.winCheck()))
    {
      puz.printBoard();
      System.out.println("command: ");
      String choice = input.nextLine();
      if(choice.equals("a"))
      {
        puz.rotateCounter();
      }
      else if(choice.equals("d"))
      {
        puz.rotateClock();
      }
    }
    puz.printBoard();
    System.out.println("You won! The door flies open.");
    currentRoom.unlockExit(allRooms.get(11),"east");
    currentRoom.setDescription("You are in the dungeon! Lining the walls are several cells. All appear to be locked but peering inside shows skeletons chained to the walls and rats roaming the floors.");
    System.out.println(currentRoom.exitString());
    
    }
    






    
    
    
    
    
    
    

    








    //jacob moment
    private void teleport(Room room) {
      //Teleport method for that spell....
    }

    private void light(Room room) {
      // Light method for the light spell
    }

    private void water(Room room) {
      //water spell method
    }

    private void snake(Room room) {
      // snake spell method
    }

    private void gravity(Room room) {
      // gravity spell method
    }
}
