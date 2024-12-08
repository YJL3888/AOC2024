import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class D6P1 {
    public static void main(String[] args) {
        String path = "C:\\Files\\Code\\AOC2024\\src\\input\\d6p1.txt";

        ArrayList<ArrayList<Character>> board = new ArrayList<>();
        int currentX = 0;
        int currentY = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null) {
                ArrayList<Character> rowList = new ArrayList<>();
                for (int col = 0; col < line.length(); col++) {
                    char c = line.charAt(col);
                    rowList.add(c);
                    // Find guard's starting position and direction
                    if (c == '^') {
                        currentX = col;
                        currentY = row;
                    }
                }
                board.add(rowList);
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        int width = board.get(0).size();
        int height = board.size();

        // Directions: 0 = up, 1 = right, 2 = down, 3 = left
        int curDir = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        Set<String> visited = new HashSet<>();
        visited.add(currentX + "," + currentY);
        long visitedCount = 1;

        while (true) {
            int nextX = currentX + dx[curDir];
            int nextY = currentY + dy[curDir];

            if (nextX < 0 || nextX >= width || nextY < 0 || nextY >= height) {
                break;
            }

            if (board.get(nextY).get(nextX) == '#') {
                curDir = (curDir + 1) % 4; // turn right
            } else {
                currentX = nextX;
                currentY = nextY;

                if (visited.add(currentX + "," + currentY)) {
                    visitedCount++;
                }
            }
        }

        System.out.println("Number of distinct visited positions: " + visitedCount);
    }
}
