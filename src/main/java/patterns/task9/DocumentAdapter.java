package patterns.task9;

public class DocumentAdapter implements DocumentProcessor {
    private DocumentProcessor documentProcessor;

    public DocumentAdapter(DocumentProcessor documentProcessor) {
        this.documentProcessor = documentProcessor;
    }

    @Override
    public void process(String filename) {
        if (documentProcessor instanceof DOCProcessor && filename.contains("pdf")) {
            System.out.println("converting pdf file " + filename + " to " + filename.replace("pdf", "doc"));
        } else if (documentProcessor instanceof PDFProcessor && filename.contains("doc")) {
            System.out.println("converting doc file " + filename + " to " + filename.replace("doc", "pdf"));
        } else documentProcessor.process(filename);
    }
}
