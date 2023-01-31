//CP1340 Lab 4 - Inheritance and Polymorphism
//Student: Cade Molloy - 20175269
//Due Date: November 15th, 2022
//Prof: Branko Cirovic

class Employee {
    protected int salary;
    protected int id;
    protected String name;

    public Employee(String name, int salary, int id) {
        this.salary = salary;
        this.id = id;
        this.name = name;
    }
}

class Salesperson extends Employee {
    protected Policy p;

    public Salesperson(int salary, int id, String name, Policy p) {
        super(name, salary, id);
        this.p = p;
    }

    public String toString() {
        String info = "Employee: " + name + " | Salary: " + salary + " | ID " + id + " | Policy: " + p;
        return info;
    }
}

class Policy {
    private int pid;
    private int amount;
    private String Beneficiary;

    public Policy() {
        Beneficiary = "Branko";
        amount = 50000;
        pid = 21675;
    }

    public Policy(String Beneficiary, int amount, int pid) {
        this.Beneficiary = Beneficiary;
        this.amount = amount;
        this.pid = pid;
    }

    public String toString() {
        String s = " Beneficiary: " + Beneficiary + " | pid: " + pid + " | amount: " + amount;
        return s;
    }
}

class Test {
    public static void main(String[] args) {
        Policy p = new Policy("Branko",100000,21872);
        Salesperson s = new Salesperson(50000,808,"Cade", p);
        System.out.println(s);
    }
}