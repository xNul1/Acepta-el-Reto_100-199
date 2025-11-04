import java.util.Scanner;
import java.util.Arrays;

/**
 * De nuevo en el bar de Javier
 * Ejercicio 108
 * @author xNul1
 */

public class p108 {

    static Scanner sc = new Scanner(System.in);
    static double[] val = new double[5];
    static int contTotal;
    static int contComidas;
    static final String[][] tipo = {
        {"DESAYUNOS", "COMIDAS", "MERIENDAS", "CENAS", "COPAS"},
        {"D", "A", "M", "I", "C"}
    };

    public static void main(String[] args) {
        while(sc.hasNext()){
            contTotal = 0;
            contComidas = 0;
            entrada();
        }
    }

    public static void entrada(){
        Arrays.fill(val, 0);
        double num, media = 0;
        String categoria;
        do{
            categoria = sc.next();
            num = sc.nextDouble();
            if (categoria.equals("N")){
                break;
            }else{
                suma(categoria, num);
                media += num;
            }
        }while(true);
        promedio();
        salidaMedia(media);
    }

    public static void suma(String categoria, double num){
        for (int i = 0; i < 5; i++){
            if (tipo[1][i].equals(categoria)){
                val[i] += num;
                contTotal++;
                if (i == 1){contComidas++;}
                break;
            }
        }
    }

    public static void promedio(){
        boolean empateMax = false, empateMin = false;
        int posMax = 0, posMin = 0;
        double max = 0, min = Double.MAX_VALUE;
        for (int i = 0; i < 5; i++){
            if (val[i] > max){
                empateMax = false;
                max = val[i];
                posMax = i;
            }else if (val[i] == val[posMax]){
                empateMax = true;
            }
            if (val[i] < min){
                empateMin = false;
                min = val[i];
                posMin = i;
            }else if (val[i] == val[posMin]){
                empateMin = true;
            }
        }
        salidaMaximo(empateMax, posMax);
        salidaMinimo(empateMin, posMin);
    }

    public static void salidaMaximo(boolean empateMax, int posM){
        if (empateMax)
            System.out.print("EMPATE#");
        else
            System.out.print(tipo[0][posM] + "#");
    }

    public static void salidaMinimo(boolean empateMin, int posN){
        if (empateMin)
            System.out.print("EMPATE#");
        else
            System.out.print(tipo[0][posN] + "#");
    }

    public static void salidaMedia(double media){
        if (val[1] / contComidas > media / contTotal)
            System.out.println("SI");
        else
            System.out.println("NO");
    }
}
