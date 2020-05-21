package synchronizedThreads.blockFileCopy;

public class Action {
    private byte[] bytes = new byte[1];
    private boolean turn;
    private boolean stop;

    public Action() {
        super();
    }

    public synchronized byte[] getBytes() {
        while (!turn) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        byte[] temp = this.bytes;
        this.turn = false;
        notifyAll();
        return temp;
    }

    public synchronized void setBytes(byte[] bytes) {
        while (turn) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.bytes = bytes;
        this.turn = true;
        notifyAll();
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
