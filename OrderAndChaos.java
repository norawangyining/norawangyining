
/**
 * Auto Generated Java Language Level Class.
*/ 
import java.util.Scanner;
import java.util.ArrayList;    
import java.util.Collections;

class OrderAndChaos extends BoardGame{
    static int seats=2;
    private final int side=6; //default size for OrderAndChaos
    private final int size=36;
    private Player Order ;
    private Player Chaos ;
    Board OC_Board;
    static ArrayList<Player> team1 = new ArrayList<Player>();
    static ArrayList<Player> team2 = new ArrayList<Player>();
    private static ArrayList<Player>[] allPlayers = (ArrayList<Player>[])new ArrayList<?>[]{team1,team2};
    Scanner scanner = new Scanner(System. in);
    private int winPieces = 5;
    private static boolean playAgain = false;
    private ArrayList<Round> rounds = new ArrayList<Round>();
    private static int numRounds = 0;
    private Player[] currentPlayers = new Player[seats];
    public OrderAndChaos(){
      this.bName = "Order-And-Chaos";
      welcomeMsg();
      rules();
      OC_Board  = new Board(side,side);
    }
    public void rules(){
        String rule  = "Unlike typical board games, both players control both sets of pieces (Xs and Os)."+ 
            "The game starts with the board empty. Order plays first, then turns alternate. "+
            "On each turn, a player places either an X or an O on any open square."+ 
            "Once played, pieces cannot be moved, thus Order and Chaos can be played using pencil and paper."+
            "Order aims to get five like pieces in a row either vertically, horizontally, or diagonally."+
            "Chaos aims to fill the board without completion of a line of five like pieces.";
        System.out.println(rule);
     
    }
      public void setCurrentPlayers(ArrayList<Player> t1, ArrayList<Player> t2){
      Collections.shuffle(t1);
      Collections.shuffle(t2);
      Order = t1.get(0);
      Chaos = t2.get(0);
      System.out.print("By random selection, Order is ");
      System.out.print(Order.getName());
      System.out.print(", Chaos is ");
      System.out.println(Chaos.getName() );
      if (Order.getMark().indexOf(Mark.CIRCLE) == -1&&Order.getMark().indexOf(Mark.CROSS) == -1){
          Order.setMark(Mark.CIRCLE);
          Order.setMark(Mark.CROSS);
          }
      if (Chaos.getMark().indexOf(Mark.CIRCLE) == -1&&Chaos.getMark().indexOf(Mark.CROSS) == -1){
          Chaos.setMark(Mark.CIRCLE);
          Chaos.setMark(Mark.CROSS);
          }
   
    
   }
  
    public String checkWinnerRows(Board board,int limit){
        for(int i=0; i<limit; i++){
            int counterX = 0;
            int counterO = 0;
            for (int j=0; j< limit; j++){
                if(OC_Board.getCell(i,j).getContent()==Mark.CIRCLE){
                    counterO++;
                }else if (OC_Board.getCell(i,j).getContent()==Mark.CROSS){
                   counterX++;
               }
           }
           if(counterX == limit){
               return "Order";}
           if(counterO == limit){
               return "Order";
           }
       }
           return "";          
   }
   public String checkWinnerCols(Board board,int limit){
       for(int i=0; i<limit; i++){
           int counterX = 0;
           int counterO = 0;
       for (int j=0; j<limit; j++){
           if(OC_Board.getCell(j,i).getContent()==Mark.CIRCLE){
               counterO++;
           }else if (OC_Board.getCell(j,i).getContent()==Mark.CROSS){
               counterX++;
           }
       }
       if(counterX == limit){
           return "Order";}
       if(counterO == limit){
           return "Order";
       }}
       return "";          
   }
   
 public String checkWinnerRightDiagonal(Board board,int limit){

        int counterX = 0;
        int counterY = 0;
        for(int i=0; i<limit; i++){
            if(OC_Board.getCell(i,limit-1-i).getContent()==Mark.CIRCLE){
                counterX++;
            }   else if(OC_Board.getCell(i,limit-1-i).getContent()==Mark.CROSS){
                counterY++;
            }
            if(counterX == limit){
                return "Order";
            }
            if(counterY == limit){
                return "Order";
            }
        }
        return "";
    }
  public String checkWinnerLeftDiagonal(Board board,int limit){
        int counterX = 0;
        int counterY = 0;
        for(int i=0; i<limit; i++){
            if(OC_Board.getCell(i,i).getContent()==Mark.CIRCLE){
                counterX++;
            }   else if(OC_Board.getCell(i,i).getContent()==Mark.CROSS){
                counterY++;
            }
            if(counterX == limit){
                return "Order";
            }
            if(counterY == limit){
                return "Order";
            }
        }
        return "";
    }

  public String checkWinner(Board board){
      String r = checkWinnerRows(board,winPieces);
      String c = checkWinnerCols(board, winPieces);
      String rd = checkWinnerRightDiagonal(board, winPieces);
      String ld = checkWinnerLeftDiagonal(board, winPieces);
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
      else if (Order.pos.size() +Chaos.pos.size()==size){
          return "Chaos";
      }
      else{
          return "";}
  }
    
    
  public String makePieces(){
      boolean roundEnd = false;
      String result="";
      do{
          placePiece(Order,OC_Board,Chaos);
          result = checkWinner(OC_Board);
          if (result.length()>0){
             // roundEnd = true;
                break;
          }
          placePiece(Chaos,OC_Board,Order);
          result = checkWinner(OC_Board);
          if (result.length()>0){
             // roundEnd = true;
                break;
          }}while(roundEnd == false);
          
          
      return(result);
      //round statustics
  
  }
  public void roundResult(String result){
        if(result=="Order"){ 
           Order.win();
           Chaos.lose();
           System.out.println("Congratulations to the winner: "+Order.name);

        }
        if(result=="Chaos"){
           Order.win();
           Chaos.lose();
           System.out.println("Congratulations to the winner: "+Chaos.name);
        }
        
        Round round = new Round( numRounds, currentPlayers, this.bName, result);
        round.players[0] = new Player(Order.name, Order.status, Order.score );
        round.players[1] = new Player(Chaos.name, Chaos.status, Chaos.score );
        rounds.add(round);
        round.display();
        
        
    }

    public static void startGame(){
        numRounds++;
      do{
        OrderAndChaos oc = new OrderAndChaos();
        oc.OC_Board.display();
        
        ArrayList<Player>[] all=oc.formTeam(seats,allPlayers); 
        
        oc.setCurrentPlayers(team1,team2);
       
        String res =oc.makePieces();
        oc.roundResult(res);
        oc.playAgain(playAgain);
        
      }while(playAgain);
      
        
        
      
  }

    
  public static void main(String[] args) {
       
        startGame();
        
    }
    
    
    
   
    
    
    


 
    
    
}


    

