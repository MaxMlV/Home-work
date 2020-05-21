package synchronizedThreads.lecturePractice;

public class Main {
    public static void main(String[] args) {
        Action action = new Action();

        Thread pull = new Thread(new PullPushThread("Pull", true, action));
        Thread push = new Thread(new PullPushThread("Push", false, action));

        pull.start();
        push.start();
    }
}
