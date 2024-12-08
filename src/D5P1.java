import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class D5P1 {
    public static void main(String[] args){
        long ans = 0;
        try {
            String path = "C:\\Files\\Code\\AOC2024\\src\\input\\d5p1.txt";

            HashMap<Integer, List<Integer>> rules = new HashMap<>();

            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();

            while (!line.equals("XX")) { //I changed input file to have XX
                String[] parts = line.split("\\|");
                int before = Integer.parseInt(parts[0]);
                int after = Integer.parseInt(parts[1]);

                if (!rules.containsKey(before)) {
                    rules.put(before, new ArrayList<>());
                }
                rules.get(before).add(after);

                line = br.readLine();
            }

            line = br.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                List<Integer> pages = new ArrayList<>();
                for (String part : parts) {
                    pages.add(Integer.parseInt(part));
                }

                boolean valid = true;

                for (int i = 0; i < pages.size(); i++) {
                    for (int j = i + 1; j < pages.size(); j++) {
                        int before = pages.get(i);
                        int after = pages.get(j);

                        if (rules.containsKey(before) && rules.get(before).contains(after)) {
                        } else if (rules.containsKey(after) && rules.get(after).contains(before)) {
                            valid = false;
                            break;
                        }
                    }
                    if (!valid) break;
                }

                if (valid) {
                    int size = pages.size();
                    int mid = (size - 1) / 2;
                    ans += pages.get(mid);
                }

                line = br.readLine();
            }

            System.out.println(ans);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
