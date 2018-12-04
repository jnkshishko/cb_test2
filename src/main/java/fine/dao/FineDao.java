package fine.dao;

import fine.model.Fine;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FineDao {

    @PersistenceContext(name = "fines")
    EntityManager em;

    public Fine getFineById (Long id) {

        return em.find(Fine.class, id);

    }

}
