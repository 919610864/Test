package arithmetic;

import org.junit.Test;

import java.io.File;

/**
 * using recursion,print the directory stru
 * 1.first order convenient
 * 2.last order convenient
 *
 * description of Recursion
 * four basic rules
 * 1.基准情形
 * 2.不断推进
 * 3.设计法则
 * 4.合成效益法则
 */
public class Recursion {

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        recursion.getFileListName("D:");
    }

    private void getFileListName(String path) {
        File file = new File(path);
        File [] files = file.listFiles();
        if(files!=null){
            for (int i= 0;i<files.length;i++){
                //System.out.println(files[i].getName());
                if(file.isDirectory()){
                    getFileListName(files[i].getAbsolutePath());
                    System.out.println(files[i].getAbsolutePath()+files[i].getName());

                }
            }

        }

    }

    /**
     * 打印输出的正整数
     */
    @Test
    public void test1(){

        printOut(76234);

    }

    private void printOut(int i) {

        if(i >= 10){
            printOut(i/10);
        }
        printDigit(i%10);
    }

    private void printDigit(int i) {
        System.out.print(i);
    }


}
