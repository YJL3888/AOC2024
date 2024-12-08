import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class D3P1 {
    public static void main(String[] args){
        long ans = 0;
        try {
            String path = "C:\\Files\\Code\\AOC2024\\src\\input\\d3p1.txt";

            String input = Files.readString(Paths.get(path));

            String regex = "mul\\(\\d+,\\d+\\)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            List<String> matches = new ArrayList<>();
            while(matcher.find()){
                String match = matcher.group();
                matches.add(match.substring(4, match.length() - 1));
            }

            for(String match: matches){
                String[] parts = match.split(",");
                int a = Integer.parseInt(parts[0]);
                int b = Integer.parseInt(parts[1]);
                ans += (long) a*b;
            }

            System.out.println(ans);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
