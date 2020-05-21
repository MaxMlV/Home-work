package synchronizedThreads.port;

public class Main {
    public static void main(String[] args) {
        Port port = new Port();

        Thread shipOne = new Thread(new ShipThread("Ship #1", 10, port));
        Thread shipTwo = new Thread(new ShipThread("Ship #2", 10, port));
        Thread shipThree = new Thread(new ShipThread("Ship #3", 10, port));
        Thread shipFour = new Thread(new ShipThread("Ship #4", 10, port));

        shipOne.start();
        shipTwo.start();
        shipThree.start();
        shipFour.start();
    }
}
