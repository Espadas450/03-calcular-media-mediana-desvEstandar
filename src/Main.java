import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Declaración de las variables
        Scanner scanner = new Scanner(System.in);
        int longitud = CapturarLongitud(scanner);
        double[] conjunto = new double[longitud];

        conjunto = CapturarConjunto(conjunto, scanner, longitud);

        // Calcular media, mediana y desv. estándar
        double media = CalcularMedia(conjunto, longitud);
        double mediana = CalcularMediana(conjunto);
        double desvEstandar = CalcularDesvEstandar(conjunto, media);

        // Despliegue de datos
        DesplegarResultados(conjunto, media, mediana, desvEstandar);

        scanner.close();
    }

    private static void DesplegarResultados(double[] conjunto, double media, double mediana, double desvEstandar) {
        System.out.println("El conjunto introducido fue: " + Arrays.toString(conjunto));
        Arrays.sort(conjunto);
        System.out.println("El conjunto ordenado es: " + Arrays.toString(conjunto));
        System.out.printf("Media: %.2f\n", media);
        System.out.printf("Mediana: %.2f\n", mediana);
        System.out.printf("Desviación Estándar: %.2f\n", desvEstandar);
    }

    private static double CalcularDesvEstandar(double[] conjunto, double media) {
        double temp = 0;

        for(double n : conjunto){
            temp += Math.pow(n - media, 2);
        }

        return Math.sqrt(temp / conjunto.length);
    }

    private static double CalcularMediana(double[] conjunto) {
        // Ordenamiento del arreglo
        //Arrays.sort(conjunto);
        double[] temp;
        temp = Arrays.copyOf(conjunto, conjunto.length);
        Arrays.sort(temp);

        if(temp.length % 2 == 1){
            return temp[temp.length/2]; // Si es impar
        } else {
            return (temp[temp.length / 2 + 1] + temp[temp.length / 2]) / 2.0; // Para número par
        }
    }

    private static double CalcularMedia(double[] conjunto, int longitud) {
        double temp = 0;

        for(int i = 0 ; i < longitud ; i++){
            temp += conjunto[i];
        }

        return temp / longitud;
    }

    private static double[] CapturarConjunto(double[] conjunto, Scanner scanner, int longitud) {
        double temp;

        for(int i = 0; i < longitud ; i++){
            System.out.printf("Ingresa el valor número %d: ", i + 1);

            while (!scanner.hasNextDouble() || (temp = scanner.nextDouble()) <= 0){
                System.out.println("Por favor ingresa un número positivo válido...");
                scanner.next();
            }

            conjunto[i] = temp;
        }

        return conjunto;
    }

    private static int CapturarLongitud(Scanner scanner) {
        System.out.print("¿Cuántos números desea ingresar?: ");

        int temp = 0;
        while (!scanner.hasNextInt() || (temp = scanner.nextInt()) <= 0){
            System.out.println("Por favor ingresa un número positivo o mayor a 0...");
            System.out.print("¿Cuántos números desea ingresar?: ");
            scanner.next();
        }

        return temp;
    }
}