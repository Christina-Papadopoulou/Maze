package com.papadopoulou.christina;

public class Maze {
    // Αρχικοποίηση Μεταβλητων
    private String[][] maze;

    // Σταθερές που υποδυκνύουν τα σηαμεία αρχής και τερματισμού
    public static final int START_X = 3;
    public static final int START_Y = 1;
    public static final int END_X   = 3;
    public static final int END_Y   = 4;

    /**
     * Constructor
     * @param maze
     */
    Maze(String[][] maze){
        this.maze = maze;
    }

    /**
     *
     * @return - Επιστρέφει το μέγεθος του maze
     */
    private int mazeSize() {
        return maze.length;
    }

    /**
     * Εκτυπώνει τον maze
     */
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
