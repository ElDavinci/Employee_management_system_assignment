

# Employee Management System

The Employee Management System is a sophisticated Java-based application that demonstrates the use of advanced object-oriented programming (OOP) principles. This includes inheritance, polymorphism, dynamic binding, and the strategic use of interfaces and abstract classes. Designed to mirror the complexity of a real-world organizational framework, it adeptly manages employee records, showcasing Java’s capability to construct robust and scalable applications.

## Key Features

### Abstract Employee Class
At its core, the system is built around an abstract `Employee` class. This class encapsulates common attributes and methods that all employees share—such as name, ID, and base salary—acting as a foundational blueprint for the generation of more specialized employee types.

### Inheritance and Subclasses
Stemming from the abstract `Employee` class, the system branches out into specific employee subclasses including `Manager`, `Developer`, and `Designer`. These subclasses inherit the `Employee` class’s attributes and methods, while also introducing distinct characteristics or behaviors unique to each employee type, illustrating the principle of inheritance.

### Polymorphism in Action
Utilizing polymorphic methods—for example, those used in calculating bonuses or determining vacation days—the system showcases polymorphism and dynamic binding. These methods, defined within the `Employee` class, are overridden in its subclasses to facilitate role-specific calculations.

### ArrayList for Employee Roster
For efficient employee roster management, the system employs the `ArrayList` class. This approach allows for dynamic roster modifications—such as additions, removals, and iterations over employees—highlighting the effective use of Java collections.

### Interface for Special Permissions
The system introduces an interface named `Approver` to outline special permissions for employees capable of approving leave requests. Implemented by selecting subclasses like `Manager`, this interface marks employees with decision-making authority, emphasizing the role of interfaces in mandating specific behaviors.

### Utilization of `instanceof` Operator
To identify the specific type of an employee object at runtime, the system leverages the `instanceof` operator. This facilitates type-specific operations, such as casting an employee to an `Approver` to execute approval methods, thereby demonstrating the practical use of type checking and explicit casting in Java.


## how to and use
an input.txt is already made and the output for it too, if you wanted to add commands just copy how its done and run it in an IDE :)

## background
this is the second asssingment of the course CPCS203 