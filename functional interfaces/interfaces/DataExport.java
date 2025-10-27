
interface DataExport {
    void exportCSV();
    void exportPDF();
    default void exportToJSON(){System.out.println("Exported JSON");}
}
class Report implements DataExport {
    public void exportCSV(){System.out.println("CSV Exported");}
    public void exportPDF(){System.out.println("PDF Exported");}
}
