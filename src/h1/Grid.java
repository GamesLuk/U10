package h1;

public class Grid {

    private Cell[][] gridArray;

    public Grid(Cell[] cells, int gridRows, int gridCols){
        this.gridArray = new Cell[gridRows][gridCols];

        for(int rowIndex = 0; rowIndex < gridRows; rowIndex++){
            for(int colIndex = 0; colIndex < gridCols; colIndex++){
                // Create Cell
                gridArray[rowIndex][colIndex] = new Cell(rowIndex,colIndex);

                // Set Alive if in cells
                for(Cell cell : cells){
                    if(cell.getIndexCol() == colIndex && cell.getIndexRow() == rowIndex){
                        gridArray[rowIndex][colIndex].setAlive(true);
                    }
                }
            }
        }

        // Pre-Calculate next Gen
        for(Cell[] row : gridArray){
            for(Cell cell : row){
                cell.countLivingNeighbors(gridArray);
            }
        }
    }

    public void computeNextGen(){
        Cell[][] nextGridArray = new Cell[gridArray.length][gridArray[0].length];

        for(Cell[] row : gridArray){
            for(Cell cell : row){
                nextGridArray[cell.getIndexRow()][cell.getIndexCol()] =
                        new Cell(cell.getIndexRow(), cell.getIndexCol(), cell.isAliveNextGen());
            }
        }

        for(Cell[] row : nextGridArray){
            for(Cell cell : row){
                cell.countLivingNeighbors(nextGridArray);
            }
        }

        gridArray = nextGridArray;
    }

    public void computeGeneration(int n){
        for (int i = 0; i < n; i++){
            computeNextGen();
        }
    }

    public Cell[][] getGridArray() {
        return gridArray;
    }

    public void setGridArray(Cell[][] gridArray) {
        this.gridArray = gridArray;
    }
}
