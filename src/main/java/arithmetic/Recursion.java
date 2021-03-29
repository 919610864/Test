package arithmetic;

import java.io.File;

/**
 * using recursion,print the directory stru
 * 1.first order convenient
 * 2.last order convenient
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
}
