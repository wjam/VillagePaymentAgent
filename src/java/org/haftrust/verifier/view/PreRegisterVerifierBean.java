/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.haftrust.verifier.view;

/**
 *
 * @author Miroslav
 */
public class PreRegisterVerifierBean
{
    private int idVerifier;
    private String email;
    private String password;
    private String repassword;

    public int getIdVerifier() {
        return idVerifier;
    }

    public void setIdVerifier(int idVerifier) {
        this.idVerifier = idVerifier;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
}
