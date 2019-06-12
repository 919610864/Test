package arithmetic;

import java.io.File;

/**
 * 递归 先序遍历
 */
public class MainTest {

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        String dirname = "E:\\";
        menu(dirname, 0);
        System.out.println(System.currentTimeMillis()-begin);
    }
    public static void menu(String dirname, int padding){
        File file = new File(dirname);
        if(file.isDirectory()){
            System.out.println(padding_n(padding)+"目录: " + dirname);
            String s[] = file.list();
            for (int i=0; i<s.length; i++){
                File f = new File(dirname + "/" + s[i]);
                if(f.isDirectory()){
                    menu(dirname+"\\"+s[i], padding+4);
                }else{
                    System.out.println(padding_n(padding+4)+"文件："+s[i]);
                }
            }
        }
    }
    public static void menu2(String dirname, int padding){
        File file = new File(dirname);
        if(file.isDirectory()){
            System.out.println(padding_n(padding)+"目录: " + dirname);
            File [] files = file.listFiles();
            for (int i=0; i<files.length; i++){
                if(files[i].isDirectory()){
                    menu(dirname+"\\"+files[i].getName(), padding+4);
                }else{
                    System.out.println(padding_n(padding+4)+"文件："+files[i].getName());
                }
            }
        }

    }
    public static String padding_n(int n){
        StringBuffer space = new StringBuffer("");
        for (int i=0; i<n; i++){
            space.append(" ");
        }
        return space.toString();
    }
}
