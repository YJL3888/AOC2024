import java.util.*;
import java.io.*;

public class D1P2 {
    public static void main(String []args){
        long ans = 0;
        try{
            List<Integer> r1 = new ArrayList<>();
            HashMap<Integer, Integer> r2 = new HashMap<>();


            String path = "C:\\Files\\Code\\AOC2024\\src\\input\\d1p1.txt";

            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            while(line != null){
                String[] parts = line.split("   ");
                r1.add(Integer.parseInt(parts[0]));
                int key = Integer.parseInt(parts[1]);
                r2.put(key, r2.getOrDefault(key, 0) + 1);
                line = br.readLine();
            }

            for(int i = 0; i < r1.size(); i++){
                int num = r1.get(i);
                int mult = r2.getOrDefault(num, 0);
                ans += (long) num*mult;
            }

            System.out.println(ans);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
