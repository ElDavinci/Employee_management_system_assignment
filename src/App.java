import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
public class App extends EmployeeManagementSystem {
    public static Scanner sc;
    public static PrintWriter pw;
    /**
     * The main method that reads the input file, processes the commands and
     * writes the output to the output file
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // The input file
        File inputFile = new File("input.txt");
        // The output file
        File outputFile = new File("output.txt");
        
        try {
            // Create a scanner that reads from the input file
            sc = new Scanner(inputFile);
            // Create a print writer that writes to the output file
            pw = new PrintWriter(outputFile);
        } catch (Exception e) {
            // Print the error message
            System.out.println(e.getMessage());
        }
        
        // While there are more lines in the input file
        while(sc.hasNext()){
            // Read the next line
            String line = sc.nextLine();
            // Split the line into tokens
            String[] list = lineToList(line);
            // Get the command
            String command = list[0];
            
            // If the command is Add_Manager
            if(command.equals("Add_Manager")){
                // Add a manager
                addManager(list);
            }
            // If the command is Add_Developer
            else if(command.equals("Add_Developer")){
                // Add a developer
                addDeveloper(list);
            }
            // If the command is Add_Designer
            else if(command.equals("Add_Designer")){
                // Add a designer
                addDesigner(list);
            }
            // If the command is Give_Leave
            else if(command.equals("Give_Leave")){
                // Give leave to an employee
                giveLeave(list);
            }
            // If the command is Change_State
            else if(command.equals("Change_State")){
                // Change the state of an employee
                changeState(list);
            }
            // If the command is del_Employee
            else if(command.equals("del_Employee")){
                // Delete an employee
                deleteEmployee(list);
            }
            // If the command is printAllEmployees
            else if(command.equals("printAllEmployees")){
                // Print all the employees
                pw.println(printAllEmployees());
            }
            // If the command is print_Leave_Records
            else if(command.equals("print_Leave_Records")){
                // Print the leave records of an employee
                printLeaveRecords(list);
            }
            // If the command is not found
            else{
                // Print a message to the console
                System.out.println(String.format("Skipping command %s because it's not found", command));
            }
        }
        
        // Close the scanner
        sc.close();
        // Flush and close the print writer
        pw.flush();
        pw.close();
    }

        
    
    /**
     * Add a manager to the company
     * @param line - a String array that contains the manager's information
     *        in the format of [command, name, id, salary]
     */
    public static void addManager(String[] line){
        String name = line[1]; // The name of the manager
        int id = Integer.parseInt(line[2]); // The id of the manager
        double salary = Double.parseDouble(line[3]); // The salary of the manager
        Employee employee = new Manager(name, id, salary); // Create a Manager object
        pw.println(addEmployee(employee)); // Add the manager to the company and print the message
    }
    /**
     * Add a developer to the company
     * @param line - a String array that contains the developer's information
     *        in the format of [command, name, id, salary]
     */
    public static void addDeveloper(String[] line){
        String name = line[1]; // The name of the developer
        int id = Integer.parseInt(line[2]); // The id of the developer
        double salary = Double.parseDouble(line[3]); // The salary of the developer
        Employee employee = new Developer(name, id, salary); // Create a Developer object
        pw.println(addEmployee(employee)); // Add the developer to the company and print the message
    }
    /**
     * Add a designer to the company
     * @param line - a String array that contains the designer's information
     *        in the format of [command, name, id, salary]
     */
    public static void addDesigner(String[] line){
        String name = line[1]; // The name of the designer
        int id = Integer.parseInt(line[2]); // The id of the designer
        double salary = Double.parseDouble(line[3]); // The salary of the designer
        Employee employee = new Designer(name, id, salary); // Create a Designer object
        pw.println(addEmployee(employee)); // Add the designer to the company and print the message
    }

    /**
     * Give leave to an employee
     * @param line - a String array that contains the information
     *        in the format of [command, managerID, employeeID, starDate, daysOfLeave]
     */
    public static void giveLeave(String[] line){
        int managerID = Integer.parseInt(line[1]);
        int employeeID = Integer.parseInt(line[2]);

        int year = Integer.valueOf(line[3].split("-")[0]);
        int month = Integer.valueOf(line[3].split("-")[1]);
        int day = Integer.valueOf(line[3].split("-")[2]);
        LocalDate starDate = LocalDate.of(year,month,day);

        int daysOfLeave = Integer.valueOf(line[4]);
        pw.println(approveLeaveMain(managerID, employeeID, starDate, daysOfLeave));
    }
    /**
     * Change the state of an employee from OnLeave to Working.
     * @param line - a String array that contains the information
     *        in the format of [command, managerID, employeeID]
     */
    public static void changeState(String[] line){
        int managerID = Integer.parseInt(line[1]);
        int employeeID = Integer.parseInt(line[2]);
        pw.println(markEmployeeAsWorking(managerID, employeeID));
    }
    /**
     * Delete an employee from the company
     * @param line - a String array that contains the employee's ID
     *        in the format of [command, employeeID]
     */
    public static void deleteEmployee(String[] line){
        int employeeID = Integer.parseInt(line[1]);
        pw.println(removeEmployee(employeeID)); // Remove the employee from the company and print the message
    }
    /**
     * Print the leave records of an employee
     * @param line - a String array that contains the employee's ID
     *        in the format of [command, employeeID]
     */
    public static void printLeaveRecords(String[] line){
        int employeeID = Integer.parseInt(line[1]);

        // Print the leave records of the employee with the given ID
        pw.println(printEmployeeLeaveRecords(employeeID));
    }

    /**
     * Convert a line of text to a String array by splitting the line
     * on commas and stripping any leading or trailing whitespace from
     * each element.
     * @param line - a String representing a line of text
     * @return a String array with the tokens from the line
     */
    public static String[] lineToList(String line){
        String[] dirtyList = line.split(","); // Split the line on commas
        String[] clearnList = new String[dirtyList.length]; // Create a new array
        for (int i = 0; i < dirtyList.length; i++) { // Loop through the array
            clearnList[i] = dirtyList[i].strip(); // Strip any whitespace
        }
        
        return clearnList.clone(); // Return a copy of the array
    }

}
