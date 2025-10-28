import java.util.Scanner;

/**
 * Cuadrados diabolicos y esotericos
 * Ejercicio 101
 * @author xNul1
 */
 
public class p101 {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int num;
        while (true){
            num = sc.nextInt();
            if (num == 0)
                break;
            else{
                leer(num);
            }
        }
        sc.close();
    }
        
    public static void leer(int num){
        int entrada, sum = 0;
        int[][] arr = new int[num][num];
        for (int i = 0; i < num; i++){
            for (int j = 0; j < num; j++){
                entrada = sc.nextInt();
                arr[i][j] = entrada;
            }
        }
        for (int i : arr[0])
            sum += i;
        diabolico(arr, num, sum);
    }
    
    public static void diabolico(int[][] arr, int num, int sumaEsperada){
        int sumaHorizontal, sumaVertical, sumaDiagonal1 = 0, sumaDiagonal2 = 0;
        for (int i = 0; i < num; i++){
            sumaHorizontal = 0;
            sumaVertical = 0;
            sumaDiagonal1 += arr[i][i];
            sumaDiagonal2 += arr[i][num - 1 - i];
            for (int j = 0; j < num; j++){
                sumaHorizontal += arr[i][j];
                sumaVertical += arr[j][i];
            }
            if (sumaHorizontal != sumaEsperada || sumaVertical != sumaEsperada){
                System.out.println("NO");
                return;
            }
        }
        if (sumaDiagonal1 != sumaEsperada || sumaDiagonal2 != sumaEsperada){
            System.out.println("NO");
            return;
        }
        if (comprobar_esoterico(arr, num))
            esoterico(arr, num);
        else
            System.out.println("DIABOLICO");
        return;
    }

    public static boolean comprobar_esoterico(int[][] arr, int num){
        int sumaEsperada = num * num * (num * num + 1) / 2;
        for (int i = 0; i < num; i++){
            for (int j : arr[i])
                sumaEsperada -= j;   
        }
        if (sumaEsperada == 0)
            return true;
        else
            return false;
    }

    public static void esoterico(int[][] arr, int num){
        int sumaLateral = 0, sumaCentral = 0, mid = num / 2;
        num--;
        int cm2 = arr[0][0] + arr[num][num] + arr[0][num] + arr[num][0];
        if (num % 2 == 1){
            for (int i = 0; i < 2; i++){
                sumaLateral += arr[mid - i][0] + arr[0][mid - i];
                sumaLateral += arr[mid - i][num] + arr[num][mid - i];
                sumaCentral += arr[mid][mid - i] + arr[mid - 1][mid - i];
            }
            if (sumaCentral == cm2 && sumaLateral == cm2 * 2)
                System.out.println("ESOTERICO");
            else
                System.out.println("DIABOLICO");
        }else{
            sumaLateral = 0;
            for (int i = 0; i <= num; i += num)
                sumaLateral += arr[mid][i] + arr[i][mid];
            if (arr[mid][mid] * 4 == cm2 && sumaLateral == cm2)
                System.out.println("ESOTERICO");
            else
                System.out.println("DIABOLICO");
        }
    }
}
