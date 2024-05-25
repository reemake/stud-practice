package util;



import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

/**
 * Class for correct converting LocalDate type in process of parsing
 * @author Nikita Safonov
 */
public class DateAdapter extends XmlAdapter<String, LocalDate> {
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v);
    }

    public String marshal(LocalDate v) throws Exception {
        return v.toString();
    }

    public int summ(int a, int b) {
        return a+b;
    }
}