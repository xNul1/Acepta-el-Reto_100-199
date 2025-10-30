import java.util.Scanner;
import java.util.Arrays;

/**
 * Aproximacion de Gauss
 * Ejercicio 107
 * @author xNul1
 */
 
public class p107 {
    static Scanner sc = new Scanner(System.in);
    static boolean[] criba = primos();
    static int[] numero = contador();
    public static void main(String[] args){
        int n;
        double dif;
        while (true){
            n = sc.nextInt();
            dif = sc.nextInt();
            if (n + dif == 0){  
                break;
            }else{
                double aproxC, aproxR, error;
                int pi = numero[n];
                aproxR = 1.0 * pi / n;
                aproxC = 1 / (Math.log(n));
                error = Math.abs(aproxR - aproxC);
                dif = 1 / Math.pow(10, dif);
                if (error > dif)
                    System.out.println("Mayor");
                else if (error < dif)
                    System.out.println("Menor");
                else
                    System.out.println("Igual");
            }
        }
        sc.close();
    }
    
    public static int[] contador(){
        int n = 100000, cont = 0;
        int[] arr = new int[n];
		for (int i = 2; i < n; i++) {
			if (criba[i] == true)
				cont++;
			arr[i] = cont;
		}
		return arr;
    }
    
    public static boolean[] primos(){
        int n = 100000;
        boolean[] arr = new boolean[n];
		Arrays.fill(arr, true);
		for (int i = 2; i * i < n; i++) {
			if (arr[i] == true) {
				for (int j = i * i; j < n; j += i) {
					arr[j] = false;
				}
			}
		}
		return arr;
    }
}
