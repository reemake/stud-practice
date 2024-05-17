import exception.FilenameNotSpecifiedException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FilenameNotSpecifiedExceptionTest {

    @Test
    void exceptionZeroParamsTest() {
        String[] args = {};
        Exception exception = assertThrows(FilenameNotSpecifiedException.class, ()-> Main.main(args));
        assertEquals("Параметры не заданы!", exception.getMessage());
    }

    @Test
    void exceptionNameParamTest() {
        String[] args = {"name"};
        Exception exception = assertThrows(FilenameNotSpecifiedException.class, ()-> Main.main(args));
        assertEquals("Имя файла не указано!", exception.getMessage());
    }

    @Test
    void exceptionAgeParamTest() {
        String[] args = {"age"};
        Exception exception = assertThrows(FilenameNotSpecifiedException.class, ()-> Main.main(args));
        assertEquals("Имя файла не указано!", exception.getMessage());
    }
}
