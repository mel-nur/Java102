package org.example;

import org.example.manager.BrandManager;
import org.example.manager.MobilePhoneManager;
import org.example.manager.NotebookManager;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BrandManager brandManager = new BrandManager();
        NotebookManager notebookManager = new NotebookManager(brandManager);
        MobilePhoneManager mobilePhoneManager = new MobilePhoneManager(brandManager);
        System.out.println("  PatikaStore Ürün Yönetim Paneli'ne Hoşgeldiniz!");

        boolean running = true;
        while (running) {
            printMainMenu();
            System.out.print("Tercihiniz : ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1": notebookMenu(scanner, notebookManager); break;
                case "2": phoneMenu(scanner, mobilePhoneManager); break;
                case "3": brandManager.listBrands(); break;
                case "0":
                    System.out.println("Çıkış yapılıyor...");
                    running = false;
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }
        scanner.close();
    }

    static void printMainMenu() {
        System.out.println("\nPatikaStore Ürün Yönetim Paneli !");
        System.out.println("1 - Notebook İşlemleri");
        System.out.println("2 - Cep Telefonu İşlemleri");
        System.out.println("3 - Marka Listele");
        System.out.println("0 - Çıkış Yap");
    }

    static void notebookMenu(Scanner scanner, NotebookManager manager) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Notebook İşlemleri ---");
            System.out.println("1 - Notebook Listele");
            System.out.println("2 - Notebook Ekle");
            System.out.println("3 - Notebook Sil");
            System.out.println("4 - Notebook Filtrele");
            System.out.println("0 - Ana Menü");
            System.out.print("Tercihiniz : ");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    manager.listAll();
                    break;
                case "2":
                    manager.add(scanner);
                    break;
                case "3":
                    manager.delete(scanner);
                    break;
                case "4":
                    manager.filter(scanner);
                    break;
                case "0":
                    back = true;
                    break;
                default:
                    System.out.println("Geçersiz seçim.");
            }
        }
    }
    static void phoneMenu (Scanner scanner, MobilePhoneManager manager){
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Cep Telefonu İşlemleri ---");
            System.out.println("1 - Cep Telefonu Listele");
            System.out.println("2 - Cep Telefonu Ekle");
            System.out.println("3 - Cep Telefonu Sil");
            System.out.println("4 - Cep Telefonu Filtrele");
            System.out.println("0 - Ana Menü");
            System.out.print("Tercihiniz : ");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    manager.listAll();
                    break;
                    case "2":
                        manager.add(scanner);
                        break;
                    case "3":
                        manager.delete(scanner);
                        break;
                    case "4":
                        manager.filter(scanner);
                        break;
                    case "0":
                        back = true;
                        break;
                    default:
                        System.out.println("Geçersiz seçim.");
            }
        }
    }
}