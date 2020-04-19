package oopIntro.network;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] phoneArray = new String[10];
        Network network = new Network(phoneArray);
        Phone phoneOne = new Phone();
        phoneOne.setPhoneNumber("+38(066)017-44-11");
        phoneOne.setName("Max");
        phoneOne.sigUp(network);
        Phone phoneTwo = new Phone("Anton", "+38(050)324-56-32");
        phoneTwo.sigUp(network);
        network.clearArray();
        System.out.println(network.call("+38(050)324-56-32"));
    }
}
