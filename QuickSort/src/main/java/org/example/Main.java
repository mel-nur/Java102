package org.example;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] data = {10, 80, 30, 90, 40, 50, 70};
        System.out.println("Sıralanmadan önce: ");
        printArray(data);

        QuickSort.sort(data, 0, data.length - 1);

        System.out.println("Sıralandıktan sonra: ");
        printArray(data);
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}