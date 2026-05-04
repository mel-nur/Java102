package org.example.manager;

import org.example.model.Brand;
import org.example.model.MobilePhone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MobilePhoneManager {
    private List<MobilePhone> phones = new ArrayList<>();
    private int nextId = 1;
    private BrandManager brandManager;

    public MobilePhoneManager(BrandManager brandManager) {
        this.brandManager = brandManager;
    }

    public void listMobilePhones(List<MobilePhone> list) {
        MobilePhone.printTableHeader();
        if (list.isEmpty()) {
            System.out.println("Kayıt Bulunamadı.");
        } else {
            list.forEach(MobilePhone::printTableRow);
        }
        MobilePhone.printTableFooter();
    }

    public void listAll() {
        listMobilePhones(phones);
    }

    public void add(Scanner scanner){
        System.out.println("\n--- Cep Telefonu Ekle ---");

        System.out.print("Ürün Adı: ");
        String name = scanner.nextLine();

        System.out.print("Birim Fiyatı: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("İndirim Oranı (%): ");
        int  discount = Integer.parseInt(scanner.nextLine());

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

        System.out.print("Hafıza (GB): ");
        int storage = Integer.parseInt(scanner.nextLine());

        System.out.print("Ekran Boyutu (inç): ");
        double screen = Double.parseDouble(scanner.nextLine());

        System.out.print("Pil Gücü (mAh): ");
        double battery = Double.parseDouble(scanner.nextLine());

        System.out.print("RAM (GB): ");
        int ram = Integer.parseInt(scanner.nextLine());

        System.out.print("Renk: ");
        String color = scanner.nextLine();

        MobilePhone phone = new MobilePhone(nextId++, price, discount, stock, name, brand,
                storage, screen, battery, ram, color);
        phones.add(phone);
        System.out.println("✓ Cep telefonu başarıyla eklendi! (ID: " + phone.getId() + ")");
    }

    public void delete(Scanner scanner) {
        System.out.print("Silinecek Cep Telefonu ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean removed = phones.removeIf(p -> p.getId() == id);
        System.out.println(removed ? "✓ Cep telefonu silindi." : "✗ Kayıt bulunamadı.");
    }

    public void filter(Scanner scanner) {
        System.out.println("Filtre Seçenekleri: 1 - ID ile  2 - Marka ile");
        System.out.print("Tercihiniz: ");
        String choice = scanner.nextLine();

        List<MobilePhone> result;
        if ("1".equals(choice)) {
            System.out.print("Telefon ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            result = phones.stream().filter(p -> p.getId() == id).collect(Collectors.toList());
        } else if ("2".equals(choice)) {
            brandManager.listBrands();
            System.out.print("Marka ID: ");
            int brandId = Integer.parseInt(scanner.nextLine());
            result = phones.stream().filter(p -> p.getBrand().getId() == brandId).collect(Collectors.toList());
        } else {
            System.out.println("Geçersiz seçim.");
            return;
        }
        listMobilePhones(result);
    }


}
