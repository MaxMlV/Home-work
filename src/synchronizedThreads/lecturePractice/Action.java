package synchronizedThreads.lecturePractice;

public class Action {
    private boolean turn;

    public Action() {
        super();
    }

    public synchronized void getText(String text, boolean turn) {
        while (this.turn == turn) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(text + " ");
        this.turn = !this.turn;
        notifyAll();
    }
}
