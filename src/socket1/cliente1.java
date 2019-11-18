package socket1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class cliente1 {
    
    public static void main(String[] args) throws IOException {
        System.out.println("******CLIENTE******");

        Socket cliente = new Socket("localhost", 50707);

        DataOutputStream valor = new DataOutputStream(cliente.getOutputStream());
        DataOutputStream entrada = new DataOutputStream(cliente.getOutputStream());
        DataOutputStream tempo = new DataOutputStream(cliente.getOutputStream());
        DataInputStream respostaServidor = new DataInputStream(cliente.getInputStream());

        System.out.println("Valor do veiculo:");
        valor.writeDouble(new Scanner(System.in).nextDouble());
        System.out.println("Valor da entrada:");
        entrada.writeDouble(new Scanner(System.in).nextDouble());
        System.out.println("Tempo em meses:");
        tempo.writeInt(new Scanner(System.in).nextInt());
        
        double valorParcelas = respostaServidor.readDouble();
        System.out.println("valor das parcela do finaciamento " + valorParcelas);
    }
}
