import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class D7P1 {
    public static void main(String[] args){
        long ans = 0;
        try{
            String path = "C:\\Files\\Code\\AOC2024\\src\\input\\d7p1.txt";

            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();


            while(line != null){
                List<Long> numList = new ArrayList<>();
                String[] parts = line.split(":");
                long res = Long.parseLong(parts[0]);
                String[] numbers = parts[1].trim().split(" ");
                for(String num : numbers){
                    numList.add(Long.parseLong(num));

                }

                System.out.println(numList);

                if(canForm(res, numList, 1 , numList.get(0))){
                    ans+= res;
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

    private static boolean canForm(Long res, List<Long> nums, int index, Long cur){
        if(index == nums.size()){
            return cur.equals(res);
        }
        return canForm(res, nums, index + 1, cur + nums.get(index)) || canForm(res, nums, index + 1, cur * nums.get(index));

    }
}
