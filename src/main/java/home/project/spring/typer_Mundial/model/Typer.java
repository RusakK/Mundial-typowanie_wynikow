package home.project.spring.typer_Mundial.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Typer extends BaseModel implements Serializable {

    private int points;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "matchResultsId")
    private MatchResults matchResults;

    public Typer() {
    }

    public Typer(int points, Date date, Customer customer, MatchResults matchResults) {
        this.points = points;
        this.date = date;
        this.customer = customer;
        this.matchResults = matchResults;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public MatchResults getMatchResults() {
        return matchResults;
    }

    public void setMatchResults(MatchResults matchResults) {
        this.matchResults = matchResults;
    }
}
