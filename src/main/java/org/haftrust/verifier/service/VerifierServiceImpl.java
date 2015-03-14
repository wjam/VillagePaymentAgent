package org.haftrust.verifier.service;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class VerifierServiceImpl implements VerifierService {

    private static final Logger LOG = LoggerFactory.getLogger(VerifierServiceImpl.class);

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
        StaticData deviceAllocation = staticDataDao.getDeviceAllocation("Yes");

        verifierDevice.setAllocation(deviceAllocation.getValue());
        verifierDevice.setAllocationDate(todaysDate());
        deviceDao.saveDevice(verifierDevice);

        verifier.setMobileDevice(verifierDevice);
        verifier = verifierDao.setVerifier(verifier);
    }

    public void failVerification(String strVerifierVerificationComment) {
        sdStatus = staticDataDao.getEmploymentStatus("Failed");
        //this.verifier.setStatus(this.sdStatus.getValue());
        verifier.setVerificationComment(strVerifierVerificationComment);
        //this.verifier.setStatusDate(this.todaysDate());

        saveVerifier();
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
            sdStatus = staticDataDao.getEmploymentStatus("Verified");
            verifier.setStatus(sdStatus.getValue());

            for (Fom aFomList : fomList) {
                if (idFom == aFomList.getId()) {
                    fom = aFomList;
                }
            }
        }

        verifier.setVerificationStatus(strVerifierVerificationStatus);
        verifier.setVerificationComment(strVerifierVerificationComment);
        verifier.setVerificationDate(todaysDate());
        verifier.setStatusDate(todaysDate());

        address.setVerificationStatus(strAddressVerificationStatus);
        address.setVerificationComment(strAddressVerificationComment);
        address.setVerificationDate(todaysDate());

        image.setVerificationStatus(strImageVerificationStatus);
        image.setVerificationComment(strImageVerificationComment);
        image.setVerificationDate(todaysDate());

        identityDocument.setVerificationStatus(strIdentityDocumentVerificationStatus);
        identityDocument.setVerificationComment(strIdentityDocumentVerificationComment);
        identityDocument.setVerificationDate(todaysDate());

        bank.setVerificationStatus(strBankVerificationStatus);
        bank.setVerificationComment(strBankVerificationComment);
        bank.setVerificationDate(todaysDate());

        reference1.setVerificationStatus(strReference1VerificationStatus);
        reference1.setVerificationComment(strReference1VerificationComment);
        reference1.setVerificationDate(todaysDate());

        reference2.setVerificationStatus(strReference2VerificationStatus);
        reference2.setVerificationComment(strReference2VerificationComment);
        reference2.setVerificationDate(todaysDate());

        return fom;
    }

    public void getEmployedVerifierDetails(int id) {
        // set verifier details
        for (Verifier anEmployedVerifiersList : employedVerifiersList) {
            if (anEmployedVerifiersList.getId() == id) {
                verifier = anEmployedVerifiersList;
            }
        }
    }

    public void getRegisteredVerifierDetails(int id) {
        // set verifier details
        for (Verifier aRegisteredVerifiersList : registeredVerifiersList) {
            if (aRegisteredVerifiersList.getId() == id) {
                verifier = aRegisteredVerifiersList;
            }
        }

        //set address details
        for (Address aRegisteredVerifierAddressList : registeredVerifierAddressList) {
            if (aRegisteredVerifierAddressList.getVerifier().getId() == id) {
                address = aRegisteredVerifierAddressList;
            }
        }

        address = addressDao.getAddress(verifier, sdVerifierType.getValue());
        verifierDistrict = address.getDistrict();

        image = verifier.getImage();
        identityDocument = identityDocumentDao.getIdentityDocument(verifier, sdVerifierType.getValue());
        bank = bankDao.getBank(verifier, sdVerifierType.getValue());

        List<Reference> r = referenceDao.getReferences(verifier, sdVerifierType.getValue());
        reference1 = r.get(0);
        reference2 = r.get(1);
    }

    public List<Fom> getFoms() {
        fomList = fomDao.getFom();

        return fomList;
    }

    public List<Verifier> getEmployedVerifiersWithoutDevice() {
        List<Address> aList;

        sdVerifierType = staticDataDao.getEmployeeType("Verifier");
        sdStatus = staticDataDao.getVerificationStatus("Verified");
        aList = addressDao.getAddressByCountryAndRegion(verifierCountry, verifierRegion, sdVerifierType.getValue());

        employedVerifiersList = aList.stream()
                .filter(a -> a.getVerifier().getStatus().equals(sdStatus.getValue()))
                .filter(a -> a.getVerifier().getMobileDevice() == null)
                .map(Address::getVerifier)
                .collect(toList());

        LOG.debug("------------------- employed verifier list size: {}", employedVerifiersList.size());

        employedVerifierAddressList = aList;

        return employedVerifiersList;
    }

    public List<Verifier> getRegisteredVerifiers() {
        List<Address> aList = new ArrayList<Address>();
        registeredVerifiersList.clear();

        sdVerifierType = staticDataDao.getEmployeeType("Verifier");
        sdStatus = staticDataDao.getEmploymentStatus("Registered");
        aList = addressDao.getAddressByCountryAndRegion(verifierCountry, verifierRegion, sdVerifierType.getValue());

        for (int i = 0; i < aList.size(); i++) {
            if (aList.get(i).getVerifier().getStatus().equals(sdStatus.getValue())) {
                registeredVerifiersList.add(aList.get(i).getVerifier());
                LOG.debug("------------------- adsress list, registered verifier id: {}",
                          aList.get(i).getVerifier().getId());
            }
        }

        LOG.debug("------------------- registered verifier list size: {}", registeredVerifiersList.size());

        registeredVerifierAddressList = aList;

        return registeredVerifiersList;
    }

    public List<Verifier> isVerifier(String email, String password) {
        StaticData sdPreregistered = new StaticData();
        sdPreregistered = staticDataDao.getEmploymentStatus("Preregistered");
        return verifierDao.getPreRegisteredVerifierByEmailAndPassword(email, password, sdPreregistered.getValue());
    }

    public Verifier logInVerifier(String email, String password) {
        verifierCountry = new Country();
        verifierRegion = new Region();
        verifierDistrict = new District();
        verifier = new Verifier();
        address = new Address();
        image = new Image();
        identityDocument = new IdentityDocument();
        bank = new Bank();
        reference1 = new Reference();
        reference2 = new Reference();

        List<Verifier> verifierList = new ArrayList<Verifier>();
        StaticData sdPreregistered = new StaticData();
        sdPreregistered = staticDataDao.getEmploymentStatus("Preregistered");
        verifierList = verifierDao.getPreRegisteredVerifierByEmailAndPassword(email, password,
                                                                              sdPreregistered.getValue());

        if (verifierList.isEmpty()) {
            return null;
        }
        else {
            verifier = verifierList.get(0);
            sdVerifierType = staticDataDao.getEmployeeType("Verifier");

            LOG.debug("------------- LogInVerifier in verifierService verifier id: {}", verifier.getId());

            if (verifier.getImage() != null) {
                image = verifier.getImage();
            }

            address = addressDao.getAddress(verifier, sdVerifierType.getValue());

            if (address == null) {
                address = new Address();
            }
            else {
                verifierCountry = address.getCountry();
                verifierRegion = address.getRegion();
                verifierDistrict = address.getDistrict();
            }

            identityDocument = identityDocumentDao.getIdentityDocument(verifier, sdVerifierType.getValue());
            if (identityDocument == null) {
                identityDocument = new IdentityDocument();
            }

            bank = bankDao.getBank(verifier, sdVerifierType.getValue());
            if (bank == null) {
                bank = new Bank();
            }

            LOG.debug("------------- LogInVerifier in verifierService before reference verifier id: {}",
                      verifier.getId());
            LOG.debug("------------- LogInVerifier in verifierService before reference verifier employee type: {}",
                      sdVerifierType.getValue());
            List<Reference> referenceList = new ArrayList<Reference>();
            referenceList = referenceDao.getReferences(verifier, sdVerifierType.getValue());

            LOG.debug("------------- LogInVerifier in verifierService before referenceList size: {}",
                      referenceList.size());
            if (!referenceList.isEmpty()) {
                if (referenceList.size() == 2) {
                    reference1 = referenceList.get(0);
                    reference2 = referenceList.get(1);
                }
                else {
                    if (referenceList.size() == 1) {
                        reference1 = referenceList.get(0);
                    }
                }
            }

            LOG.debug("------------------ end of LoginVerifier in verifierService");

            return verifier;
        }
    }

    public int preRegisterVerifier(String email, String password) {
        Verifier ver = new Verifier();

        ver.setEmail(email);
        ver.setPassword(password);

        StaticData sdPreregistered = new StaticData();
        sdPreregistered = staticDataDao.getEmploymentStatus("Preregistered");
        ver.setStatus(sdPreregistered.getValue());

        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlDate = java.sql.Date.valueOf(dateFmt.format(today));
        LOG.debug("------------------------sql date = {}", sqlDate);

        ver.setStatusDate(sqlDate);

        ver = verifierDao.setVerifier(ver);
        return ver.getId();
    }

    public void save(int page) {
        sdAwaitingVerificationType = staticDataDao.getVerificationStatus("Awaiting Verification");
        sdStatus = staticDataDao.getEmploymentStatus("Preregistered");

        // save verifier personal, address and image details
        if (page == 4) {
            image.setVerificationStatus(sdAwaitingVerificationType.getValue());
            saveImage();
            verifier.setVerificationStatus(sdAwaitingVerificationType.getValue());
            saveVerifier();
            address.setVerificationStatus(sdAwaitingVerificationType.getValue());
            saveAddress();
        }

        //save verifier identity document, personal, address and image details
        if (page == 5) {
            image.setVerificationStatus(sdAwaitingVerificationType.getValue());
            saveImage();
            verifier.setVerificationStatus(sdAwaitingVerificationType.getValue());
            saveVerifier();
            address.setVerificationStatus(sdAwaitingVerificationType.getValue());
            saveAddress();
            identityDocument.setVerificationStatus(sdAwaitingVerificationType.getValue());
            saveIdentityDocument();
        }

        // save verifier bank, personal, address and image details
        if (page == 6) {
            image.setVerificationStatus(sdAwaitingVerificationType.getValue());
            saveImage();
            verifier.setVerificationStatus(sdAwaitingVerificationType.getValue());
            saveVerifier();
            address.setVerificationStatus(sdAwaitingVerificationType.getValue());
            saveAddress();
            identityDocument.setVerificationStatus(sdAwaitingVerificationType.getValue());
            saveIdentityDocument();
            bank.setVerificationStatus(sdAwaitingVerificationType.getValue());
            saveBank();
        }

        //save verifier reference, personal, bank, address and image details
        if (page == 7) {
            image.setVerificationStatus(sdAwaitingVerificationType.getValue());
            saveImage();
            verifier.setVerificationStatus(sdAwaitingVerificationType.getValue());
            saveVerifier();
            address.setVerificationStatus(sdAwaitingVerificationType.getValue());
            saveAddress();
            identityDocument.setVerificationStatus(sdAwaitingVerificationType.getValue());
            saveIdentityDocument();
            bank.setVerificationStatus(sdAwaitingVerificationType.getValue());
            saveBank();
            reference1.setVerificationStatus(sdAwaitingVerificationType.getValue());
            //this.reference2.setVerificationStatus(this.sdAwaitingVerificationType.getValue());
            saveReference1();
        }

        if (page == 10) {
            image.setVerificationStatus(sdAwaitingVerificationType.getValue());
            saveImage();
            verifier.setVerificationStatus(sdAwaitingVerificationType.getValue());
            saveVerifier();
            address.setVerificationStatus(sdAwaitingVerificationType.getValue());
            saveAddress();
            identityDocument.setVerificationStatus(sdAwaitingVerificationType.getValue());
            saveIdentityDocument();
            bank.setVerificationStatus(sdAwaitingVerificationType.getValue());
            saveBank();
            reference1.setVerificationStatus(sdAwaitingVerificationType.getValue());
            saveReference1();
            reference2.setVerificationStatus(sdAwaitingVerificationType.getValue());
            saveReference2();
        }
    }

    public void saveImage() {
        LOG.debug("------------------------save image = {}", image);

        image.setVerificationDate(todaysDate());
        image.setEmployeeType(sdVerifierType.getValue());

        //this.image.setId(1);
        image = imageDao.saveImage(image);
    }

    public void saveVerifier() {
        verifier.setStatus(sdStatus.getValue());
        verifier.setStatusDate(todaysDate());

        verifier.setVerificationDate(todaysDate());
        verifier.setImage(image);

        verifier = verifierDao.setVerifier(verifier);
    }

    public void saveAddress() {
        address.setVerificationDate(todaysDate());
        address.setEmployeeType(sdVerifierType.getValue());
        address.setVerifier(verifier);

        LOG.debug("----------- save address, address country id: {}", address.getCountry().getId());
        address = addressDao.saveAddress(address);
    }

    public void saveIdentityDocument() {
        identityDocument.setVerificationDate(todaysDate());
        identityDocument.setEmployeeType(sdVerifierType.getValue());
        identityDocument.setVerifier(verifier);

        identityDocument = identityDocumentDao.saveIdentityDocument(identityDocument);
    }

    public void saveInterview() {
        sdInterviewStatus = staticDataDao.getInterviewStatus("Awaiting Arrangement");
        sdVerifierType = staticDataDao.getEmployeeType("Verifier");
        interview.setFom(fom);
        interview.setVerifier(verifier);
        interview.setStatus(sdInterviewStatus.getValue());
        interview.setEmployeeType(sdVerifierType.getValue());

        interview = interviewDao.saveInterview(interview);
    }

    public void saveBank() {
        bank.setVerificationDate(todaysDate());
        bank.setEmployeeType(sdVerifierType.getValue());
        bank.setVerifier(verifier);

        bank = bankDao.saveBank(bank);
    }

    public void saveReference1() {
        reference1.setVerificationDate(todaysDate());
        reference1.setEmployeeType(sdVerifierType.getValue());
        reference1.setVerifier(verifier);

        reference1 = referenceDao.saveReference(reference1);
    }

    public void saveReference2() {
        reference2.setVerificationDate(todaysDate());
        reference2.setEmployeeType(sdVerifierType.getValue());
        reference2.setVerifier(verifier);

        reference2 = referenceDao.saveReference(reference2);
    }

    public Interview verifyVerifier() {
        saveImage();
        saveVerifier();
        saveAddress();
        saveIdentityDocument();
        saveBank();
        saveReference1();
        saveReference2();
        saveInterview();

        return interview;
    }

    public void saveVerifyVerifier() {
        saveImage();
        saveVerifier();
        saveAddress();
        saveIdentityDocument();
        saveBank();
        saveReference1();
        saveReference2();
    }

    public Verifier registerVerifier() {
        sdAwaitingVerificationType = staticDataDao.getVerificationStatus("Awaiting Verification");

        image.setVerificationStatus(sdAwaitingVerificationType.getValue());
        saveImage();

        sdStatus = staticDataDao.getEmploymentStatus("Registered");

        verifier.setVerificationStatus(sdAwaitingVerificationType.getValue());
        saveVerifier();
        address.setVerificationStatus(sdAwaitingVerificationType.getValue());
        saveAddress();
        identityDocument.setVerificationStatus(sdAwaitingVerificationType.getValue());
        saveIdentityDocument();
        bank.setVerificationStatus(sdAwaitingVerificationType.getValue());
        saveBank();
        reference1.setVerificationStatus(sdAwaitingVerificationType.getValue());
        saveReference1();
        reference2.setVerificationStatus(sdAwaitingVerificationType.getValue());
        saveReference2();

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
        verifier.setFirstName(strFirstName);
        verifier.setMiddleName(strMiddleName);
        verifier.setLastName(strLastName);
        verifier.setGender(strGender);
        verifier.setDob(sqlDob);

        verifier.setTelephoneNumber(strTelephoneNumber);
        verifier.setEducationLevel(strEducationLevel);
        verifier.setEducationType(strEducationType);
    }

    public void setIdentityDocumentDetails(String strType,
                                           String strNumber,
                                           java.sql.Date sqlIssueDate,
                                           java.sql.Date sqlExpiryDate) {
        identityDocument.setType(strType);
        identityDocument.setNumber(strNumber);
        identityDocument.setIssueDate(sqlIssueDate);
        identityDocument.setExpiryDate(sqlExpiryDate);
    }

    public void setBankDetails(String strAccountNumber,
                               String strBankName,
                               String strBankContactNumber,
                               String strBankAddress,
                               String strBankSortCode,
                               String strBankIban) {
        bank.setAccountNumber(strAccountNumber);
        bank.setBankName(strBankName);
        bank.setContactNumber(strBankContactNumber);
        bank.setAddress(strBankAddress);
        bank.setSortcode(strBankSortCode);
        bank.setIban(strBankIban);
    }

    public void setReference1Details(String strReference1Title,
                                     String strReference1FullName,
                                     String strReference1OrganisationName,
                                     String strReference1Designation,
                                     String strReference1ContactNumber,
                                     String strReference1Email,
                                     String strReference1Address) {
        reference1.setTitle(strReference1Title);
        reference1.setFullName(strReference1FullName);
        reference1.setOrganisationName(strReference1OrganisationName);
        reference1.setDesignation(strReference1Designation);
        reference1.setContactNumber(strReference1ContactNumber);
        reference1.setEmail(strReference1Email);
        reference1.setAddress(strReference1Address);
    }

    public void setReference2Details(String strReference2Title,
                                     String strReference2FullName,
                                     String strReference2OrganisationName,
                                     String strReference2Designation,
                                     String strReference2ContactNumber,
                                     String strReference2Email,
                                     String strReference2Address) {
        reference2.setTitle(strReference2Title);
        reference2.setFullName(strReference2FullName);
        reference2.setOrganisationName(strReference2OrganisationName);
        reference2.setDesignation(strReference2Designation);
        reference2.setContactNumber(strReference2ContactNumber);
        reference2.setEmail(strReference2Email);
        reference2.setAddress(strReference2Address);
    }

    public void setAddressDetails(String strStreet,
                                  String strVillage,
                                  String strPostcode,
                                  String strTown,
                                  String strCity) {
        address.setStreet(strStreet);
        address.setVillage(strVillage);
        address.setPostcode(strPostcode);
        address.setTown(strTown);
        address.setCity(strCity);
        address.setDistrict(verifierDistrict);
        address.setRegion(verifierRegion);
        address.setCountry(verifierCountry);
    }

    public void setImageDetails(MultipartFile mFile) {

        image.setDate(todaysDate());

        byte[] bFile = new byte[(int)mFile.getSize()];

        try {
            mFile.getInputStream().read(bFile);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        image.setPhoto(bFile);
    }

    public List<StaticData> getVerificationStatusList() {
        return staticDataDao.getVerificationStatusTypes();
    }

    public List<StaticData> getIdentityDocumentTypeList() {
        return staticDataDao.getIdentityDocumentTypes();
    }

    public List<StaticData> getTitleList() {
        return staticDataDao.getTitles();
    }

    public List<StaticData> getGenderList() {
        return staticDataDao.getGenders();
    }

    public List<StaticData> getEducationLevelList() {
        return staticDataDao.getEducationLevels();
    }

    public List<StaticData> getEducationTypeList() {
        return staticDataDao.getEducationTypes();
    }

    public List<Country> getCountryList() {
        countryList = countryDao.getCountries();
        return countryList;
    }

    public List<Device> getUnallocatedDeviceList() {
        StaticData deviceAllocation = staticDataDao.getDeviceAllocation("No");
        deviceList = deviceDao.getDevicesByAllocation(deviceAllocation.getValue());

        return deviceList;
    }

    public List<Region> getRegionList() {
        regionList = regionDao.getRegions(verifierCountry);
        return regionList;
    }

    public List<District> getDistrictList() {
        LOG.debug("---------------- verifier region: {}", verifierRegion.getDescription());
        districtList = districtDao.getDistricts(verifierRegion);
        return districtList;
    }

    public Device setVerifierDevice(long imei) {
        for (Device aDeviceList : deviceList) {
            if (imei == aDeviceList.getImei()) {
                verifierDevice = aDeviceList;
            }
        }

        return verifierDevice;
    }

    public Country setVerifierCountry(int id) {
        for (Country aCountryList : countryList) {
            if (id == aCountryList.getId()) {
                verifierCountry = aCountryList;
            }
        }

        return verifierCountry;
    }

    public Region setVerifierRegion(int idRegion) {
        LOG.debug("---------------- verifier region id: {}", idRegion);
        for (Region aRegionList : regionList) {
            if (idRegion == aRegionList.getId()) {
                verifierRegion = aRegionList;
            }
        }

        return verifierRegion;
    }

    public District setVerifierDistrict(int idDistrict) {
        LOG.debug("---------------- verifier district id: {}", idDistrict);
        for (District aDistrictList : districtList) {
            if (idDistrict == aDistrictList.getId()) {
                verifierDistrict = aDistrictList;
            }
        }

        return verifierDistrict;
    }

    public boolean checkEmail(String email) {
        return verifierDao.getVerifierByEmail(email);
    }

    public List<Bank> getBanksWhereAccountIsRegistered(String account) {
        return bankDao.getBankByAccountNumber(account);
    }

    private static java.sql.Date todaysDate() {
        return java.sql.Date.valueOf(LocalDate.now());
    }

}
