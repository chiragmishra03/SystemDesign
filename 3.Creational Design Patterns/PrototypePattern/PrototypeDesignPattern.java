
interface Prototype {
    Prototype clone();
}

class Employee implements Prototype {
    private String name;
    private String employeeCode;

    Employee(String name, String employeeCode) {
        this.name = name;
        this.employeeCode = employeeCode;
    }

    @Override
    public Prototype clone() {
        return new Employee(this.name, this.employeeCode);
    }
}

public class PrototypeDesignPattern {

    public static void main(String[] args) {
        Employee originalEmployee = new Employee("Alice", "E001");

        Employee clonedEmployee = (Employee) originalEmployee.clone(); // Shallow copy clone

    }

}