package tests;

import classes.finderMap;

public class testGoal2 {
    public static void main(String[] args) {
        String testMap = "x#xxx\nxp!xx\nxxxxx";
        finderMap FM = new finderMap(testMap);

        System.out.println("Original Map:");
        System.out.println(FM);
        int startX = 0, startY = 0;
        for (int i = 0; i < FM.getRows(); i++) {
            for (int j = 0; j < FM.getCols(); j++) {
                if (FM.getMap()[i][j].equals("#")) {
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }
        // Solve the maze
        if (FM.solveMaze(startX, startY)) {
            System.out.println("Solution found:");
            System.out.println(FM.visitedString());
        } else {
            System.out.println("No solution exists.");
        }
    }
}