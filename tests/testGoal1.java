package tests;
import classes.finderMap;

public class testGoal1 {
    public static void main(String[] args) {

        String testMap = "XXXXX\nXXXXX\nXXXXX";
        finderMap FM = new finderMap(testMap);
        System.out.print(FM);
    }
}