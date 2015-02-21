/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.haftrust.verifier.dao.AddressDAO;
import org.haftrust.verifier.dao.BankDAO;
import org.haftrust.verifier.dao.CountryDAO;
import org.haftrust.verifier.dao.DeviceDAO;
import org.haftrust.verifier.dao.DistrictDAO;
import org.haftrust.verifier.dao.FomDAO;
import org.haftrust.verifier.dao.IdentityDocumentDAO;
import org.haftrust.verifier.dao.ImageDAO;
import org.haftrust.verifier.dao.InterviewDAO;
import org.haftrust.verifier.dao.ReferenceDAO;
import org.haftrust.verifier.dao.RegionDAO;
import org.haftrust.verifier.dao.StaticDataDAO;
import org.haftrust.verifier.dao.VerifierDAO;
import org.haftrust.verifier.model.Address;
import org.haftrust.verifier.model.Bank;
import org.haftrust.verifier.model.Country;
import org.haftrust.verifier.model.Device;
import org.haftrust.verifier.model.District;
import org.haftrust.verifier.model.Fom;
import org.haftrust.verifier.model.IdentityDocument;
import org.haftrust.verifier.model.Image;
import org.haftrust.verifier.model.Interview;
import org.haftrust.verifier.model.Reference;
import org.haftrust.verifier.model.Region;
import org.haftrust.verifier.model.StaticData;
import org.haftrust.verifier.model.Verifier;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Miroslav
 */
public class VerifierServiceImpl implements VerifierService {

    private VerifierDAO verifierDao;
    private CountryDAO countryDao;
    private RegionDAO regionDao;
    private DistrictDAO districtDao;
    private StaticDataDAO staticDataDao;
    private AddressDAO addressDao;
    private BankDAO bankDao;
    private ReferenceDAO referenceDao;
    private IdentityDocumentDAO identityDocumentDao;
    private ImageDAO imageDao;
    private FomDAO fomDao;
    private InterviewDAO interviewDao;
    private DeviceDAO deviceDao;

    private List<Country> countryList = new ArrayList<Country>();
    private List<Region> regionList = new ArrayList<Region>();
    private List<District> districtList = new ArrayList<District>();
    private List<Fom> fomList = new ArrayList<Fom>();
    private Region verifierRegion = new Region();
    private Country verifierCountry = new Country();
    private District verifierDistrict = new District();
    private Device verifierDevice = new Device();
    private Fom fom = new Fom();
    private Interview interview = new Interview();
    private Verifier verifier = new Verifier();
    private Address address = new Address();
    private Image image = new Image();
    private IdentityDocument identityDocument = new IdentityDocument();
    private Bank bank = new Bank();
    private Reference reference1 = new Reference();
    private Reference reference2 = new Reference();
    private StaticData sdVerifierType = new StaticData();
    private StaticData sdAwaitingVerificationType = new StaticData();
    private StaticData sdStatus = new StaticData();
    private StaticData sdInterviewStatus = new StaticData();

    private List<Verifier> registeredVerifiersList = new ArrayList<Verifier>();
    private List<Address> registeredVerifierAddressList = new ArrayList<Address>();

    private List<Verifier> employedVerifiersList = new ArrayList<Verifier>();
    private List<Address> employedVerifierAddressList = new ArrayList<Address>();

    private List<Device> deviceList = new ArrayList<Device>();

    public DeviceDAO getDeviceDao() {
        return deviceDao;
    }

    public void setDeviceDao(DeviceDAO deviceDao) {
        this.deviceDao = deviceDao;
    }

    public InterviewDAO getInterviewDao() {
        return interviewDao;
    }

    public void setInterviewDao(InterviewDAO interviewDao) {
        this.interviewDao = interviewDao;
    }

    public FomDAO getFomDao() {
        return fomDao;
    }

    public void setFomDao(FomDAO fomDao) {
        this.fomDao = fomDao;
    }

    public Country getVerifierCountry() {
        return verifierCountry;
    }

    public Region getVerifierRegion() {
        return verifierRegion;
    }

    public District getVerifierDistrict() {
        return verifierDistrict;
    }

    public ImageDAO getImageDao() {
        return imageDao;
    }

    public void setImageDao(ImageDAO imageDao) {
        this.imageDao = imageDao;
    }

    public Reference getReference2() {
        return reference2;
    }

    public Bank getBank() {
        return bank;
    }

    public IdentityDocument getIdentityDocument() {
        return identityDocument;
    }

    public Image getImage() {
        return image;
    }

    public Reference getReference1() {
        return reference1;
    }

    public Address getAddress() {
        return address;
    }

    public IdentityDocumentDAO getIdentityDocumentDao() {
        return identityDocumentDao;
    }

    public void setIdentityDocumentDao(IdentityDocumentDAO identityDocumentDao) {
        this.identityDocumentDao = identityDocumentDao;
    }

    public ReferenceDAO getReferenceDao() {
        return referenceDao;
    }

    public void setReferenceDao(ReferenceDAO referenceDao) {
        this.referenceDao = referenceDao;
    }

    public AddressDAO getAddressDao() {
        return addressDao;
    }

    public void setAddressDao(AddressDAO addressDao) {
        this.addressDao = addressDao;
    }

    public BankDAO getBankDao() {
        return bankDao;
    }

    public void setBankDao(BankDAO bankDao) {
        this.bankDao = bankDao;
    }

    public Verifier getVerifier() {
        return verifier;
    }

    public StaticDataDAO getStaticDataDao() {
        return staticDataDao;
    }

    public void setStaticDataDao(StaticDataDAO staticDataDao) {
        this.staticDataDao = staticDataDao;
    }

    public DistrictDAO getDistrictDao() {
        return districtDao;
    }

    public void setDistrictDao(DistrictDAO districtDao) {
        this.districtDao = districtDao;
    }

    public RegionDAO getRegionDao() {
        return regionDao;
    }

    public void setRegionDao(RegionDAO regionDao) {
        this.regionDao = regionDao;
    }

    public CountryDAO getCountryDao() {
        return countryDao;
    }

    public void setCountryDao(CountryDAO countryDao) {
        this.countryDao = countryDao;
    }

    public VerifierDAO getVerifierDao() {
        return verifierDao;
    }

    public void setVerifierDao(VerifierDAO verifierDao) {
        this.verifierDao = verifierDao;
    }

    public void allocateDevice() {
        StaticData deviceAllocation = this.staticDataDao.getDeviceAllocation("Yes");

        this.verifierDevice.setAllocation(deviceAllocation.getValue());
        this.verifierDevice.setAllocationDate(this.getCurrentDate());
        this.deviceDao.saveDevice(this.verifierDevice);

        this.verifier.setMobileDevice(this.verifierDevice);
        this.verifier = this.verifierDao.setVerifier(this.verifier);
    }

    public void failVerification(String strVerifierVerificationComment) {
        this.sdStatus = this.staticDataDao.getEmploymentStatus("Failed");
        //this.verifier.setStatus(this.sdStatus.getValue());
        this.verifier.setVerificationComment(strVerifierVerificationComment);
        //this.verifier.setStatusDate(this.todaysDate());

        this.saveVerifier();
    }

    public Fom setVerifyVerifierDetils(String strVerifierVerificationStatus,
            String strVerifierVerificationComment,
            String strAddressVerificationStatus,
            String strAddressVerificationComment,
            String strImageVerificationStatus,
            String strImageVerificationComment,
            String strIdentityDocumentVerificationStatus,
            String strIdentityDocumentVerificationComment,
            String strBankVerificationStatus,
            String strBankVerificationComment,
            String strReference1VerificationStatus,
            String strReference1VerificationComment,
            String strReference2VerificationStatus,
            String strReference2VerificationComment,
            int idFom,
            boolean verified) {
        if (verified) {
            this.sdStatus = this.staticDataDao.getEmploymentStatus("Verified");
            this.verifier.setStatus(this.sdStatus.getValue());

            for (int i = 0; i < this.fomList.size(); i++) {
                if (idFom == this.fomList.get(i).getId()) {
                    this.fom = this.fomList.get(i);
                }
            }
        }

        this.verifier.setVerificationStatus(strVerifierVerificationStatus);
        this.verifier.setVerificationComment(strVerifierVerificationComment);
        this.verifier.setVerificationDate(this.todaysDate());
        this.verifier.setStatusDate(this.todaysDate());

        this.address.setVerificationStatus(strAddressVerificationStatus);
        this.address.setVerificationComment(strAddressVerificationComment);
        this.address.setVerificationDate(this.todaysDate());

        this.image.setVerificationStatus(strImageVerificationStatus);
        this.image.setVerificationComment(strImageVerificationComment);
        this.image.setVerificationDate(this.todaysDate());

        this.identityDocument.setVerificationStatus(strIdentityDocumentVerificationStatus);
        this.identityDocument.setVerificationComment(strIdentityDocumentVerificationComment);
        this.identityDocument.setVerificationDate(this.todaysDate());

        this.bank.setVerificationStatus(strBankVerificationStatus);
        this.bank.setVerificationComment(strBankVerificationComment);
        this.bank.setVerificationDate(this.todaysDate());

        this.reference1.setVerificationStatus(strReference1VerificationStatus);
        this.reference1.setVerificationComment(strReference1VerificationComment);
        this.reference1.setVerificationDate(this.todaysDate());

        this.reference2.setVerificationStatus(strReference2VerificationStatus);
        this.reference2.setVerificationComment(strReference2VerificationComment);
        this.reference2.setVerificationDate(this.todaysDate());

        return this.fom;
    }

    public void getEmployedVerifierDetails(int id) {
        // set verifier details
        for (int i = 0; i < this.employedVerifiersList.size(); i++) {
            if (this.employedVerifiersList.get(i).getId() == id) {
                this.verifier = this.employedVerifiersList.get(i);
            }
        }
    }

    public void getRegisteredVerifierDetails(int id) {
        // set verifier details
        for (int i = 0; i < this.registeredVerifiersList.size(); i++) {
            if (this.registeredVerifiersList.get(i).getId() == id) {
                this.verifier = this.registeredVerifiersList.get(i);
            }
        }

        //set address details
        for (int i = 0; i < this.registeredVerifierAddressList.size(); i++) {
            if (this.registeredVerifierAddressList.get(i).getVerifier().getId() == id) {
                this.address = this.registeredVerifierAddressList.get(i);
            }
        }

        this.address = this.addressDao.getAddress(this.verifier, this.sdVerifierType.getValue());
        this.verifierDistrict = this.address.getDistrict();

        this.image = this.verifier.getImage();
        this.identityDocument = this.identityDocumentDao.getIdentityDocument(this.verifier, this.sdVerifierType.getValue());
        this.bank = this.bankDao.getBank(this.verifier, this.sdVerifierType.getValue());

        List<Reference> r = new ArrayList<Reference>();
        r = this.referenceDao.getReferences(this.verifier, this.sdVerifierType.getValue());
        this.reference1 = r.get(0);
        this.reference2 = r.get(1);
    }

    public List<Fom> getFoms() {
        this.fomList = this.fomDao.getFom();

        return this.fomList;
    }

    public List<Verifier> getEmployedVerifiersWithoutDevice() {
        List<Address> aList = new ArrayList<Address>();
        this.employedVerifiersList.clear();

        this.sdVerifierType = this.staticDataDao.getEmployeeType("Verifier");
        this.sdStatus = this.staticDataDao.getEmploymentStatus("Employed");
        aList = this.addressDao.getAddressByCountryAndRegion(this.verifierCountry, this.verifierRegion, this.sdVerifierType.getValue());

        for (int i = 0; i < aList.size(); i++) {
            if (aList.get(i).getVerifier().getStatus().equals(this.sdStatus.getValue())) {
                if (aList.get(i).getVerifier().getMobileDevice() == null) {
                    this.employedVerifiersList.add(aList.get(i).getVerifier());
                    System.out.println("------------------- adsress list, employed verifier id: " + aList.get(i).getVerifier().getId());
                }
            }
        }

        System.out.println("------------------- employed verifier list size: " + this.employedVerifiersList.size());

        this.employedVerifierAddressList = aList;

        return this.employedVerifiersList;
    }

    public List<Verifier> getRegisteredVerifiers() {
        List<Address> aList = new ArrayList<Address>();
        this.registeredVerifiersList.clear();

        this.sdVerifierType = this.staticDataDao.getEmployeeType("Verifier");
        this.sdStatus = this.staticDataDao.getEmploymentStatus("Registered");
        aList = this.addressDao.getAddressByCountryAndRegion(this.verifierCountry, this.verifierRegion, this.sdVerifierType.getValue());

        for (int i = 0; i < aList.size(); i++) {
            if (aList.get(i).getVerifier().getStatus().equals(this.sdStatus.getValue())) {
                this.registeredVerifiersList.add(aList.get(i).getVerifier());
                System.out.println("------------------- adsress list, registered verifier id: " + aList.get(i).getVerifier().getId());
            }
        }

        System.out.println("------------------- registered verifier list size: " + this.registeredVerifiersList.size());

        this.registeredVerifierAddressList = aList;

        return this.registeredVerifiersList;
    }

    public List<Verifier> isVerifier(String email, String password) {
        StaticData sdPreregistered = new StaticData();
        sdPreregistered = this.staticDataDao.getEmploymentStatus("Preregistered");
        return this.verifierDao.getPreRegisteredVerifierByEmailAndPassword(email, password, sdPreregistered.getValue());
    }

    public Verifier logInVerifier(String email, String password) {
        this.verifierCountry = new Country();
        this.verifierRegion = new Region();
        this.verifierDistrict = new District();
        this.verifier = new Verifier();
        this.address = new Address();
        this.image = new Image();
        this.identityDocument = new IdentityDocument();
        this.bank = new Bank();
        this.reference1 = new Reference();
        this.reference2 = new Reference();

        List<Verifier> verifierList = new ArrayList<Verifier>();
        StaticData sdPreregistered = new StaticData();
        sdPreregistered = this.staticDataDao.getEmploymentStatus("Preregistered");
        verifierList = this.verifierDao.getPreRegisteredVerifierByEmailAndPassword(email, password, sdPreregistered.getValue());

        if (verifierList.isEmpty()) {
            return null;
        } else {
            this.verifier = verifierList.get(0);
            this.sdVerifierType = this.staticDataDao.getEmployeeType("Verifier");

            System.out.println("------------- LogInVerifier in verifierService verifier id: " + verifier.getId());

            if (this.verifier.getImage() != null) {
                this.image = this.verifier.getImage();
            }

            this.address = this.addressDao.getAddress(this.verifier, this.sdVerifierType.getValue());

            if (this.address == null) {
                this.address = new Address();
            } else {
                this.verifierCountry = this.address.getCountry();
                this.verifierRegion = this.address.getRegion();
                this.verifierDistrict = this.address.getDistrict();
            }

            this.identityDocument = this.identityDocumentDao.getIdentityDocument(this.verifier, this.sdVerifierType.getValue());
            if (this.identityDocument == null) {
                this.identityDocument = new IdentityDocument();
            }

            this.bank = this.bankDao.getBank(this.verifier, this.sdVerifierType.getValue());
            if (this.bank == null) {
                this.bank = new Bank();
            }

            System.out.println("------------- LogInVerifier in verifierService before reference verifier id: " + verifier.getId());
            System.out.println("------------- LogInVerifier in verifierService before reference verifier employee type: " + this.sdVerifierType.getValue());
            List<Reference> referenceList = new ArrayList<Reference>();
            referenceList = this.referenceDao.getReferences(this.verifier, this.sdVerifierType.getValue());

            System.out.println("------------- LogInVerifier in verifierService before referenceList size: " + referenceList.size());
            if (!referenceList.isEmpty()) {
                if (referenceList.size() == 2) {
                    this.reference1 = referenceList.get(0);
                    this.reference2 = referenceList.get(1);
                } else {
                    if (referenceList.size() == 1) {
                        this.reference1 = referenceList.get(0);
                    }
                }
            }

            System.out.println("------------------ end of LoginVerifier in verifierService");

            return this.verifier;
        }
    }

    public int preRegisterVerifier(String email, String password) {
        Verifier ver = new Verifier();

        ver.setEmail(email);
        ver.setPassword(password);

        StaticData sdPreregistered = new StaticData();
        sdPreregistered = this.staticDataDao.getEmploymentStatus("Preregistered");
        ver.setStatus(sdPreregistered.getValue());

        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlDate = java.sql.Date.valueOf(dateFmt.format(today));
        System.out.println("------------------------sql date = " + sqlDate);

        ver.setStatusDate(sqlDate);

        ver = this.verifierDao.setVerifier(ver);
        return ver.getId();
    }

    public void save(int page) {
        this.sdAwaitingVerificationType = this.staticDataDao.getVerificationStatus("Awaiting Verification");
        this.sdStatus = this.staticDataDao.getEmploymentStatus("Preregistered");

        // save verifier personal, address and image details
        if (page == 4) {
            this.image.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveImage();
            this.verifier.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveVerifier();
            this.address.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveAddress();
        }

        //save verifier identity document, personal, address and image details
        if (page == 5) {
            this.image.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveImage();
            this.verifier.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveVerifier();
            this.address.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveAddress();
            this.identityDocument.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveIdentityDocument();
        }

        // save verifier bank, personal, address and image details
        if (page == 6) {
            this.image.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveImage();
            this.verifier.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveVerifier();
            this.address.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveAddress();
            this.identityDocument.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveIdentityDocument();
            this.bank.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveBank();
        }

        //save verifier reference, personal, bank, address and image details
        if (page == 7) {
            this.image.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveImage();
            this.verifier.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveVerifier();
            this.address.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveAddress();
            this.identityDocument.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveIdentityDocument();
            this.bank.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveBank();
            this.reference1.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            //this.reference2.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveReference1();
        }

        if (page == 10) {
            this.image.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveImage();
            this.verifier.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveVerifier();
            this.address.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveAddress();
            this.identityDocument.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveIdentityDocument();
            this.bank.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveBank();
            this.reference1.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveReference1();
            this.reference2.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            this.saveReference2();
        }
    }

    public java.sql.Date todaysDate() {
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlDate = java.sql.Date.valueOf(dateFmt.format(today));
        System.out.println("------------------------sql date = " + sqlDate);
        return sqlDate;
    }

    public void saveImage() {
        System.out.println("------------------------save image = " + this.image);

        this.image.setVerificationDate(this.todaysDate());
        this.image.setEmployeeType(this.sdVerifierType.getValue());

        //this.image.setId(1);
        this.image = this.imageDao.saveImage(image);
    }

    public void saveVerifier() {
        this.verifier.setStatus(this.sdStatus.getValue());
        this.verifier.setStatusDate(this.todaysDate());

        this.verifier.setVerificationDate(this.todaysDate());
        this.verifier.setImage(this.image);

        this.verifier = this.verifierDao.setVerifier(verifier);
    }

    public void saveAddress() {
        this.address.setVerificationDate(this.todaysDate());
        this.address.setEmployeeType(this.sdVerifierType.getValue());
        this.address.setVerifier(this.verifier);

        System.out.println("----------- save address, address country id: " + address.getCountry().getId());
        this.address = this.addressDao.saveAddress(this.address);
    }

    public void saveIdentityDocument() {
        this.identityDocument.setVerificationDate(this.todaysDate());
        this.identityDocument.setEmployeeType(this.sdVerifierType.getValue());
        this.identityDocument.setVerifier(this.verifier);

        this.identityDocument = this.identityDocumentDao.saveIdentityDocument(this.identityDocument);
    }

    public void saveInterview() {
        this.sdInterviewStatus = this.staticDataDao.getInterviewStatus("Awaiting Arrangement");
        this.sdVerifierType = this.staticDataDao.getEmployeeType("Verifier");
        this.interview.setFom(fom);
        this.interview.setVerifier(verifier);
        this.interview.setStatus(this.sdInterviewStatus.getValue());
        this.interview.setEmployeeType(this.sdVerifierType.getValue());

        this.interview = this.interviewDao.saveInterview(this.interview);
    }

    public void saveBank() {
        this.bank.setVerificationDate(this.todaysDate());
        this.bank.setEmployeeType(this.sdVerifierType.getValue());
        this.bank.setVerifier(this.verifier);

        this.bank = this.bankDao.saveBank(this.bank);
    }

    public void saveReference1() {
        this.reference1.setVerificationDate(this.todaysDate());
        this.reference1.setEmployeeType(this.sdVerifierType.getValue());
        this.reference1.setVerifier(this.verifier);

        this.reference1 = this.referenceDao.saveReference(this.reference1);
    }

    public void saveReference2() {
        this.reference2.setVerificationDate(this.todaysDate());
        this.reference2.setEmployeeType(this.sdVerifierType.getValue());
        this.reference2.setVerifier(this.verifier);

        this.reference2 = this.referenceDao.saveReference(this.reference2);
    }

    public Interview verifyVerifier() {
        this.saveImage();
        this.saveVerifier();
        this.saveAddress();
        this.saveIdentityDocument();
        this.saveBank();
        this.saveReference1();
        this.saveReference2();
        this.saveInterview();

        return interview;
    }

    public void saveVerifyVerifier() {
        this.saveImage();
        this.saveVerifier();
        this.saveAddress();
        this.saveIdentityDocument();
        this.saveBank();
        this.saveReference1();
        this.saveReference2();
    }

    public Verifier registerVerifier() {
        this.sdAwaitingVerificationType = this.staticDataDao.getVerificationStatus("Awaiting Verification");

        this.image.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
        this.saveImage();

        this.sdStatus = this.staticDataDao.getEmploymentStatus("Registered");

        this.verifier.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
        this.saveVerifier();
        this.address.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
        this.saveAddress();
        this.identityDocument.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
        this.saveIdentityDocument();
        this.bank.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
        this.saveBank();
        this.reference1.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
        this.saveReference1();
        this.reference2.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
        this.saveReference2();

        return verifier;
    }

    public void setVerifierDetails(String strFirstName,
            String strMiddleName,
            String strLastName,
            String strGender,
            java.sql.Date sqlDob,
            String strTelephoneNumber,
            String strEducationLevel,
            String strEducationType) {
        this.verifier.setFirstName(strFirstName);
        this.verifier.setMiddleName(strMiddleName);
        this.verifier.setLastName(strLastName);
        this.verifier.setGender(strGender);
        this.verifier.setDob(sqlDob);

        this.verifier.setTelephoneNumber(strTelephoneNumber);
        this.verifier.setEducationLevel(strEducationLevel);
        this.verifier.setEducationType(strEducationType);
    }

    public void setIdentityDocumentDetails(String strType,
            String strNumber,
            java.sql.Date sqlIssueDate,
            java.sql.Date sqlExpiryDate) {
        this.identityDocument.setType(strType);
        this.identityDocument.setNumber(strNumber);
        this.identityDocument.setIssueDate(sqlIssueDate);
        this.identityDocument.setExpiryDate(sqlExpiryDate);
    }

    public void setBankDetails(String strAccountNumber,
            String strBankName,
            String strBankContactNumber,
            String strBankAddress,
            String strBankSortCode,
            String strBankIban) {
        this.bank.setAccountNumber(strAccountNumber);
        this.bank.setBankName(strBankName);
        this.bank.setContactNumber(strBankContactNumber);
        this.bank.setAddress(strBankAddress);
        this.bank.setSortcode(strBankSortCode);
        this.bank.setIban(strBankIban);
    }

    public void setReference1Details(String strReference1Title,
            String strReference1FullName,
            String strReference1OrganisationName,
            String strReference1Designation,
            String strReference1ContactNumber,
            String strReference1Email,
            String strReference1Address) {
        this.reference1.setTitle(strReference1Title);
        this.reference1.setFullName(strReference1FullName);
        this.reference1.setOrganisationName(strReference1OrganisationName);
        this.reference1.setDesignation(strReference1Designation);
        this.reference1.setContactNumber(strReference1ContactNumber);
        this.reference1.setEmail(strReference1Email);
        this.reference1.setAddress(strReference1Address);
    }

    public void setReference2Details(String strReference2Title,
            String strReference2FullName,
            String strReference2OrganisationName,
            String strReference2Designation,
            String strReference2ContactNumber,
            String strReference2Email,
            String strReference2Address) {
        this.reference2.setTitle(strReference2Title);
        this.reference2.setFullName(strReference2FullName);
        this.reference2.setOrganisationName(strReference2OrganisationName);
        this.reference2.setDesignation(strReference2Designation);
        this.reference2.setContactNumber(strReference2ContactNumber);
        this.reference2.setEmail(strReference2Email);
        this.reference2.setAddress(strReference2Address);
    }

    public void setAddressDetails(String strStreet,
            String strVillage,
            String strPostcode,
            String strTown,
            String strCity) {
        this.address.setStreet(strStreet);
        this.address.setVillage(strVillage);
        this.address.setPostcode(strPostcode);
        this.address.setTown(strTown);
        this.address.setCity(strCity);
        this.address.setDistrict(this.verifierDistrict);
        this.address.setRegion(this.verifierRegion);
        this.address.setCountry(this.verifierCountry);
    }

    public void setImageDetails(MultipartFile mFile) {
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlDate = java.sql.Date.valueOf(dateFmt.format(today));
        System.out.println("------------------------sql date = " + sqlDate);

        this.image.setDate(sqlDate);
        System.out.println("------------------------verifier service set image details mFile: = " + mFile);

        byte[] bFile = new byte[(int) mFile.getSize()];

        try {
            mFile.getInputStream().read(bFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < bFile.length; i++) {
            System.out.println("------------------------------- bFile: " + bFile[i]);
        }

        this.image.setPhoto(bFile);
    }

    public List<StaticData> getVerificationStatusList() {
        return this.staticDataDao.getVerificationStatusTypes();
    }

    public List<StaticData> getIdentityDocumentTypeList() {
        return this.staticDataDao.getIdentityDocumentTypes();
    }

    public List<StaticData> getTitleList() {
        return this.staticDataDao.getTitles();
    }

    public List<StaticData> getGenderList() {
        return this.staticDataDao.getGenders();
    }

    public List<StaticData> getEducationLevelList() {
        return this.staticDataDao.getEducationLevels();
    }

    public List<StaticData> getEducationTypeList() {
        return this.staticDataDao.getEducationTypes();
    }

    public List<Country> getCountryList() {
        this.countryList = this.countryDao.getCountries();
        return countryList;
    }

    public List<Device> getUnallocatedDeviceList() {
        StaticData deviceAllocation = this.staticDataDao.getDeviceAllocation("No");
        this.deviceList = this.deviceDao.getDevicesByAllocation(deviceAllocation.getValue());

        return this.deviceList;
    }

    public List<Region> getRegionList(/*Country c*/) {
        System.out.println("---------------- verifier country: " + this.verifierCountry.getDescription());
        this.regionList = this.regionDao.getRegions(this.verifierCountry);
        return regionList;
    }

    public List<District> getDistrictList() {
        System.out.println("---------------- verifier region: " + this.verifierRegion.getDescription());
        this.districtList = this.districtDao.getDistricts(this.verifierRegion);
        return districtList;
    }

    public Device setVerifierDevice(long imei) {
        for (int i = 0; i < this.deviceList.size(); i++) {
            if (imei == this.deviceList.get(i).getImei()) {
                this.verifierDevice = this.deviceList.get(i);
            }
        }

        return this.verifierDevice;
    }

    public Country setVerifierCountry(int id) {
        for (int i = 0; i < this.countryList.size(); i++) {
            if (id == this.countryList.get(i).getId()) {
                this.verifierCountry = this.countryList.get(i);
            }
        }

        return this.verifierCountry;
    }

    public Region setVerifierRegion(int idRegion) {
        System.out.println("---------------- verifier region id: " + idRegion);
        for (int i = 0; i < this.regionList.size(); i++) {
            if (idRegion == this.regionList.get(i).getId()) {
                this.verifierRegion = this.regionList.get(i);
            }
        }

        return this.verifierRegion;
    }

    public District setVerifierDistrict(int idDistrict) {
        System.out.println("---------------- verifier district id: " + idDistrict);
        for (int i = 0; i < this.districtList.size(); i++) {
            if (idDistrict == this.districtList.get(i).getId()) {
                this.verifierDistrict = this.districtList.get(i);
            }
        }

        return this.verifierDistrict;
    }

    public boolean checkEmail(String email) {
        return this.verifierDao.getVerifierByEmail(email);
    }

    public java.sql.Date getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlDate = java.sql.Date.valueOf(dateFmt.format(today));
        System.out.println("------------------------sql date = " + sqlDate);

        return sqlDate;
    }

    public List<Bank> isBankAccountRegistered(String account) {
        List<Bank> bankList = new ArrayList<Bank>();
        bankList = this.bankDao.getBankByAccountNumber(account);

        return bankList;
    }
}
