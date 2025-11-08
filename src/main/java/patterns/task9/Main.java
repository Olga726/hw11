package patterns.task9;

public class Main {
    public static void main(String[] args) {
        DocumentProcessor processor1 = new DOCProcessor();
        DocumentAdapter adapter = new DocumentAdapter(processor1);
        adapter.process("file.pdf");

        DocumentProcessor processor2 = new PDFProcessor();
        DocumentAdapter adapter2 = new DocumentAdapter(processor2);
        adapter2.process("file.doc");

        DocumentProcessor processor3 = new PDFProcessor();
        DocumentAdapter adapter3 = new DocumentAdapter(processor3);
        adapter3.process("file.pdf");

    }
}
