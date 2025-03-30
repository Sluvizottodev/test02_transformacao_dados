package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import model.Procedimento;

public class CsvWriter {
    public static void writeToCsv(List<Procedimento> procedimentos, String filePath) {
        try (PrintWriter writer = new PrintWriter(new File(filePath))) {
            writer.println("Código,Descrição,Tipo");
            
            procedimentos.forEach(p -> 
                writer.println(String.format("\"%s\",\"%s\",\"%s\"", 
                    p.getCodigo(), p.getDescricao(), p.getTipo())));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Erro ao escrever CSV", e);
        }
    }
}