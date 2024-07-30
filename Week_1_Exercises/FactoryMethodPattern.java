interface Document {
    void open();
    void close();
    void save();
}

 class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word document.");
    }

    @Override
    public void close() {
        System.out.println("Closing Word document.");
    }

    @Override
    public void save() {
        System.out.println("Saving Word document.");
    }
}

 class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document.");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF document.");
    }

    @Override
    public void save() {
        System.out.println("Saving PDF document.");
    }
}

 class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel document.");
    }

    @Override
    public void close() {
        System.out.println("Closing Excel document.");
    }

    @Override
    public void save() {
        System.out.println("Saving Excel document.");
    }
}
 abstract class DocumentFactory {
    public abstract Document createDocument();
}
 class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}
 class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}

 class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}

public class FactoryMethodPattern {
    public static void main(String[] args) {

        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDocument = wordFactory.createDocument();
        wordDocument.open();
        wordDocument.save();
        wordDocument.close();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDocument = pdfFactory.createDocument();
        pdfDocument.open();
        pdfDocument.save();
        pdfDocument.close();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDocument = excelFactory.createDocument();
        excelDocument.open();
        excelDocument.save();
        excelDocument.close();
    }
}
