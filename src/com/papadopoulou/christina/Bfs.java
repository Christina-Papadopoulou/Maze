package com.papadopoulou.christina;

import java.util.LinkedList;

public class Bfs {

    private String[][] map;
    private Node node;

    public Bfs(String[][] map, Node node) {
        this.map = map;
        this.node = node;
    }


    public void setMap(String[][] map) {
        this.map = map;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public void solveBFS() {
        // αρχικοπιήση της ουράς
        LinkedList<Node> queue = new LinkedList<>();

        // Βάζουμε το σημείο αρχής στην ουρά
        queue.add(node);

        // Μεταβλητές για το τρέχων σημείο και για το επόμενο
        Node current;
        Node next;

        while (!queue.isEmpty()) {
            printQueue(queue);

            // Παίρνουμε το πρώτο στοιχείο απο την ουρά
            current = queue.removeFirst();

            if (node.isFinal(map, current)) {
                break;
            }

            node.markedasVisited(map, current);

            // Κινηση πράκτορα προς τα πάνω
            next = current.movesUp();

            // Έλεγχος αν ειναι μέσα στα όρια και αν δεν το εχει επισκευτει ο πράκτορας
            if (node.isInMaze(map, next) && node.isCleared(map, next)) {
                queue.add(next);
            }

            // Κινηση πράκτορα προς τα δεξιά
            next = current.movesRight();
            if (node.isInMaze(map, next) && node.isCleared(map, next)) {
                queue.add(next);
            }

            // Κινηση πράκτορα προς τα κάτω
            next = current.movesDown();
            if (node.isInMaze(map, next) && node.isCleared(map, next)) {
                queue.add(next);
            }

            // Κινηση πράκτορα προς τα αριστερά
            next = current.movesLeft();
            if (node.isInMaze(map, next) && node.isCleared(map, next)) {
                queue.add(next);
            }
        }
    }

    public void printQueue(LinkedList<Node>  linkedList) {
        for (Node node : linkedList) {
            System.out.println(node.x() +  "  " + node.y()+ " ");
        }
    }
}
