package kz.kaznitu.dancer.models;

import javax.persistence.*;

@Entity
public class Dancer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dancerId;

    private String firstName;

    private String lastName;

    @ManyToOne
    private Club club;

    public Dancer() {
    }

    public Dancer(String firstName, String lastName, Club club) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.club = club;
    }

    public Long dancerId() {
        return dancerId;
    }

    public void dancerId(Long dancerId) {
        this.dancerId = dancerId;
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

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
