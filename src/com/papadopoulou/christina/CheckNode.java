package com.papadopoulou.christina;

public interface CheckNode {
    void markedasVisited(String[][] maze, Node pos);
    boolean isCleared(String[][] maze, Node pos);
    boolean isInMaze(String[][] maze, Node pos);
    boolean isFinal(String[][] maze, Node pos);
}
