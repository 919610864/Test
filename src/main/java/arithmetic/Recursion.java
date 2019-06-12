package arithmetic;

import java.io.File;

/**
 * 使用递归，打印目录结构
 * 1.先序遍历
 * 2.后序遍历
 */
public class Recursion {

    public static void main(String[] args) {
        getFileListName("D:\\360安全浏览器下载");
    }

    private static void getFileListName(String path) {
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
