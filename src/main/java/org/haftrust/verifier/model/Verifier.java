package org.haftrust.verifier.model;

import java.sql.Date;

/**
 *
 * @author LabClass
 */
public class Verifier implements java.io.Serializable {

    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private Date dob;
    private String email;
    private String telephoneNumber;
    private String password;
    private String educationType;
    private String educationLevel;
    private String status;
    private Date statusDate;
    private Date startDate;
    private int vacancyId;
    private String verificationStatus;
    private Date verificationDate;
    private String verificationComment;
    private Device mobileDevice;
    private Image image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEducationType() {
        return educationType;
    }

    public void setEducationType(String educationType) {
        this.educationType = educationType;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(int vacancyId) {
        this.vacancyId = vacancyId;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public Date getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(Date verificationDate) {
        this.verificationDate = verificationDate;
    }

    public String getVerificationComment() {
        return verificationComment;
    }

    public void setVerificationComment(String verificationComment) {
        this.verificationComment = verificationComment;
    }

    public Device getMobileDevice() {
        return mobileDevice;
    }

    public void setMobileDevice(Device mobileDevice) {
        this.mobileDevice = mobileDevice;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Verifier{" + "id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", gender=" + gender + ", dob=" + dob + ", email=" + email + ", telephoneNumber=" + telephoneNumber + ", password=" + password + ", educationType=" + educationType + ", educationLevel=" + educationLevel + ", status=" + status + ", statusDate=" + statusDate + ", startDate=" + startDate + ", vacancyId=" + vacancyId + ", verificationStatus=" + verificationStatus + ", verificationDate=" + verificationDate + ", verificationComment=" + verificationComment + ", mobileDevice=" + mobileDevice + ", image=" + image + '}';
    }

    
}
