package creational.abstractfactory;

public class Main {
    public static void main(String[] args) {
        ITCompanyFactory factory=new BankingFactory();
        Database database = factory.getDatabase();
        Developer developer = factory.getDeveloper();
        GraphicDesigner graphicDesigner = factory.getGraphicDesigner();
    }
}
