import java.util.Scanner;
import java.util.ArrayList;    
import java.util.Collections;
public class TicTacToe extends BoardGame{
    static int seats=2;
    private int side;
    private int size;
    private Player playerO ;
    private Player playerX ;
    Board gameBoard;
    static ArrayList<Player> team1 = new ArrayList<Player>();
    static ArrayList<Player> team2 = new ArrayList<Player>();
    private static ArrayList<Player>[] allPlayers = (ArrayList<Player>[])new ArrayList<?>[]{team1,team2};
    private int winPieces = side;
    private ArrayList<Round> rounds = new ArrayList<Round>();
    private static int numRounds = 0;
    private Player[] currentPlayers = new Player[seats];
    private static boolean playAgain = false;
    
    Scanner scanner = new Scanner(System. in);
    
    public TicTacToe(){
      this.bName = "Tic-Tac-Toe";
      welcomeMsg();
      rules();
      int side = DIYboardSize();
    
      gameBoard  = new Board(side,side);
    }


    //size could be scalable 
    public int DIYboardSize(){
        System.out.println("side length? Type number");
        side = scanner. nextInt();
        size = side*side;
        return side;
    }
    
    public void rules(){
        
        String rule = "In this game, the player who succeeds in placing three of their marks in a horizontal, vertical, or diagonal row is the winner.You and your friends will enter numbers(1-9) as shown below, which refers to each empty sqaure.";
        System.out.println(rule);
    }
    
   public void setCurrentPlayers(ArrayList<Player> t1, ArrayList<Player> t2){
      Collections.shuffle(t1);
      Collections.shuffle(t2);
      playerO = t1.get(0);
      playerX = t2.get(0);
      System.out.print("By random selection, PlayerO is ");
      System.out.print(playerO.getName());
      System.out.print(", PlayerX is ");
      System.out.println(playerX.getName() );
     // playerO.setStatus(Player.Status.PLAY);
      if (playerO.getMark().indexOf(Mark.CIRCLE) == -1){
          playerO.setMark(Mark.CIRCLE);}
     // playerX.setStatus(Player.Status.PLAY);
  
      if (playerX.getMark().indexOf(Mark.CROSS) == -1){
          playerX.setMark(Mark.CROSS);}
   }
   
   public String checkWinnerRows(Board board){
       for(int i=0; i<this.side; i++){
           int counterX = 0;
           int counterO = 0;
           for (int j=0; j<this.side; j++){
               if(gameBoard.getCell(i,j).getContent()==Mark.CIRCLE){
                   counterO++;
               }else if (gameBoard.getCell(i,j).getContent()==Mark.CROSS){
                   counterX++;
               }
           }
           if(counterX == this.side){
               return "X";}
           if(counterO == this.side){
               return "O";
           }
       }
           return "";          
   }
   public String checkWinnerCols(Board board){
       for(int i=0; i<this.side; i++){
           int counterX = 0;
           int counterO = 0;
       for (int j=0; j<this.side; j++){
           if(gameBoard.getCell(j,i).getContent()==Mark.CIRCLE){
               counterO++;
           }else if (gameBoard.getCell(j,i).getContent()==Mark.CROSS){
               counterX++;
           }
       }
       if(counterX == this.side){
           return "X";}
       if(counterO == this.side){
           return "O";
       }}
       return "";          
   }
   

   
 public String checkWinnerRightDiagonal(Board board){

        int counterX = 0;
        int counterY = 0;
        for(int i=0; i<this.side; i++){
            if(gameBoard.getCell(i,this.side-1-i).getContent()==Mark.CIRCLE){
                counterX++;
            }   else if(gameBoard.getCell(i,this.side-1-i).getContent()==Mark.CROSS){
                counterY++;
            }
            if(counterX == this.side){
                return "X";
            }
            if(counterY == this.side){
                return "O";
            }
        }
        return "";
    }
  public String checkWinnerLeftDiagonal(Board board){
        int counterX = 0;
        int counterY = 0;
        for(int i=0; i<this.side; i++){
            if(gameBoard.getCell(i,i).getContent()==Mark.CIRCLE){
                counterX++;
            }   else if(gameBoard.getCell(i,i).getContent()==Mark.CROSS){
                counterY++;
            }
            if(counterX == this.side){
                return "X";
            }
            if(counterY == this.side){
                return "O";
            }
        }
        return "";
    }
  
    public String checkWinner(Board board){
      String r = checkWinnerRows(board);
      String c = checkWinnerCols(board);
      String rd = checkWinnerRightDiagonal(board);
      String ld = checkWinnerLeftDiagonal(board);
      if (r!=""){
          return r;
      }
      else if (c!=""){
          return c;
      }
      else if (rd!=""){
          return rd;
      }
      else if (ld !=""){
          return ld; 
      }
      //check draw
      else if (playerO.pos.size() +playerX.pos.size()==size){
          return "draw";
      }
      else{
          return "";}
  }
    public void roundResult(String result){
        if(result=="O"){ 
           playerO.win();
           playerX.lose();
           System.out.println("Congratulations to the winner: "+playerO.name);

        }
        if(result=="X"){
           playerX.win();
           playerO.lose();
           System.out.println("Congratulations to the winner: "+playerX.name);
        }
        if(result =="draw"){
            System.out.println("Game ends, no one wins.");
        } 
        
        Round round = new Round( numRounds, currentPlayers, this.bName, result);
        round.players[0] = new Player(playerO.name, playerO.status, playerO.score );
        round.players[1] = new Player(playerX.name, playerX.status, playerX.score );
        rounds.add(round);
        round.display();
        
        
    }

  public String makePieces(){
      boolean roundEnd = false;
      String result="";
      do{
          placePiece(playerO,gameBoard,playerX);
          result = checkWinner(gameBoard);
          if (result.length()>0){
             // roundEnd = true;
                break;
          }
          placePiece(playerX,gameBoard,playerO);
          result = checkWinner(gameBoard);
          if (result.length()>0){
            //  roundEnd = true;
                break;
          }}while(roundEnd == false);
          
          
      return result;
      //round statustics
  }
    
   
  public static void startGame(){
      numRounds++;
      do{TicTacToe ttt = new TicTacToe();
        ttt.gameBoard.display();
        
        ArrayList<Player>[] all= ttt.formTeam(seats, allPlayers); 
        
        ttt.setCurrentPlayers(team1,team2);
        String res = ttt.makePieces();
        ttt.roundResult(res);
        ttt.playAgain(playAgain);
        
      }while(playAgain);

  }

   public static void main(String[] args) {
       
        startGame();
        
    }

}


