package residentevil.domain.models.binding;

import org.springframework.format.annotation.DateTimeFormat;
import residentevil.domain.entities.Capital;
import residentevil.domain.entities.Magnitude;
import residentevil.domain.entities.Mutation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class VirusAddBindingModel {

    private String name;
    private String description;
    private String sideEffects;
    private String creator;
    private boolean isDeadly;
    private boolean isCurable;
    private Mutation mutation;
    private Integer turnoverRate;
    private Integer hoursUntilTurn;
    private Magnitude magnitude;
    private LocalDate releasedOn;
    private List<String> capitals;


    public VirusAddBindingModel() {
    }

    @NotNull()
    @Size(min = 3, max = 10, message = "Name length should be between 3 and 10 symbols")
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getSideEffects() {
        return this.sideEffects;
    }

    public String getCreator() {
        return this.creator;
    }

    public boolean isDeadly() {
        return this.isDeadly;
    }

    public boolean isCurable() {
        return this.isCurable;
    }

    public Mutation getMutation() {
        return this.mutation;
    }

    public Integer getTurnoverRate() {
        return this.turnoverRate;
    }

    public Integer getHoursUntilTurn() {
        return this.hoursUntilTurn;
    }

    public Magnitude getMagnitude() {
        return this.magnitude;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getReleasedOn() {
        return this.releasedOn;
    }

    public List<String> getCapitals() {
        return this.capitals;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setDeadly(boolean deadly) {
        isDeadly = deadly;
    }

    public void setCurable(boolean curable) {
        isCurable = curable;
    }

    public void setMutation(Mutation mutation) {
        this.mutation = mutation;
    }

    public void setTurnoverRate(Integer turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    public void setHoursUntilTurn(Integer hoursUntilTurn) {
        this.hoursUntilTurn = hoursUntilTurn;
    }

    public void setMagnitude(Magnitude magnitude) {
        this.magnitude = magnitude;
    }

    public void setReleasedOn(LocalDate releasedOn) {
        this.releasedOn = releasedOn;
    }

    public void setCapitals(List<String> capitals) {
        this.capitals = capitals;
    }
}
