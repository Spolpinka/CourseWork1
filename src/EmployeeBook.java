import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EmployeeBook {
    final private Employee[] employees = new Employee[10];

    //getters

    Employee getOneEmployee(int indexInBook) {
        if (employees != null && employees[indexInBook] != null) {
            return employees[indexInBook];
        } else {
            throw new ArrayIndexOutOfBoundsException("Книга еще не заполнена / нет такого работника");
        }
    }

    int getEmployeeLength() {
        return employees.length;
    }

    double getSumOfSalaries() {

        if (employees != null) {
            double sum = 0;
            for (Employee emp :
                    employees) {
                if (emp != null) {
                    sum += emp.getSalary();
                }
            }
            return sum;
        } else {
            throw new ArrayIndexOutOfBoundsException("Книга еще не заполнена");
        }
    }

    Employee getMaxSalaryName() {
        if (employees != null) {
            Employee maxSalary = null;
            double max = 0;
            for (Employee emp :
                    employees) {
                if (emp != null && emp.getSalary() >= max) {
                    maxSalary = emp;
                    max = emp.getSalary();
                }
            }
            return maxSalary;
        } else {
            throw new ArrayIndexOutOfBoundsException("Книга еще не заполнена");
        }
    }

    Employee getMinSalary() {
        if (employees != null) {
            Employee minSalary = null;
            double min = employees[0].getSalary();
            for (Employee emp :
                    employees) {
                if (emp != null && emp.getSalary() <= min) {
                    minSalary = emp;
                    min = emp.getSalary();
                }
            }
            return minSalary;
        } else {
            throw new ArrayIndexOutOfBoundsException("Книга еще не заполнена");
        }
    }

    double getAverageSalary() {
        return getSumOfSalaries() / employees.length;
    }

    void raiseSalary(double percent) {

        if (employees != null) {
            for (Employee emp :
                    employees) {
                if (emp != null) {
                    emp.setSalary(emp.getSalary() + emp.getSalary() * percent / 100);
                }
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("Книга еще не заполнена / нет такого работника");
        }
    }

    Employee getMinSalaryInDep(int x) {
        if (employees != null) {
            double min = employees[0].getSalary();
            Employee minSalary = null;
            for (Employee emp :
                    employees) {
                if (emp != null && emp.getDepartment() == x && min > emp.getSalary()) {
                    min = emp.getSalary();
                    minSalary = emp;
                }
            }
            return minSalary;
        } else {
            throw new ArrayIndexOutOfBoundsException("Книга еще не заполнена / нет такого работника");
        }
    }

    Employee getMaxSalaryInDep(int x) {
        if (employees != null) {
            double max = 0;
            Employee maxSalary = null;
            for (Employee emp :
                    employees) {
                if (emp != null && emp.getDepartment() == x && max < emp.getSalary()) {
                    max = emp.getSalary();
                    maxSalary = emp;

                }
            }
            return maxSalary;
        } else {
            throw new ArrayIndexOutOfBoundsException("Книга еще не заполнена / нет такого работника");
        }
    }

    double getSumSalaryOfDepart(int x) {
        if (employees != null) {
            double sum = 0;
            for (Employee emp :
                    employees) {
                if (emp != null && emp.getDepartment() == x) {
                    sum += emp.getSalary();
                }
            }
            return sum;
        } else {
            throw new ArrayIndexOutOfBoundsException("Книга еще не заполнена / нет такого работника");
        }
    }

    double getAverageSalaryOfDepart(int x) {
        if (employees != null) {
            int numberEmpInDepart = 0;
            for (Employee emp :
                    employees) {
                if (emp != null && emp.getDepartment() == x) {
                    numberEmpInDepart += 1;
                }
            }
            if (numberEmpInDepart == 0) {
                return 0;
            } else {
                return getSumSalaryOfDepart(x) / numberEmpInDepart;
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("Книга еще не заполнена / нет такого работника");
        }
    }

    void raiseSalaryOfDepart(int x, double percent) {
        if (employees != null) {
            for (Employee emp :
                    employees) {
                if (emp != null && emp.getDepartment() == x) {
                    emp.setSalary(emp.getSalary() * (1 + percent / 100));
                }
            }
        } else {
            throw new ArrayIndexOutOfBoundsException("Книга еще не заполнена / нет такого работника");
        }
    }

    //setters
    void createEmployeeArray() {
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Employee("Йорига Йозифимович Наршуян-Йыссыкулев № " + i,
                    getRandomDepartment(), getRandomSalary());
        }
    }

    //prints
    void printAllEmployees() {
        for (Employee emp :
                employees) {
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
                employees) {
            System.out.println(emp.getFullname());
        }
    }

    void printEmployeesOfDepart(int x) {
        for (Employee emp :
                employees) {
            if (emp.getDepartment() == x) {
                System.out.println("Сотрудник " + emp.getFullname() + " Id - " +
                        " указанного отдела получает " + emp.getSalary());
            }
        }
    }

    void printEmployeesSalaryLess(double salary) {
        System.out.println("Следующие сотрудники получают меньше, чем " + salary);
        for (Employee emp :
                employees) {
            if (emp.getSalary() < salary) {
                System.out.println("ID " + emp.getId() + " ФИО " + emp.getFullname() + " зарплата " + emp.getSalary());
            }
        }
    }

    void printEmployeesSalaryMore(double salary) {
        System.out.println("Следующие сотрудники получают больше или равно, чем " + salary);
        for (Employee emp :
                employees) {
            if (emp.getSalary() >= salary) {
                System.out.println("ID " + emp.getId() + " ФИО " + emp.getFullname() + " зарплата " + emp.getSalary());
            }
        }
    }

    void printEmployeesByDepartment() {
        //выбираем уникальные номера отделов (вдруг их будет больше 5?)
        int[] numbersOfDepartment = new int[employees.length];
        for (int i = 0; i < numbersOfDepartment.length; i++) {
            numbersOfDepartment[i] = employees[i].getDepartment();
        }
        Arrays.sort(numbersOfDepartment);
        List<Integer> depart = new ArrayList<>();
        for (int i = 0; i < numbersOfDepartment.length; i++) {
            if (i < numbersOfDepartment.length - 1 && numbersOfDepartment[i] != numbersOfDepartment[i + 1]) {
                depart.add(numbersOfDepartment[i]);
            } else if (i == numbersOfDepartment.length - 1) {
                depart.add(numbersOfDepartment[i]);
            }
        }
        for (int i = 0; i < depart.size(); i++) {
            System.out.println("Сотрудники отдела № " + depart.get(i));
            for (int j = 0; j < employees.length; j++) {
                if (i == employees[j].getDepartment()) {
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

    void addEmployee(String name) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(name, getRandomDepartment(), getRandomSalary());

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

    private static int getRandomSalary() {
        Random random = new Random();
        return random.nextInt(100_000) + 100_000;
    }

    private static int getRandomDepartment() {
        Random random = new Random();
        return random.nextInt(5);
    }

}
