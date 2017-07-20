package matsishin.massivemvc.model;

public class NumberEntity implements Entity{
    private String name;
    private Number value;

    public NumberEntity(String name, Number value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Number getValue() {
        return value;
    }

    public String stringOfMe(){
        return this.name+"\n"+value;
    }
}
