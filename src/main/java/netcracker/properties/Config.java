package netcracker.properties;

public class Config extends Property {
    private static Property instance;
    public static Property getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    @Override
    protected String getFileName() {
        return "config";
    }
}
