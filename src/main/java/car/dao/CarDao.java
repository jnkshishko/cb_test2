package car.dao;

import car.model.Car;
import dto.CountDTO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CarDao {

    @PersistenceContext(name = "fines")
    EntityManager em;

    public Car getCarByGosnumber (String gosnumber) {

        String stringQuery = "SELECT c FROM Car c WHERE c.gosnumber = :gosnumber";

        TypedQuery<Car> query = em.createQuery(stringQuery, Car.class);

        query.setParameter("gosnumber", gosnumber);

        List<Car> result = query.getResultList();

        if(result != null) {
            return result.get(0);
        }

        return null;
    }

    public List<Object[]> getFinesIds(int n) {

        String stringQuery = "SELECT c.fine.id, count(c.fine.id) AS cc FROM Car c GROUP BY c.fine.id ORDER BY cc DESC";

        TypedQuery<Object[]> query = em.createQuery(stringQuery, Object[].class);

        query.setMaxResults(n);

        return query.getResultList();
    }

}
