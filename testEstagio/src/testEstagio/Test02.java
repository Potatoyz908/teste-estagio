package testEstagio;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int numero = scanner.nextInt();
        scanner.close();
    
        int a = 0,
        b = 1,
        fibonacci = 0;

        if (numero == 0 || numero == 1) {
            System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
            return;
        }

        while (fibonacci < numero) {
            fibonacci = a + b;
            a = b;
            b = fibonacci;
        }

        if (fibonacci == numero) {
            System.out.println("O número " + numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + numero + " não pertence à sequência de Fibonacci.");
        }
    }
}
