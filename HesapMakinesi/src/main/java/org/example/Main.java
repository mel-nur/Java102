package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        HesapMakinesi hm = new HesapMakinesi();
        System.out.println("--- Bilimsel Hesap Makinesi ---");
        boolean running = true;
        double[] numbers;
        double sayi;

        while (running){
            menu();
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    numbers = add2(input);
                    System.out.println("Toplam: " + hm.toplama(numbers[0], numbers[1]));
                    break;
                case 2:
                    numbers = add2(input);
                    System.out.println("Çıkarma: " + hm.cikarma(numbers[0], numbers[1]));
                    break;
                case 3:
                    numbers = add2(input);
                    System.out.println("Çarpma: " + hm.carpma(numbers[0], numbers[1]));
                    break;
                case 4:
                    numbers = add2(input);
                    System.out.println("Bölme: " + hm.bolme(numbers[0], numbers[1]));
                    break;
                case 5:
                    numbers = add2(input);
                    System.out.println("Üs Alma: " + hm.usAlma(numbers[0], numbers[1]));
                    break;
                case 6:
                    sayi = sayiAl(input);
                    System.out.println("Kök Alma: " + hm.karekok(sayi));
                    break;
                case 7:
                    numbers = add2(input);
                    System.out.println("Mod Alma: " + hm.modAlma(numbers[0], numbers[1]));
                    break;
                case 8:
                    sayi = sayiAl(input);
                    System.out.println("Mutlak Değer Alma: " + hm.mutlakDeger(sayi));
                    break;
                case 9:
                    sayi = sayiAl(input);
                    System.out.println("Faktöriyel Alma: " + hm.faktoriyel(sayi));
                    break;
                case 10:
                    System.out.println("Çıkış yapılıyor...");
                    running = false;
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }
    }
    public static void menu(){
        System.out.println("\n1. Toplama\n2. Çıkarma\n3. Çarpma\n4. Bölme\n5. Üs Alma\n6. Kök Alma\n7. Mod Alma\n8. Mutlak Değer\n9. Faktöriyel\n10. Çıkış\n");
        System.out.print("Seçiminiz : ");
    }
    public static double[] add2(Scanner input){
        System.out.print("1. Sayıyı Giriniz: ");
        double a = input.nextDouble();
        System.out.print("2. Sayıyı Giriniz: ");
        double b = input.nextDouble();
        return new double[]{a, b};
    }
    public static double sayiAl(Scanner input){
        System.out.print("Sayıyı Giriniz: ");
        return input.nextDouble();
    }
}