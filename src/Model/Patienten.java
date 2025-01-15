package Model;

import java.util.List;

public class Patienten {
    private String name;
    private int alter;
    private String diagnose;
    private List<Medikamente> medikamentes;

    public Patienten(String name, int alter, String diagnose, List<Medikamente> medikamentes) {
        this.name = name;
        this.alter = alter;
        this.diagnose = diagnose;
        this.medikamentes = medikamentes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public List<Medikamente> getMedikamentes() {
        return medikamentes;
    }

    public void setMedikamentes(List<Medikamente> medikamentes) {
        this.medikamentes = medikamentes;
    }
}
