package owner.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import owner.model.Owner;

import java.util.List;

@Stateless
public class OwnerDao {

    @PersistenceContext(unitName = "fines")
    EntityManager em;

    public Owner getOwnerById(Long id) {
        return em.find(Owner.class, id);
    }

    public List<Owner> findOwners(List<String> partsOfName) {

        String stringQuery = "SELECT owner FROM Owner owner WHERE ";

        if (partsOfName != null) {

//            for (String part : partsOfName) {
//                part = part.toLowerCase();
//            }
            for (int i = 0; i < partsOfName.size(); i++) {
                if (i > 0) {
                    stringQuery += " AND ";
                }
                stringQuery += "(owner.firstname like :parts_of_name" + i + " OR" +
                        " owner.lastname like :parts_of_name" + i + " OR" +
                        " owner.middlename like :parts_of_name" + i + " )";
            }
        }

        TypedQuery<Owner> query = em.createQuery(stringQuery, Owner.class);

        if (partsOfName != null) {
            for (int i = 0; i < partsOfName.size(); i++) {
                query.setParameter("parts_of_name" + i, "%" + partsOfName.get(i) + "%");
            }
        }
        return query.getResultList();
    }
}
