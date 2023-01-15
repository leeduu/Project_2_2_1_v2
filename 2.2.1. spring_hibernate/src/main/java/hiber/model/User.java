package hiber.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component("userBean")
@Table(name = "users", schema = "project_2_2_1")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "user_id")
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

//   @OneToOne
//   @MapsId
//   private Car car;

//   @Autowired
//   public User(Car car) {
//      System.out.println("User bean is created");
//      this.car = car;
//   }

   @OneToOne/*cascade = CascadeType.ALL)*/
   @MapsId
   @JoinColumn(name = "id")
   private Car userCar;

   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + email +
              '}';
   }

   public Car getUserCar() {
      return userCar;
   }

   public Car setUserCar(Car userCar) {
      this.userCar = userCar;
      return userCar;
   }
}
