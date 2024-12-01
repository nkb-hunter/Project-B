package classes;
public class finderMap{
    String[][] map;
    boolean[][] visited;
    final int COLS;
    final int ROWS;

    public finderMap(String map){
        int rows = 1;
        int cols = 0;

        // figure out dimensions
        for(int i = 0; i < map.length(); i++){
            if(map.charAt(i) == '\n'){
                rows++;
                if(cols == 0){ // the first time we hit a new line
                    cols = i;
                }
            }
        }
        ROWS = rows;
        COLS = cols;
        this.map = new String[ROWS][COLS];
        visited = new boolean[ROWS][COLS];

        int row = 0;
        int col = 0;
        for(int i = 0; i < map.length(); i++){
            if(map.charAt(i) == '\n'){
                row++; // go to next row
                col = 0; // reset col
            }
            else{
                this.map[row][col] = String.valueOf(map.charAt(i));
                visited[row][col] = false;
                col++;
            }
        }
    }

    public boolean getPath(int x, int y){
        return map[x][y].equals("p") || map[x][y].equals("!") || map[x][y].equals("#");
    }

    public boolean getVisited(int x, int y){
        return visited[x][y] == true;
    }

    public boolean[][] getVisited(){
        return visited;
    }

    public void setVisited(int x, int y){
        if(x < 0 || x >= ROWS || y < 0 || y >= COLS){
            System.out.println("Off the path!");
        }
        else if (getPath(x, y) == false){
            System.out.println("Cannot visit that square.");
        }
        else{
            visited[x][y] = true;
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
    public boolean solveMaze(int x, int y) {
        // Base cases
        if (x < 0 || x >= ROWS || y < 0 || y >= COLS){
        return false;
        } // Out of bounds
        if (!getPath(x, y)){
        return false;
        } // Not a valid path 
        if (getVisited(x, y)){
            return false;
        } //already visited
        if (map[x][y].equals("!")) {
            setVisited(x, y);
            return true; //Reached end
        }
        setVisited(x, y);
        if (solveMaze(x - 1, y) ||solveMaze(x + 1, y) || solveMaze(x, y - 1) || solveMaze(x, y + 1) ) {
        return true;
        }
        visited[x][y] = false;
        return false;
        }
    }