/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.dao;

import java.util.List;
import org.haftrust.verifier.model.Reference;
import org.haftrust.verifier.model.Verifier;

/**
 *
 * @author Miroslav
 */
public interface ReferenceDAO {

    public List<Reference> getReferences(Verifier ver, String employeeType);

    public Reference saveReference(Reference reference);
}
