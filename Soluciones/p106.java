import java.util.Scanner;

/**
 * Codigo de Barras
 * Ejercicio 106
 * @author xNul1
 */

public class p106 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        String num = sc.next();
        while (!num.equals("0")) {
            if (suma(num)){
                System.out.print("SI");
                if (num.length() > 8){
                    if (num.length() < 13)
                        System.out.print(" EEUU");
                    else
                        System.out.print(" " + pais(num));
                }
            }else
                System.out.print("NO");
	        System.out.println();
	        num = sc.next();
        }
        sc.close();
    }

    public static boolean suma(String num){
        int sum = 0, val;
        int control = Integer.parseInt(num.substring(num.length() - 1));
        num = num.substring(0, num.length() - 1);
        boolean alternador = true;
        while (num.length() > 0){
            val = num.charAt(num.length() - 1) - 48;
            sum += val * (alternador ? 3 : 1);
            alternador = !alternador;
            num = num.substring(0, num.length() - 1);
        }
        return ((sum + control) % 10 == 0);
    }

    public static String pais(String num){
    	String[] cty = {"India", "Cuba", "Venezuela", "Portugal", "Irlanda", "Bulgaria", "Noruega", "Inglaterra", "EEUU", "Desconocido"};
        String[] val = {"890", "850", "759", "560", "539", "380", "70", "50", "0"};
        int i = 0;
    	for (; i < 9; i++) {
            if (num.startsWith(val[i]))
                break;
        }
        return cty[i];
    }
}
