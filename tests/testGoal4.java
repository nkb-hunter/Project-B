package tests;

import classes.CompleteRoute;
import classes.finderMap;

public class testGoal4 {
    public static void main(String[] args) {
        String testMap = "!21XX\n3X888\n218XXX\n#XXXX";
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

        CompleteRoute currentRoute = new CompleteRoute();
        FM.findAllRoutes(startX, startY, currentRoute);

        CompleteRoute bestRoute = FM.getLowestCostRoute();
        if (bestRoute != null) {
            System.out.println("Best Route:");
            System.out.println(bestRoute);
        } else {
            System.out.println("No routes found.");
        }
    }
}
