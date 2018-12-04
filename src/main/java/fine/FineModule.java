package fine;

import fine.dao.FineDao;
import fine.model.Fine;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class FineModule {

    @EJB
    private FineDao fineDao;

    public Fine getFineById (Long id) {

        return fineDao.getFineById(id);

    }

}
