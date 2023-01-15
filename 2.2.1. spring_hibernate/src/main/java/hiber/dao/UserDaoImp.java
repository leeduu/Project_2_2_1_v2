package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

//   private final SessionFactory sessionFactory;
//
//   public UserDaoImp(SessionFactory sessionFactory) {
//      this.sessionFactory = sessionFactory;
//   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public void add(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }

   @Override
   public List<Car> listCars() {
      TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   Car car = new Car();

   @Override
   public User getUserByCar(User user) {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(
              "FROM User where Car.model = :model and Car.series = :series", User.class);
      query.setParameter("model", car.getModel());
      query.setParameter("series", car.getSeries());
      return query.getSingleResult();
   }

//   @Override
//   public User getUserByCar(User user) {
//      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(
//              "FROM User u INNER JOIN Car c ON u.id = c.id", User.class);
//      return query.getSingleResult();
//   }
}
