package org.example.manager;

import org.example.model.Brand;
import org.example.model.Notebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NotebookManager {
    private List<Notebook> notebooks = new ArrayList<>();
    private int nextId = 1;
    private BrandManager brandManager;

    public NotebookManager(BrandManager brandManager) {
        this.brandManager = brandManager;
    }
    public void listNotebooks(List<Notebook> list){
        Notebook.printTableHeader();
        if(list.isEmpty()){
            System.out.println("Kayıt Bulunamadı.");
        }
        else {
            list.forEach(Notebook:: printTableRow);
        }
        Notebook.printTableFooter();
    }
    public void listAll(){
        listNotebooks(notebooks);
    }
    public void add(Scanner scanner){

        System.out.println("\n--- Notebook Ekle ---");

        System.out.print("Ürün Adı: ");
        String name = scanner.nextLine();

        System.out.print("Birim Fiyatı: ");
        double unitPrice = Double.parseDouble(scanner.nextLine());

        System.out.print("İndirim Oranı (%): ");
            int discountRate = Integer.parseInt(scanner.nextLine());

        System.out.print("Stok Miktarı: ");
        int stock = Integer.parseInt(scanner.nextLine());

        brandManager.listBrands();
        System.out.print("Marka ID: ");
        int brandId = Integer.parseInt(scanner.nextLine());
        Brand brand = brandManager.findById(brandId);
        if (brand == null) {
            System.out.println("Geçersiz marka ID!");
            return;
        }

        System.out.print("RAM (GB): ");
        int ram = Integer.parseInt(scanner.nextLine());

        System.out.print("Depolama (GB SSD): ");
        int storage = Integer.parseInt(scanner.nextLine());

        System.out.print("Ekran Boyutu (inç): ");
        double screenSize = Double.parseDouble(scanner.nextLine());

        Notebook nb = new Notebook(nextId++, unitPrice, discountRate, stock, name, brand, ram, storage, screenSize);
        notebooks.add(nb);
        System.out.println("✓ Notebook başarıyla eklendi! (ID: " + nb.getId() + ")");
    }

    public void delete(Scanner scanner){
        System.out.print("\nSilinecek Notebook ID'si: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean removed = notebooks.removeIf(n -> n.getId() == id);
        System.out.println(removed ? "✓ Notebook silindi." : "Notebook bulunamadı.");
    }

    public void filter(Scanner scanner) {
        System.out.println("Filtre Seçenekleri: 1 - ID ile  2 - Marka ile");
        System.out.print("Tercihiniz: ");
        String choice = scanner.nextLine();
        List<Notebook> result;
        if ("1".equals(choice)) {
            System.out.print("Notebook ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            result = notebooks.stream().filter(n -> n.getId() == id).collect(Collectors.toList());
        } else if ("2".equals(choice)) {
            brandManager.listBrands();
            System.out.print("Marka ID: ");
            int brandId = Integer.parseInt(scanner.nextLine());
            result = notebooks.stream().filter(n -> n.getBrand().getId() == brandId).collect(Collectors.toList());
        } else {
            System.out.println("Geçersiz seçim.");
            return;
        }
        listNotebooks(result);

    }
}
