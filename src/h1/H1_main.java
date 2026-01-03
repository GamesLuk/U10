package h1;

public class H1_main {

    public static void main(String[] args){

        Cell[] aliveCells = {
                new Cell(0,4),
                new Cell(1,1),
                new Cell(2,2),
                new Cell(2,3),
                new Cell(3,1),
                new Cell(3,2),
        };

        Grid grid = new Grid(aliveCells, 4, 5);

        printGrid(grid);

        grid.computeGeneration(1);

        printGrid(grid);

    }

    public static void printGrid(Grid grid){
        for (Cell[] row : grid.getGridArray()){
            System.out.println();
            for(Cell cell : row){
                int numIsAlive = cell.isAlive() ? 1 : 0;
                System.out.print(numIsAlive + ", ");
            }
        }
        System.out.println("\n----------------------------------");
    }

}
