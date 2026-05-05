package org.example;


//Türev alma (kullanıcıdan katsayıları ve denklem derecesini almanız yeterlidir) -
// Integral Alma (kullanıcıdan katsayıları ve denklem derecesini almanız yeterlidir) -

public class HesapMakinesi {

    double toplama(double a, double b){ return a + b;}
    double cikarma(double a, double b){ return a - b;}
    double carpma(double a, double b){ return a * b;}
    double bolme(double a, double b){  return (b==0) ? 0 : a / b;}

    double usAlma(double a, double b){ return Math.pow(a, b);}
    double karekok(double a){ return Math.sqrt(a);}

    double modAlma(double a, double b){ return a % b;}
    double mutlakDeger(double a){ return Math.abs(a);}
    double faktoriyel(double n) {
         double result = 1;
        if (n < 0) {
            return -1;
        }
        for(int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }


}
