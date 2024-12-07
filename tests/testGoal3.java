package tests;

import classes.finderMap;

public class testGoal3 {
    public static void main(String[] args) {
        String testMap = "X!xxxxx\nX3x888#\nX218xxx\nxxxxxxx";
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

        int[] totalCost = {0};
        if (FM.solveMaze(startX, startY, 1, totalCost)) {
            System.out.println("Solution found with total cost: " + totalCost[0]);
            for (int i = 0; i < FM.getRows(); i++) {
                for (int j = 0; j < FM.getCols(); j++) {
                    if (FM.getVisited(i, j) > 0) {
                        System.out.print(FM.getVisited(i, j) + " ");
                    } else {
                        System.out.print("X ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution exists.");
        }
    }
}
