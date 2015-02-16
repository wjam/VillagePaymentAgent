/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.haftrust.verifier.dao;

import java.util.List;
import org.haftrust.verifier.model.Address;
import org.haftrust.verifier.model.Verifier;

/**
 *
 * @author Miroslav
 */
public interface VerifierDAO
{
    public Verifier setVerifier(Verifier verifier);
    public List<Verifier> getPreRegisteredVerifierByEmailAndPassword(String email, String password, String status);
    public List<Verifier> getVerifierbyAddress(Address address, String status);
    public boolean getVerifierByEmail(String email);
}
