import java.util.List;
import model.Procedimento;
import service.CsvWriter;
import service.PdfTableExtractor;
import service.ZipService;

public class App {
    public static void main(String[] args) {
        String pdfPath = "downloads/Anexo_I.pdf";
        String csvPath = "procedimentos.csv";
        String zipPath = "Teste_Nome.zip";
        
        // 2.1 Extrair dados do PDF
        List<Procedimento> procedimentos = PdfTableExtractor.extractData(pdfPath);
        
        // 2.4 Substituir abreviações
        procedimentos.forEach(Procedimento::expandirAbreviacoes);
        
        // 2.2 Salvar CSV
        CsvWriter.writeToCsv(procedimentos, csvPath);
        
        // 2.3 Compactar
        ZipService.compressFile(csvPath, zipPath);
        
        System.out.println("Processo concluído com sucesso!");
    }
}