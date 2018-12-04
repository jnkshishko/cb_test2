package owner;

import common.exceptions.OwnerNotFoundException;
import owner.dao.OwnerDao;
import owner.model.Owner;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.List;

@Stateless
public class OwnerModule {

    @EJB
    OwnerDao ownerDao;

    public Owner getOwnerById (Long id) throws OwnerNotFoundException {
        Owner result = ownerDao.getOwnerById(id);
        if (result == null) {
            throw new OwnerNotFoundException(String.format("Owner with id '%s' not found", id));
        }
        return result;
    }

    public List<Owner> searchOwner(String fullName) {

        List<String> partsOfName = null;
        if (fullName != null) {
            partsOfName = Arrays.asList(fullName.split(" "));
        }

        return ownerDao.findOwners(partsOfName);

    }

}
