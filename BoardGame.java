import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/*This is an abstract Boardgame class, which can be extendible to different kinds of board games.
 * it contains common methods including:
 * 
 * */
public abstract class BoardGame {
    
    String bName; //Name of the board game;
    Board gameBoard; 
    int seats =2; //number of players needed in one round;
    ArrayList<Player>[] allPlayers = (ArrayList<Player>[])new ArrayList<?>[seats]; //consists of the all players from all teams.
    public void setTeam(){
    for(int i = 0; i < seats; i++) { 
            allPlayers[i] = new ArrayList<Player>(); 
        }
    }

    Scanner keyboard = new Scanner(System.in);
    ArrayList<Round> statistscs = new ArrayList<Round>(); 
    
    public boolean addPlayer(ArrayList<Player> t, int teamnum){
        System.out.println("Join team "+ teamnum+"? 'y' for yes");
        char join = keyboard.next().charAt(0); 
        if (join=='y'){
            return true;
        }else{
              return false;
        }
    }
    /*Assigns players into teams. Team number is scalable according to number of players each round the game needs*/
    public ArrayList<Player>[] formTeam(int seats, ArrayList<Player>[] allplayers){
        for(int i=0; i<seats;i++){
            int teamnum = i+1;
            while(addPlayer(allplayers[i],teamnum)==true){
                System.out.println("Please enter your nickname:");
                String pname = keyboard.next();
                Player P = new Player(pname,Player.Status.WAIT,0);
                allplayers[i].add(P); 
        }
            System.out.print("Team "+teamnum+" formed, including ");
            for (int j=0;j<allplayers[i].size();j++){
                System.out.print(allplayers[i].get(j).getName());
            if(j+1!=allplayers[i].size()){
                System.out.print(", ");
            }   
        }System.out.println(".");
        }
        return allplayers;
      
    }
    /*set the number of players each round to be scalable*/
    public void setNumPlaying(int num){
        seats = num;
    }
  
    public void welcomeMsg(){
        String welcomeMessage = "Welcome to " + bName+" !";
        System.out.println(welcomeMessage);
    }   
    
    public void placePiece(Player p,Board board,Player other){
        Mark mark;
        if(p.getMark().size()>1){
            System.out.println( p.name+", which symbol you want to use? Enter number: "                             );
            for (int i=0;i<p.getMark().size();i++) { 
                System.out.print(i+":");
                System.out.print(p.getMark().get(i).toString()); 
                System.out.println(" "); 
            }
            mark = p.getMark().get(keyboard.nextInt());}
        else{
            mark = p.getMark().get(0);
        }
        /*
        int r = 0 ;
        int c=0 ;
        int[] move = new int[]{r,c};
        System.out.println( p.name+", enter the row number you how to place the piece");
        
        r = keyboard.nextInt()-1;
        System.out.println( p.name+", enter the col number.");
        c = keyboard.nextInt()-1;
        
        System.out.println( p.name+", ");
      
        move= Validator.checkExist(r,c, board,p, other );*/
        
        System.out.println( p.name+", enter the row number you how to place the piece");
        int r,c;
        r = keyboard.nextInt()-1;
        System.out.println( p.name+", enter the col number.");
        c = keyboard.nextInt()-1;
        //checkPos(r,c);

        board.markCell(r,c,mark);
        p.addPos(r,c );
        board.display();       
    }
    
    abstract public void rules(); //depends on different games
    /*If user consistently ask to play again, the game will never ends*/
    public void playAgain(boolean playAgain){
      System.out.println("Want to play again? Enter 'y' if you want to, or enter anyother character to exit.");
      char restart = keyboard.next().charAt(0); 
      if (restart=='y'){
          playAgain=true;
      }
      
      else{
          //playAgain =false;
          System.out.println("");
          System.out.println("Game end.Thank you for playing.");
          playAgain=false;
      }
  }
    
    public static void main( String[] args ) {
        /* BoardGame is now an abstract class
         * and we can no longer create a specific
         * instance of class Student.
         */
 }

}


