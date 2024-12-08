import java.io.*;
import java.util.*;

public class D2P1 {
    public static void main(String[] args) {
        long ans = 0;
        try {

            String path = "C:\\Files\\Code\\AOC2024\\src\\input\\d2p1.txt";
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while (line != null) {
                List<Integer> lvl = new ArrayList<>();
                String[] parts = line.split(" ");
                for (String part : parts) {
                    lvl.add(Integer.parseInt(part));
                }

                boolean isStrictlyIncreasing = true;
                boolean isStrictlyDecreasing = true;
                    // 1 2 7
                for (int i = 1; i < lvl.size(); i++) {
                    int prev = lvl.get(i - 1);
                    int curr = lvl.get(i);


                    if (Math.abs(curr - prev) > 3) {
                        isStrictlyIncreasing = false;
                        isStrictlyDecreasing = false;
                        break;
                    }

                    if (curr <= prev) {
                        isStrictlyIncreasing = false;
                    }

                    if (curr >= prev) {
                        isStrictlyDecreasing = false;
                    }
                }

                if (isStrictlyIncreasing || isStrictlyDecreasing) {
                    ans++;
                }

                line = br.readLine();
            }

            System.out.println(ans);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
