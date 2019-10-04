package com.papadopoulou.christina;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MazeFile mazeFile = new MazeFile();
        String[][] map = mazeFile.readFile();

        Maze maze = new Maze(map);
        Node node = new Node(mazeFile.getStartPointX(), mazeFile.getStartPointY());
        Bfs bfs = new Bfs(map, node);
        bfs.setMap(map);
        bfs.setNode(node);
        bfs.solveBFS();
        maze.print();
    }
}
