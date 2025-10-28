import java.util.Scanner;

/**
 * Encriptacion de mensajes
 * Ejercicio 102
 * @author xNul1
 */

public class p102 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        String cadena;
        int clave;
        while(true){
            cadena = sc.nextLine().toLowerCase();
            clave = (int)cadena.charAt(0) - 'p';
            if (cadena.length() == 4 &&
            cadena.charAt(1) - clave == 'F' &&
            cadena.charAt(2) - clave == 'I' &&
            cadena.charAt(3) - clave == 'N'){
                break;
            }
            vocales(cadena, clave);
        }
    }

    public static void vocales(String cadena, int clave){
        int caracter, contador = 0;
        for (int i = 0; i < cadena.length(); i++){
            caracter = cadena.charAt(i);
            if (caracter >= 'a' && caracter <= 'z'){
                caracter -= clave;
                caracter = caracter > 'z' ? caracter - 26 : caracter < 'a' ? caracter + 26 : caracter;
                if (caracter == 'a' || 
                caracter == 'e' || 
                caracter == 'i' || 
                caracter == 'o' || 
                caracter == 'u')
                    contador++;
            }
        }
        System.out.println(contador);
    }
}
