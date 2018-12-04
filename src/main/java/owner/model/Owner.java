package owner.model;

import car.model.Car;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "owner")
@SequenceGenerator(allocationSize = 1, name = "commonsequence", sequenceName = "commonsequence")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commonsequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "middlename")
    private String middlename;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner")
    private Set<Car> cars;

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }


    public Owner() {
    }

    public Owner(String lastname, String firstname, String middlename, Set<Car> cars) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.middlename = middlename;
        this.cars = cars;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(id, owner.id) &&
                Objects.equals(lastname, owner.lastname) &&
                Objects.equals(firstname, owner.firstname) &&
                Objects.equals(middlename, owner.middlename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastname, firstname, middlename);
    }
}
