package car.model;

import fine.model.Fine;
import owner.model.Owner;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "gosnumber")
    private String gosnumber;

    @Column(name = "mark")
    private String mark;

    @Column(name = "model")
    private String model;

//    @Column(name = "owner_id")
//    private Long owner_id;
//
//    @Column(name = "fine_id")
//    private Long fine_id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "fine_id", nullable = false)
    private Fine fine;

    public Fine getFine() {
        return fine;
    }

    public void setfine(Fine fine) {
        this.fine = fine;
    }

    public Car() {
    }

    public Car(Long id, String gosnumber, String mark, String model, Owner owner) {
        this.id = id;
        this.gosnumber = gosnumber;
        this.mark = mark;
        this.model = model;
        this.owner = owner;
    }

//    public Long getOwner_id() {
//        return owner_id;
//    }
//
//    public void setOwner_id(Long owner_id) {
//        this.owner_id = owner_id;
//    }
//
//    public Long getFine_id() {
//        return fine_id;
//    }
//
//    public void setFine_id(Long fine_id) {
//        this.fine_id = fine_id;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGosnumber() {
        return gosnumber;
    }

    public void setGosnumber(String gosnumber) {
        this.gosnumber = gosnumber;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) &&
                Objects.equals(mark, car.mark) &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, model);
    }
}
