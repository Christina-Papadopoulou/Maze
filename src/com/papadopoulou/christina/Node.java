package com.papadopoulou.christina;

public class Node implements Move, CheckNode{
    private int x, y;

    //Constructor Node with coordinates x,y
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Get coordinate x
    public int x() {
        return x;
    }

    //Get coordinate y
    public int y() {
        return y;
    }

    //Override methods of interface Move
    //First parameter x is for the columns and second for the lines
    @Override
    public Node movesUp() {
        return new Node(y - 1, x);
    }

    @Override
    public Node movesRight() {
        return new Node(y, x + 1);
    }

    @Override
    public Node movesDown() {
        return new Node(y + 1, x);
    }

    @Override
    public Node movesLeft() {
        return new Node(y, x - 1);
    }

    //Notate the node of the maze as visited with V
    public void markedasVisited(String[][] maze, Node pos) {
        maze[pos.x()][pos.y()] = "V";
    }

    //If node is visited-V or node is wall-X then we don't want to move in this node
    public boolean isCleared(String[][] maze, Node pos) {
        return !(maze[pos.x()][pos.y()].equals("V")) && !(maze[pos.x()][pos.y()].equals("X"));
    }

    //Check if node is in maze
    public boolean isInMaze(String[][] maze, Node pos) {
        return  pos.x() >= 0 &&
                pos.x() < maze.length &&
                pos.y() >= 0 &&
                pos.y() < maze[0].length;
    }

    //Check if the node is the End node of maze so as the moves stop
    public boolean isFinal(String[][] maze, Node pos) {
        return maze[pos.x()][pos.y()].equals("E");
    }
}
