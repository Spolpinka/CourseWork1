import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeBook {
    static private Employee[] employees = new Employee[10];

    //getters
    Employee[] getEmployees() {
        return employees;
    }

    Employee getOneEmployee(int indexInBook) {
        return employees[indexInBook];
    }

    double getSumOfSalaries() {
        double sum = 0;
        for (Employee emp :
                EmployeeBook.employees
        ) {
            sum += emp.getSalary();
        }
        return sum;
    }

    Employee getMaxSalaryName() {
        Employee maxSalary = null;
        double max = 0;
        for (Employee emp :
                EmployeeBook.employees) {
            if (emp.getSalary() >= max) {
                maxSalary = emp;
                max = emp.getSalary();
            }
        }
        return maxSalary;
    }

    Employee getMinSalary() {
        Employee minSalary = null;
        double min = EmployeeBook.employees[0].getSalary();
        for (Employee emp :
                EmployeeBook.employees) {
            if (emp.getSalary() <= min) {
                minSalary = emp;
                min = emp.getSalary();
            }
        }
        return minSalary;
    }

    double getAverageSalary() {
        return getSumOfSalaries() / EmployeeBook.employees.length;
    }

    void getHighSalary(double percent) {
        for (Employee emp :
                EmployeeBook.employees) {
            emp.setSalary(emp.getSalary() + emp.getSalary() * percent / 100);
        }
    }

    Employee getMinSalaryInDep(int x) {
        double min = EmployeeBook.employees[0].getSalary();
        Employee minSalary = null;
        for (Employee emp :
                EmployeeBook.employees) {
            if (emp.getDepartment() == x && min > emp.getSalary()) {
                min = emp.getSalary();
                minSalary = emp;
            }
        }
        return minSalary;
    }

    Employee getMaxSalaryInDep(int x) {
        double max = 0;
        Employee maxSalary = null;
        for (Employee emp :
                EmployeeBook.employees) {
            if (emp.getDepartment() == x && max < emp.getSalary()) {
                max = emp.getSalary();
                maxSalary = emp;

            }
        }
        return maxSalary;
    }

    double getSumSalaryOfDepart(int x) {
        double sum = 0;
        for (Employee emp :
                EmployeeBook.employees) {
            if (emp.getDepartment() == x) {
                sum += emp.getSalary();
            }
        }
        return sum;
    }

    double getAverageSalaryOfDepart(int x) {
        int numberEmpInDepart = 0;
        for (Employee emp :
                EmployeeBook.employees) {
            if (emp.getDepartment() == x) {
                numberEmpInDepart += 1;
            }
        }
        if (numberEmpInDepart == 0) {
            return 0;
        } else {
            double averageSal = getSumSalaryOfDepart(x) / numberEmpInDepart;
            return averageSal;
        }
    }

    void getHighSalaryOfDepart(int x, double percent) {
        for (Employee emp :
                EmployeeBook.employees) {
            if (emp.getDepartment() == x) {
                emp.setSalary(emp.getSalary() * (1 + percent / 100));
            }
        }
    }

    //setters
    void setEmployee(int id, String fullname, int department, double salary) {
        employees[id] = new Employee(id, fullname, department, salary);
    }

    //prints
    void printAllEmployees() {
        for (Employee emp :
                EmployeeBook.employees) {
            if (emp != null) {
                System.out.println("Id # " + emp.getId() + "; Name:" + emp.getFullname() + "; Department # " +
                        emp.getDepartment() + "; Salary: " + emp.getSalary());
            } else {
                System.out.println("null");
            }
        }

    }

    void printAllFullnames() {
        for (Employee emp :
                EmployeeBook.employees) {
            System.out.println(emp.getFullname());
        }
    }

    void printEmployeesOfDepart(int x) {
        for (Employee emp :
                EmployeeBook.employees) {
            if (emp.getDepartment() == x) {
                System.out.println("Сотрудник " + emp.getFullname() + " Id - " +
                        " указанного отдела получает " + emp.getSalary());
            }
        }
    }

    void printEmployeesSalaryLess(double salary) {
        System.out.println("Следующие сотрудники получают меньше, чем " + salary);
        for (Employee emp :
                EmployeeBook.employees) {
            if (emp.getSalary() < salary) {
                System.out.println("ID " + emp.getId() + " ФИО " + emp.getFullname() + " зарплата " + emp.getSalary());
            }
        }
    }

    void printEmployeesSalaryMore(double salary) {
        System.out.println("Следующие сотрудники получают больше или равно, чем " + salary);
        for (Employee emp :
                EmployeeBook.employees) {
            if (emp.getSalary() >= salary) {
                System.out.println("ID " + emp.getId() + " ФИО " + emp.getFullname() + " зарплата " + emp.getSalary());
            }
        }
    }

    void printEmployeesByDeparment() {
        //выбираем уникальные номера отделов (вдруг их будет больше 5?)
        int[] numbersOfDepartment = new int[employees.length];
        for (int i = 0; i < numbersOfDepartment.length; i++) {
            numbersOfDepartment[i] = employees[i].getDepartment();
        }
        Arrays.sort(numbersOfDepartment);
        ArrayList depart = new ArrayList<Integer>();
        for (int i = 0; i < numbersOfDepartment.length; i++) {
            if (i < numbersOfDepartment.length-1 && numbersOfDepartment[i] != numbersOfDepartment[i + 1]) {
                depart.add(numbersOfDepartment[i]);
            } else if (i == numbersOfDepartment.length - 1) {
                depart.add(numbersOfDepartment[i]);
            }
        }
        for (int i = 0; i < depart.size(); i++) {
            System.out.println("Сотрудники отдела № " + depart.get(i));
            for (int j = 0; j < employees.length; j++) {
                if (i == employees[j].getDepartment()){
                    System.out.println(employees[j].getFullname());
                }
            }
        }
    }

    //others methods
    void searchDelete(String fullName, int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFullname().equals(fullName) || employees[i].getId() == id) {
                employees[i] = null;
            }
        }
    }

    void addEmployee(int id, String name) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(id, name, Main.getRandomDepartment(), Main.getRandomSalary());
                Main.setCounter(id + 1);
            }
        }
    }

    void changeEmployeeSalaryDepartment(String fullName, double newSalary, int newDepartment) {
        for (Employee emp :
                employees) {
            if (emp.getFullname().equals(fullName)) {
                emp.setSalary(newSalary);
                emp.setDepartment(newDepartment);
            }
        }
    }

}
