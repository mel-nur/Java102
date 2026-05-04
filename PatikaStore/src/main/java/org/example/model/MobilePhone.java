package org.example.model;

public class MobilePhone extends Product{
    private int storage;
    private double screenSize;
    private double battery;
    private int ram;
    private String color;

    public MobilePhone(int id, double unitPrice, int discountRate, int stock, String name, Brand brand, int storage, double screenSize, double battery, int ram, String color){
        super(id, unitPrice, discountRate, stock, name, brand);
        this.storage = storage;
        this.screenSize = screenSize;
        this.battery = battery;
        this.ram = ram;
        this.color = color;
    }

    public int getStorage() { return storage; }
    public double getScreenSize() { return screenSize; }
    public double getBattery() { return battery; }
    public int getRam() { return ram; }
    public String getColor() { return color; }

    @Override
    public void printTableRow() {
        System.out.format("| %-3d| %-30s| %-10s| %-10s| %-10d| %-10.1f| %-10d| %-10.1f| %-10d| %-10s|\n",
                getId(), getName(), String.format("%.1f TL", getUnitPrice()),
                getBrand().getName(), storage, screenSize, 0, battery, ram, color);
    }

    public static void printTableHeader() {
        String line = "-".repeat(134);
        System.out.println("\nCep Telefonu Listesi\n");
        System.out.println(line);
        System.out.format("| %-3s| %-30s| %-10s| %-10s| %-10s| %-10s| %-10s| %-10s| %-10s| %-10s|\n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "Kamera", "Pil", "RAM", "Renk");
        System.out.println(line);
    }

    public static void printTableFooter() {
        System.out.println("-".repeat(134));
    }
}
