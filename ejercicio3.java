import java.util.Scanner;

public class ejercicio3 {

    public static void main(String [] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese un número: ");
        int numeroIngresado = input.nextInt();

        int dobleNumero = devolverDoble(numeroIngresado);

        System.out.println("El doble del número ingresado es: " + dobleNumero);

    }

    public static int devolverDoble(int num){
        return num*2;
    }
}
