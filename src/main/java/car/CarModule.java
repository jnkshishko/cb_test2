package car;

import car.dao.CarDao;
import car.model.Car;
import common.exceptions.CarNotFoundException;
import dto.CountDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CarModule {

    @EJB
    private CarDao carDao;

    public Car getCarByGosnumber(String gosnumber) throws CarNotFoundException {
        Car result = carDao.getCarByGosnumber(gosnumber);
        if(result == null) {
            throw new CarNotFoundException("Машина с гос.номером: " + gosnumber + " не найдена.");
        }
        return result;
    }

    public List<CountDTO> getFinesIds(int n) {

        List<Object[]> objects = carDao.getFinesIds(n);
        List<CountDTO> result = new ArrayList<>();

        if (objects != null) {
            for(Object[] o:objects){
                CountDTO countDTO = new CountDTO();
                countDTO.setFineId((Long)o[0]);
                countDTO.setCount((Long)o[1]);
                result.add(countDTO);
            }
        }

        return result;

    }

}
