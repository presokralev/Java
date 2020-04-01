package person.salary;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;
    public Person(){

    }

    public Person(String firstName, String lastName, int age, double salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(int bonus){
        if(this.getAge() < 30){
            this.setSalary(this.getSalary() + (getSalary() * bonus/200));
        }else{
            this.setSalary(this.getSalary() + (getSalary() * bonus/100));
        }
    }

    @Override
    public String toString(){
        return String.format(this.firstName + " " + this.lastName +
                " is " + this.age + " years old " + ", gets salary: " + this.salary);
    }
}
