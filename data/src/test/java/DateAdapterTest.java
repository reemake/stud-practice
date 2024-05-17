import entity.Patient;
import entity.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.DateAdapter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateAdapterTest {
    DateAdapter dateAdapter;

    @BeforeEach
    void setUp() {
        dateAdapter = new DateAdapter();
    }

    @Test
    void unmarshalTest() throws Exception {
        LocalDate expected = LocalDate.of(2001, 5, 20);
        LocalDate actual = dateAdapter.unmarshal("2001-05-20");
        assertEquals(expected, actual);
    }

    @Test
    void marshalTest() throws Exception {
        String expected = "2001-05-20";
        String actual = dateAdapter.marshal(LocalDate.of(2001, 5, 20));
    }
}
