/*Financiamento de veículos: implemente a lógica no Servidor para verificar se o 
financiamento de um veículo será aprovado, recebendo para tal o valor do veículo, 
o valor da entrada e a quantidade de tempo (em meses) que o cliente deseja financiar 
o veículo. Considere que a financiadora adota um acréscimo (juros) de 35% sobre o valor 
financiado, caso a entrada seja superior ou igual 50% do valor do veículo. Caso a entrada 
seja inferior a 50% do valor do veículo, o juros serão de 45% sobre o valor financiado. 
Este método deve retornar o valor das parcelas deste financiamento.*/
package socket1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor1 {

    public static void main(String[] args) throws IOException {
        double financiamento = 0;
        double valorConvertido = 0, valorEntrada = 0;
        int tempoAux = 0;

        System.out.println("******SERVIDOR******");

        ServerSocket servidor = new ServerSocket(50707);
        Socket cliente = servidor.accept();

        DataInputStream entrada = new DataInputStream(cliente.getInputStream());
        DataInputStream valor = new DataInputStream(cliente.getInputStream());
        DataInputStream tempo = new DataInputStream(cliente.getInputStream());
        DataOutputStream enviaParaCliente = new DataOutputStream(cliente.getOutputStream());
        
        valorConvertido = valor.readDouble();
        valorEntrada = entrada.readDouble();
        tempoAux = tempo.readInt();
        
        financiamento = valorConvertido - valorEntrada;
        if (valorEntrada >= (valorConvertido * 0.5)) {
            financiamento = financiamento * 0.35;
        }else if (valorEntrada < (valorConvertido * 0.5)) {
            financiamento = financiamento * 0.45;
        }
        
        enviaParaCliente.writeDouble(financiamento / tempoAux);
    }
}
