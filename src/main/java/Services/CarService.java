package Services;

import DAO.CarDao;
import Model.Car;

import java.util.List;

public class CarService {

    public List<Car> getAllCars(){
        return CarDao.getAllCars();

    }
}
