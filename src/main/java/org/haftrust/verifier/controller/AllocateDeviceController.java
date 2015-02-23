/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.haftrust.verifier.model.Verifier;
import org.haftrust.verifier.service.VerifierService;
import org.haftrust.verifier.view.AllocateDeviceBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

/**
 *
 * @author Miroslav
 */
public class AllocateDeviceController extends AbstractWizardFormController {

    private static final Logger LOG = LoggerFactory.getLogger(AllocateDeviceController.class);

    private VerifierService verifierService;
    private String cancelView;
    private String successView;

    public String getSuccessView() {
        return successView;
    }

    public void setSuccessView(String successView) {
        this.successView = successView;
    }

    public String getCancelView() {
        return cancelView;
    }

    public void setCancelView(String cancelView) {
        this.cancelView = cancelView;
    }

    public VerifierService getVerifierService() {
        return verifierService;
    }

    public void setVerifierService(VerifierService verifierService) {
        this.verifierService = verifierService;
    }

    protected Map referenceData(HttpServletRequest request, Object command, Errors errors, int page) throws Exception {
        Map<Object, Object> dataMap = new HashMap<Object, Object>();

        if (page == 0) {
            dataMap.put("countryList", this.verifierService.getCountryList());
            LOG.debug("------------------------ controller allocate device reference data country list");
        }

        if (page == 1) {
            dataMap.put("regionList", this.verifierService.getRegionList());
            LOG.debug("------------------------ controller allocate device reference data region list");
        }

        if (page == 3) {
            dataMap.put("unallocatedDeviceList", this.verifierService.getUnallocatedDeviceList());
        }

        return dataMap;
    }

    protected void validatePage(Object command, Errors errors, int page) {

    }

    protected void postProcessPage(HttpServletRequest request, Object command, Errors errors, int page) throws Exception {
        AllocateDeviceBean adBean = (AllocateDeviceBean) command;

        if (page == 0 && request.getParameter("_target1") != null) {
            adBean.setCountry(this.verifierService.setVerifierCountry(adBean.getIdCountry()));
        }

        if (page == 1 && request.getParameter("_target2") != null) {
            LOG.debug("------------------------- post process page search verifier");
            adBean.setRegion(this.verifierService.setVerifierRegion(adBean.getIdRegion()));

            List<Verifier> v = new ArrayList<Verifier>();
            v = this.verifierService.getEmployedVerifiersWithoutDevice();
            LOG.debug("------------------------- post process page search verifier, v list size: {}", v);
            adBean.setVerifierList(v);
            adBean.setvBean(v);
        }

        if (page == 2 && request.getParameter("_target3") != null) {
            this.verifierService.getEmployedVerifierDetails(adBean.getIdVerifier());

            Verifier verifier = new Verifier();
            verifier = this.verifierService.getVerifier();
            adBean.setFirstName(verifier.getFirstName());
            adBean.setMiddleName(verifier.getMiddleName());
            adBean.setLastName(verifier.getLastName());
            if (verifier.getDob() != null) {
                String date;
                date = verifier.getDob().toString();
                int year = 0;
                int month = 0;
                int day = 0;
                String[] strSplit = date.split("-");
                day = Integer.parseInt(strSplit[2]);
                month = Integer.parseInt(strSplit[1]);
                year = Integer.parseInt(strSplit[0]);
                date = Integer.toString(day) + "-" + Integer.toString(month) + "-" + Integer.toString(year);

                adBean.setDob(date);
            }
            adBean.setEmail(verifier.getEmail());
        }

        // cancel allocate device select country page
        if (page == 0 && request.getParameter("_target4") != null) {
            adBean.setTarget("_target0");
        }

        // cancel registration select region page
        if (page == 1 && request.getParameter("_target4") != null) {
            adBean.setTarget("_target1");
        }

        // cancel registration select district page
        if (page == 2 && request.getParameter("_target4") != null) {
            adBean.setTarget("_target2");
        }

        // cancel registration select district page
        if (page == 3 && request.getParameter("_target4") != null) {
            adBean.setTarget("_target3");
        }
    }

    protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        AllocateDeviceBean adBean = (AllocateDeviceBean) command;
        adBean = new AllocateDeviceBean();

        return new ModelAndView(this.getCancelView(), "adBean", adBean);
    }

    protected ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        AllocateDeviceBean adBean = (AllocateDeviceBean) command;

        adBean.setDevice(this.verifierService.setVerifierDevice(adBean.getImei()));

        this.verifierService.allocateDevice();

        return new ModelAndView(this.getSuccessView(), "adBean", adBean);
    }
}
