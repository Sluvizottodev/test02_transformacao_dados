# 📂 Processador de Dados de Saúde - Java

**Extração de dados de PDF para CSV compactado**

## 📋 Descrição
Aplicação Java que processa o PDF "Rol de Procedimentos e Eventos em Saúde", extrai os dados e gera um arquivo CSV compactado com as abreviações substituídas por descrições completas.

## 🛠️ Tecnologias Utilizadas
- **Java 21**
- Apache PDFBox (para extração de PDF)
- OpenCSV (para geração de CSV)

## 🏗️ Estrutura do Projeto
```
src/
├── main/
│ ├── java/
│ │ ├── model/
│ │ │ ├── Colunas.java
│ │ │ └── Procedimento.java 
│ │ ├── service/
│ │ │ ├── PdfProcessor.java # Processamento de PDF
│ │ │ ├── CsvWriter.java # Geração de CSV
│ │ │ └── ZipService.java # Compactação
│ │ └── App.java # Classe principal
│ └── resources/
└── pom.xml
```

## ⚙️ Funcionalidades
1. **Extração de dados** do PDF (todas as páginas)
2. **Substituição de abreviações**:
   - OD → Odontológico
   - AMB → Ambulatorial
3. **Geração de CSV** estruturado
4. **Compactação** para arquivo ZIP

## 🚀 Como Executar
1. **Pré-requisitos**:
   - Java instalado
   - Maven configurado

