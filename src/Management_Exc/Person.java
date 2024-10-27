package Management_Exc;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

abstract class Person {
    private final String name;
    private int age;

    /**
     * TODO the implementation
     * @param name the name of the person
     * @param age the age of the person
     * @throws IllegalArgumentException when age is negative
     */

    public Person(String name, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age must be non-negative");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void birthday() {
        System.out.println("Happy birthday, " + name + "!");
        age++;
    }

    public abstract void performTask();

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}