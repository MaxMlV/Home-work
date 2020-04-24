package interfaceLecture;

public class Dog implements Bite {
    private String name;

    public Dog(String name) {
        super();
        this.name = name;
    }

    public Dog() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean isTasty() {
        return false;
    }

    public void bite(Bite some) {
        if (some == this) {
            System.out.println("I've bitten myself.");
            return;
        }
        System.out.println("I bite " + some + ", it was " + (some.isTasty()?"Good":"Bad"));
    }
}
