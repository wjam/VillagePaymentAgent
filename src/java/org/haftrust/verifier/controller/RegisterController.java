/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.haftrust.verifier.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.haftrust.verifier.model.Address;
import org.haftrust.verifier.model.Bank;
import org.haftrust.verifier.model.IdentityDocument;
import org.haftrust.verifier.model.Reference;
import org.haftrust.verifier.model.Verifier;
import org.haftrust.verifier.service.VerifierService;
import org.haftrust.verifier.view.RegisterVerifierBean;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

/**
 *
 * @author Miroslav
 */
public class RegisterController extends AbstractWizardFormController
{
    private VerifierService verifierService;
    private String successView;
    private String cancelView;
    private String saveView;

    public String getSaveView() {
        return saveView;
    }

    public void setSaveView(String saveView) {
        this.saveView = saveView;
    }

    public String getCancelView() {
        return cancelView;
    }

    public void setCancelView(String cancelView) {
        this.cancelView = cancelView;
    }

    public String getSuccessView() {
        return successView;
    }

    public void setSuccessView(String successView) {
        this.successView = successView;
    }

    public VerifierService getVerifierService() {
        return verifierService;
    }

    public void setVerifierService(VerifierService verifierService) {
        this.verifierService = verifierService;
    }

    protected Map referenceData(HttpServletRequest request, Object command, Errors errors, int page) throws Exception
    {
        Map<Object, Object> dataMap = new HashMap<Object, Object>();
        RegisterVerifierBean rvBean = (RegisterVerifierBean) command;

        if(page == 1)
        {
            dataMap.put("countryList", this.verifierService.getCountryList());
            System.out.println("------------------------ controller register verifier reference data country list");

            Verifier verifier = new Verifier();
            verifier = this.verifierService.logInVerifier(rvBean.getEmail(), rvBean.getPassword());
            rvBean.setVerifier(verifier);
            rvBean.setFirstName(verifier.getFirstName());
            System.out.println("----------------------- rvBean frst name: " + rvBean.getFirstName());
            rvBean.setMiddleName(verifier.getMiddleName());
            rvBean.setLastName(verifier.getLastName());
            rvBean.setGender(verifier.getGender());
            if(verifier.getDob() != null)
            {
                String date;
                date = verifier.getDob().toString();
                int year = 0;
                int month = 0;
                int day = 0;
                String[] strSplit =  date.split("-");
                day = Integer.parseInt(strSplit[2]);
                month = Integer.parseInt(strSplit[1]);
                year = Integer.parseInt(strSplit[0]);
                date = Integer.toString(day) + "-" + Integer.toString(month) + "-" + Integer.toString(year);

                rvBean.setDob(date);
            }
            rvBean.setEmail(verifier.getEmail());
            System.out.println("--------------------register verifier controller post process page verifier email: " + rvBean.getEmail());
            rvBean.setTelephoneNumber(verifier.getTelephoneNumber());
            rvBean.setEducationType(verifier.getEducationType());
            rvBean.setEducationLevel(verifier.getEducationLevel());
            rvBean.setIdVerifier(verifier.getId());
            if(verifier.getImage() != null)
            {
                rvBean.setImage(verifier.getImage());
            }
            System.out.println("---------------- login verifier id: " + rvBean.getVerifier().getId());

            Address address = new Address();
            address = this.verifierService.getAddress();
            rvBean.setStreet(address.getStreet());
            System.out.println("----------------------- rvBean street: " + rvBean.getStreet());
            rvBean.setVillage(address.getVillage());
            rvBean.setPostcode(address.getPostcode());
            rvBean.setTown(address.getTown());
            rvBean.setCity(address.getCity());
            if(address.getDistrict() != null)
            {
                rvBean.setDistrict(address.getDistrict());
                rvBean.setIdDistrict(address.getDistrict().getId());
            }
            if(address.getRegion() != null)
            {
                rvBean.setRegion(address.getRegion());
                rvBean.setIdRegion(address.getRegion().getId());
            }
            if(address.getCountry() != null)
            {
                rvBean.setCountry(address.getCountry());
                rvBean.setIdCountry(address.getCountry().getId());
            }

            Bank bank = new Bank();
            bank = this.verifierService.getBank();
            rvBean.setBankAccountNumber(bank.getAccountNumber());
            rvBean.setBankName(bank.getBankName());
            System.out.println("----------------------- rvBean bank name: " + rvBean.getBankName());
            rvBean.setBankContactNumber(bank.getContactNumber());
            rvBean.setBankAddress(bank.getAddress());
            rvBean.setBankSortCode(bank.getSortcode());
            rvBean.setBankIban(bank.getIban());

            Reference reference1 = new Reference();
            reference1 = this.verifierService.getReference1();
            rvBean.setReference1Title(reference1.getTitle());
            rvBean.setReference1FullName(reference1.getFullName());
            System.out.println("----------------------- rvBean reference 1 full name: " + rvBean.getReference1FullName());
            rvBean.setReference1OrganisationName(reference1.getOrganisationName());
            rvBean.setReference1Designation(reference1.getDesignation());
            rvBean.setReference1ContactNumber(reference1.getContactNumber());
            rvBean.setReference1Email(reference1.getEmail());
            rvBean.setReference1Address(reference1.getAddress());

            Reference reference2 = new Reference();
            reference2 = this.verifierService.getReference2();
            rvBean.setReference2Title(reference2.getTitle());
            rvBean.setReference2FullName(reference2.getFullName());
            System.out.println("----------------------- rvBean reference 2 full name: " + rvBean.getReference2FullName());
            rvBean.setReference2OrganisationName(reference2.getOrganisationName());
            rvBean.setReference2Designation(reference2.getDesignation());
            rvBean.setReference2ContactNumber(reference2.getContactNumber());
            rvBean.setReference2Email(reference2.getEmail());
            rvBean.setReference2Address(reference2.getAddress());

            IdentityDocument id = new IdentityDocument();
            id = this.verifierService.getIdentityDocument();
            rvBean.setIdentityDocumentType(id.getType());
            rvBean.setIdentityDocumentNumber(id.getNumber());
            if(id.getIssueDate() != null)
            {
                String date;
                date = id.getIssueDate().toString();
                int year = 0;
                int month = 0;
                int day = 0;
                String[] strSplit =  date.split("-");
                day = Integer.parseInt(strSplit[2]);
                month = Integer.parseInt(strSplit[1]);
                year = Integer.parseInt(strSplit[0]);
                date = Integer.toString(day) + "-" + Integer.toString(month) + "-" + Integer.toString(year);

                rvBean.setIdentityDocumentIssueDate(date);
            }
            if(id.getExpiryDate() != null)
            {
                String date;
                date = id.getExpiryDate().toString();
                int year = 0;
                int month = 0;
                int day = 0;
                String[] strSplit =  date.split("-");
                day = Integer.parseInt(strSplit[2]);
                month = Integer.parseInt(strSplit[1]);
                year = Integer.parseInt(strSplit[0]);
                date = Integer.toString(day) + "-" + Integer.toString(month) + "-" + Integer.toString(year);

                rvBean.setIdentityDocumentExpiryDate(date);
            }

            dataMap.put("rvBean", rvBean);
        }

        if(page == 2)
        {
            dataMap.put("regionList", this.verifierService.getRegionList());
            System.out.println("------------------------ controller register verifier reference data region list");
        }

        if(page == 3)
        {
            dataMap.put("districtList", this.verifierService.getDistrictList());
            System.out.println("------------------------ controller register verifier reference data district list");
        }

        if(page == 4)
        {
             rvBean.setPage(4);
             dataMap.put("genderList", this.verifierService.getGenderList());
             dataMap.put("educationLevelList", this.verifierService.getEducationLevelList());
             dataMap.put("educationTypeList", this.verifierService.getEducationTypeList());
             dataMap.put("rvBean", rvBean);
        }

        if(page == 5)
        {
            rvBean.setPage(5);
            dataMap.put("identityDocumentTypeList", this.verifierService.getIdentityDocumentTypeList());
            dataMap.put("rvBean", rvBean);
        }

        if(page == 6)
        {
            rvBean.setPage(6);
            dataMap.put("rvBean", rvBean);
        }

        if(page == 7)
        {
            rvBean.setPage(7);
            dataMap.put("titleList", this.verifierService.getTitleList());
            dataMap.put("rvBean", rvBean);
        }

        if(page == 10)
        {
            rvBean.setPage(10);
            dataMap.put("titleList", this.verifierService.getTitleList());
            dataMap.put("rvBean", rvBean);
        }

        return dataMap;
    }

    protected void validatePage(Object command, Errors errors, int page)
    {
        RegisterVerifierBean rvBean = (RegisterVerifierBean) command;

        System.out.println("----------------------- validate page method");
        if (page == 0)
        {
            System.out.println("----------------------- validate page login country" +  getValidators()[0].getClass());
            getValidators()[0].validate(command, errors);
        }

        if (page == 1)
        {
            System.out.println("----------------------- validate page select country");
            getValidators()[1].validate(command, errors);
        }

        if (page == 4)
        {
            System.out.println("----------------------- validate page create verifier");
            getValidators()[4].validate(command, errors);
        }

        if (page == 5)
        {
            System.out.println("----------------------- validate page create identity document");
            getValidators()[5].validate(command, errors);
        }

        if (page == 6)
        {
            System.out.println("----------------------- validate page create bank");
            getValidators()[2].validate(command, errors);
        }

        if (page == 7)
        {
            System.out.println("----------------------- validate page create reference");
            getValidators()[3].validate(command, errors);
            
        }

        if(page == 10)
        {
            getValidators()[6].validate(command, errors);
        }
    }

    protected void postProcessPage(HttpServletRequest request, Object command, Errors errors, int page) throws Exception
    {
        RegisterVerifierBean rvBean = (RegisterVerifierBean) command;

        if(page == 0 && request.getParameter("_target1") !=null)
        {
           
        }

        if(page == 1 && request.getParameter("_target2") !=null)
        {
            rvBean.setCountry(this.verifierService.setVerifierCountry(rvBean.getIdCountry()));
        }

        if(page == 2 && request.getParameter("_target3") !=null)
        {
            rvBean.setRegion(this.verifierService.setVerifierRegion(rvBean.getIdRegion()));
        }

        if(page == 3 && request.getParameter("_target4") !=null)
        {
            rvBean.setDistrict(this.verifierService.setVerifierDistrict(rvBean.getIdDistrict()));
        }

        if(page == 4 && request.getParameter("_target5") !=null)
        {
            this.verifierService.setVerifierDetails(rvBean.getFirstName(),
                                                    rvBean.getMiddleName(),
                                                    rvBean.getLastName(),
                                                    rvBean.getGender(),
                                                    rvBean.getSqlDob(),
                                                    rvBean.getTelephoneNumber(),
                                                    rvBean.getEducationLevel(),
                                                    rvBean.getEducationType());

            this.verifierService.setAddressDetails(rvBean.getStreet(),
                                                   rvBean.getVillage(),
                                                   rvBean.getPostcode(),
                                                   rvBean.getTown(),
                                                   rvBean.getCity());

            MultipartFile file = rvBean.getFile();
            if (file == null)
            {
                System.out.println("--------------------------- register verifier controller file is empty");
            }
            else
            {
                System.out.println("--------------------------- register verifier controller file: " + file);
            }
            this.verifierService.setImageDetails(rvBean.getFile());
            rvBean.setImage(this.verifierService.getImage());
        }

        if(page == 5 && request.getParameter("_target6") !=null)
        {
            this.verifierService.setIdentityDocumentDetails(rvBean.getIdentityDocumentType(),
                                                            rvBean.getIdentityDocumentNumber(),
                                                            rvBean.getSqlIdentityDocumentIssueDate(),
                                                            rvBean.getSqlIdentityDocumentExpiryDate());
        }

        if(page == 6 && request.getParameter("_target7") !=null)
        {
            this.verifierService.setBankDetails(rvBean.getBankAccountNumber(),
                                                rvBean.getBankName(),
                                                rvBean.getBankContactNumber(),
                                                rvBean.getBankAddress(),
                                                rvBean.getBankSortCode(),
                                                rvBean.getBankIban());
        }

        if(page == 7 && request.getParameter("_target10") !=null)
        {
            this.verifierService.setReference1Details(rvBean.getReference1Title(),
                                                         rvBean.getReference1FullName(),
                                                         rvBean.getReference1OrganisationName(),
                                                         rvBean.getReference1Designation(),
                                                         rvBean.getReference1ContactNumber(),
                                                         rvBean.getReference1Email(),
                                                         rvBean.getReference1Address());
        }

        if(page == 4 && request.getParameter("_target11") !=null)
        {
            rvBean.setTarget("_target4");
        }

        if(page == 11 && request.getParameter("_target8") !=null)
        {
            if(rvBean.getPage() == 4)
            {
                this.verifierService.setVerifierDetails(rvBean.getFirstName(),
                                                        rvBean.getMiddleName(),
                                                        rvBean.getLastName(),
                                                        rvBean.getGender(),
                                                        rvBean.getSqlDob(),
                                                        rvBean.getTelephoneNumber(),
                                                        rvBean.getEducationLevel(),
                                                        rvBean.getEducationType());

                this.verifierService.setAddressDetails(rvBean.getStreet(),
                                                       rvBean.getVillage(),
                                                       rvBean.getPostcode(),
                                                       rvBean.getTown(),
                                                       rvBean.getCity());

                this.verifierService.setImageDetails(rvBean.getFile());

                this.verifierService.save(rvBean.getPage());

                rvBean.setImage(this.verifierService.getImage());
                rvBean.setVerifier(this.verifierService.getVerifier());
                rvBean.setAddress(this.verifierService.getAddress());
            }

            if(rvBean.getPage() == 5)
            {
                this.verifierService.setVerifierDetails(rvBean.getFirstName(),
                                                    rvBean.getMiddleName(),
                                                    rvBean.getLastName(),
                                                    rvBean.getGender(),
                                                    rvBean.getSqlDob(),
                                                    rvBean.getTelephoneNumber(),
                                                    rvBean.getEducationLevel(),
                                                    rvBean.getEducationType());

                this.verifierService.setAddressDetails(rvBean.getStreet(),
                                                       rvBean.getVillage(),
                                                       rvBean.getPostcode(),
                                                       rvBean.getTown(),
                                                       rvBean.getCity());

                this.verifierService.setImageDetails(rvBean.getFile());

                 this.verifierService.setIdentityDocumentDetails(rvBean.getIdentityDocumentType(),
                                                                rvBean.getIdentityDocumentNumber(),
                                                                rvBean.getSqlIdentityDocumentIssueDate(),
                                                                rvBean.getSqlIdentityDocumentExpiryDate());

                this.verifierService.save(rvBean.getPage());

                rvBean.setImage(this.verifierService.getImage());
                rvBean.setVerifier(this.verifierService.getVerifier());
                rvBean.setAddress(this.verifierService.getAddress());
                rvBean.setIdentityDocument(this.verifierService.getIdentityDocument());
            }

            if(rvBean.getPage() == 6)
            {
                this.verifierService.setVerifierDetails(rvBean.getFirstName(),
                                                        rvBean.getMiddleName(),
                                                        rvBean.getLastName(),
                                                        rvBean.getGender(),
                                                        rvBean.getSqlDob(),
                                                        rvBean.getTelephoneNumber(),
                                                        rvBean.getEducationLevel(),
                                                        rvBean.getEducationType());

                this.verifierService.setAddressDetails(rvBean.getStreet(),
                                                       rvBean.getVillage(),
                                                       rvBean.getPostcode(),
                                                       rvBean.getTown(),
                                                       rvBean.getCity());

                this.verifierService.setImageDetails(rvBean.getFile());

                 this.verifierService.setIdentityDocumentDetails(rvBean.getIdentityDocumentType(),
                                                                rvBean.getIdentityDocumentNumber(),
                                                                rvBean.getSqlIdentityDocumentIssueDate(),
                                                                rvBean.getSqlIdentityDocumentExpiryDate());

                 this.verifierService.setBankDetails(rvBean.getBankAccountNumber(),
                                                    rvBean.getBankName(),
                                                    rvBean.getBankContactNumber(),
                                                    rvBean.getBankAddress(),
                                                    rvBean.getBankSortCode(),
                                                    rvBean.getBankIban());

                this.verifierService.save(rvBean.getPage());

                rvBean.setImage(this.verifierService.getImage());
                rvBean.setVerifier(this.verifierService.getVerifier());
                rvBean.setAddress(this.verifierService.getAddress());
                rvBean.setIdentityDocument(this.verifierService.getIdentityDocument());
                rvBean.setBank(this.verifierService.getBank());
            }

            if(rvBean.getPage() == 7)
            {
                this.verifierService.setVerifierDetails(rvBean.getFirstName(),
                                                        rvBean.getMiddleName(),
                                                        rvBean.getLastName(),
                                                        rvBean.getGender(),
                                                        rvBean.getSqlDob(),
                                                        rvBean.getTelephoneNumber(),
                                                        rvBean.getEducationLevel(),
                                                        rvBean.getEducationType());

                this.verifierService.setAddressDetails(rvBean.getStreet(),
                                                       rvBean.getVillage(),
                                                       rvBean.getPostcode(),
                                                       rvBean.getTown(),
                                                       rvBean.getCity());

                this.verifierService.setImageDetails(rvBean.getFile());

                 this.verifierService.setIdentityDocumentDetails(rvBean.getIdentityDocumentType(),
                                                                rvBean.getIdentityDocumentNumber(),
                                                                rvBean.getSqlIdentityDocumentIssueDate(),
                                                                rvBean.getSqlIdentityDocumentExpiryDate());

                 this.verifierService.setBankDetails(rvBean.getBankAccountNumber(),
                                                    rvBean.getBankName(),
                                                    rvBean.getBankContactNumber(),
                                                    rvBean.getBankAddress(),
                                                    rvBean.getBankSortCode(),
                                                    rvBean.getBankIban());

                  this.verifierService.setReference1Details(rvBean.getReference1Title(),
                                                         rvBean.getReference1FullName(),
                                                         rvBean.getReference1OrganisationName(),
                                                         rvBean.getReference1Designation(),
                                                         rvBean.getReference1ContactNumber(),
                                                         rvBean.getReference1Email(),
                                                         rvBean.getReference1Address());

                this.verifierService.save(rvBean.getPage());

                rvBean.setImage(this.verifierService.getImage());
                rvBean.setVerifier(this.verifierService.getVerifier());
                rvBean.setAddress(this.verifierService.getAddress());
                rvBean.setIdentityDocument(this.verifierService.getIdentityDocument());
                rvBean.setBank(this.verifierService.getBank());
                rvBean.setReference1(this.verifierService.getReference1());
            }

            if(rvBean.getPage() == 10)
            {
                this.verifierService.setVerifierDetails(rvBean.getFirstName(),
                                                        rvBean.getMiddleName(),
                                                        rvBean.getLastName(),
                                                        rvBean.getGender(),
                                                        rvBean.getSqlDob(),
                                                        rvBean.getTelephoneNumber(),
                                                        rvBean.getEducationLevel(),
                                                        rvBean.getEducationType());

                this.verifierService.setAddressDetails(rvBean.getStreet(),
                                                       rvBean.getVillage(),
                                                       rvBean.getPostcode(),
                                                       rvBean.getTown(),
                                                       rvBean.getCity());

                this.verifierService.setImageDetails(rvBean.getFile());

                 this.verifierService.setIdentityDocumentDetails(rvBean.getIdentityDocumentType(),
                                                                rvBean.getIdentityDocumentNumber(),
                                                                rvBean.getSqlIdentityDocumentIssueDate(),
                                                                rvBean.getSqlIdentityDocumentExpiryDate());

                 this.verifierService.setBankDetails(rvBean.getBankAccountNumber(),
                                                    rvBean.getBankName(),
                                                    rvBean.getBankContactNumber(),
                                                    rvBean.getBankAddress(),
                                                    rvBean.getBankSortCode(),
                                                    rvBean.getBankIban());

                  this.verifierService.setReference1Details(rvBean.getReference1Title(),
                                                         rvBean.getReference1FullName(),
                                                         rvBean.getReference1OrganisationName(),
                                                         rvBean.getReference1Designation(),
                                                         rvBean.getReference1ContactNumber(),
                                                         rvBean.getReference1Email(),
                                                         rvBean.getReference1Address());

                  this.verifierService.setReference2Details(rvBean.getReference2Title(),
                                                         rvBean.getReference2FullName(),
                                                         rvBean.getReference2OrganisationName(),
                                                         rvBean.getReference2Designation(),
                                                         rvBean.getReference2ContactNumber(),
                                                         rvBean.getReference2Email(),
                                                         rvBean.getReference2Address());

                this.verifierService.save(rvBean.getPage());

                rvBean.setImage(this.verifierService.getImage());
                rvBean.setVerifier(this.verifierService.getVerifier());
                rvBean.setAddress(this.verifierService.getAddress());
                rvBean.setIdentityDocument(this.verifierService.getIdentityDocument());
                rvBean.setBank(this.verifierService.getBank());
                rvBean.setReference1(this.verifierService.getReference1());
                rvBean.setReference2(this.verifierService.getReference2());
            }
        }

        if(page == 5 && request.getParameter("_target11") !=null)
        {
            rvBean.setTarget("_target5");
        }

        if(page == 6 && request.getParameter("_target11") !=null)
        {
            rvBean.setTarget("_target6");
        }

        if(page == 7 && request.getParameter("_target11") !=null)
        {
            rvBean.setTarget("_target7");
        }

        if(page == 10 && request.getParameter("_target11") !=null)
        {
            rvBean.setTarget("_target10");
        }

        // cancel registration select country page
        if(page == 1 && request.getParameter("_target9") !=null)
        {
            rvBean.setTarget("_target1");
        }

        // cancel registration select region page
        if(page == 2 && request.getParameter("_target9") !=null)
        {
            rvBean.setTarget("_target2");
        }

        // cancel registration select district page
        if(page == 3 && request.getParameter("_target9") !=null)
        {
            rvBean.setTarget("_target3");
        }

        // cancel registration create verifier page
        if(page == 4 && request.getParameter("_target9") !=null)
        {
            rvBean.setTarget("_target4");
        }

        // cancel registration create identity document page
        if(page == 5 && request.getParameter("_target9") !=null)
        {
            rvBean.setTarget("_target5");
        }

        // cancel registration create bank page
        if(page == 6 && request.getParameter("_target9") !=null)
        {
            rvBean.setTarget("_target6");
        }

        // cancel registration create reference page
        if(page == 7 && request.getParameter("_target9") !=null)
        {
            rvBean.setTarget("_target7");
        }

        System.out.println("---------------------------- page number "  + page);
    }

    protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception
    {
        RegisterVerifierBean rvBean = (RegisterVerifierBean) command;
        rvBean = new RegisterVerifierBean();

        return new ModelAndView(this.getCancelView(), "rvBean", rvBean);
    }

    protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception
    {
        RegisterVerifierBean rvBean = (RegisterVerifierBean) command;

        this.verifierService.setReference2Details(rvBean.getReference2Title(),
                                                  rvBean.getReference2FullName(),
                                                  rvBean.getReference2OrganisationName(),
                                                  rvBean.getReference2Designation(),
                                                  rvBean.getReference2ContactNumber(),
                                                  rvBean.getReference2Email(),
                                                  rvBean.getReference2Address());

        Verifier v = new Verifier();

        v = this.verifierService.registerVerifier();

        rvBean.setImage(this.verifierService.getImage());
        rvBean.setVerifier(v);
        rvBean.setAddress(this.verifierService.getAddress());
        rvBean.setIdentityDocument(this.verifierService.getIdentityDocument());
        rvBean.setBank(this.verifierService.getBank());
        rvBean.setReference1(this.verifierService.getReference1());
        rvBean.setReference2(this.verifierService.getReference2());

        return new ModelAndView(this.getSuccessView(), "rvBean", rvBean);
    }

    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
            throws ServletException
    {
        // to actually be able to convert Multipart instance to byte[]
        // we have to register a custom editor
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
        // now Spring knows how to handle multipart object and convert them
    }

    
    protected Object formBackingObject(HttpServletRequest request) throws Exception
    {
        return new RegisterVerifierBean();
    }
}
