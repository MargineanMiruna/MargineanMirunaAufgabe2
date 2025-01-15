package UI;

import Model.Medikamente;
import Controller.*;
import Model.Patienten;

import java.util.ArrayList;
import java.util.List;
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
                5 - View all medikaments
                6 - Create patient
                7 - Read patient
                8 - Update patient
                9 - Delete patient
                10 - View all patients""");

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
                case "6": {
                    System.out.println("Name: ");
                    String name = sc.nextLine();
                    System.out.println("Alter: ");
                    int alter = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Diagnose: ");
                    String diagnose = sc.nextLine();
                    System.out.println("Nr of medikaments: ");
                    int nrOfMed = sc.nextInt();
                    sc.nextLine();
                    List<Medikamente> medikamentes = new ArrayList<Medikamente>();
                    for (int i = 0; i < nrOfMed; i++) {
                        int medId = sc.nextInt();
                        sc.nextLine();
                        medikamentes.add(controller.readMedikamente(medId));
                    }

                    Patienten patienten = new Patienten(name, alter, diagnose, medikamentes);
                    controller.addPatienten(patienten);
                    break;
                }
                case "7": {
                    System.out.println("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Patienten patienten = controller.readPatienten(id);
                    System.out.println(patienten.getName() + " " + patienten.getAlter() + " " + patienten.getDiagnose());
                    break;
                }
                case "8": {
                    System.out.println("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Name: ");
                    String name = sc.nextLine();
                    System.out.println("Alter: ");
                    int alter = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Diagnose: ");
                    String diagnose = sc.nextLine();
                    System.out.println("Nr of medikaments: ");
                    int nrOfMed = sc.nextInt();
                    sc.nextLine();
                    List<Medikamente> medikamentes = new ArrayList<Medikamente>();
                    for (int i = 0; i < nrOfMed; i++) {
                        int medId = sc.nextInt();
                        sc.nextLine();
                        medikamentes.add(controller.readMedikamente(medId));
                    }

                    Patienten patienten = controller.readPatienten(id);
                    patienten.setName(name);
                    patienten.setAlter(alter);
                    patienten.setDiagnose(diagnose);
                    patienten.setMedikamentes(medikamentes);
                    controller.updatePatienten(id, patienten);
                    break;
                }
                case "9": {
                    System.out.println("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Patienten patienten = controller.readPatienten(id);
                    controller.deletePatienten(patienten);
                    break;
                }
                case "10": {
                    Map<Integer,Patienten> patients = controller.getPatienten();
                    for(Map.Entry<Integer,Patienten> patienten: patients.entrySet()) {
                        System.out.println(patienten.getValue().getName() + " " + patienten.getValue().getAlter() + " " + patienten.getValue().getDiagnose());
                    }
                    break;
                }
            }
            }
        }

}
