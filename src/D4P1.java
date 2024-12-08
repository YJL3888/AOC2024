import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;

public class D4P1 {

//    private static List<List<Character>> grid = new ArrayList<>();
    public static void main(String[] args){
        long ans = 0;
        try {
            String path = "C:\\Files\\Code\\AOC2024\\src\\input\\d4p1.txt";

            List<List<Character>> grid = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();

            while(line != null){
                List<Character> row = new ArrayList<>();
                for(char c: line.toCharArray()){
                    if(c == 'X' || c == 'M' || c == 'A' || c == 'S') {
                        row.add(c);
                    }else{
                        row.add('.');
                    }
                }
                grid.add(row);
                line = br.readLine();
            }

            for (List<Character> row : grid) {
                for (char c : row) {
                    System.out.print(c + " ");
                }
                System.out.println();
            }

            System.out.println(findXMAS(grid));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int findXMAS(List<List<Character>> grid){
        int count = 0;
        int row = grid.size();
        int col = grid.get(0).size();

        String xmas = "XMAS";

        int[][] dirs = {
                {0, 1},   // right
                {1, 0},   // down
                {1, 1},   // diagonal down-right
                {1, -1},  // diagonal down-left
                {0, -1},  // left
                {-1, 0},  // up
                {-1, -1}, // diagonal up-left
                {-1, 1}   // diagonal up-right
        };

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // For each direction
                for (int[] dir : dirs) {
                    boolean match = true;

                    for (int k = 0; k < 4; k++) {
                        int r = i + k * dir[0];
                        int c = j + k * dir[1];

                        if (r < 0 || r >= row || c < 0 || c >= col || grid.get(r).get(c) != xmas.charAt(k)) {
                            match = false;
                            break;
                        }
                    }

                    if (match) count++;
                }
            }
        }
        return count;
    }

}