package residentevil.domain.models.binding;

import jdk.jfr.BooleanFlag;
import org.springframework.format.annotation.DateTimeFormat;
import residentevil.domain.entities.Capital;
import residentevil.domain.entities.Magnitude;
import residentevil.domain.entities.Mutation;

import javax.validation.constraints.*;
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

    @NotNull(message = "Name cannot be empty!")
    @Size(min = 3, max = 10, message = "Name length should be between 3 and 10 symbols")
    public String getName() {
        return this.name;
    }

    @Size(min = 5, max = 100, message = "Description length should be between 5 and 100 symbols")
    public String getDescription() {
        return this.description;
    }

    @NotNull(message = "Side Effects cannot be empty!")
    @Size(max = 50, message = "Side Effects length should not more than 50 symbols")
    public String getSideEffects() {
        return this.sideEffects;
    }

    @NotNull(message = "Creator cannot be empty!")
    @Pattern(regexp = "Corp|corp", message = "Creator must be Corp or corp!")
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

    @NotNull(message = "Turn over rate cannot be empty!")
    @Min(value = 0, message = "Turn over rate minimum is 0")
    @Max(value = 100, message = "Turn over rate maximum is 100")
    public Integer getTurnoverRate() {
        return this.turnoverRate;
    }

    @NotNull(message = "Hours until turn cannot be empty!")
    @Min(value = 1, message = "Hours until turn minimum is 1")
    @Max(value = 12, message = "Hours until turn minimum is 12")
    public Integer getHoursUntilTurn() {
        return this.hoursUntilTurn;
    }

    @NotNull(message = "Magnitude cannot be empty!")
    public Magnitude getMagnitude() {
        return this.magnitude;
    }

    @NotNull(message = "Date cannot be empty!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getReleasedOn() {
        return this.releasedOn;
    }
    @NotNull(message = "Cannot be empty!")
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
