package src;

import java.util.Date;
import java.util.Calendar;

public class Person {
    private String name;
    private String surname;
    private Date birthDate;
    private boolean anotherCompanyOwner;
    private boolean pensioner;
    private boolean publicServer;
    private float salary;

    public Person(String name, String surname, Date birthDate, boolean anotherCompanyOwner, boolean pensioner, boolean publicServer) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.anotherCompanyOwner = anotherCompanyOwner;
        this.pensioner = pensioner;
        this.publicServer = publicServer;
    }

    public String fullName() {
        return name + " " + surname;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float calculateYearlySalary() {
        return salary * 12;
    }

    private int getAge() {
        Calendar birth = Calendar.getInstance();
        birth.setTime(birthDate);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }

    public boolean isMEI() {
        return calculateYearlySalary() < 130000 &&
                getAge() > 18 &&
                !anotherCompanyOwner &&
                !pensioner &&
                !publicServer;
    }

    // Getters and setters for test manipulation
    public void setAnotherCompanyOwner(boolean value) {
        this.anotherCompanyOwner = value;
    }

    public void setPensioner(boolean value) {
        this.pensioner = value;
    }

    public void setPublicServer(boolean value) {
        this.publicServer = value;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
