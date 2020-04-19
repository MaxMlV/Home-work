package oopIntro.network;

public class Network {
    private String[] phoneNumbers;

    public Network(String[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void addNumber(String number) {
        for (int i = 0; i < phoneNumbers.length; i++) {
            if (phoneNumbers[i] == null) {
                phoneNumbers[i] = number;
                break;
            }
        }
    }

    public void clearArray() {
        for (int i = 0; i < phoneNumbers.length; i++) {
            if (phoneNumbers[i] == null) {
                phoneNumbers[i] = "";
            }
        }
    }

    public String call(String searchNumber) {
        for (int i = 0; i < phoneNumbers.length; i++) {
            if (phoneNumbers[i].equals(searchNumber)) {
                return "Calling to " + searchNumber + ".";
            }
        }
        return "Incorrect number.";
    }
}
