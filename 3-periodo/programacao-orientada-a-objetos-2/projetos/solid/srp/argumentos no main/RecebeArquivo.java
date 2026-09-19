
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;


public class RecebeArquivo {

    public static void main(String[] args) {
       // int soma = 0;
        FileReader file;
        try{
           if(args.length<=0)
                System.out.println("Sem argumentos");
           else
              for(String arq : args){
                  file = new FileReader(arq);
                  BufferedReader lerArq = new BufferedReader(file);
                  String linha = lerArq.readLine();
                  while (linha != null) {
                       System.out.printf("%s\n", linha);
                       linha = lerArq.readLine(); // lê da segunda até a última linha
                  }
                  file.close();
               }
            } catch (FileNotFoundException e) {
                     e.printStackTrace();
            } catch (IOException e) {
                     e.printStackTrace();
        }
    }
    
}
