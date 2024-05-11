import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeManagementSystem{
    private static ArrayList<Employee> employees = new ArrayList<>();
    
    public EmployeeManagementSystem(){}

    
    /**
     * Adds an employee to the list of employees and returns a formatted string indicating the position and name of the employee that was added.
     *
     * @param  employee  the employee object to be added
     * @return           a formatted string indicating the position and name of the employee that was added
     */
    public static String addEmployee(Employee employee){
        employees.add(employee);
        return String.format("%s %s added.", employee.getPosition(),employee.getName());
    }
    /**
     * Removes an employee from the system based on their ID.
     *
     * @param  employeeID    the ID of the employee to be removed
     * @return               a message indicating whether the employee was successfully removed or not
     */
    public static String removeEmployee(int employeeID){

        int employeeIndex = (idtoindexEmployee(employeeID));
        if((employeeIndex!=-1)){
            employees.remove(employeeIndex);
            return String.format("Employee removed sucessfully", employees.get(employeeID).getName());

        }
        else{
            return String.format("Employee with ID %d is not found", employeeID);
        }

    }

    /**
     * Prints all the employees in a formatted table.
     *
     * @return a string containing the formatted table of employees
     */
    public static String printAllEmployees(){
        String s = String.format("%-16s%-6s%-11s%-7s\n", "Name","ID","Salary","Bonus");
        for (int index = 0; index < employees.size(); index++) {
            Employee employee = employees.get(index);
            s+=String.format("%-16s%-6s%-11s%-7s", employee.getName(),employee.getId(),employee.getSalary(),employee.calculateBonus());
            String newLine = (index < (employees.size()-1)) ? "\n": "";
            s+= newLine;
        }
        return s;
    }
    /**
     * Approves leave for an employee with the given manager ID, employee ID, start date, and number of days of leave.
     *
     * @param  managerID    the ID of the manager who approves the leave
     * @param  employeeID   the ID of the employee who wants to take leave
     * @param  starDate     the start date of the leave
     * @param  daysOfLeave  the number of days of leave
     * @return              a message indicating whether the leave was approved or not, and the name of the employee if approved
     */
    public static String approveLeaveMain(int managerID, int employeeID, LocalDate starDate, int daysOfLeave){
        int managerIndex = (idtoindexEmployee(managerID));

        int employeeIndex = (idtoindexEmployee(employeeID));
        if((managerIndex != -1)&&(employeeIndex!=-1)){

            Employee employee = employees.get(employeeIndex);

            if((employees.get(managerIndex)) instanceof Approver){
                if(employee.getState().equals("OnLeave")){
                    return String.format("Cannot approve leave for %s as they are already on leave.", employee.getName());
                }
                Manager manager = (Manager)employees.get(managerIndex);
                manager.approveLeave(employee, starDate, daysOfLeave);  

                return  String.format("Leave approved for %s", employee.getName());
            }
            else{
                return "Leave approval failed. Either manager ID is incorrect or employee ID does not exist.";
            }

        }
        else{
            return "Leave approval failed. Either manager ID is incorrect or employee ID does not exist.";
        }

        
    }
    /**
     * Marks an employee as working by updating their status in the system.
     *
     * @param  managerID    the ID of the manager who marks the employee as working
     * @param  employeeID   the ID of the employee to be marked as working
     * @return              a message indicating the success or failure of marking the employee as working
     */
    public static String markEmployeeAsWorking(int managerID, int employeeID){
        int managerIndex = (idtoindexEmployee(managerID));

        int employeeIndex = (idtoindexEmployee(employeeID));
        if((managerIndex != -1)&&(employeeIndex!=-1)){
            Employee employee = employees.get(employeeIndex);
            if (employees.get(managerIndex) instanceof Manager){
                ((Manager)(employees.get(managerIndex))).markEmployeeAsWorking(employees.get(employeeIndex));
                return String.format("Employee %s is now marked as working",employee.getName() );
            }
            else{
                return "Something went wrong with Marking this Employee as working";
            }
        }
        else{
            //Remove the numbers
             return "Something went wrong with Marking this Employee as working";
        }
    }
    /**
     * Prints the leave records of an employee.
     *
     * @param  employeeID  the ID of the employee
     * @return             a formatted string containing the leave records of the employee
     */
    public static String printEmployeeLeaveRecords(int employeeID){
        if(idtoindexEmployee(employeeID)!= -1){
            Employee employee = employees.get(idtoindexEmployee(employeeID));
            ArrayList<Leave> leaveRecords =employee.getLeaveRecords();

            String s = String.format("Leave records for %s:\n%-13s%-13s\n", employee.getName(), "Start Date", "Days of Leave");
            for (int index = 0; index < leaveRecords.size(); index++) {
                s += (leaveRecords.get(index).displayLeaveDetails()+"\n");
                
            }
            return s;
        }
        else{
            return "No Leave Record found for this person";
        }   
    }
    /**
     * Returns the index of the employee with the given ID in the list of employees.
     *
     * @param  ID  the ID of the employee
     * @return     the index of the employee in the list, or -1 if the employee is not found
     */
    public static int idtoindexEmployee(int ID){
        for (int index = 0; index < employees.size(); index++) {
            Employee employee = employees.get(index);
            if(employee.getId() == ID){
                return index;
                
            }

        }
        return -1;
    }
}
