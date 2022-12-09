public class Main {
    public static void main(String[] args) {
        int[] heights = {2, 1, 3};
        mountains(heights);
    }
    //Usarem els caracters /, \, i ^
    private static void mountains(int[] heights) {
        char[][] grid = crearCanvas(heights);
        //grid = ferMuntanya(heights[0], grid, rows);



        int posicio = 0;
        for (int i = 0; i < heights.length; i++) {
            posicio = ferMuntanya(grid, posicio, heights[i]);
        }
        printMountains(grid);
    }

    private static void printMountains(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    private static int ferMuntanya(char[][] grid, int posicio, int heights) {
        int h = grid.length -1;
        for (int i = 0; i < heights-1; i++) {
            grid[h][posicio] = '/';
            posicio++;
            h--;
        }
        grid[h][posicio] = '^';
        posicio++;
        h++;
        for (int i = 0; i < heights-1; i++) {
            grid[h][posicio] = '\\';
            posicio++;
            h++;
        }
        return posicio;
    }

    private static char[][] crearCanvas(int[] heights) {
        char[][] grid = new char[setRows(heights)][setColumns(heights)];
        return grid;
    }

    private static int setRows(int[] heights) {
        int firstMax = Math.max(heights[0], heights[1]);
        return Math.max(firstMax, heights[2]);
    }

    private static int setColumns(int[] heights) {
        return (heights[0] * 2 - 1) + (heights[1] * 2 - 1) + (heights[2] * 2 - 1);
    }
}