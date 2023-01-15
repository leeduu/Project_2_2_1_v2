package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();

   void add(Car car);
   List<Car> listCars();

   User getUserByCar(User user);
}
