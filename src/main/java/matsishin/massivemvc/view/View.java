package matsishin.massivemvc.view;

import matsishin.massivemvc.model.Entity;
import matsishin.massivemvc.model.Model;

import java.util.List;

public class View {
    public void soutTheModel(Model model){
        System.out.println("Task "+model.getNumber()+" :");
        if (model.getOutput()!=null){
       List<Entity> entities= model.getOutput();
        for (Entity e:entities) {
            System.out.println(e.stringOfMe());
        }
            System.out.println();
    }else System.out.println("empty model =(");
    }
}
