import java.time.LocalDate;

/**
 * A manager is an employee who can approve leave for other employees.
 */
public class Manager extends Employee implements Approver {
    private String position = "Manager";
    
    /**
     * Creates a new manager with the given name, ID, and salary.
     * 
     * @param name the name of the manager
     * @param id the ID of the manager
     * @param salary the salary of the manager
     */
    Manager(String name, int id, double salary) {
        super(name, id, salary);
    }

    /**
     * Calculates the bonus for this manager based on their salary.
     * 
     * @return the bonus for this manager
     */
    @Override
    public double calculateBonus() {
        return this.getSalary() * 0.15;
    }
    
    /**
     * Approves leave for an employee with the given start date and number of days of leave.
     * 
     * @param employee the employee who is taking leave
     * @param localDate the start date of the leave
     * @param daysOfLeave the number of days of leave
     */
    @Override
    public void approveLeave(Employee employee, LocalDate localDate, int daysOfLeave) {
        employee.addLeaveRecord(new Leave(employee, localDate, daysOfLeave));
        employee.setStateOnLeave();
        
    }
    
    /**
     * Marks an employee as working by updating their status in the system.
     * 
     * @param employee the employee to be marked as working
     */
    @Override
    public void markEmployeeAsWorking(Employee employee) {
        employee.setStateWorking();
        
    }
    
    /**
     * Gets the position of this employee (one of manager, designer, or developer).
     * 
     * @return the position of this employee
     */
    public String getPosition() {
        return position;
    }

}


