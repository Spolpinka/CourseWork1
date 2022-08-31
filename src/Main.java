import java.util.Random;

public class Main {
    static int counter = 0;

    public static void setCounter(int counter) {
        Main.counter = counter;
    }

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        //формируем массив работников
        for (int i = 0; i < employeeBook.getEmployees().length; i++) {
            employeeBook.setEmployee(counter, "Алексей Алексеевич Алексеев №" + i,
                    getRandomDepartment(), getRandomSalary());
            counter += 1;
        }

        //проверяем сеттеры по полям отдела и зарплаты
        int indexOfEmp = 0; //произвольный сотрудник
        System.out.println("У сотрудника " +
                employeeBook.getOneEmployee(indexOfEmp).getFullname() + " до внесения изменений доход составляет " +
                employeeBook.getOneEmployee(indexOfEmp).getSalary() + ", в отделе " +
                employeeBook.getOneEmployee(indexOfEmp).getDepartment());
        employeeBook.getOneEmployee(indexOfEmp).setDepartment(getRandomDepartment());
        employeeBook.getOneEmployee(indexOfEmp).setSalary(200000);
        System.out.println("У того же сотрудника " +
                employeeBook.getOneEmployee(indexOfEmp).getFullname() + " после повышения доход составляет " +
                employeeBook.getOneEmployee(indexOfEmp).getSalary() + " в отделе " +
                employeeBook.getOneEmployee(indexOfEmp).getDepartment());

        //проверяем метод выведения в консоль всех полей всех сотрудников
        employeeBook.printAllEmployees();

        //проверяем метод подсчета всех затрат в месяц на запрлату
        System.out.println("Сумма расходов на зарплаты в месяц = " + employeeBook.getSumOfSalaries());

        //находим самого высокооплачиваемого сотрудника
        System.out.println("Самый высокооплачиваемый сотрудник: " +
                employeeBook.getMaxSalaryName().getFullname() + " с зарплатой " +
                employeeBook.getMaxSalaryName().getSalary());

        //находим самого низкооплачиваемого сотрудника
        System.out.println("Самый низко оплачиваемый сотрудник: " +
                employeeBook.getMinSalary().getFullname() + " с зарплатой " +
                employeeBook.getMinSalary().getSalary());

        //считаем среднее значение зарплат
        System.out.println("Средняя зарплата - " + employeeBook.getAverageSalary());

        //выводим в консоль все ФИО
        employeeBook.printAllFullnames();

        //повышаем зарплату на 10 % и выводим результат в консоль
        System.out.println("После повышения зарплат доход каждого сотрудника составит:");
        double percent = 10;
        employeeBook.getHighSalary(percent);
        for (Employee emp :
                employeeBook.getEmployees()) {
            System.out.println("сотрудник " + emp.getFullname() + " стал получать " + emp.getSalary());
        }

        //определяем самого низкооплачиваемого в конкретном отделе
        int departNumber = 3;
        System.out.println("Самым низкооплачиваемым сотрудником в отделе № " + departNumber + " является " +
                employeeBook.getMinSalaryInDep(departNumber).getFullname() + " с зарплатой " +
                employeeBook.getMinSalaryInDep(departNumber).getSalary());

        //определяем самого высокооплачиваемого в том же отделе
        System.out.println("Самым дорогим сотрудником в отделе № " + departNumber + " является " +
                employeeBook.getMaxSalaryInDep(departNumber).getFullname() + " с зарплатой " +
                employeeBook.getMaxSalaryInDep(departNumber).getSalary());

        //считаем сумму затрат на зарплату по отделу
        System.out.println("сумма расходов на з/п по отделу № " + departNumber + " составляет " +
                employeeBook.getSumSalaryOfDepart(departNumber));

        //считаем среднюю зарплату по отделу
        if (employeeBook.getAverageSalaryOfDepart(departNumber) == 0) {
            System.out.println("В указанном отделе нет сотрудников!");
        } else {
            System.out.println("Средняя з/п по отделу № " + departNumber + " составляет " +
                    employeeBook.getAverageSalaryOfDepart(departNumber));
        }

        //повышем з/п на процент по отделу
        System.out.println("з/п до повышения по отделу " + departNumber + ":");
        employeeBook.printEmployeesOfDepart(departNumber);
        employeeBook.getHighSalaryOfDepart(departNumber, percent);
        System.out.println("з/п после повышения по отделу " + departNumber + ":");
        employeeBook.printEmployeesOfDepart(departNumber);

        //печатаем всех сотрудников отдела
        System.out.println("Просто печатаем сотрудников отдела (да, смысла нет, но ради галки в перечне...)");
        employeeBook.printEmployeesOfDepart(departNumber);

        //по числу выводим сотрудником с зарплатой меньше и больше/равно этого числа
        double salary = getRandomSalary();
        employeeBook.printEmployeesSalaryLess(salary);
        employeeBook.printEmployeesSalaryMore(salary);

        //удаляем сотрудника из ячейки 8
        System.out.println("удаляем сотрудника № 8");
        employeeBook.searchDelete(employeeBook.getOneEmployee(8).getFullname(), 8);
        employeeBook.printAllEmployees();

        //добавляем нового сотрудника
        System.out.println("Добавляем нового сотрудника вместо null");
        employeeBook.addEmployee(counter, "Совсем Новый Иванов");
        //удаляем и ставим индекс неверный для проверки удаления
        employeeBook.searchDelete(employeeBook.getOneEmployee(5).getFullname(), 50);
        employeeBook.addEmployee(counter, "Еще Один Для Проверки counter д.б. 11");
        employeeBook.printAllEmployees();
        //изменяем данные о сотруднике, находим по fullName, меняем salary и department
        employeeBook.changeEmployeeSalaryDepartment(employeeBook.getOneEmployee(indexOfEmp).getFullname(),
                getRandomSalary(), getRandomDepartment());
        //печатаем сотрудников по отделам
        System.out.println("Печатаем сотрудников по отделам");
        employeeBook.printEmployeesByDeparment();
    }

    static int getRandomSalary() {
        Random random = new Random();
        return random.nextInt(100_000) + 100_000;
    }

    static int getRandomDepartment() {
        Random random = new Random();
        return random.nextInt(5);
    }

}