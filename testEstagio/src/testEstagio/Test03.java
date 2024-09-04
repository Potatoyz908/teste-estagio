package testEstagio;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Test03 {

    public static void main(String[] args) {
        String caminhoArquivo = "D:\\Programação\\Aplicações a vagas\\testEstagio\\src\\testEstagio\\faturamento.json";

        List<Double> valores = carregarDados(caminhoArquivo);
        double menorValor = Double.MAX_VALUE;
        double maiorValor = Double.MIN_VALUE;
        double soma = 0;
        int diasComFaturamento = 0;

        for (double valor : valores) {
            if (valor > 0) { 
                if (valor < menorValor) {
                    menorValor = valor;
                }
                if (valor > maiorValor) {
                    maiorValor = valor;
                }
                soma += valor;
                diasComFaturamento++;
            }
        }

        double mediaMensal = soma / diasComFaturamento;

        int diasAcimaDaMedia = 0;
        for (double valor : valores) {
            if (valor > mediaMensal) {
                diasAcimaDaMedia++;
            }
        }


        System.out.println("Menor valor de faturamento: " + menorValor);
        System.out.println("Maior valor de faturamento: " + maiorValor);
        System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);
    }

    private static List<Double> carregarDados(String caminhoArquivo) {
        List<Double> valores = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try {
            FileReader reader = new FileReader(caminhoArquivo);
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray faturamentoDiario = (JSONArray) jsonObject.get("faturamento_diario");

            for (Object o : faturamentoDiario) {
                JSONObject dia = (JSONObject) o;
                double valor = (double) dia.get("valor");
                valores.add(valor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return valores;
    }
}
