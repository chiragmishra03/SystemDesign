public class Cloning {
}

class Address {
    String city;

    public Address(String add) {
        this.city = add;
    }
}

class EmployeeShallowCopy implements Cloneable {
    private String name;
    private String employeeCode;
    private Address add;

    EmployeeShallowCopy(String name, String employeeCode, Address add) {
        this.name = name;
        this.employeeCode = employeeCode;
        this.add = add;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class EmployeeDeepCopy implements Cloneable {
    private String name;
    private String employeeCode;
    private Address add;

    EmployeeDeepCopy(String name, String employeeCode, Address add) {
        this.name = name;
        this.employeeCode = employeeCode;
        this.add = add;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        EmployeeDeepCopy employeeCopy = (EmployeeDeepCopy) super.clone();
        employeeCopy.add = new Address(this.add.city);
        return employeeCopy;
    }
}
