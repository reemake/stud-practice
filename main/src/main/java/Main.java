import entity.PatientRepository;
import exception.FilenameNotSpecifiedException;
import jaxb.JAXBConverter;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

/**
 * Цель задания: продемонстрировать базовые навыки владения языком Java (ООП, коллекции, ввод\вывод, XML), а также базовым инструментарием для работы (JDK, компилятор, IDE, GitHub, Maven).
 *
 * Необходимо разработать консольное java приложение, читающее входной XML-файл, далее осуществляющее обработку считанных данных и выдачу результата обратно на консоль.
 *
 * Входные данные для программы представлены в виде XML-файла, содержащих список пациентов и их атрибуты.
 * Пример файла представлен ниже в приложении №1.
 *
 * Управление программой должно осуществляться с помощью параметров командной строки:
 *
 * Имя XML-файла (первый параметр). Если параметр не указан, выводить ошибку и прекращать работу;
 * Способ сортировки результата (второй параметр). Если параметр не указан, то выводить данные без сортировки. Если указан, то в случае:
 * “name” - сортировка по фамилии
 * “age” - сортировка по возрасту
 * Программа должна считать входной XML-файл и создать модель данных, то есть для каждой XML-записи создать свой экземпляр класса Patient.
 * Далее в зависимости от заданного способа сортировки выдать на консоль записи в табличной форме и правильной последовательности.
 *
 * Колонки для вывода:
 *
 * “ФИО” - фамилия имя и отчество пациента
 * “Возраст” - возраст пациента
 * “Пол” - пол пациента (М или Ж)
 * “Телефон” - телефон пациента
 */

public class Main {

    private static void validateArgs(String[] args) throws FilenameNotSpecifiedException {
        if (args.length == 0) {
            throw new FilenameNotSpecifiedException("Параметры не заданы!");
        }
        else if (args.length == 1)
            if (args[0].equals("age") || args[0].equals("name"))
                throw new FilenameNotSpecifiedException("Имя файла не указано!");
    }

    public static void main(String[] args) throws FileNotFoundException, JAXBException, FilenameNotSpecifiedException {

        try {
            validateArgs(args);

            JAXBConverter jaxbConverter;
            PatientRepository patients;

            String filename = args[0];
            jaxbConverter = new JAXBConverter(PatientRepository.class);
            patients = jaxbConverter.unmarshall("src/main/resources/" + filename + ".xml");

            if (args.length == 2) {
                String sortBy = args[1];
                if (sortBy.equals("name")) {
                    patients.sortByLastName();
                } else if (sortBy.equals("age")) {
                    patients.sortByAge();
                }
            }

            patients.printInfo();

        } catch (JAXBException e) {
            System.out.println(e);;
        } catch (FileNotFoundException e) {
            System.out.println(e);;
        }

    }
}