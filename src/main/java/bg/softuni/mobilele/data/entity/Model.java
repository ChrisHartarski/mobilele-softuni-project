package bg.softuni.mobilele.data.entity;

import bg.softuni.mobilele.data.entity.enums.Category;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique = true)
    public String name;

    @Enumerated(EnumType.ORDINAL)
    public Category category;

    @Column(name = "image_url", length = 512)
    public String imageUrl;

    @Column(name = "start_year", length = 11)
    public int startYear;

    @Column(name = "end_year", length = 11)
    public int endYear;

    @Column
    public Timestamp created;

    @Column
    public Timestamp modified;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    public Brand brand;

    public Model() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
