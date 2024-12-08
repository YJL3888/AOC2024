import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class D6P2 {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) {
        String path = "C:\\Files\\Code\\AOC2024\\src\\input\\d6p1.txt";

        List<List<Character>> board = new ArrayList<>();
        int startX = 0;
        int startY = 0;
        int startDir = 0;
        // Read the board
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null) {
                List<Character> rowList = new ArrayList<>();
                for (int col = 0; col < line.length(); col++) {
                    char c = line.charAt(col);
                    rowList.add(c);
                    if (c == '^' || c == '>' || c == 'v' || c == '<') {
                        startX = col;
                        startY = row;
                        startDir = directionFromChar(c);
                    }
                }
                board.add(rowList);
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        int height = board.size();
        int width = board.get(0).size();


        int countLoopPositions = 0;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (!(x == startX && y == startY) && board.get(y).get(x) != '#') {
                    char original = board.get(y).get(x);
                    board.get(y).set(x, '#');

                    boolean loopFound = simulate(board, startX, startY, startDir);
                    if (loopFound) {
                        countLoopPositions++;
                    }

                    board.get(y).set(x, original);
                }
            }
        }

        System.out.println("Number of positions that cause a loop: " + countLoopPositions);
    }


    private static boolean simulate(List<List<Character>> board, int startX, int startY, int startDir) {
        int x = startX;
        int y = startY;
        int dir = startDir;

        int height = board.size();
        int width = board.get(0).size();

        Set<String> visitedStates = new HashSet<>();
        visitedStates.add(stateToString(x, y, dir));

        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= width || ny < 0 || ny >= height) {
                return false;
            }

            if (board.get(ny).get(nx) == '#') {
                dir = (dir + 1) % 4;
            } else {
                x = nx;
                y = ny;
                String currentState = stateToString(x, y, dir);
                if (!visitedStates.add(currentState)) {
                    return true;
                }
            }
        }
    }

    private static String stateToString(int x, int y, int dir) {
        return x + "," + y + "," + dir;
    }

    private static int directionFromChar(char c) {
        // '^' = 0 (up), '>' = 1 (right), 'v' = 2 (down), '<' = 3 (left)
        switch (c) {
            case '^': return 0;
            case '>': return 1;
            case 'v': return 2;
            case '<': return 3;
        }
        throw new IllegalArgumentException("Invalid direction character: " + c);
    }
}
