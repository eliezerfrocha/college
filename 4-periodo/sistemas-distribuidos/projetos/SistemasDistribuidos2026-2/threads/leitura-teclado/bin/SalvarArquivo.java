import java.io.File;

public class SalvarArquivo implements Runnable {
    private String nomeArquivo = ".\\output\\saida.txt";
    private String conteudo;

    public SalvarArquivo(String nomeArquivo, String conteudo) {
        //this.buffer = buffer;
        File file = new File(nomeArquivo);
        // this.nomeArquivo = nomeArquivo;
        // this.conteudo = conteudo;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000); // Simula um atraso na escrita do arquivo
            java.nio.file.Files.write(java.nio.file.Paths.get(nomeArquivo), conteudo.getBytes());
            System.out.println("Arquivo '" + nomeArquivo + "' salvo com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }
}
