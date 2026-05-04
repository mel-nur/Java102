package org.example.manager;

import org.example.model.Brand;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BrandManager {
    private List<Brand> brands = new ArrayList<>();
    private int nextId = 1;

    public BrandManager(){
        String[] brandNames = {"Samsung", "Lenovo", "Apple", "Huawei", "Casper", "Asus", "HP", "Xiaomi", "Monster"};
        for (String name: brandNames) {
            brands.add(new Brand(nextId++, name));
        }
    }
    public List<Brand> getBrands(){
        List<Brand> sorted = new ArrayList<>(brands);
        sorted.sort(Comparator.comparing(Brand:: getName));
        return sorted;
    }
    public Brand findById(int id){
        return brands.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }
    public void listBrands(){
        System.out.println("\nMarkalarımız");
        System.out.println("-".repeat(20));
        getBrands().forEach(b -> System.out.println(b.getId() + " - " + b.getName()));
    }
}
