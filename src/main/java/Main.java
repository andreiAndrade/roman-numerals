import coverter.IntegerToRomanConverter;
import coverter.RomanToIntegerConverter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, String> encode = new HashMap<>();

    public static void main(String[] args) {
        String operacao = "";

        while (!operacao.equals("3")) {
            System.out.println();
            System.out.println("Operações: ");
            System.out.println("1 - Converter número romano em decimal;");
            System.out.println("2 - Converter número decimal em romano;");
            System.out.println("3 - Sair.");
            System.out.print("Digite o número correspondente a operação desejada: ");
            Scanner in = new Scanner(System.in);
            operacao = in.next();
            System.out.println();

            switch (operacao) {
                case "1":
                    romanToDecimal();
                    break;
                case "2":
                    decimalToRoman();
                case "3":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Operação inválida");
            }
        }
    }


    private static void decimalToRoman() {
        System.out.print("Digite um número inteiro na escala decimal: ");
        Scanner in = new Scanner(System.in);
        String decimalNumber = in.next();

        try {
            System.out.println("Número em romano: " + IntegerToRomanConverter.convert(decimalNumber));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void romanToDecimal() {
        System.out.print("Digite um número romano: ");
        Scanner in = new Scanner(System.in);
        String decimalNumber = in.next();

        try {
            System.out.println("Número decimal: " + RomanToIntegerConverter.convert(decimalNumber));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
