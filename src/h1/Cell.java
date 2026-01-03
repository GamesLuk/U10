package h1;

public class Cell {

    private int indexRow;
    private int indexCol;
    private boolean alive;
    private int numLivingNeighbors;
    private boolean isAliveNextGen;

    public Cell(int indexRow, int indexCol, boolean alive){
        this.indexRow = indexRow;
        this.indexCol = indexCol;
        this.alive = alive;
    }

    public Cell(int indexRow, int indexCol){
        this.indexRow = indexRow;
        this.indexCol = indexCol;
    }

    public void countLivingNeighbors(Cell[][] gridArray){

        numLivingNeighbors = 0;
        int numDeadNeighbors = 0;

        int[] verticalValues = {indexRow - 1, indexRow, indexRow + 1};
        int[] horizontalValues = {indexCol - 1, indexCol, indexCol + 1};

        for(int row : verticalValues){
            for(int col : horizontalValues){
                // Filter Index-Out-Of-Bound
                if (row < 0 || row >= gridArray.length ||
                    col < 0 || col >= gridArray[0].length){
                    continue;
                }

                // Filter current Cell
                if (row == indexRow && col == indexCol){
                    continue;
                }

                // Increment numLivingNeighbors by 1 if cell is living
                if (gridArray[row][col].isAlive()) numLivingNeighbors += 1;
                else numDeadNeighbors += 1;
            }
        }
        decideNextStatus();
    }

    private void decideNextStatus(){
        isAliveNextGen = alive;
        if(!alive && numLivingNeighbors == 3) isAliveNextGen = true;
        else if (alive && numLivingNeighbors != 2 && numLivingNeighbors != 3) isAliveNextGen = false;
    }

    public int getIndexRow() {
        return indexRow;
    }

    public void setIndexRow(int indexRow) {
        this.indexRow = indexRow;
    }

    public int getIndexCol() {
        return indexCol;
    }

    public void setIndexCol(int indexCol) {
        this.indexCol = indexCol;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getNumLivingNeighbors() {
        return numLivingNeighbors;
    }

    public void setNumLivingNeighbors(int numLivingNeighbors) {
        this.numLivingNeighbors = numLivingNeighbors;
    }

    public boolean isAliveNextGen() {
        return isAliveNextGen;
    }

    public void setAliveNextGen(boolean aliveNextGen) {
        isAliveNextGen = aliveNextGen;
    }
}
