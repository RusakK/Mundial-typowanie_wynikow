package home.project.spring.typer_Mundial.model;

public class NewTyperFormData {

    private Typer preparingTyper;
    private Match match1;
    private Match match2;
    private Match match3;

    public Typer getPreparingTyper() {
        return preparingTyper;
    }

    public void setPreparingTyper(Typer preparingTyper) {
        this.preparingTyper = preparingTyper;
    }

    public Match getMatch1() {
        return match1;
    }

    public void setMatch1(Match match1) {
        this.match1 = match1;
    }

    public Match getMatch2() {
        return match2;
    }

    public void setMatch2(Match match2) {
        this.match2 = match2;
    }

    public Match getMatch3() {
        return match3;
    }

    public void setMatch3(Match match3) {
        this.match3 = match3;
    }
}
