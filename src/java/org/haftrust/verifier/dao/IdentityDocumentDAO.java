/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.haftrust.verifier.dao;

import org.haftrust.verifier.model.IdentityDocument;
import org.haftrust.verifier.model.Verifier;

/**
 *
 * @author Miroslav
 */
public interface IdentityDocumentDAO
{
    public IdentityDocument getIdentityDocument(Verifier ver, String employeeType);
    public IdentityDocument saveIdentityDocument(IdentityDocument identityDocument);
}
