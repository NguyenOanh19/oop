// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
    private char[][] grid;

    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     *
     * @param grid
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns the area for the given char in the grid. (see handout).
     *
     * @param ch char to look for
     * @return area for given char
     */
    public int charArea(char ch) {
        int w1 = -1, w2 = -1;
        int h1 = -1, h2 = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]==ch) {
                    if (w1==-1) {
                        w1 = j;
                        w2 = j;
                        h1 = i;
                        h2 = i;
                        continue;
                    }
                    w1 = Math.min(w1, j);
                    h1 = Math.min(h1, i);
                    w2 = Math.max(w2, j);
                    h2 = Math.max(h2, i);
                }
            }
        }
        if (w1==-1) {
            return 0;
        }
        return (w2 - w1 + 1) * (h2 - h1 + 1); // YOUR CODE HERE
    }

    /**
     * Returns the count of '+' figures in the grid (see handout).
     *
     * @return number of + in grid
     */

    private boolean isPlus(int y, int x, int I, int J) {
        int w1 = -1, w2 = -1;
        int h1 = -1, h2 = -1;
        for (int i = y - 1; i >= 0; i--) {
            if (grid[i][x]==grid[y][x]) {
                h1 = i;
            } else {
                break;
            }
        }
        for (int i = y + 1; i <= I; i++) {
            if (grid[i][x]==grid[y][x]) {
                h2 = i;
            } else {
                break;
            }
        }
        for (int j = x - 1; j >= 0; j--) {
            if (grid[y][j]==grid[y][x]) {
                w1 = j;
            } else {
                break;
            }
        }
        for (int j = x + 1; j <= J; j++) {
            if (grid[y][j]==grid[y][x]) {
                w2 = j;
            } else {
                break;
            }
        }
        if ((x - w1) < 1 || (w2 - x) < 1 || (y - h1) < 1 || (h2 - y) < 1) {
            return false;
        }
        return ((x - w1)==(w2 - x) && (y - h1)==(h2 - y) && (w2 - w1)==(h2 - h1));
    }

    public int countPlus() {
        int cnt = 0;
        int I = grid.length - 1;
        int J = grid[0].length - 1;
        for (int i = 1; i <= I - 1; i++) {
            for (int j = 1; j <= J - 1; j++) {
                if (grid[i][j]!=' ' && isPlus(i, j, I, J)) {
                    cnt++;
                }
            }
        }
        return cnt; // YOUR CODE HERE
    }

    public static void main(String[] args) {
        char[][] grid = {
                {' ', ' ', 'p', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', 'p', ' ', ' ', ' ', ' ', 'x', ' '},
                {'p', 'p', 'p', 'p', 'p', ' ', 'x', 'x', 'x'},
                {' ', ' ', 'p', ' ', ' ', 'y', ' ', 'x', ' '},
                {' ', ' ', 'p', ' ', 'y', 'y', 'y', ' ', ' '},
                {'z', 'z', 'z', 'z', 'z', 'y', 'z', 'z', 'z'},
                {' ', ' ', 'x', 'x', ' ', 'y', ' ', ' ', ' '}
        };
        CharGrid charGrid = new CharGrid(grid);
        System.out.println(charGrid.countPlus());
    }
}
