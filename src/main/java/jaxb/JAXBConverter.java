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
 * Class which is describing JAXB Converter
 * @author Nikita Safonov
 */
public class JAXBConverter {
    private JAXBContext c;
    private Marshaller m;
    private Unmarshaller um;

    public JAXBConverter(Class clazz) throws JAXBException {
        this.c = JAXBContext.newInstance(clazz);
        this.m = this.c.createMarshaller();
        this.m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        this.um = this.c.createUnmarshaller();
    }

    public void marshall(PatientRepository patient, String filepath) throws JAXBException {
        m.marshal(patient, new File(filepath));
    }

    public PatientRepository unmarshall(String filepath) throws JAXBException, FileNotFoundException {
        return (PatientRepository) um.unmarshal(new FileReader(filepath));
    }
}