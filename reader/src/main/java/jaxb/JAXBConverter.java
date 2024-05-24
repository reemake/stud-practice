package jaxb;

import entity.PatientRepository;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Class which is describing JAXB Converter.
 * @author Nikita Safonov
 */
public class JAXBConverter {
    /** JAXBContext field. */
    private JAXBContext c;
    /** Marshaller field. */
    private Marshaller m;
    /** Unmarshaller field. */
    private Unmarshaller um;
    /**
     * @param clazz
     * @throws JAXBException
     */
    public JAXBConverter(final Class clazz) throws JAXBException {
        this.c = JAXBContext.newInstance(clazz);
        this.m = this.c.createMarshaller();
        this.m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        this.um = this.c.createUnmarshaller();
    }
    /**
     * @param patient
     * @throws JAXBException
     */
    public void marshall(final PatientRepository patient) throws JAXBException {
        m.marshal(patient, new File("src/main/resources/patients1.xml"));
    }
    /**
     * @param filepath
     * @return unmarshalled XML in PatientRepository type
     * @throws JAXBException
     * @throws FileNotFoundException
     */
    public PatientRepository unmarshall(final String filepath)
            throws JAXBException, FileNotFoundException {
        return (PatientRepository) um.unmarshal(new FileReader(filepath));
    }
}
