import java.util.*;
import java.io.*;

public class D4P2 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Files\\Code\\AOC2024\\src\\input\\d4p1.txt";

        List<List<Character>> grid = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();

        while(line != null){
            List<Character> row = new ArrayList<>();
            for(char c: line.toCharArray()){
                if(c == 'M' || c == 'A' || c == 'S') {
                    row.add(c);
                }else{
                    row.add('.');
                }
            }
            grid.add(row);
            line = br.readLine();
        }

        System.out.println(findX_MAS(grid));

    }

    private static int findX_MAS(List<List<Character>> grid){
        int count = 0;
        int row = grid.size();
        int col = grid.get(0).size();

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid.get(i).get(j) == 'A'){
                    int match = 0;

                    if(i + 1 < row && j + 1 < col && i - 1 >= 0 && j - 1 >= 0 && grid.get(i + 1).get(j + 1) == 'S' && grid.get(i - 1).get(j - 1) == 'M'){
                        match++;
                    }
                    if(i + 1 < row && j + 1 < col && i - 1 >= 0 && j - 1 >= 0 && grid.get(i + 1).get(j - 1) == 'S' && grid.get(i - 1).get(j + 1) == 'M'){
                        match++;
                    }
                    if(i + 1 < row && j + 1 < col && i - 1 >= 0 && j - 1 >= 0 && grid.get(i + 1).get(j + 1) == 'M' && grid.get(i - 1).get(j - 1) == 'S'){
                        match++;
                    }
                    if(i + 1 < row && j + 1 < col && i - 1 >= 0 && j - 1 >= 0 && grid.get(i + 1).get(j - 1) == 'M' && grid.get(i - 1).get(j + 1) == 'S'){
                        match++;
                    }

                    if (match == 2){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
