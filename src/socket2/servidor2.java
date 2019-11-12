/*Seguro veicular: implemente a lógica no Servidor para calcular o valor do seguro
do veículo, recebendo para tal o ano do veículo, região de São Paulo onde reside
o dono do veículo e seu valor. Para veículos até 2005, o valor do seguro
correspoderá a 15% do valor do veículo. Para veículos de 2006 até 2014, o valor do
seguro correspoderá a 10% do valor do veículo. Para veículos a partir de 2014, o valor do
seguro correspoderá a 5% do valor do veículo. Para cada região de São Paulo deverá ser
adicionada uma taxa extra sobre o valor do seguro. Para tal, siga a tabela abaixo:
Região Valor da Taxa
Zona Sul R$ 500,00
Zona Oeste R$ 350,00
Zona Leste R$ 600,00
Zona Norte R$ 250,00
Este método deve retornar o valor do seguro.*/
package socket2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor2 {

    public static void main(String[] args) throws IOException {

        int anoConvertido = 0;
        String regiaoConvertida;
        double valorConvertido = 0, valorseg = 0;

        System.out.println("***SERVIDOR***");
        
        ServerSocket servidor = new ServerSocket(50708);
        Socket cliente = servidor.accept();

        DataInputStream ano = new DataInputStream(cliente.getInputStream());
        DataInputStream regiao = new DataInputStream(cliente.getInputStream());
        DataInputStream valor = new DataInputStream(cliente.getInputStream());

        anoConvertido = ano.readInt();
        regiaoConvertida = regiao.readUTF();
        valorConvertido = valor.readDouble();
        
        //verificando ano do carro
        if (anoConvertido <= 2005) {
            valorseg = valorConvertido * 0.15;
        }else if (anoConvertido >= 2006 && anoConvertido < 2014) {
            valorseg = valorConvertido * 0.1;
        }else if (anoConvertido >= 2014) {
            valorseg = valorConvertido * 0.05;
        }
        
        //verificando regiao
        if (regiaoConvertida.equals("ZS")) {
            valorseg = valorseg + 500;
        }else if (regiaoConvertida.equals("ZO")) {
            valorseg = valorseg + 350;
        }else if (regiaoConvertida.equals("ZL")) {
            valorseg = valorseg + 600;
        }else if (regiaoConvertida.equals("ZN")) {
            valorseg = valorseg + 250;
        }

        System.out.println("Valor do seguro: " + valorseg);
    }
}
