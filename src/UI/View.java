package UI;

import Model.Medikamente;
import Controller.*;

import java.util.Map;
import java.util.Scanner;

public class View {
    Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void view() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                1 - Create medikament
                2 - Read medikament
                3 - Update medikament
                4 - Delete medikament
                5 - View all medikaments""");

        String option = "-1";

        while (option != "0") {
            System.out.println("Enter option: ");

            option = sc.nextLine();
            switch (option) {
                case "1": {
                    System.out.println("Name: ");
                    String name = sc.nextLine();
                    System.out.println("Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Krankheit: ");
                    String krankheit = sc.nextLine();

                    Medikamente medikamente = new Medikamente(name, price, krankheit);
                    controller.addMedikamente(medikamente);
                    break;
                }
                case "2": {
                    System.out.println("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Medikamente medikamente = controller.readMedikamente(id);
                    System.out.println(medikamente.getName() +" "+ medikamente.getPrice() +" "+ medikamente.getKrankheit());
                    break;
                }
                case "3": {
                    System.out.println("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Name: ");
                    String name = sc.nextLine();
                    System.out.println("Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Krankheit: ");
                    String krankheit = sc.nextLine();

                    Medikamente medikamente = controller.readMedikamente(id);
                    medikamente.setName(name);
                    medikamente.setPrice(price);
                    medikamente.setKrankheit(krankheit);
                    controller.updateMedikamente(id, medikamente);
                    break;
                }
                case "4": {
                    System.out.println("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Medikamente medikamente = controller.readMedikamente(id);
                    controller.deleteMedikamente(medikamente);
                    break;
                }
                case "5": {
                    Map<Integer,Medikamente> medikaments = controller.getMedikamente();
                    for(Map.Entry<Integer,Medikamente> medikamente : medikaments.entrySet()) {
                        System.out.println(medikamente.getValue().getName() +" "+ medikamente.getValue().getPrice() +" "+ medikamente.getValue().getKrankheit());
                    }
                    break;
                }
            }
            }
        }

}
