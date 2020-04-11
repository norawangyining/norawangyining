/**
 * A mark instance could be any symbols. 
 */
public enum Mark {
        
        
    EMPTY(" "),
    CROSS("X"),
    CIRCLE("O");

    private final String text;

    private Mark(String text) {
        this.text = text;
    }

    public String toString() {
         return text;
    }
       
    
    
}

