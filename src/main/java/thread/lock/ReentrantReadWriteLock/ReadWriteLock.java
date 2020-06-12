package thread.lock.ReentrantReadWriteLock;

public class ReadWriteLock {

    /**
     * 实际正在读取的线程个数
     */
    private int readingReaders = 0;

    /**
     * 实际写入中的线程个数 写入线程个数 0或者1
     */
    private int writingWriters = 0;

    /**
     *  等待写入线程中的个数
     */
    private int waitingWriters = 0;

    /**
     * 标识 true:表示写入优先
     */
    private boolean preferWriter;


    public synchronized void  readLock() throws InterruptedException {
        while (waitingWriters > 0 || (preferWriter && writingWriters > 0)){
            wait();
        }
        //实际正在读取的线程加1
        readingReaders ++;
    }

    public synchronized void readUnlock(){
        readingReaders --;
        preferWriter = true;
        notifyAll();

    }

    public synchronized void writeLock() throws InterruptedException {
        waitingWriters ++;
        try{
            while (readingReaders > 0 || writingWriters > 0) {
                wait();
            }
        }finally {
            waitingWriters --;
        }
        writingWriters ++;
    }


    public synchronized void writeUnlock(){
        writingWriters --;
        preferWriter = false;
        notifyAll();
    }


    public int getReadingReaders() {
        return readingReaders;
    }

    public void setReadingReaders(int readingReaders) {
        this.readingReaders = readingReaders;
    }

    public int getWritingWriters() {
        return writingWriters;
    }

    public void setWritingWriters(int writingWriters) {
        this.writingWriters = writingWriters;
    }

    public int getWaitingWriters() {
        return waitingWriters;
    }

    public void setWaitingWriters(int waitingWriters) {
        this.waitingWriters = waitingWriters;
    }

    public boolean isPreferWriter() {
        return preferWriter;
    }

    public void setPreferWriter(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }
}
