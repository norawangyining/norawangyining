/**
 * Auto Generated Java Language Level Class.
 */

public class Board {
    public int width ;
    public int height;
    private BoardCell[][] cells;
    //Constructor
    public Board(int w, int h){
        setWidth(w);
        setHeight(h);
        cells = new BoardCell[w][h];
        for( int r = 0; r < w; r++) {
            for (int c = 0; c < h;c++) {
                cells[r][c] = new BoardCell(r,c);
                cells[r][c].clearCell();
            }
        }  
    }
    public BoardCell getCell(int r, int c){
        return  this.cells[r][c];
    }
    public void setWidth(int w){
        if(w<=0){
            throw new IllegalArgumentException();
        }
        this.width = w;
    }
    
    public void setHeight(int h){
        if(h<=0){
            throw new IllegalArgumentException();
        }
        this.height = h;
    }
    //A method to prints out the board
    public void display(){
        for (int i = 1; i<=this.height;i++){
            if(i>=10){
                System.out.print(i+" ");
            }else{
                System.out.print(" "+i+" ");}
        }
        System.out.println();
        for(int r = 0; r<this.width; r++){
            for(int c =0; c<this.height;c++){
                System.out.print("[");
                cells[r][c].printCell();
                System.out.print("]");
            }
            int rowNum = r+1;
            System.out.println(" "+rowNum+" ");
            //System.out.println();
        }
    }
    //make board empty
    public void clearBoard(){
        for( int r = 0; r < width; r++) {
            for (int c = 0; c < height;c++) {
                cells[r][c].clearCell();
            }
        }
    }
    
    public void markCell(int r, int c,Mark m){
        this.cells[r][c].setContent(m);
    }
    
    public static void main(String[] args) {
        Board b = new Board(10,12);
        b.display();
    }
    

}

