package patterns.task9;

public class DOCProcessor implements DocumentProcessor {
    @Override
    public void process(String filename) {
        System.out.println("processing DOC file: " + filename);
    }
}
