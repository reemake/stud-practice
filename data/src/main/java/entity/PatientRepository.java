package entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Class which is describing a repository storing information about patients.
 * @author Nikita Safonov
 */
@XmlRootElement(name = "patients")
@XmlAccessorType(XmlAccessType.FIELD)
public class PatientRepository {

    /** Patients field. */
    @XmlElement(name = "patient")
    private ArrayList<Patient> patients;

    /**
     * Patients getter.
     * @return patients
     */
    public ArrayList<Patient> getPatients() {
        return patients;
    }

    /**
     * Patients setter.
     * @param newPatients
     */
    public void setPatients(final ArrayList<Patient> newPatients) {
        this.patients = newPatients;
    }

    /**
     * Method for sorting patients by lastname.
     */
    public void sortByLastName() {
        Collections.sort(patients, Comparator.comparing(Patient::getLastName));
    }

    /**
     * Method for sorting patients by age.
     */
    public void sortByAge() {
        Collections.sort(patients, Comparator.comparing(Patient::getAge));
    }

    /**
     * Method for printing patients info.
     */
    public void printInfo() {
        System.out.println(this);
    }

    /**
     * Overrided default toString method.
     * @return string
     */
    @Override
    public String toString() {
        String result = "";
        String alignFormat = "|%-30s|%-11s|%-11s|%-20s|%n";

        result += String.format("+------------------------------+-----------+"
                + "-----------+--------------------+\n");
        result += String.format("|             ФИО              |  Возраст  |"
                + "    Пол    |       Телефон      |\n");
        result += String.format("+------------------------------+-----------+"
                + "-----------+--------------------+\n");

        for (Patient p : patients) {
            result += String.format(alignFormat, p.getLastName()
                    + " " + p.getFirstName()
                    + " " + p.getMiddleName(), p.getAge(),
                    p.getGender(), p.getPhoneNumber());
        }
        result += String.format("+------------------------------+-----------+"
                + "-----------+--------------------+");
        return result.trim().replace("\r", "");
    }
}
