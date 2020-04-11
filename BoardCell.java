/**
 * A Cell instance contents
 * row, col --> positions on the board
 * 
 */
public class BoardCell {
    private Mark content;
    private int row, col;
    public BoardCell(int row, int col) {
        this.row = row;
        this.col = col;
        this.content = Mark.EMPTY;
        
    }
    
    public void clearCell(){
        content = Mark.EMPTY;
    }
    public Mark getContent(){
        return content;
    }
    public void setContent(Mark m){
        this.content = m;
    }
    public void printCell(){
        switch(content){
            case EMPTY: 
                System.out.print(" "); 
                break;
            case CROSS:
                System.out.print("X");
                break;
            case CIRCLE:
                System.out.print("O");
        }
       
    }

    public static void main(String[] args) {
        BoardCell cell = new BoardCell(2,3);
        cell.printCell();
    }
    

    //public void setContent(Mark content) { this.content = content;
    //}

    
    
}
