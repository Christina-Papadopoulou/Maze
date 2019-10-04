package com.papadopoulou.christina;

public class Maze {
    private String[][] maze;

    //Constructor of Maze
    Maze(String[][] maze){
        this.maze = maze;
    }

    //Return size of maze
    private int mazeSize() {
        return maze.length;
    }

    //Print maze with visited cells
    public void print(){
        System.out.println("The maze with the visited cells");
        for (int i = 0; i < mazeSize(); i++) {
            for (int j = 0; j < mazeSize(); j++) {
                System.out.print(maze[j][i]);
                System.out.print(' ');
            }
            System.out.println();
        }
        System.out.println("====================");
    }
}
