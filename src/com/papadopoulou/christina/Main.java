package com.papadopoulou.christina;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception{
        //Instantiate mazeFile
        MazeFile mazeFile = new MazeFile();

        //Instantiate map
        String[][] map = mazeFile.readFile();

        //Instantiate maze
        Maze maze = new Maze(map);

        //Instantiate node
        Node nodestart = new Node(mazeFile.getStartPointX(), mazeFile.getStartPointY());

        //Instantiate bfs for the equivalent map and nodestart
        Bfs bfs = new Bfs(map, nodestart);

        //Solve bfs
        bfs.solveBFS();

        //Print maze with the visited cells
        maze.print();
    }
}
