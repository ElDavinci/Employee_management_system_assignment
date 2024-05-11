/**
 * Represents a designer in the company.
 */
public class Designer extends Employee {
    private String position = "Designer";

    /**
     * Creates a new {@code Designer} object.
     * @param name the name of the designer
     * @param id the id of the designer
     * @param salary the salary of the designer
     */
    Designer(String name, int id, double salary){
        super(name,id,salary);
    }

    /**
     * Calculates the bonus for this designer based on their salary.
     * The bonus is 10% of the designer's salary.
     *
     * @return the bonus for this designer
     */
    @Override
    public double calculateBonus() {
        return this.getSalary() * 0.1;
    }

    /**
     * Gets the position of this designer (always "Designer").
     *
     * @return the position of this designer
     */
    public String getPosition() {
        return position;
    }
}

