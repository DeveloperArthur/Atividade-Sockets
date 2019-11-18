package socket2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class cliente2 {

    public static void main(String[] args) throws IOException {
        System.out.println("******CLIENTE******");

        Socket cliente = new Socket("localhost", 50708);

        DataOutputStream ano = new DataOutputStream(cliente.getOutputStream());
        DataOutputStream regiao = new DataOutputStream(cliente.getOutputStream());
        DataOutputStream valor = new DataOutputStream(cliente.getOutputStream());
        DataInputStream respostaServidor = new DataInputStream(cliente.getInputStream());
        
        System.out.println("Ano do veiculo:");
        ano.writeInt(new Scanner(System.in).nextInt());
        System.out.println("Região:");
        regiao.writeUTF(new Scanner(System.in).nextLine());
        System.out.println("Valor do veiculo:");
        valor.writeDouble(new Scanner(System.in).nextDouble());
        
        double valorseg = respostaServidor.readDouble();
        System.out.println("Valor do seguro: " + valorseg);
    }
}
