package matsishin.massivemvc.model;

import java.util.StringJoiner;

public class IntMasEntity implements Entity {
    private String name;
    private int[] value;

    public IntMasEntity(String name, int[] value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int[] getValue() {
        return value;
    }

    public String stringOfMe(){
        StringJoiner sj=new StringJoiner(" ");
        for (int element:this.value) {
            sj.add(String.valueOf(element));
        }
        return this.name+"\n"+sj;
    }
}
