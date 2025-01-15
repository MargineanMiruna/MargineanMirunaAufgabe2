package Controller;

import Model.Medikamente;
import Model.Patienten;
import Repository.IRepository;

import java.util.Map;

public class Controller {
    private IRepository<Medikamente> medikamenteRepository;
    private IRepository<Patienten> patientenRepository;

    public Controller(IRepository<Medikamente> medikamenteRepository, IRepository<Patienten> patientenRepository) {
        this.medikamenteRepository = medikamenteRepository;
        this.patientenRepository = patientenRepository;
    }

    public void addMedikamente(Medikamente medikamente) {
        medikamenteRepository.create(medikamente);
    }

    public Medikamente readMedikamente(int id) {
        return medikamenteRepository.read(id);
    }

    public void updateMedikamente(int id, Medikamente medikamente) {
        medikamenteRepository.update(id, medikamente);
    }

    public void deleteMedikamente(Medikamente medikamente) {
        medikamenteRepository.delete(medikamente);
    }

    public Map<Integer,Medikamente> getMedikamente() {
        return medikamenteRepository.getAll();
    }

    public void addPatienten(Patienten patienten) {
        patientenRepository.create(patienten);
    }

    public Patienten readPatienten(int id) {
        return patientenRepository.read(id);
    }

    public void updatePatienten(int id, Patienten patienten) {
        patientenRepository.update(id, patienten);
    }

    public void deletePatienten(Patienten patienten) {
        patientenRepository.delete(patienten);
    }

    public Map<Integer,Patienten> getPatienten() {
        return patientenRepository.getAll();
    }

    public void filterPatientByDiagnose(String diagnose) {
        Map<Integer, Patienten> patients = patientenRepository.getAll();

        for(Patienten patienten : patients.values()) {
            if(patienten.getDiagnose().equals(diagnose)) {
                System.out.println(patienten.getName());
            }
        }
    }

    public void filterPatientByKrankheit(String krankheit) {
        Map<Integer, Patienten> patients = patientenRepository.getAll();

        for(Patienten patienten : patients.values()) {
            for(Medikamente medikamente : patienten.getMedikamentes()) {
                if(medikamente.getKrankheit().equals(krankheit)) {
                    System.out.println(patienten.getName());
                    break;
                }
            }
        }
    }
}
