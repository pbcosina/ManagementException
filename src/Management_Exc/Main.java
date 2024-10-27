package Management_Exc;

import java.util.List;
import java.util.NoSuchElementException;

public class Main {

    /**
     * Gives a raise to an employee from a manager.
     * @param persons the list of persons
     * @param managerName the name of the manager giving the raise
     * @param employeeName the name of the employee receiving the raise
     * @param salary the salary increase to be given
     * @throws ClassCastException when manager or employee is not a manager or employee
     * @throws IllegalArgumentException when salary is invalid
     * @throws NoSuchElementException when given manager or employee does not exist in the list of persons
     */

    public static void giveRaise(List<Person> persons, String managerName, String employeeName, double salary) {
        Manager manager = findPerson(persons, managerName, Manager.class);
        Employee employee = findPerson(persons, employeeName, Employee.class);

        if (salary < 0) {
            throw new IllegalArgumentException("Salary increase must be non-negative");
        }
        manager.giveRaise(employee, salary);
    }

    /**
     * Assigns a project manager to a developer.
     * @param persons the list of persons
     * @param developerName the name of the developer to be assigned
     * @param managerName the name of the manager assigned to the developer
     * @throws ClassCastException when manager or developer is not a manager or employee
     * @throws NoSuchElementException when given manager or developer does not exist in the list of persons
     * @throws IllegalStateException when developer already has a manager
     */

    public static void assignPM(List<Person> persons, String developerName, String managerName) {
        Developer developer = findPerson(persons, developerName, Developer.class);
        Manager manager = findPerson(persons, managerName, Manager.class);

        developer.setProjectManager(manager);
    }

    /**
     * Customer speaks to an employee.
     * @param persons the list of persons
     * @param customerName the customer to speak to the employee
     * @param employeeName the employee to be spoken to
     * @return the dialogue of the customer to the employee
     * @throws ClassCastException when given customer or employee is not what they are
     * @throws NoSuchElementException when given customer or employee is not in the list of persons
     */

    public static String customerSpeak(List<Person> persons, String customerName, String employeeName) {
        Customer customer = findPerson(persons, customerName, Customer.class);
        Employee employee = findPerson(persons, employeeName, Employee.class);

        return customer.speak(employee);
    }

    private static <T> T findPerson(List<Person> persons, String name, Class<T> type) {
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                if (!type.isInstance(person)) {
                    throw new ClassCastException(name + " is not a/n " + type.getSimpleName());
                }
                return type.cast(person);
            }
        }
        throw new NoSuchElementException(name + " does not exist");
    }
}