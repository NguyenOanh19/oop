//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
    private boolean[][] grid;

    /**
     * Constructs a new instance with the given grid.
     * Does not make a copy.
     *
     * @param grid
     */
    public TetrisGrid(boolean[][] grid) {
        this.grid = grid;
    }

    /**
     * Does row-clearing on the grid (see handout).
     */
    public void clearRows() {
        if (grid.length > 0) {
            int j = 0;
            while (j < grid[0].length) {
                boolean isFull = true;
                for (int i = 0; i < grid.length; i++) {
                    if (!grid[i][j]) {
                        isFull = false;
                        break;
                    }
                }
                if (isFull) {
                    for (int j1 = j; j1 < grid[0].length; j1++) {
                        for (int i = 0; i < grid.length; i++) {
                            if (j1!=grid[0].length - 1) {
                                grid[i][j1] = grid[i][j1 + 1];
                            } else {
                                grid[i][j1] = false;
                            }
                        }
                    }
                } else {
                    j++;
                }
            }
        }
    }

    /**
     * Returns the internal 2d grid array.
     *
     * @return 2d grid array
     */
    boolean[][] getGrid() {
        return grid; // YOUR CODE HERE
    }
}
