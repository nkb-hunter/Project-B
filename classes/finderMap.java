package classes;
public class finderMap{
    String[][] map;

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
        this.map = new String[rows][cols];
        System.out.println("rows: " + rows + " cols: " + cols);

        int row = 0;
        int col = 0;
        for(int i = 0; i < map.length(); i++){
            if(map.charAt(i) == '\n'){
                row++; // go to next row
                col = 0; // reset col
            }
            else{
                this.map[row][col] = String.valueOf(map.charAt(i));
                col++;
            }
        }
    }

    public String toString(){
        String result = "";
        for(int row = 0; row < map.length; row++){
            for(int col = 0; col < map[0].length; col++){
                result += map[row][col];
                if(col == map[0].length - 1){
                    result+= '\n';
                }
            }
        }
        return result;
    }
}