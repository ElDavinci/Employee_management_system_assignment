import java.time.LocalDate;

/**
 * A Leave object represents a leave record for an employee.
 */
public class Leave {
    /**
     * The employee who is taking leave.
     */
    private Employee employee;
    /**
     * The start date of the leave.
     */
    private LocalDate starDate;
    /**
     * The number of days of leave.
     */
    private int daysOfLeave;

    /**
     * Constructs a Leave object with the given employee, start date, and number of days of leave.
     * @param employee the employee who is taking leave
     * @param starDate the start date of the leave
     * @param daysOfLeave the number of days of leave
     */
    public Leave(Employee employee, LocalDate starDate, int daysOfLeave){
        this.employee = employee;
        this.daysOfLeave = daysOfLeave;
        this.starDate = starDate;
    }
    /**
     * Gets the number of days of leave.
     * @return the number of days of leave
     */
    public int getDaysOfLeave() {
        return daysOfLeave;
    }
    /**
     * Gets the employee who is taking leave.
     * @return the employee who is taking leave
     */
    public Employee getEmployee() {
        return employee;
    }
    /**
     * Gets the start date of the leave.
     * @return the start date of the leave
     */
    public LocalDate getStarDate() {
        return starDate;
    }
    /**
     * Returns a formatted string containing the leave details.
     * @return a formatted string containing the leave details
     */
    public String displayLeaveDetails(){
        return String.format("%-13s%-13d", getStarDate(),getDaysOfLeave());
    }

}
