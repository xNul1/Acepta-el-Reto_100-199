import java.util.Scanner;

/**
 * Moviles
 * Ejercicio 104
 * @author xNul1
 */

public class p104 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        int pi, di, pd, dd;
    	while(true){
            pi = sc.nextInt();
            di = sc.nextInt();
            pd = sc.nextInt();
            dd = sc.nextInt();
            if (pi + pd + di + dd == 0)
                break;
            pi = (pi == 0 ? entrada() : pi) * di;
            pd = (pd == 0 ? entrada() : pd) * dd;
            if (pi < 0 || pd < 0)
                System.out.println("NO");
            else if (pi == pd)
                System.out.println("SI");
            else
                System.out.println("NO");
        }
        sc.close();
    }

    public static int entrada(){
        int pi = sc.nextInt();
        int di = sc.nextInt();
        int pd = sc.nextInt();
        int dd = sc.nextInt();
        pi = pi == 0 ? entrada() : pi;
        pd = pd == 0 ? entrada() : pd;
        if (pi * di == pd * dd)
            return pi + pd;
        else
            return -1;
    }
}
