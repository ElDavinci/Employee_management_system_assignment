import java.util.ArrayList;

/**
 * This abstract class represents an employee in the company.
 * An employee has a name, id, salary, and leave records.
 * An employee is also in a certain state (working or on leave).
 * An employee also has a position (one of manager, designer, or developer).
 */
public abstract class Employee {
    private String name;
    private int id;
    private double salary;
    private ArrayList<Leave> leaveRecords = new ArrayList<>();
    private String state = "";

    /**
     * Creates an employee with the given name, id, and salary.
     * @param name the name of the employee
     * @param id the id of the employee
     * @param salary the salary of the employee
     */
    public Employee(String name, int id, double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    /**
     * Calculates the bonus for this employee based on their position and salary.
     * @return the bonus for this employee
     */
    public abstract double calculateBonus();

    /**
     * Gets the id of this employee.
     * @return the id of this employee
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name of this employee.
     * @return the name of this employee
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the salary of this employee.
     * @return the salary of this employee
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Gets the state of this employee (working or on leave).
     * @return the state of this employee
     */
    public String getState() {
        return state;
    }

    /**
     * Gets the leave records of this employee.
     * @return the leave records of this employee
     */
    public ArrayList<Leave> getLeaveRecords() {
        return leaveRecords;
    }

    /**
     * Sets the state of this employee to on leave.
     */
    public void setStateOnLeave() {
        this.state = "OnLeave";
    }

    /**
     * Sets the state of this employee to working.
     */
    public void setStateWorking() {
        this.state = "Working";
    }

    /**
     * Adds a leave record to this employee's leave records.
     * @param leaveRecord the leave record to be added
     */
    public void addLeaveRecord(Leave leaveRecord){
        this.getLeaveRecords().add(leaveRecord);
    }

    /**
     * Gets the position of this employee (one of manager, designer, or developer).
     * @return the position of this employee
     */
    abstract public String getPosition();

    @Override
    public String toString() {
        return String.format("%-14s%-6d%-11.2f%-6.2f\n");
    }

}

