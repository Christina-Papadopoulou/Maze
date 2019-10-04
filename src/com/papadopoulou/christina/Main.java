package com.papadopoulou.christina;

public class Main {

    public static void main(String[] args) {
        //Instantiate mazeFile
        MazeFile mazeFile = new MazeFile();

        //Instantiate map
        String[][] map = mazeFile.readFile();

        //Instantiate maze
        Maze maze = new Maze(map);

        //Instantiate node
        Node node = new Node(mazeFile.getStartPointX(), mazeFile.getStartPointY());

        //Instantiate bfs
        Bfs bfs = new Bfs(map, node);
       // bfs.setMap(map);
        //bfs.setNode(node);
        bfs.solveBFS();

        //Print maze with the visited cells
        maze.print();
    }
}
