import java.util.Scanner;
import java.util.ArrayList;     

/*
 * instance player has 
 * name, 
 * score(positiove for number of wins, negative for number of loss),
 * symbols(of instance Mark) to use
 * status (playing or wait in team)
 * Positions 
 * 
 */
class Player {
    String name; 
    ArrayList<Mark> symbol = new ArrayList<Mark>();
    Scanner keyboard = new Scanner(System.in); 
    public enum Status{
        PLAY,
        WAIT
    }
    public int score;
    public Status status;
    public ArrayList<int[]> pos = new ArrayList<int[]>();
    
    public Player(String n, Status st, int sc ){
        setName(n);
        setStatus(st);
        setScore(sc);
    }
    
    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
    public void askName(Player p){
      System.out.println("Please enter your nickname:");
      String pname = keyboard.nextLine();
      p.setName(pname);
      
    }
    public void setStatus(Status st){
        status = st;
    }
 
    public void setScore(int s){
        score = s;
    }
    //return current score of player
    public int getScore(){
        return score;
    }
    public void setMark(Mark m){
        symbol.add(m);
    }
    public ArrayList<Mark> getMark(){
        return symbol;
    }
    public void addPos(int r,int c ){
        int[] position = new int[2];
        position[0] = r;
        position[1] = c;
        pos.add(position);
    }
    public void clearPos(){
        pos.clear();
    }
    public void win(){
        this.score++;
        
    }
    public void lose(){
        this.score--;
    }
    
    
    /* ADD YOUR CODE HERE */
    
    /*An arraylist of players */
    
}
