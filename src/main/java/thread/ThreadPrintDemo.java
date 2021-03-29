//package thread;
//
//public class ThreadPrintDemo {
//    static int num = 0;
//    static boolean flag = false;
//
//    public static void main(String[] args){
//
//        Thread t1 = new Thread(() -> {
//            for (; 100 > num; ) {
//                if (!flag && (num == 0 || ++num % 2 == 0)) {
//                    System.out.println("线程:"+Thread.currentThread().getName()+":"+num);
//                    flag = true;
//                }
//            }
//        }
//        );
//
//        Thread t2 = new Thread(() -> {
//            for (; 100 > num; ) {
//                if (flag && (++num % 2 != 0)) {
//                    System.out.println("线程:"+Thread.currentThread().getName()+":"+num);
//                    flag = false;
//                }
//            }
//        }
//        );
//
//        t1.start();
//        t2.start();
//    }
//}
