package arithmetic.stack;

import java.util.Stack;

/**
 */
public class BackAndGo {

    private Stack stack1 = new Stack();

    private Stack stack2 = new Stack();

    public String go(){
        if(stack2.isEmpty()){
            return null;
        }
        String page = (String) stack2.pop();
        stack1.push(page);
        System.out.println("�ƶ�Ԫ��:"+page);
        return  page;
    }

    public String back(){

        if(stack1.isEmpty()){
            return null;
        }
        String page = (String) stack1.pop();
        stack2.push(page);
        System.out.println("��ǰҳ����:"+page);
        return page;

    }

    public void open(String page){
        stack1.push(page);
    }

    public static void main(String[] args) {
        BackAndGo backAndGo = new BackAndGo();

        backAndGo.open("A");
        backAndGo.open("B");
        backAndGo.open("C");
        backAndGo.open("D");
        //sort a b c d
        // sort a b c  ����d
        backAndGo.back();
        // sort a b
        backAndGo.back();

        backAndGo.go();


    }
}
