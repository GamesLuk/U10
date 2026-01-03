package h2;

public class Spielstein {

    private int currentRow;
    private int currentCol;
    private Spielbrett brett;

    public Spielstein(Spielbrett brett, int indexRow, int indexCol){
        this.brett = brett;
        this.currentRow = indexRow;
        this.currentCol = indexCol;
    }

    private boolean movesOut(){
        if (currentRow < 0 || currentRow >= brett.getDim() ||
                currentCol < 0 || currentCol >= brett.getDim()) return true;
        return brett.getBrett()[currentRow][currentCol] == null;
    }

    public void go(int a){
        for(int i=0; i < a;i++){
            // System.out.println(currentRow + " | " + currentCol);

            Feld currentFeld = brett.getBrett()[currentRow][currentCol];
            int oldRow = currentRow;
            int oldCol = currentCol;

            if(currentFeld.isBoese()){
                continue;
            }

            switch (currentFeld.getDirection()){
                case 'U' -> currentRow -= 1;
                case 'D' -> currentRow += 1;
                case 'L' -> currentCol -= 1;
                case 'R' -> currentCol += 1;
            }

            if(movesOut()) {
                currentRow = oldRow;
                currentCol = oldCol;
            }

        }
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }

    public Spielbrett getBrett() {
        return brett;
    }

    public void setBrett(Spielbrett brett) {
        this.brett = brett;
    }
}
