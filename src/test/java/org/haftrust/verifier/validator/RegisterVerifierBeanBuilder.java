/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.validator;

import org.haftrust.verifier.view.RegisterVerifierBean;

/**
 *
 * @author amarinperez
 */
public class RegisterVerifierBeanBuilder {

    public static RegisterVerifierBean getValidBean() {
        RegisterVerifierBean bean = new RegisterVerifierBean();
        bean.setBankAccountNumber("1212312");
        bean.setBankName("My Bank");
        bean.setBankContactNumber("098098");
        bean.setBankAddress("some where");
        bean.setBankSortCode("001122");
        bean.setBankIban("GB29 RBOS 6016 1331 9268 19");

        return bean;
    }
}
