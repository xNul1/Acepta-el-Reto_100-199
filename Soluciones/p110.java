import java.util.Scanner;
import java.util.Arrays;

/**
 * Estrofas
 * Ejercicio 110
 * @author xNul1
 */

public class p110 {
    static Scanner sc = new Scanner(System.in);
    static String[] rimas;
    static int versos; 
    
    public static void main(String[] args){
        while (entrada()){
            rellenar();
            comparar();
        }
    }
    public static boolean entrada(){
        versos = sc.nextInt();
        sc.nextLine();
        if (versos == 0)
            return false;
        else{
            if (versos > 1 && versos < 5){
                rimas = new String[versos];
                Arrays.fill(rimas, "");
            }
        }
        return true;
    }
    public static void rellenar(){
        if (versos < 2 || versos > 4){
            while (versos-- > 0)
                sc.nextLine();
        }else{
            String valor;
            int num_vocales;
            for (int i = 0; i < versos; i++){
                valor = sc.nextLine().toLowerCase();
                num_vocales = 0;
                for (int j = valor.length() - 1; j > 0; j--){
                    if (valor.charAt(j) <= 'z' && valor.charAt(j) >= 'a'){
                        if ("aeiou".indexOf(valor.charAt(j) + "") != -1)
                            num_vocales++;
                        rimas[i] = (valor.charAt(j) + "") + rimas[i];
                        if (num_vocales == 2)
                            break;
                    }
                }
            }
        }
    }
    public static void comparar(){
        switch (versos) {
            case 2:
                System.out.println(versos2());
                break;
            case 3:
                System.out.println(versos3());
                break;
            case 4:
                System.out.println(versos4());
                break;
            default:
                System.out.println("DESCONOCIDO");
        }
    }
    public static String versos2(){
        if (rimas[0].equals(rimas[1])) {return "PAREADO";}
        return "DESCONOCIDO";
    }
    public static String versos3(){
        if (rimas[0].equals(rimas[2]) && !rimas[0].equals(rimas[1])){return "TERCETO";}
        return "DESCONOCIDO";
    }
    public static String versos4(){
        if (rimas[0].equals(rimas[1])){
            if (rimas[1].equals(rimas[2]) && rimas[2].equals(rimas[3]))
                return "CUADERNA VIA";
            else
                return "DESCONOCIDO";
        }
        if (rimas[1].equals(rimas[2])){
            if (rimas[0].equals(rimas[3]))
                return "CUARTETO";
            else
                return "DESCONOCIDO";
        }
        if (rimas[1].equals(rimas[3])){    
            if (rimas[0].equals(rimas[2]))
                return "CUARTETA";
            else
                return "DESCONOCIDO";
        }
        return seguidilla();
    }
    public static String seguidilla(){
        if (!rimas[0].equals(rimas[3]) && 
        !rimas[2].equals(rimas[3]) &&
        !rimas[2].equals(rimas[0])){
            String[] rimasA = {"", "", "", ""};
            int cont = 0;
            for (String palabra : rimas){
                for (int i = 0; i < palabra.length(); i++){
                    if ("aeiou".indexOf(palabra.substring(i, i + 1)) != -1)
                        rimasA[cont] += palabra.substring(i, i + 1);
                }
                cont++;
            }
            if (rimasA[1].equals(rimasA[3])){
                if (!rimasA[1].equals(rimasA[0]) &&
                !rimasA[1].equals(rimasA[2]) &&
                !rimasA[0].equals(rimasA[2]))
                return "SEGUIDILLA";
            }   
        }
        return "DESCONOCIDO";
    }
}
