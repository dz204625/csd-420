package module2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class WriteData {
    public static void main(String[] args){
        try ( FileWriter myWriter = new FileWriter("src/module2/zhu_filedata.dat", true)) {
            Random random = new Random();
            int[] randomIntegers = new int[5];
            double [] randomDouble = new double[5];
            for (int i=0; i<5; i++) {
                randomIntegers[i]=random.nextInt();
                randomDouble[i]=random.nextDouble();
;            }
            myWriter.write("Integers: " + Arrays.stream(randomIntegers)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")) + "\n");

            myWriter.write("Doubles: " + Arrays.stream(randomDouble)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")) + "\n");

        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
