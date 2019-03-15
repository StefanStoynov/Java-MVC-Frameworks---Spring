package residentevil.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "viruses")
public class Virus extends BaseEntity {

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
    private List<Capital>capitals;

    public Virus() {
    }


    public String getName() {
        return this.name;
    }

    @NotEmpty(message = "Cannot be empty")
    @NotNull(message = "Cannot be empty")
    @Size(min = 5, max = 100, message = "Description length should be between 5 and 100 symbols")
    @Column(name = "description", columnDefinition = "TEXT")
    public String getDescription() {
        return this.description;
    }

    @NotEmpty(message = "Cannot be empty")
    @NotNull(message = "Cannot be empty")
    @Size(max = 50, message = "Side Effects length should not more than 50 symbols")
    @Column(name = "side_effects")
    public String getSideEffects() {
        return this.sideEffects;
    }

    @NotNull
    @Column(name = "creator")
    public String getCreator() {
        return this.creator;
    }

    @NotNull
    @Column(name = "is_deadly")
    public Boolean getDeadly() {
        return this.isDeadly;
    }

    @NotNull
    @Column(name = "is_curable")
    public Boolean getCurable() {
        return this.isCurable;
    }

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "mutation")
    public Mutation getMutation() {
        return this.mutation;
    }

    @NotNull
    @Size(min = 0, max = 100, message = "Number, between 0 and 100.")
    @Column(name = "turnover_rate")
    public Integer getTurnoverRate() {
        return this.turnoverRate;
    }

    @NotNull
    @Size(min = 1, max = 12, message = "Number, between 0 and 12.")
    @Column(name = "hours_until_turn")
    public Integer getHoursUntilTurn() {
        return this.hoursUntilTurn;
    }

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Can`t be null")
    @Column(name = "magnitude")
    public Magnitude getMagnitude() {
        return this.magnitude;
    }


    public LocalDate getReleasedOn() {
        return this.releasedOn;
    }

    @OneToMany(targetEntity = Capital.class)
    @JoinTable(name = "viruses_capitals",
            joinColumns = @JoinColumn(name = "virus_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "capital_id", referencedColumnName = "id")
    )
    public List<Capital> getCapitals() {
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

    public void setDeadly(Boolean deadly) {
        isDeadly = deadly;
    }

    public void setCurable(Boolean curable) {
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

    public void setCapitals(List<Capital> capitals) {
        this.capitals = capitals;
    }
}
