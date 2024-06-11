package bg.softuni.mobilele.data.entity;

import bg.softuni.mobilele.data.entity.enums.Engine;
import bg.softuni.mobilele.data.entity.enums.Transmission;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(columnDefinition = "TEXT")
    public String description;

    @Enumerated(EnumType.ORDINAL)
    public Engine engine;

    @Column(name = "image_url")
    public String imageUrl;

    @Column(length = 11)
    public int mileage;

    @Column(columnDefinition = "DECIMAL(19,2)")
    public double price;

    @Enumerated(EnumType.ORDINAL)
    public Transmission transmission;

    @Column
    public int year;

    @Column
    public Timestamp created;

    @Column
    public Timestamp modified;

    @OneToOne
    @JoinColumn(name = "model_id")
    public Model model;

    @OneToOne
    @JoinColumn(name = "seller_id")
    public User seller;

    public Offer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getModified() {
        return modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}
