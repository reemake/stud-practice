package util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

/**
 * Class for correct converting LocalDate type in process of parsing.
 * @author Nikita Safonov
 */
public class DateAdapter extends XmlAdapter<String, LocalDate> {
    /**
     * @param v The value to be converted. Can be null.
     * @return date in LocalDate type
     * @throws Exception
     */
    public LocalDate unmarshal(final String v) throws Exception {
        return LocalDate.parse(v);
    }

    /**
     * @param v The value to be convereted. Can be null.
     * @return date in String type
     * @throws Exception
     */
    public String marshal(final LocalDate v) throws Exception {
        return v.toString();
    }
}
