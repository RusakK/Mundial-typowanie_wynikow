package home.project.spring.typer_Mundial.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "game")
public class Match extends BaseModel {

    private String name;
    private int scoreTeamA;
    private int scoreTeamB;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "typerId")
    private Typer typer;


    public Match() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScoreTeamA() {
        return scoreTeamA;
    }

    public void setScoreTeamA(int scoreTeamA) {
        this.scoreTeamA = scoreTeamA;
    }

    public int getScoreTeamB() {
        return scoreTeamB;
    }

    public void setScoreTeamB(int scoreTeamB) {
        this.scoreTeamB = scoreTeamB;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Typer getTyper() {
        return typer;
    }

    public void setTyper(Typer typer) {
        this.typer = typer;
    }
}
