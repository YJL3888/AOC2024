import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.File;
import java.util.*;
import java.io.*;

public class D1P1 {
    public static void main(String[] args) {
        long ans = 0;
        try {

            List<Integer> r1 = new ArrayList<>();
            List<Integer> r2 = new ArrayList<>();

            String path = "C:\\Files\\Code\\AOC2024\\src\\input\\d1p1.txt";

            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();

            while(line != null){
                String[] parts = line.split("   ");
                r1.add(Integer.parseInt(parts[0]));
                r2.add(Integer.parseInt(parts[1]));
                line = br.readLine();
            }

            r1.sort(null);
            r2.sort(null);

            for(int i = 0; i < r1.size(); i++){
                ans += Math.abs(r1.get(i) - r2.get(i));
            }

            System.out.println(ans);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
