package com.papadopoulou.christina;

public class Node implements Move{
    private int x, y;

    /*** Constructor @param x coordinate @param y coordinate*/
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /*** @return - Επιστρέφει την συντεταγμένη x του πράκτορα*/
    public int x() {
        return x;
    }

    /*** @return - Επιστρέφει την συντεταγμένη y του πράκτορα*/
    public int y() {
        return y;
    }

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

    /**
     * Σημειώνει το μονοπάτι πο επισκέφθηκε ο πράκτορας με το σύμβολο V
     *
     */
    public void markPos(String[][] maze, Node pos) {
        maze[pos.x()][pos.y()] = "V";
    }

    /**
     * Έλεγχος μονοπατιού: Αν ο πράκτορας δεν το εχει επισκεφθεί και δεν ειναι
     * τοίχος
     *
     * @return: true - ειναι καθαρό, false - δεν ειναι καθαρό
     */
    public boolean isCleared(String[][] maze, Node pos) {
        return !(maze[pos.x()][pos.y()].equals("V")) && !(maze[pos.x()][pos.y()].equals("x"));
    }

    /**
     * Έλεγχος αν το σημείο που ελέγχεται βρίσκεται μεσα στα όρια του πίνακα
     *
     * @param - αντικείμενο Agent_Moves
     * @return: true - ειναι μεσα στα όρια, false- εκτος ορίων
     */
    public boolean isInMaze(String[][] maze, Node pos) {
        return  pos.x() >= 0 &&
                pos.x() < maze.length &&
                pos.y() >= 0 &&
                pos.y() < maze[0].length;
    }

    /**
     * Έλεγχος αν ειναι το σημείο του τερματισμού
     *
     * @return: true - ειναι το σημείο τρερματισμου, false - δεν ειναι το σημείο τρερματισμου
     */
    public boolean isFinal(String[][] maze, Node pos) {
        return maze[pos.x()][pos.y()].equals("E");
    }
}
