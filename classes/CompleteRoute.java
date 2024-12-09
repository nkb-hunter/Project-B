package classes;

import java.util.ArrayList;
import java.util.List;

public class CompleteRoute {
    private List<int[]> steps; //List of coordinates
    private int totalCost;

    public CompleteRoute() {
        this.steps = new ArrayList<>();
        this.totalCost = 0;
    }
    public CompleteRoute(CompleteRoute clone) {
        this.steps = new ArrayList<>(clone.steps);
        this.totalCost = clone.totalCost;
    } //copy constructor

    public void addStep(int x, int y, int cost) {
        steps.add(new int[] {x, y});
        totalCost += cost;
    }

    public void removeStep(int cost) {
        if (!steps.isEmpty()) {
            steps.remove(steps.size() - 1);
            totalCost -= cost;
        }
    }

    public int getTotalCost() {
        return totalCost;
    }

    public List<int[]> getSteps() {
        return steps;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("The route costs ").append(totalCost).append(".\nThe route is: \n");
        for (int[] step : steps) {
            sb.append("(").append(step[0]).append(", ").append(step[1]).append(") ");
        }
        return sb.toString();
    }
   
}
