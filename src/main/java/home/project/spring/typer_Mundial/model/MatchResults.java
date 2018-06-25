package home.project.spring.typer_Mundial.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public class MatchResults extends BaseModel implements Serializable {

    private Date date;
    private int points;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    private int game_1A_2B;
    private int game_1C_2D;
    private int game_1E_2F;
    private int game_1G_2H;
    private int game_1B_2A;
    private int game_1D_2C;
    private int game_1F_2E;
    private int game_1H_2G;

    public MatchResults() {
    }

    public MatchResults(Date date, int points, Customer customer, int game_1A_2B, int game_1C_2D, int game_1E_2F, int game_1G_2H, int game_1B_2A, int game_1D_2C, int game_1F_2E, int game_1H_2G) {
        this.date = date;
        this.points = points;
        this.customer = customer;
        this.game_1A_2B = game_1A_2B;
        this.game_1C_2D = game_1C_2D;
        this.game_1E_2F = game_1E_2F;
        this.game_1G_2H = game_1G_2H;
        this.game_1B_2A = game_1B_2A;
        this.game_1D_2C = game_1D_2C;
        this.game_1F_2E = game_1F_2E;
        this.game_1H_2G = game_1H_2G;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getGame_1A_2B() {
        return game_1A_2B;
    }

    public void setGame_1A_2B(int game_1A_2B) {
        this.game_1A_2B = game_1A_2B;
    }

    public int getGame_1C_2D() {
        return game_1C_2D;
    }

    public void setGame_1C_2D(int game_1C_2D) {
        this.game_1C_2D = game_1C_2D;
    }

    public int getGame_1E_2F() {
        return game_1E_2F;
    }

    public void setGame_1E_2F(int game_1E_2F) {
        this.game_1E_2F = game_1E_2F;
    }

    public int getGame_1G_2H() {
        return game_1G_2H;
    }

    public void setGame_1G_2H(int game_1G_2H) {
        this.game_1G_2H = game_1G_2H;
    }

    public int getGame_1B_2A() {
        return game_1B_2A;
    }

    public void setGame_1B_2A(int game_1B_2A) {
        this.game_1B_2A = game_1B_2A;
    }

    public int getGame_1D_2C() {
        return game_1D_2C;
    }

    public void setGame_1D_2C(int game_1D_2C) {
        this.game_1D_2C = game_1D_2C;
    }

    public int getGame_1F_2E() {
        return game_1F_2E;
    }

    public void setGame_1F_2E(int game_1F_2E) {
        this.game_1F_2E = game_1F_2E;
    }

    public int getGame_1H_2G() {
        return game_1H_2G;
    }

    public void setGame_1H_2G(int game_1H_2G) {
        this.game_1H_2G = game_1H_2G;
    }
}
