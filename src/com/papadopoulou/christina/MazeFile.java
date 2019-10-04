package com.papadopoulou.christina;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MazeFile {
    private final String FILENAME = "labirinthos.txt";
    private int startPointX;
    private int startPointY;
    private int endPointX;
    private int endPointY;

    MazeFile() {
    }

    public int getStartPointX() {
        return startPointX;
    }

    public int getStartPointY() {
        return startPointY;
    }

    public String[][] readFile() {
        String[][] maze = {{""}};
        BufferedReader br;

        try {
            //Instantiate file
            File file = new File(FILENAME);
            //Instantiate BufferedReader
            br = new BufferedReader(new FileReader(file));

            String line;
            int numLine = 0;

            for (int i = 0; i < 3; i++) {
                line = br.readLine();
                String[] parametersSplit = line.split(" ");

                //First line of lavirinthos.txt we read row and columns
                if (i == 0) {
                    int rows = Integer.parseInt(parametersSplit[0]);
                    int columns = Integer.parseInt(parametersSplit[1]);
                    maze = new String[rows][columns];

                //Second line of lavirinthos.txt we read the StartPoint of maze
                } else if (i == 1) {
                    startPointX = Integer.parseInt(parametersSplit[0]);
                    startPointY = Integer.parseInt(parametersSplit[1]);
                //Third line of lavirinthos.txt we read the Endpoin of maze
                } else {
                    endPointX = Integer.parseInt(parametersSplit[0]);
                    endPointY = Integer.parseInt(parametersSplit[1]);
                }
            }

            //From the fourth line and after we read the maze
            while ((line = br.readLine()) != null) {
                String[] array = line.split(" ");

                for (int i = 0; i < array.length; i++) {
                    maze[i][numLine] = array[i];
                }
                numLine++;
            }
        } catch (Exception ex) {
            //If the file did not found the alert user to put txt archive in the appropriate folder
            System.out.println("Put the file labirithos.txt in folder Maze");
        }
        return maze;
    }


}
