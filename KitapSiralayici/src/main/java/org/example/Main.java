package org.example;

import java.util.Set;
import java.util.TreeSet;

//Kitap Sıralayıcı
//Book isminde bir sınıf tasarlayınız. Bu sınıf Comparable interface'den kalıtım alıp "compareTo"
// metodunu override ediniz. Bu metodun içinde kitabı A'dan Z'ye isme göre sıralayan kodu yazınız. Bu sınıftan 5 tane nesne oluşturun ve
// nesneleri Set tipinde bir yapısında saklayınız. Sonra ikinci kez Set tipinden bir veri yapısı kullanın ve kitapları sayfa sayısına göre
// sıralamasını sağlayınız.

//Book sınıfı kitap ismi, sayfa sayısı, yazarın ismi, yayın tarihi değişkenlerinden oluşmaktadır.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Set<Book> byName = new TreeSet<>();
        byName.add(new Book("Sefiller",          1232, "Victor Hugo",       "1862"));
        byName.add(new Book("Don Kişot",         863,  "Cervantes",          "1605"));
        byName.add(new Book("Suç ve Ceza",       687,  "Dostoyevski",        "1866"));
        byName.add(new Book("Anna Karenina",     964,  "Lev Tolstoy",        "1878"));
        byName.add(new Book("Beyaz Geceler",     128,  "Dostoyevski",        "1848"));

        System.out.println("=== İsme göre (A → Z) ===");
       for (Book book : byName){
           System.out.println(book);
       }

        System.out.println("\n=== Sayfa sayısına göre (artan) ===");
       Set<Book> byPage = new TreeSet<>(new PageCountComparator());
       byPage.addAll(byName);
       for (Book book : byPage){
           System.out.println(book);
       }


    }
}