// Singleton Class (PrinterManager)
class PrinterManager {
    private static PrinterManager instance;

    private PrinterManager() {
        // Private constructor to prevent instantiation
    }

    public static PrinterManager getInstance() {
        if (instance == null) {
            instance = new PrinterManager();
        }
        return instance;
    }

    public void printDocument(String document) {
        System.out.println("Printing: " + document);
    }
}

public class SingletonPrinterDemo {
    public static void main(String[] args) {
        PrinterManager printer1 = PrinterManager.getInstance();
        printer1.printDocument("Report_2024.pdf");

        PrinterManager printer2 = PrinterManager.getInstance();
        printer2.printDocument("Invoice_12345.pdf");

        System.out.println(printer1 == printer2);  // true, both point to the same instance
    }
}
