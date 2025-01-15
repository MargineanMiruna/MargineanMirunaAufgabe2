import Controller.Controller;
import Model.Medikamente;
import Model.Patienten;
import Repository.Repository;
import UI.View;

public class Main {
    public static void main(String[] args) {
        Repository<Medikamente> medikamenteRepository = new Repository();
        Repository<Patienten> patientenRepository = new Repository();
        Controller controller = new Controller(medikamenteRepository, patientenRepository);
        View view = new View(controller);
        view.view();
    }
}