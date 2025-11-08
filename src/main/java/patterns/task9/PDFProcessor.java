package patterns.task9;

public class PDFProcessor implements DocumentProcessor {

    @Override
    public void process(String filename) {
        System.out.println("processing PDF file: " + filename);
    }
}
