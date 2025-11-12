import java.util.Scanner;
import java.util.Arrays;

/**
 * Calculo de la Mediana
 * Ejercicio 161
 * @author xNul1
 */

public class p161 {
    static Scanner sc = new Scanner(System.in);
    static int[] secuencia;
    public static void main(String[] args){
        while(entrada()){
            rellenar();
            System.out.println(media());
        }
    }
    public static boolean entrada(){
        int numero = sc.nextInt();
        if (numero == 0)
            return false;
        else
            secuencia = new int[numero];
        return true;
    }
    public static void rellenar(){
        for (int i = 0; i < secuencia.length; i++)
            secuencia[i] = sc.nextInt();
        Arrays.sort(secuencia);
    }
    public static int media(){
        if (secuencia.length % 2 == 1)
            return secuencia[(secuencia.length - 1) / 2] * 2;
        return secuencia[(secuencia.length - 1) / 2] + secuencia[(secuencia.length / 2)];
    }
}
