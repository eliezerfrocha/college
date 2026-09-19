 
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

 public class GeraArquivo {

    public static void main(String[] args) throws IOException{
        BufferedWriter br = new BufferedWriter(new FileWriter("teste.txt"));

        br.write("Vamos escrever nesse novo arquivo em Java! que legal hahaha!!!");
        br.newLine();
        br.newLine();
        br.write("Vamos escrever outra linha aqui embaixo hahaha!!!");
        br.close();
    }
 }