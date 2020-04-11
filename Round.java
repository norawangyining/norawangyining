import java.util.ArrayList; 
/* A Round instance contains of the statistics for each round of the game, including:
 * which game
 * players
 * winner
 * number of rounds
 * */
public class Round{
    private int number;
    public Player[] players;
    private String gameName;
    private String winner;

    public Round(int n, Player[] p, String name, String result){
        this.gameName = name;
        this.number = n;
        this.players = p;
        String winner = result;
        
    }
    public void display(){
        System.out.println("Round "+number+ ": "+players[0].name+" vs. "+ players[1].name);
        System.out.println(players[0].name+"'s cumulative score: "+players[0].score);
        System.out.println(players[1].name+"'s cumulative score: "+players[1].score);
            
    }
    
}