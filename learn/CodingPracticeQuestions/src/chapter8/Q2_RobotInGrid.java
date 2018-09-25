package chapter8;

import base.Question;

public class Q2_RobotInGrid implements Question {

    enum Path {
        RIGHT, DOWN, BLANK, BLOCK
    }

    int rows = 4;
    int cols = 4;

    Path[][] grid = new Path[rows][cols];

    @Override
    public void run() {

        // r rows , c cols

        // Inti Grid.
        grid[0][1] = Path.BLOCK;
        grid[1][2] = Path.BLOCK;

        for(int c = cols -1; c >= 0 ; c--){
            for(int r = rows -1; r >=0 ; r-- ){
                markPosition(r, c);
            }
        }

        // Print grid:
        for(int r = 0; r < rows; r++){
           for(int c=0; c < cols; c++) {
             System.out.print(grid[r][c].name() + "  ");
           }
           System.out.println();
        }

        // Do DFS to find the

    }

    void markPosition( int r, int c ){
        if(c==cols-1 && r==rows-1) {
            grid[r][c] = Path.BLANK;
        }
        else if(grid[r][c] == Path.BLOCK){
            // do nothing.
        }
        // Case on right edge.
        else if(c == cols-1){
            if(grid[r+1][c] != Path.BLOCK)
                grid[r][c] = Path.DOWN;
            else {
                grid[r][c] = Path.BLOCK;
            }
        }
        else if(r == rows -1){
            if( grid[r][c + 1] != Path.BLOCK )
                grid[r][c] = Path.RIGHT;
            else {
                grid[r][c] = Path.BLOCK;
            }
        } else {


            if (grid[r][c + 1] != Path.BLOCK) {
                grid[r][c] = Path.RIGHT;
            } else if (grid[r + 1][c] != Path.BLOCK) {
                grid[r][c] = Path.DOWN;
            } else {
                grid[r][c] = Path.BLOCK;
            }
        }
    }


}
