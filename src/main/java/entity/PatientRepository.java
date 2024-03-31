package entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Class which is describing a repository storing information about patients
 * @author Nikita Safonov
 */
@XmlRootElement(name = "patients")
@XmlAccessorType(XmlAccessType.FIELD)
public class PatientRepository {

    @XmlElement(name = "patient")
    private ArrayList<Patient> patients;

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public void sortByLastName() {
        Collections.sort(patients, Comparator.comparing(Patient::getLastName));
    }

    public void sortByAge() {
        Collections.sort(patients, Comparator.comparing(Patient::getAge));
    }

    public void printInfo() {
        String alignFormat = "|%-30s|%-11s|%-11s|%-20s|%n";

        System.out.format("+------------------------------+-----------+-----------+--------------------+%n");
        System.out.format("|             ФИО              |  Возраст  |    Пол    |       Телефон      |%n");
        System.out.format("+------------------------------+-----------+-----------+--------------------+%n");

        for(Patient p : patients) {
            System.out.format(alignFormat, p.getLastName() + " " + p.getFirstName() + " " + p.getMiddleName(), p.getAge(), p.getGender(), p.getPhoneNumber());
        }
        System.out.format("+------------------------------+-----------+-----------+--------------------+%n");
    }
}