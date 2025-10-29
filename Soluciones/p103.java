import java.util.Scanner;

/**
 * Problemas de Herencia
 * Ejercicio 103
 * @author xNul1
 */

public class p103 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        int grado;
        while(true){
            grado = sc.nextInt();
            if (grado == 20)
                break;
            else{
                double valorX, valorF, suma = 0;
                int[] funcion = new int[grado + 1];
                for (int i = 0; i <= grado; i++){
                    funcion[i] = sc.nextInt();
                }
                int rectangulos = sc.nextInt();
                for (int i = 1; i < rectangulos; i++){
                    valorX = (double)i / rectangulos;
                    valorF = 0;
                    for (int j = 0; j < grado; j++)
                        valorF += Math.pow(valorX, grado - j) * funcion[j];
                    valorF += funcion[grado];
                    if (valorF > 0)
                        suma += (valorF > 1 ? 1 : valorF) * 1.0 / rectangulos;
                }
                if (suma < 0.4999)
                    System.out.println("ABEL");
                else if (suma > 0.5001)
                    System.out.println("CAIN");
                else
                    System.out.println("JUSTO");      
            }
        }
        sc.close();
    }
}
