package com.github.DevSankhya;

import br.com.sankhya.modelcore.util.SPBeanUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File dir = new File("libs");  // Substitua pelo caminho do seu diretório
        List<File> files = getFilesFromDir(dir);
        for (File file : files) {
            renameFile(file);
        }

//        getDep(files);
    }

    public static void getDep(List<File> files) {
        for (File file : files) {
            // Imprime no formato desejado
            System.out.printf("implementation(\":%s\")%n", file.getName().replaceFirst("[.][^.]+$", ""));
        }
    }

    private static List<File> getDirs(File dir) {
        List<File> dirs = new ArrayList<>();
        File[] dirList = dir.listFiles();
        if (dirList != null) {
            for (File file : dirList) {
                if (file.isDirectory()) {
                    dirs.add(file);
                }
            }
        }
        return dirs;
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
            System.out.printf("implementation(\"br.com.sankhya:%s:master\")\n", file.getName().replaceFirst("[.][^.]+$", ""));
        }
    }

    public static void renameFile(File file) {
        // Get file name without extension
        String fileName = file.getName().replaceFirst("[.][^.]+$", "");
        // Remove all numbers from fileName
        fileName = fileName.replaceAll("\\d", "");
        // Remove all dots from fileName
        fileName = fileName.replaceAll("\\.", "");
        // Remove all alone hyphens from fileName
        fileName = fileName.replaceAll("-$", "");
        
        file.renameTo(new File("libs/" + fileName + ".jar"));
        // Create a pom.xml file in the folder
    }

    public static void createPomLib(File file) {
        // Get file name without extension
        String fileName = file.getName().replaceFirst("[.][^.]+$", "");
        // Remove all numbers from fileName
        fileName = fileName.replaceAll("\\d", "");
        // Remove all dots from fileName
        fileName = fileName.replaceAll("\\.", "");
        // Remove all alone hyphens from fileName
        fileName = fileName.replaceAll("-$", "");

        String version = "master";

        // Delete "libs2" if exists
        File libs = new File("libs");
        // Copy file to a folder with the same name as the file without extension
        File folder = new File(libs, fileName + "/" + version);
        folder.mkdirs();
        File newFile = new File(folder, fileName + "-" + version + ".jar");
        copyFile(file, newFile);
        // Create a pom.xml file in the folder
        try {
            generatePomFile(fileName, "com.github.DevSankhya", version);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public static void generatePomFile(String fileName, String group, String version) throws JAXBException {
        // Criar objeto Java
        Pom pom = new Pom();
        pom.setModelVersion("4.0.0");
        pom.setGroupId(group);
        pom.setArtifactId(fileName);
        pom.setVersion(version);
        pom.setPackaging("jar");
        pom.setName(fileName);
        pom.setDescription(fileName + " library");

        // Serializar para XML
        JAXBContext context = JAXBContext.newInstance(Pom.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // Create file if not exists
        File file = new File("libs/" + fileName + "/" + version + "/pom.xml");
        marshaller.marshal(pom, file); // salvar no arquivo
    }

    private static void copyFile(File source, File dest) {
        try {
            java.nio.file.Files.copy(source.toPath(), dest.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}