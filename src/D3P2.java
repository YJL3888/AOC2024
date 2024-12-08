import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class D3P2 {
    public static void main(String[] args){
        long ans = 0;
        try {
            String path = "C:\\Files\\Code\\AOC2024\\src\\input\\d3p1.txt";

            String input = Files.readString(Paths.get(path));

            String regex = "mul\\(\\d+,\\d+\\)|do\\(\\)|don't\\(\\)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            List<String> matches = new ArrayList<>();
            Boolean good = true;
            while(matcher.find()){
                String match = matcher.group();
                if(match.equals("do()")){
                    good = true;
                } else if(match.equals("don't()")){
                    good = false;
                } else if(good) {
                    matches.add(match.substring(4, match.length() - 1));
                }
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
