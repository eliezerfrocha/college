package service;

import model.Funcionario;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FuncionarioService {
    private static final String DIRETORIO = "output";
    private static final String CAMINHO_ARQUIVO = DIRETORIO + "/funcionarios.txt";
    private static int contador = contarRegistrosExistentes();

    public void salvar(Funcionario funcionario) {
        criarDiretorioSeNaoExistir();

        contador++;  // incrementa ao salvar

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO, true))) {
            writer.write("Registro #" + contador);
            writer.newLine();
            writer.write("Data de Cadastro: " + obterDataHoraAtual());
            writer.newLine();
            writer.write("Nome : " + funcionario.getNome());
            writer.newLine();
            writer.write("Cargo: " + funcionario.getCargo());
            writer.newLine();
            writer.write("---------------------------");
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar o funcionário: " + e.getMessage(), e);
        }

        System.out.println("\nFuncionário salvo com sucesso!\n");
    }

    public String exibir() {
        File arquivo = new File(CAMINHO_ARQUIVO);

        if (!arquivo.exists() || arquivo.length() == 0) {
            return "Nenhum funcionário cadastrado.";
        }

        StringBuilder sb = new StringBuilder();

        try (Scanner scanner = new Scanner(arquivo)) {
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append("\n");
            }
        } catch (IOException e) {
            return "Erro ao ler o arquivo: " + e.getMessage();
        }

        return sb.toString();
    }

    private void criarDiretorioSeNaoExistir() {
        File dir = new File(DIRETORIO);
        if (!dir.exists() && !dir.mkdirs()) {
            throw new RuntimeException("Não foi possível criar o diretório 'output'.");
        }
    }

    private static String obterDataHoraAtual() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
    }

    private static int contarRegistrosExistentes() {
        File arquivo = new File(CAMINHO_ARQUIVO);
        int count = 0;

        if (arquivo.exists()) {
            try (Scanner scanner = new Scanner(arquivo)) {
                while (scanner.hasNextLine()) {
                    if (scanner.nextLine().startsWith("Registro #")) {
                        count++;
                    }
                }
            } catch (IOException ignored) {}
        }

        return count;
    }
}