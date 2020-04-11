import java.util.Scanner;
/**
 * contains implementation of the validate method, can be applied for any model
 */

public class Validator {
    static Scanner scanner = new Scanner(System.in); 
    public static int[] checkExist(int r,int c, Board board,Player pO,Player pX ){
        int[] ret = new int[]{r,c};
        int rows = board.width;
        int cols = board.height;
 
        boolean bError = true;
           //Catch the exceptions that the user input is not integers and is outside of board
        do{
            
                if ( r>=0 && r<rows ){
                    bError = false;
                    //r = scanner.nextInt();
                }else {
                    System.out.println("Wrong input! The number does not exist on board.");
                    System.out.println("enter the row number of your piece");
                    r = scanner.nextInt()-1;
                    //continue;
                }
                bError = false;
            }while(bError);
        do{
            
                if ( c>=0 && c<cols ){
                    bError = false;
                    //r = scanner.nextInt();
                }else {
                    System.out.println("Wrong input! The number does not exist on board.");
                    System.out.println("enter the column number of your piece");
                    c = scanner.nextInt()-1;
                    //continue;
                }
                bError = false;
            }while(bError);
        //To catch the exceptions that user may place a move that has been taken.              
        while(pO.pos.contains(ret)||pX.pos.contains(ret)){
            System.out.println("Error! Your move has been taken, please enter a correct position.");
            r =scanner.nextInt()-1;
            c = scanner.nextInt()-1;
        }
            
            
        return ret;
    }
    
}
