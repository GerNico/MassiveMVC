package matsishin.massivemvc.model;

import java.util.List;

public class Model {
    private TaskNumber number;
    private List<int[]> input;
    private List<Entity> output;

    public TaskNumber getNumber() {
        return number;
    }

    public List<int[]> getInput() {
        return input;
    }

    public List<Entity> getOutput() {
        return output;
    }

    public void setOutput(List<Entity> output) {
        this.output = output;
    }

    public Model(TaskNumber number, List<int[]> input, List<Entity> output) {
        this.number = number;
        this.input = input;
        this.output = output;
    }
}
