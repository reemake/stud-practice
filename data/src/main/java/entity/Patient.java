package entity;

import util.DateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.Period;

/**
 * Class which is describing an entity Patient
 * @author Nikita Safonov
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Patient {

    @XmlElement(name = "first_name")
    private String firstName;

    @XmlElement(name = "middle_name")
    private String middleName;

    @XmlElement(name = "last_name")
    private String lastName;

    @XmlElement(name = "birthday")
    @XmlJavaTypeAdapter(value = DateAdapter.class)
    private LocalDate birthday;

    @XmlElement(name = "gender")
    private String gender;

    @XmlElement(name = "phone")
    private String phoneNumber;

    public Patient(String firstName, String middleName, String lastName, LocalDate birthday, String gender, String phoneNumber) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public Patient() {
        this.firstName = null;
        this.middleName = null;
        this.lastName = null;
        this.birthday = null;
        this.gender = null;
        this.phoneNumber = null;
    }

    /**
     * Function of calculating the age
     * @return age in years
     */
    public int calcAge(LocalDate birthday) {
        LocalDate currDate = LocalDate.now();
        if (birthday != null && currDate != null)
            return Period.between(birthday, currDate).getYears();
        else
            return 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return calcAge(birthday);
    }

    @Override
    public String toString() {
        String gender_ = (getGender().equals("male") ? "М" : "Ж");
        return  "ФИО: " + getFirstName() + " " + getMiddleName() + " " + getLastName() +
                "\nВозраст: " + calcAge(getBirthday()) +
                "\nПол: " + gender_ +
                "\nТелефон: " + getPhoneNumber();

    }
}