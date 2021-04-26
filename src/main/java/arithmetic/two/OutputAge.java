package arithmetic.two;

import java.io.*;
import java.util.Random;

/**
 * 输出全国人民年龄 age.txt
 */
public class OutputAge {

        public static void main(String[] args) throws Exception {
            long startTime = System.currentTimeMillis();
            final String fileName = "d:\\age1.txt";
            final Random random = new Random();
            BufferedWriter objWriter = null;
            objWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
            for (int i = 0; i < 1400000000; i++) {
                int age = Math.abs(random.nextInt()) % 180;
                objWriter.write(age + "\r\n");
            }
            objWriter.flush();
            objWriter.close();
            long endTime = (System.currentTimeMillis() - startTime)/1000;
            System.out.println(endTime);

    }
}
