package entity;

import util.DateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.Period;

/**
 * Class which is describing an entity Patient.
 * @author Nikita Safonov
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Patient {
    /** Firstname field. */
    @XmlElement(name = "first_name")
    private String firstName;

    /** Middlename field. */
    @XmlElement(name = "middle_name")
    private String middleName;

    /** Lastname field. */
    @XmlElement(name = "last_name")
    private String lastName;

    /** Birthday field. */
    @XmlElement(name = "birthday")
    @XmlJavaTypeAdapter(value = DateAdapter.class)
    private LocalDate birthday;

    /** Gender field. */
    @XmlElement(name = "gender")
    private String gender;

    /** Phone number field. */
    @XmlElement(name = "phone")
    private String phoneNumber;

    /**
     * Constructor with parameters.
     * @param newFirstName
     * @param newMiddleName
     * @param newLastName
     * @param newBirthday
     * @param newGender
     * @param newPhoneNumber
     */
    public Patient(final String newFirstName, final String newMiddleName,
                   final String newLastName, final LocalDate newBirthday,
                   final String newGender, final String newPhoneNumber) {
        this.firstName = newFirstName;
        this.middleName = newMiddleName;
        this.lastName = newLastName;
        this.birthday = newBirthday;
        this.gender = newGender;
        this.phoneNumber = newPhoneNumber;
    }

    /**
     * Default constructor.
     */
    public Patient() {
        this.firstName = null;
        this.middleName = null;
        this.lastName = null;
        this.birthday = null;
        this.gender = null;
        this.phoneNumber = null;
    }

    /**
     * Function of calculating the age.
     * @param newBirthday
     * @return age in years
     */
    public int calcAge(final LocalDate newBirthday) {
        LocalDate currDate = LocalDate.now();
        if (newBirthday != null && currDate != null) {
            return Period.between(newBirthday, currDate).getYears();
        } else {
            return 0;
        }
    }

    /**
     * Firstname getter.
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Firstname setter.
     * @param newFirstName
     */
    public void setFirstName(final String newFirstName) {
        this.firstName = newFirstName;
    }

    /**
     * Middlename getter.
     * @return middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Middlename setter.
     * @param newMiddleName
     */
    public void setMiddleName(final String newMiddleName) {
        this.middleName = newMiddleName;
    }

    /**
     * Lastname getter.
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Lastname setter.
     * @param newLastName
     */
    public void setLastName(final String newLastName) {
        this.lastName = newLastName;
    }

    /**
     * Birthday getter.
     * @return birthday
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Birthday setter.
     * @param newBirthday
     */
    public void setBirthday(final LocalDate newBirthday) {
        this.birthday = newBirthday;
    }

    /**
     * Gender getter.
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Gender setter.
     * @param newGender
     */
    public void setGender(final String newGender) {
        this.gender = newGender;
    }

    /**
     * Phone number getter.
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Phone number setter.
     * @param newPhoneNumber
     */
    public void setPhoneNumber(final String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }

    /**
     * Age getter.
     * @return age in years
     */
    public int getAge() {
        return calcAge(birthday);
    }

    /**
     * Overrided default toString method.
     * @return string
     */
    @Override
    public String toString() {
        String finalGender = (getGender().equals("male") ? "М" : "Ж");
        return  "ФИО: " + getFirstName() + " "
                + getMiddleName() + " " + getLastName()
                + "\nВозраст: " + calcAge(getBirthday())
                + "\nПол: " + finalGender + "\nТелефон: " + getPhoneNumber();
    }
}
