package Management_Exc;

public class Developer extends Employee {
    private Manager projectManager;

    public Developer(String name, int age, double salary) {
        super(name, age, salary);
        projectManager = null;
    }

    public Manager getProjectManager() {
        return projectManager;
    }

    /**
     * TODO the implementation
     * @param projectManager to be added as project manager
     * @throws IllegalStateException when this developer already has a project manager
     */

    protected void setProjectManager(Manager projectManager) throws IllegalStateException {
        if (this.projectManager != null) {
            throw new IllegalStateException(getName() + " already has a manager: " + this.projectManager.getName());
        }
        this.projectManager = projectManager;
    }

    public void removePM() {
        projectManager = null; // Unassign the project manager
    }

    @Override
    public void birthday() {
        super.birthday(); // Call birthday method from Person
        if (projectManager != null) {
            // Give a raise of 5% of the current salary
            double raiseAmount = this.getSalary() * 0.05;
            projectManager.giveRaise(this, raiseAmount);
        }
    }

    @Override
    public void performTask() {
        System.out.println(getName() + " is coding"); // Specific task for Developer
    }

    @Override
    public String toString() {
        if (projectManager != null) {
            return super.toString() + " [" + projectManager.getName() + "]"; // Include PM name if exists
        }
        return super.toString(); // Default to superclass toString()
    }
}