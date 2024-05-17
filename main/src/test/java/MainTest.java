import entity.PatientRepository;
import exception.FilenameNotSpecifiedException;
import jaxb.JAXBConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    JAXBConverter jaxbConverter;
    String filename;

    @BeforeEach
    void setUp() throws JAXBException {
        jaxbConverter = new JAXBConverter(PatientRepository.class);
        filename = "patients";
    }

    @Test
    void sortByAgeTest() throws JAXBException, FileNotFoundException {
        PatientRepository newRepoFromXml = jaxbConverter.unmarshall("C:\\Users\\reema\\IdeaProjects\\stud-practice\\main\\src\\main\\resources\\" + filename + ".xml");
        newRepoFromXml.sortByAge();
        String expected = "+------------------------------+-----------+-----------+--------------------+\n" +
                "|             ФИО              |  Возраст  |    Пол    |       Телефон      |\n" +
                "+------------------------------+-----------+-----------+--------------------+\n" +
                "|Medvedev Mihail Viktorovich   |29         |male       |+7-920-670-9643     |\n" +
                "|Lisitsyna Larisa Ivanovna     |34         |female     |+7-980-719-1668     |\n" +
                "|Volkova Maria Petrovna        |36         |female     |+7-903-220-7681     |\n" +
                "|Petrov Petr Petrovich         |38         |male       |+7-920-230-1756     |\n" +
                "|Ivanov Ivan Ivanovich         |43         |male       |+7-905-680-4476     |\n" +
                "+------------------------------+-----------+-----------+--------------------+".trim().replace("\r","");
        String actual = newRepoFromXml.toString();
        assertEquals(expected, expected);
    }

    @Test
    void sortByNameTest() throws JAXBException, FileNotFoundException {
        PatientRepository newRepoFromXml = jaxbConverter.unmarshall("C:\\Users\\reema\\IdeaProjects\\stud-practice\\main\\src\\main\\resources\\" + filename + ".xml");
        newRepoFromXml.sortByLastName();
        String expected = "+------------------------------+-----------+-----------+--------------------+\n" +
                "|             ФИО              |  Возраст  |    Пол    |       Телефон      |\n" +
                "+------------------------------+-----------+-----------+--------------------+\n" +
                "|Ivanov Ivan Ivanovich         |43         |male       |+7-905-680-4476     |\n" +
                "|Lisitsyna Larisa Ivanovna     |34         |female     |+7-980-719-1668     |\n" +
                "|Medvedev Mihail Viktorovich   |29         |male       |+7-920-670-9643     |\n" +
                "|Petrov Petr Petrovich         |38         |male       |+7-920-230-1756     |\n" +
                "|Volkova Maria Petrovna        |36         |female     |+7-903-220-7681     |\n" +
                "+------------------------------+-----------+-----------+--------------------+".trim().replace("\r","");
        String actual = newRepoFromXml.toString().trim().replace("\r","");
        assertEquals(expected, expected);
    }

    @Test
    void mainNameTest() throws JAXBException, FileNotFoundException, FilenameNotSpecifiedException {
        String[] args = {"patients", "name"};
        Main.main(args);
    }

    @Test
    void mainAgeTest() throws JAXBException, FileNotFoundException, FilenameNotSpecifiedException {
        String[] args = {"patients", "age"};
        Main.main(args);
    }
}
