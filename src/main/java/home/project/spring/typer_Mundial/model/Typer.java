package home.project.spring.typer_Mundial.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Typer extends BaseModel implements Serializable {

    private String nickname;
    private String email;
    private int points;

    @OneToMany(mappedBy = "typer")
    private List<Match> matchList;


    public Typer() {
    }

    public Typer(String nickname, String email, int points, List<Match> matchList) {
        this.nickname = nickname;
        this.email = email;
        this.points = points;
        this.matchList = matchList;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List<Match> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<Match> matchList) {
        this.matchList = matchList;
    }
}
