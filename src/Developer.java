/**
 * Represents a developer in the company.
 */
public class Developer extends Employee {
    private final String position = "Developer";

    /**
     * Creates a new developer with the given name, id, and salary.
     *
     * @param name the name of the developer
     * @param id   the id of the developer
     * @param salary the salary of the developer
     */
    Developer(String name, int id, double salary){
        super(name,id,salary);
    }

    /**
     * Calculates the bonus for this developer based on their salary.
     * The bonus is 12% of the developer's salary.
     *
     * @return the bonus for this developer
     */
    @Override
    public double calculateBonus() {
        return this.getSalary() * 0.12;
    }

    /**
     * Gets the position of this developer (always "Developer").
     *
     * @return the position of this developer
     */
    @Override
    public String getPosition() {
        return position;
    }

}
