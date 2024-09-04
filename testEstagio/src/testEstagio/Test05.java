package testEstagio;

import java.util.Scanner;

public class Test05 {
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string: ");
        String original = scanner.nextLine();
        
        char[] caracteres = original.toCharArray();
        
        int i = 0;
        int f = caracteres.length - 1;
        
        while (i < f) {
            char temp = caracteres[i];
            caracteres[i] = caracteres[f];
            caracteres[f] = temp;
            i++;
            f--;
        }
        
        String invertida = new String(caracteres);
        System.out.println("String invertida: " + invertida);
        
        scanner.close();
    }
}
