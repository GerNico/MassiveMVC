package matsishin.massivemvc.controller;

import matsishin.massivemvc.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static matsishin.massivemvc.model.TaskNumber.*;

class Controller {
    void forwardAndReverse(Model model) {
        checkModel(model, FIRST);
        int[] mas = model.getInput().get(0).clone();

        StringJoiner sj1 = new StringJoiner(" ");
        for (int ma : mas) {
            sj1.add(String.valueOf(ma));
        }
        Entity entity1 = new StringEntity("normal order", sj1.toString());

        StringJoiner sj2 = new StringJoiner(" ");
        for (int i = mas.length - 1; i >= 0; i--) {
            sj2.add(String.valueOf(mas[i]));
        }
        Entity entity2 = new StringEntity("reverse order", sj2.toString());
        List<Entity> entities = new ArrayList<>();
        entities.add(entity1);
        entities.add(entity2);
        model.setOutput(entities);

    }

    void sumOfAll(Model model) {
        checkModel(model, SECOND);
        int[] mas = model.getInput().get(0).clone();
        long result = 0;

        for (int element : mas) {
            result += element;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) throw new ControllerException("int overflow");
        else {
            List<Entity> entities = new ArrayList<>();
            entities.add(new NumberEntity("total sum is:", (int) result));
            model.setOutput(entities);
        }
    }

    void maxFromArr(Model model) {
        checkModel(model, THIRD);
        int[] mas = model.getInput().get(0).clone();
        int result = mas[0];
        for (int i = 0; i < mas.length - 1; i++) {
            if (mas[i] > result) result = mas[i];
        }
        List<Entity> entities = new ArrayList<>();
        entities.add(new NumberEntity("max value is:", result));
        model.setOutput(entities);
    }

    void minIndex(Model model) {
        checkModel(model, FOURTH);
        int[] mas = model.getInput().get(0).clone();
        int result = 0;
        for (int i = 0; i < mas.length - 1; i++) {
            if (mas[i] < mas[result]) result = i;
        }
        List<Entity> entities = new ArrayList<>();
        entities.add(new NumberEntity("index of min value is:", result));
        entities.add(new NumberEntity("min value is:", mas[result]));
        model.setOutput(entities);
    }

    void evenCountAndSum(Model model) {
        checkModel(model, FIFTH);
        int[] mas = model.getInput().get(0).clone();
        long sum = 0;
        int num = 0;
        for (int ma : mas) {
            if (ma % 2 == 0) {
                sum += ma;
                num++;
            }
        }
        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) throw new ControllerException("int overflow");
        List<Entity> entities = new ArrayList<>();
        entities.add(new NumberEntity("number of evens is:", num));
        entities.add(new NumberEntity("sum of evens is:", (int) sum));
        model.setOutput(entities);
    }

    void evenCountAndSum2030(Model model) {
        checkModel(model, SIXTH);
        int[] mas = model.getInput().get(0).clone();
        long sum = 0;
        int num = 0;
        for (int ma : mas) {
            if (ma % 2 == 0 && ma < 30 && ma > 20) {
                sum += ma;
                num++;
            }
        }
        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) throw new ControllerException("int overflow");
        List<Entity> entities = new ArrayList<>();
        entities.add(new NumberEntity("number of evens 20<e<30 is:", num));
        entities.add(new NumberEntity("sum of evens 20<e<30 is:", (int) sum));
        model.setOutput(entities);
    }

    void minOddMaxEven(Model model) {
        checkModel(model, SEVENTH);
        int[] mas = model.getInput().get(0).clone();
        int minOdd = 0, maxEven = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] % 2 != 0) {
                if (mas[i] < mas[minOdd]) minOdd = i;
            } else if (mas[i] > mas[maxEven]) maxEven = i;
        }
        List<Entity> entities = new ArrayList<>();
        entities.add(new NumberEntity("min odd number is:", mas[minOdd]));
        entities.add(new NumberEntity("max even number is:", mas[maxEven]));
        model.setOutput(entities);
    }

    void makePositive(Model model) {
        checkModel(model, EIGHTH);
        int[] mas = model.getInput().get(0).clone();

        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < 0) mas[i] = ~mas[i] + 1;
        }
        List<Entity> entities = new ArrayList<>();
        entities.add(new IntMasEntity("Array without negatives :", mas));
        model.setOutput(entities);
    }

    void incPosDecNeg(Model model) {
        checkModel(model, NINTH);
        int[] mas = model.getInput().get(0).clone();

        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < 0) mas[i] = --mas[i];
            if (mas[i] > 0) mas[i] = ++mas[i];
        }
        List<Entity> entities = new ArrayList<>();
        entities.add(new IntMasEntity("Array with negative-- positive++:", mas));
        model.setOutput(entities);
    }

    void meanAndNumOfBigger(Model model) {
        checkModel(model, TENTH);
        int[] mas = model.getInput().get(0).clone();
        long sum = 0;
        for (int ma : mas) {
            sum += ma;
        }
        double mean = sum / mas.length;
        int howMany = 0;
        for (int ma : mas) {
            if (ma > mean) howMany++;
        }
        List<Entity> entities = new ArrayList<>();
        entities.add(new NumberEntity("mean value is:", mean));
        entities.add(new NumberEntity("Number of elements bigger than mean:", howMany));
        model.setOutput(entities);
    }

    void sumOfMass(Model model) {
        checkModel(model, ELEVENTH);
        int[] m1 = model.getInput().get(0).clone();
        int[] m2 = model.getInput().get(1);
        if (m1.length != m2.length) throw new ControllerException("missives of different size");
        for (int i = 0; i < m1.length; i++) {
            m1[i] = m1[i] + m2[i];
        }
        List<Entity> entities = new ArrayList<>();
        entities.add(new IntMasEntity("sum of each element:", m1));
        model.setOutput(entities);
    }

    void concatMass(Model model) {
        checkModel(model, TWELFTH);
        int[] m1 = model.getInput().get(0);
        int[] m2 = model.getInput().get(1);
        int[] newMas = new int[m1.length + m2.length];
        System.arraycopy(m1, 0, newMas, 0, m1.length);
        System.arraycopy(m2, 0, newMas, m1.length, m2.length);
        List<Entity> entities = new ArrayList<>();
        entities.add(new IntMasEntity("concat mass:", newMas));
        model.setOutput(entities);
    }

    void replaseMaxMin(Model model) {
        checkModel(model, THIRTEENTH);
        int[] mas = model.getInput().get(0).clone();
        int minIndex = 0, maxIndex = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < mas[minIndex]) minIndex = i;
            if (mas[i] > mas[maxIndex]) maxIndex = i;
        }
        mas[minIndex] = mas[minIndex] ^ mas[maxIndex];
        mas[maxIndex] = mas[maxIndex] ^ mas[minIndex];
        mas[minIndex] = mas[minIndex] ^ mas[maxIndex];
        List<Entity> entities = new ArrayList<>();
        entities.add(new IntMasEntity("massive with replaced min/max:", mas));
        model.setOutput(entities);
    }

    void deleteMaxMin(Model model) {
        checkModel(model, FOURTEENTH);
        int[] mas = model.getInput().get(0).clone();
        int minIndex = 0, maxIndex = 0;

        if (mas.length < 2) throw new ControllerException("too small array");

        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < mas[minIndex]) minIndex = i;
        }

        System.arraycopy(mas, minIndex + 1, mas, minIndex, mas.length - 1 - minIndex);
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] > mas[maxIndex]) maxIndex = i;
        }
        System.arraycopy(mas, maxIndex + 1, mas, maxIndex, mas.length - 1 - maxIndex);
        mas[mas.length - 1] = 0;
        mas[mas.length - 2] = 0;

        List<Entity> entities = new ArrayList<>();
        entities.add(new IntMasEntity("massive with removed min & max:", mas));
        model.setOutput(entities);
    }

    void splitNegAndPos (Model model){
        checkModel(model, FIFTEENTH);
        int[] mas = model.getInput().get(0).clone();
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        for (int ma : mas) {
            if (ma < 0) list1.add(ma);
            else list2.add(ma);
        }
        List<Entity> entities = new ArrayList<>();
        entities.add(new IntMasEntity("massive of negatives:", list1.stream().mapToInt(i->i).toArray()));
        entities.add(new IntMasEntity("massive of other:", list2.stream().mapToInt(i->i).toArray()));
        model.setOutput(entities);
    }


    private static void checkModel(Model model, TaskNumber taskNumber) { //todo: implement the verification of model
        if (!model.getNumber().equals(taskNumber)) throw new ControllerException("wrong model was passed");
    }
}
