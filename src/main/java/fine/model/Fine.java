package fine.model;

import car.model.Car;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "fine")
@SequenceGenerator(allocationSize = 1, name = "commonsequence", sequenceName = "commonsequence")
public class Fine {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commonsequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "cost")
    private Long cost;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "fine")
    private Set<Car> cars;

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public Fine(){
    }

    public Fine(String type, Long cost) {
        this.type = type;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fine fine = (Fine) o;
        return Objects.equals(id, fine.id) &&
                Objects.equals(type, fine.type) &&
                Objects.equals(cost, fine.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, cost);
    }
}
