import java.io.*;
import java.util.*;

public class D2P2 {
    public static void main(String[] args) {
        long ans = 0;
        String path = "C:\\Files\\Code\\AOC2024\\src\\input\\d2p1.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                List<Integer> numbers = new ArrayList<>();
                String[] parts = line.split(" ");

                try {
                    for (String part : parts) {
                        numbers.add(Integer.parseInt(part));
                    }
                } catch (NumberFormatException e) {

                    System.err.println("Invalid number format in line: " + line);
                    continue;
                }

                if (numbers.size() < 2) {
                    continue;
                }

                if (isValidSequence(numbers)) {
                    ans++;
                    continue;
                }

                boolean isValidAfterRemoval = false;
                for (int i = 0; i < numbers.size(); i++) {
                    List<Integer> modifiedSequence = new ArrayList<>(numbers);
                    modifiedSequence.remove(i);

                    if (isValidSequence(modifiedSequence)) {
                        isValidAfterRemoval = true;
                        break;
                    }
                }

                if (isValidAfterRemoval) {
                    ans++;
                }
            }

            System.out.println("Number of valid rows: " + ans);
        } catch (FileNotFoundException e) {
            System.err.println("File not found at path: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidSequence(List<Integer> numbers) {
        if (numbers.size() < 2) {
            return true;
        }

        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 1; i < numbers.size(); i++) {
            int prev = numbers.get(i - 1);
            int curr = numbers.get(i);
            int difference = Math.abs(curr - prev);

            if (difference > 3) {
                return false;
            }

            // Check strictly increasing
            if (curr <= prev) {
                isIncreasing = false;
            }

            // Check strictly decreasing
            if (curr >= prev) {
                isDecreasing = false;
            }
        }

        return isIncreasing || isDecreasing;
    }
}
