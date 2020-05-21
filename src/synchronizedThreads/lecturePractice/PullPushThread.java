package synchronizedThreads.lecturePractice;

public class PullPushThread implements Runnable {
    private String text;
    private boolean turn;
    private Action action;

    public PullPushThread(String text, boolean turn, Action action) {
        this.text = text;
        this.turn = turn;
        this.action = action;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            action.getText(text, turn);
        }
    }
}
