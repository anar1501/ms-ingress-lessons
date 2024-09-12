package creational.abstractfactory;

public interface ITCompanyFactory {
    Developer getDeveloper();

    Database getDatabase();

    GraphicDesigner getGraphicDesigner();

}
