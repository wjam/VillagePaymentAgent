package org.haftrust.verifier.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "HT_VERIFIER", schema = "kj905")
public class Verifier {

    @Id
    @Column(name = "IDVERIFIER", nullable = false)
    @GeneratedValue
    private Integer id;

    @Column(name = "FIRST_NAME", length = 45)
    private String firstName;

    @Column(name = "MIDDLE_NAME", length = 45)
    private String middleName;

    @Column(name = "LAST_NAME", length = 45)
    private String lastName;

    @Column(length = 1)
    private String gender;
    private Date dob;

    @Column(length = 45, nullable = false)
    private String email;

    @Column(name = "TELEPHONE_NUMBER", length = 25)
    private String telephoneNumber;

    @Column(length = 45)
    private String password;

    @Column(name = "EDUCATION_TYPE", length = 45)
    private String educationType;

    @Column(name = "EDUCATION_LEVEL", length = 45)
    private String educationLevel;

    @Column(length = 45, nullable = false)
    private String status;

    @Column(name = "STATUS_DATE", nullable = false)
    private Date statusDate;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "HT_VACANCY_IDVACANCY")
    private Integer vacancyId;

    @Column(name = "VERIFICATION_STATUS", length = 45)
    private String verificationStatus;

    @Column(name = "VERIFICATION_DATE")
    private Date verificationDate;

    @Column(name = "VERIFICATION_COMMENT", length = 100)
    private String verificationComment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HT_DEVICE_IMEI")
    private Device mobileDevice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HT_IMAGE_IDIMAGE")
    private Image image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
