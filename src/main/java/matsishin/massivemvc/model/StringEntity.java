package matsishin.massivemvc.model;

public class StringEntity implements Entity {
    private String name;
    private String value;

    public StringEntity(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public String stringOfMe(){
        return this.name+"\n"+value;
    }
}
