package src;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

public class PersonTest {
    private Person person;

    @BeforeEach
    public void setup() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1);
        Date birthDate = calendar.getTime();

        person = new Person("Paul", "McCartney", birthDate, true, true, true);
    }

    @Test
    public void show_full_name() {
        assertEquals("Paul McCartney", person.fullName());
    }

    @Test
    public void test_calculateYearlySalary() {
        person.setSalary(1200);
        assertEquals(14400, person.calculateYearlySalary(), 0.01);
    }

    @Test
    public void person_is_MEI() {
        person.setSalary(1000); // 12,000 annual
        person.setAnotherCompanyOwner(false);
        person.setPensioner(false);
        person.setPublicServer(false);

        Calendar calendar = Calendar.getInstance();
        calendar.set(1990, Calendar.JANUARY, 1); // age > 18
        person.setBirthDate(calendar.getTime());

        assertTrue(person.isMEI());
    }

    @Test
    public void person_is_not_MEI() {
        person.setSalary(12000); // 144,000 annual
        person.setAnotherCompanyOwner(true);
        person.setPensioner(true);
        person.setPublicServer(true);

        assertFalse(person.isMEI());
    }
}
