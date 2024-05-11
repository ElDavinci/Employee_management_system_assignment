import java.time.LocalDate;

/**
 * An approver is an employee who can approve leave for other employees.
 */
public interface Approver {
    /**
     * Approves leave for an employee with the given start date and number of days of leave.
     * @param employee the employee who is taking leave
     * @param localDate the start date of the leave
     * @param daysOfLeave the number of days of leave
     */
    public void approveLeave(Employee employee, LocalDate localDate, int daysOfLeave);
    /**
     * Marks an employee as working by updating their status in the system.
     * @param employee the employee to be marked as working
     */
    public void markEmployeeAsWorking(Employee employee);

}