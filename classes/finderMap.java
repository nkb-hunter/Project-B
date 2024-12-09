package classes;

import java.util.List;
import java.util.ArrayList;

public class finderMap{
    String[][] map;
    int[][] visited;
    int[][] costs;
    final int COLS;
    final int ROWS;
    List<CompleteRoute> allRoutes;

    public finderMap(String map){
        // int rows = 1; //Test Goal 2
        // int cols = 0;

        // //figure out dimensions
        // for(int i = 0; i < map.length(); i++){
        //     if(map.charAt(i) == '\n'){
        //         rows++;
        //         if(cols == 0){ // the first time we hit a new line
        //             cols = i;
        //         }
        //     }
        // }
        //ROWS = rows;
        //COLS = cols;
        String[] rows = map.split("\n");
        ROWS = rows.length;
        COLS = rows[0].length();
        this.map = new String[ROWS][COLS];
        visited = new int[ROWS][COLS];
        costs = new int [ROWS][COLS];
        allRoutes = new ArrayList<>();

        for(int row = 0; row<ROWS; row++){
            for (int col = 0; col < COLS; col++){
            char current = rows[row].charAt(col); 
            // if (current == '\n'){ //Used in test goal 2, i out of bounds in tg3//
            //     row++; // go to next row
            //     col = 0; // reset col
            // }
            if (current == '#') {
                this.map[row][col] = "#"; //Starting
                costs[row][col] = 0;
            } else if (current == '!') {
                this.map[row][col] = "!"; //Ending
                costs[row][col] = 0;
            } else if (current == 'X' || current == 'x') {
                this.map[row][col] = "X";
                costs[row][col] = -1; 
            } else {
                this.map[row][col] = "p";
                costs[row][col] = Integer.parseInt(String.valueOf(current), 16); //Hexadecimal
            }
            visited[row][col] = 0; 
            }
        }
    }
    

    public boolean getPath(int x, int y){
        return map[x][y].equals("p") || map[x][y].equals("!") || map[x][y].equals("#");
    }

    public int getVisited(int x, int y){
        return visited[x][y];
    }

    public int getCost(int x, int y) {
        return costs[x][y];
    }
    

    // public boolean[][] getVisited(){
    //     return visited;
    // }

    public void setVisited(int x, int y, int step){
        if(x < 0 || x >= ROWS || y < 0 || y >= COLS){
            System.out.println("Off the path!");
        }
        else if (getPath(x, y) == false){
            System.out.println("Cannot visit that square.");
        }
        else{
            visited[x][y] = step;
        }
    }

    public String visitedString(){
        String result = "";
        for(int row = 0; row < ROWS; row++){
            for(int col = 0; col < COLS; col++){
                result += visited[row][col];
                if(col == COLS - 1){
                    result+= '\n';
                }
            }
        }
        return result;
    }

    public String toString(){
        String result = "";
        for(int row = 0; row < ROWS; row++){
            for(int col = 0; col < COLS; col++){
                result += map[row][col];
                if(col == COLS - 1){
                    result+= '\n';
                }
            }
        }
        return result;
    }
    public int getRows() {
        return ROWS;
    }
    
    public int getCols() {
        return COLS;
    }
    
    public String[][] getMap() {
        return map;
    }
    public boolean solveMaze(int x, int y, int step, int[] totalCost) {
        // Base cases
        if (x < 0 || x >= ROWS || y < 0 || y >= COLS|| map[x][y].equals("X")||visited[x][y] != 0){
        return false;
        } // Out of bounds
        if (!getPath(x, y)){
        return false;
        } // Not a valid path 
        // if (getVisited(x, y)){
        //     return false;
        // } //already visited--> dont need for tg3
        if (map[x][y].equals("!")) {
            visited[x][y] = step;
            return true; // Reached end
        }

        visited[x][y] = step;
        totalCost[0] += costs[x][y];

        if (solveMaze(x - 1, y, step +1, totalCost) ||solveMaze(x + 1, y, step +1, totalCost) || 
            solveMaze(x, y - 1, step +1, totalCost) || solveMaze(x, y + 1, step +1, totalCost) ) {
        return true;
        }

        visited[x][y] = 0;
        totalCost[0] -= costs[x][y];
        return false;
        }
        public void findAllRoutes(int x, int y, CompleteRoute currentRoute) {
            // Base cases
            if (x < 0 || x >= ROWS || y < 0 || y >= COLS || map[x][y].equals("X") || visited[x][y] != 0) {
                return; // Out of bounds or already visited
            }
    
            // If we reach the end
            if (map[x][y].equals("!")) {
                currentRoute.addStep(x, y, costs[x][y]);
                allRoutes.add(new CompleteRoute(currentRoute));
                currentRoute.removeStep(costs[x][y]);
                return;
            }
    
            // Mark the current cell as visited with the step number
            visited[x][y] = currentRoute.getSteps().size() + 1;
            currentRoute.addStep(x, y, costs[x][y]);
    
            // Explore all directions
            findAllRoutes(x - 1, y, currentRoute); 
            findAllRoutes(x + 1, y, currentRoute); 
            findAllRoutes(x, y - 1, currentRoute); 
            findAllRoutes(x, y + 1, currentRoute); 
    
            // Backtrack
            visited[x][y] = 0;
            currentRoute.removeStep(costs[x][y]);
        }
    
        public CompleteRoute getLowestCostRoute() {
            return allRoutes.stream().min((r1, r2) -> Integer.compare(r1.getTotalCost(), r2.getTotalCost())).orElse(null);
        }
    }