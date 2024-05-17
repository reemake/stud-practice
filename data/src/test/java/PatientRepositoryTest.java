import entity.Patient;
import entity.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatientRepositoryTest {
    Patient patient1;
    Patient patient2;
    Patient patient3;
    PatientRepository repo;

    @BeforeEach
    void setUp() {
        patient1 = new Patient("Ivan", "Ivanovich", "Ivanov", LocalDate.parse("1990-05-25"), "male", "+7-902-244-54-66");
        patient2 = new Patient("Larisa", "Ivanovna", "Lisitsyna", LocalDate.parse("1997-12-20"), "female", "+7-999-040-54-22");
        patient3 = new Patient("Maria", "Petrovna", "Volkova", LocalDate.parse("1955-07-14"), "female", "+7-999-454-78-32");
        List<Patient> patients = new ArrayList<>();
        patients.add(patient1);
        patients.add(patient2);
        patients.add(patient3);

        repo = new PatientRepository();
        repo.setPatients((ArrayList<Patient>) patients);
    }

    @Test
    void toStringTest() {
        String expected = "+------------------------------+-----------+-----------+--------------------+\n" +
                "|             ФИО              |  Возраст  |    Пол    |       Телефон      |\n" +
                "+------------------------------+-----------+-----------+--------------------+\n" +
                "|Ivanov Ivan Ivanovich         |33         |male       |+7-902-244-54-66    |\n" +
                "|Lisitsyna Larisa Ivanovna     |26         |female     |+7-999-040-54-22    |\n" +
                "|Volkova Maria Petrovna        |68         |female     |+7-999-454-78-32    |\n" +
                "+------------------------------+-----------+-----------+--------------------+".trim().replace("\r","");
        String actual = repo.toString().trim().replace("\r","");
        assertEquals(expected, actual);
    }
}
