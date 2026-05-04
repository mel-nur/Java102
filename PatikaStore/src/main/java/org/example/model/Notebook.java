package org.example.model;

public class Notebook extends Product{
    private int ram;
    private int storage;
    private double screenSize;

    public Notebook(int id, double unitPrice, int discountRate, int stock,
                    String name, Brand brand, int ram, int storage, double screenSize) {
        super(id, unitPrice, discountRate, stock, name, brand);
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    public int getRam(){return this.ram;}
    public int getStorage(){return this.storage;}
    public double getScreenSize(){return this.screenSize;}
    @Override
    public void printTableRow() {
        System.out.format("| %-3d| %-30s| %-10s| %-10s| %-10d| %-10.1f| %-12d|\n",
                getId(), getName(), String.format("%.1f TL", getUnitPrice()),
                getBrand().getName(), storage, screenSize, ram);
    }

    public static void printTableHeader() {
        String line = "-".repeat(100);
        System.out.println("\nNotebook Listesi\n");
        System.out.println(line);
        System.out.format("| %-3s| %-30s| %-10s| %-10s| %-10s| %-10s| %-12s|\n",
                "ID", "Ürün Adı", "Fiyat", "Marka", "Depolama", "Ekran", "RAM");
        System.out.println(line);
    }

    public static void printTableFooter() {
        System.out.println("-".repeat(100));
    }
}
