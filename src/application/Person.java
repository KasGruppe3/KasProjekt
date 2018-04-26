package application;

/**
 * Base class of persons in the system
 *
 */
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNavn(String name) {
        this.name = name;
    }
}
