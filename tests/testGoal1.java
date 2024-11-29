package tests;
import classes.finderMap;

public class testGoal1 {
    public static void main(String[] args) {

        String testMap = "xpxxx\nxxxxp\npxxxx";
        finderMap FM = new finderMap(testMap);
        System.out.println(FM);
        FM.setVisited(0, 1);

        System.out.println(FM.visitedString());

        System.out.println(FM.getVisited(0, 1));    //true
        System.out.println(FM.getVisited(0, 0));    //false

        System.out.println(FM.getPath(0, 0));       //false
        System.out.println(FM.getPath(1, 4));       //true

        FM.setVisited(-1, 0);                         // off the path
        FM.setVisited(0, 5);                        // off the path
    }
}