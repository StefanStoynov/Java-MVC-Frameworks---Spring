package residentevil.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "capitals")
public class Capital extends BaseEntity {

    private String name;
    private Double latitude;
    private double longitude;

    public Capital() {
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    @Column(name = "latitude")
    public Double getLatitude() {
        return this.latitude;
    }

    @Column(name = "longitude")
    public double getLongitude() {
        return this.longitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
