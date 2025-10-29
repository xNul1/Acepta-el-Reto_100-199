import java.util.Scanner;

/**
 * Ventas
 * Ejercicio 105
 * @author xNul1
 */

public class p105 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        funct();
        sc.close();
    }

    public static void funct(){
        double num = 0, min, max, mid;
        int max_indx = 0, min_indx = 0;
        while(true){
            min = Double.MAX_VALUE; 
            max = 0; 
            mid = 0;
            for (int i = 0; i < 6; i++){
                num = sc.nextDouble();
                if (num == -1)
                    return;
                if (num > max){
                    max = num;
                    max_indx = i;
                }
                if (num < min){
                    min = num;
                    min_indx = i;
                }
                mid += num;
            }
            System.out.print(semana(max_indx) + " " + semana(min_indx) + " ");
            media(num, mid);     
        }
    }

    public static void media(double domingo, double mid){
        if (mid / 6 > domingo)
            System.out.println("NO");
        else
            System.out.println("SI");
    }

    public static String semana(int num){
        switch(num){
            case 0:
                return "MARTES";
            case 1:
                return "MIERCOLES";
            case 2: 
                return "JUEVES";
            case 3:
                return "VIERNES";
            case 4:
                return "SABADO";
            case 5:
                return "DOMINGO";
        }
        return "";
    }
}
