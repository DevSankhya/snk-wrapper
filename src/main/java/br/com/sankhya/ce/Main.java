package br.com.sankhya.ce;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File dir = new File("libs");  // Substitua pelo caminho do seu diretório
        List<File> files = getFilesFromDir(dir);
        addToDependencies(files);
    }

    // Função para obter arquivos .jar recursivamente de um diretório
    public static List<File> getFilesFromDir(File dir) {
        List<File> files = new ArrayList<>();
        File[] fileList = dir.listFiles();

        if (fileList != null) {
            for (File file : fileList) {
                if (file.isDirectory()) {
                    // Chama recursivamente para subdiretórios
                    files.addAll(getFilesFromDir(file));
                } else if (file.getName().endsWith(".jar")) {
                    // Adiciona o arquivo .jar à lista
                    files.add(file);
                }
            }
        }
        return files;
    }

    // Função para adicionar arquivos como dependências no formato desejado
    public static void addToDependencies(List<File> files) {
        for (File file : files) {
            // Imprime no formato desejado
            System.out.println(String.format("implementation(mapOf(\"name\" to \"%s\"))", file.getName().replaceFirst("[.][^.]+$", "")));
        }
    }
}