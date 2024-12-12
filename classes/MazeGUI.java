package classes;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MazeGUI extends Application{

    private static final int ROWS = 4;
    private static final int COLS = 5;
    private String[][] map = {
        {"!", "2", "1", "X", "X"},
        {"3", "X", "8", "8", "8"},
        {"2", "1", "8", "X", "X"},
        {"#", "X", "X", "X", "X"}
    };
    
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        // Create a label for each cell in the map
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                Label label = new Label(map[row][col]);
                label.setStyle("-fx-border-color: black;");
                grid.add(label, col, row);
                
                // Change label color based on cell content
                if (map[row][col].equals("X")) {
                    label.setStyle("-fx-background-color: red; -fx-border-color: black;");
                } else if (map[row][col].equals("#")) {
                    label.setStyle("-fx-background-color: green; -fx-border-color: black;");
                } else if (map[row][col].equals("!")) {
                    label.setStyle("-fx-background-color: green; -fx-border-color: black;");
                }
            }
        }
        
        // Create a scene and display the grid
        Scene scene = new Scene(grid, 300, 300);
        primaryStage.setTitle("Maze Solver");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
