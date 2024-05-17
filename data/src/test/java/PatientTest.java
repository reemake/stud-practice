import entity.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {
    Patient patient1;
    Patient patient2;

    Patient patient3;

    @BeforeEach
    void setUp() {
        patient1 = new Patient("Ivan", "Ivanovich", "Ivanov", LocalDate.parse("1990-05-25"), "male", "+7-902-244-54-66");
        patient2 = new Patient("Larisa", "Ivanovna", "Lisitsyna", LocalDate.parse("1997-12-20"), "female", "+7-999-040-54-22");
        patient3 = new Patient();
    }

    @Test
    void toStringPersonMaleTest() {
        String expected = "ФИО: Ivan Ivanovich Ivanov\n" +
                "Возраст: 33\n" +
                "Пол: М\n" +
                "Телефон: +7-902-244-54-66";
        String actual = patient1.toString();
        assertEquals(expected, actual);
    }

    @Test
    void toStringPersonFemaleTest() {
        String expected = "ФИО: Larisa Ivanovna Lisitsyna\n" +
                "Возраст: 26\n" +
                "Пол: Ж\n" +
                "Телефон: +7-999-040-54-22";
        String actual = patient2.toString();
        assertEquals(expected, actual);
    }

    @Test
    void isNullPatientTest() {
        assertNotNull(patient3);
    }
}
