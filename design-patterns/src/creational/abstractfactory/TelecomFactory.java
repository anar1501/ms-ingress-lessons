package creational.abstractfactory;

public class TelecomFactory implements ITCompanyFactory {
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Database getDatabase() {
        return new OracleSql();
    }

    @Override
    public GraphicDesigner getGraphicDesigner() {
        return new UiDesigner();
    }
}
