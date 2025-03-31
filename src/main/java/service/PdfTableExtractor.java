package service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import model.Procedimento;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


public class PdfTableExtractor {
    public static List<Procedimento> extractData(String pdfPath) {
        List<Procedimento> procedimentos = new ArrayList<>();
        
        try (PDDocument document = PDDocument.load(new File(pdfPath))) {
            PDFTextStripper stripper = new PDFTextStripper();
            
            for (int page = 1; page <= document.getNumberOfPages(); page++) {
                stripper.setStartPage(page);
                stripper.setEndPage(page);
                String text = stripper.getText(document);
                
                // Processar texto e extrair tabela
                procedimentos.addAll(parseTable(text));
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler PDF", e);
        }
        
        return procedimentos;
    }
    
    private static List<Procedimento> parseTable(String text) {
 
        return Arrays.stream(text.split("\n"))
            .filter(line -> line.matches(".*(OD|AMB).*"))
            .map(line -> {
                String[] parts = line.split("\\s{2,}");
                return new Procedimento(parts[0], parts[1], parts[2]);
            })
            .collect(Collectors.toList());
    }
}