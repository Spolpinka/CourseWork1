import java.util.concurrent.atomic.AtomicInteger;

public class Employee {
    private String fullname;
    private int department;
    private double salary;
    private static int counter;
    private int id;

    Employee(String fullname, int department, double salary) {
        this.fullname = fullname;
        this.department = department;
        this.salary = salary;
        this.id = counter++;
    }

    //getters
    String getFullname() {
        return fullname;
    }

    int getDepartment() {
        return department;
    }

    double getSalary() {
        return salary;
    }

    int getId() {
        return id;
    }

    //setters
    void setSalary(double salary) {
        if (salary < 100000) {
            throw new IllegalArgumentException("Зарплата не может быть меньше 100000!");
        }
        this.salary = salary;
    }

    void setDepartment(int department) {
        if (department < 0 || department > 5) {
            throw new IllegalArgumentException("Номер отдела должен быть от 1 до 5");
        }
        this.department = department;
    }

    int counterGrow(int counter){
        return counter++;
    }
}
