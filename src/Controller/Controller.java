package Controller;

import Model.Medikamente;
import Repository.IRepository;

import java.util.Map;

public class Controller {
    private IRepository<Medikamente> medikamenteRepository;

    public Controller(IRepository<Medikamente> medikamenteRepository) {
        this.medikamenteRepository = medikamenteRepository;
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
}
