import java.util.Scanner;
import java.util.Arrays;

/**
 * Constante de Kaprekar
 * Ejercicio 100
 * @author xNul1
 */

public class p100{
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int val, num = sc.nextInt();
		while (num-- > 0){
            val = sc.nextInt();
            if (val % 10 * 1111 == val)
                System.out.println(8);
            else if (val == 6174)
                System.out.println(0);
            else
                System.out.println(kaprekar(val));
		}
	}
	public static int kaprekar(int val){
	    int cont = 0, mayor, menor;
	    int arr[] = new int[4];
	    while(true){
            cont++;
            for (int j = 0; j < 4; j++){
                arr[j] = val % 10;
                val /= 10;
            }
            Arrays.sort(arr);
            mayor = 0; menor = 0;
            for (int i = 0; i < 4; i++){
                mayor = mayor * 10 + arr[3 - i];
                menor = menor * 10 + arr[i];
            }
            if(mayor - menor == 6174)
                break;
            else
                val = mayor - menor;
        }
        return cont;
	}
}
