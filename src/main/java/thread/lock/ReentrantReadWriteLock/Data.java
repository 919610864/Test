package thread.lock.ReentrantReadWriteLock;

public class Data {
    private final char [] buffer;
    private final ReadWriteLock lock = new ReadWriteLock();

    public Data(int size){
        this.buffer = new char[size];
        for (int i = 0 ; i < buffer.length; i++){
            buffer[i] = '*';
        }
    }

    public char [] read() throws InterruptedException {
//        lock.readLock();
//        try {
//            return doRead();
//        }finally {
//            lock.readUnlock();
//        }
        return doRead();
    }

    public void write(char c) throws InterruptedException {
//        lock.writeLock();
//        try{
//            doWrite(c);
//        }finally {
//            lock.writeUnlock();
//        }
        doWrite(c);
    }

    private void doWrite(char c) {
        for (int i = 0;i<buffer.length;i++){
            buffer[i] = c;
            slowly();
        }
    }

    private void slowly() {
        try{
            Thread.sleep(50);
        }catch (Exception e){

        }
    }

    /**
     * copy and read
     * @return
     */
    private char[] doRead() {
        char [] newbuf = new char[buffer.length];
        for (int i = 0;i<buffer.length;i++){
            newbuf[i] = buffer[i];
        }
        return newbuf;
    }

}
