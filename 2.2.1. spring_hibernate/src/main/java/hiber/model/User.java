package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "project_2_2_1")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   //@Column(name = "user_id")
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "car_id")
   private Car car;

//   @Autowired
//   public User(Car car) {
//      System.out.println("User bean is created");
//      this.car = car;
//   }

//   @OneToOne/*cascade = CascadeType.ALL)*/
//   @MapsId
//   @JoinColumn(name = "car_id", referencedColumnName = "user_id")
//   private Car car;

   public User() {}
   
   public User(String firstName, String lastName, String email, Car car) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.car = car;
   }

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

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return id.equals(user.id) && firstName.equals(user.firstName) && lastName.equals(user.lastName) && email.equals(user.email) && Objects.equals(car, user.car);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, firstName, lastName, email, car);
   }
}
