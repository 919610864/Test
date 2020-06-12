package thread.balk;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Data {

    //保存文件名称
    private final String fileName;

    //数据内容
    private String content;

    //数据改变后未保存,则为true
    private boolean changed;

    public Data(String fileName,String content){
        this.fileName = fileName;
        this.content = content;
        this.changed = true;
    }

    public synchronized void change(String newContent){
        content = newContent;
        changed = true;
    }

    public synchronized void save() throws IOException {
        if(!changed){
            return;
        }
        doSave();
        changed = false;
    }

    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + "calls doSave, content = " + content);
        Writer writer = new FileWriter(fileName);
        writer.write(content);
        writer.close();
    }
}
