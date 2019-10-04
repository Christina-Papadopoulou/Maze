package com.papadopoulou.christina;

import java.util.LinkedList;

public class Bfs {

    private String[][] map;
    private Node node;

    public Bfs(String[][] map, Node node) {
        this.map = map;
        this.node = node;
    }

    public void solveBFS() {
        //Initialize the queue
        LinkedList<Node> queue = new LinkedList<>();

        //Put the fist node in the queue
        queue.add(node);

        //Variable for the current node and next node
        Node current;
        Node next;

        //Until queue has elements
        while (!queue.isEmpty()) {
            System.out.print("Queue: ");
            printQueue(queue);

            //Take the first element of queue
            current = queue.removeFirst();

            //The loop stops when we will arrive in End point
            if (node.isFinal(map, current)) {
                break;
            }

            //Mark as Visited current node we have visited
            node.markedasVisited(map, current);

            //Move of agent Up
            next = current.movesUp();

            //Check if agent is in Maze limits and he is no visite a wall or an already visited node
            if (node.isInMaze(map, next) && node.isCleared(map, next)) {
                queue.add(next);
            }

            //Move of agent Right
            next = current.movesRight();
            if (node.isInMaze(map, next) && node.isCleared(map, next)) {
                queue.add(next);
            }

            //Move of agent Down
            next = current.movesDown();
            if (node.isInMaze(map, next) && node.isCleared(map, next)) {
                queue.add(next);
            }

            //Move of agent Left
            next = current.movesLeft();
            if (node.isInMaze(map, next) && node.isCleared(map, next)) {
                queue.add(next);
            }
        }
    }

    //Print Queue
    public void printQueue(LinkedList<Node>  linkedList) {
        for (Node node : linkedList) {
            System.out.print("[" + node.x() +  "," + node.y()+ "}");
        }
        System.out.println();
    }

}
