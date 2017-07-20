package matsishin.massivemvc.controller;

import matsishin.massivemvc.model.Model;

import static matsishin.massivemvc.model.TaskNumber.*;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ControllerTest {

    @Test
    public void testForwardAndReverse() {
        ArrayList<int[]> input = new ArrayList<>(1);
        input.add(new int[]{1, 5, 7, 54, 3, 7, 3, 1, 45, 86, 25});
        Model model = new Model(FIRST, input, null);
        Controller controller = new Controller();
        controller.forwardAndReverse(model);
        String name1 = model.getOutput().get(0).getName();
        String name2 = model.getOutput().get(1).getName();
        String val1 = (String) model.getOutput().get(0).getValue();
        String val2 = (String) model.getOutput().get(1).getValue();

        assertTrue(name1.equals("normal order") && val1.equals("1 5 7 54 3 7 3 1 45 86 25"));
        assertTrue(name2.equals("reverse order") && val2.equals("25 86 45 1 3 7 3 54 7 5 1"));
    }

    @Test
    public void testSumOfAll() {
        ArrayList<int[]> input = new ArrayList<>(1);
        input.add(new int[]{1, 5, 7, 54, 3, 7, 3, 1, 45, 86, 25});
        Model model = new Model(SECOND, input, null);
        Controller controller = new Controller();
        controller.sumOfAll(model);
        String name = model.getOutput().get(0).getName();
        Integer value = (Integer) model.getOutput().get(0).getValue();
        assertTrue(name.equals("total sum is:") && value.equals(237));
    }

    @Test
    public void testMaxFromArr() {
        ArrayList<int[]> input = new ArrayList<>(1);
        input.add(new int[]{1, 5, 7, 54, 3, 7, 3, 1, 45, 86, 25});
        Model model = new Model(THIRD, input, null);
        Controller controller = new Controller();
        controller.maxFromArr(model);
        String name = model.getOutput().get(0).getName();
        Integer value = (Integer) model.getOutput().get(0).getValue();
        assertTrue(name.equals("max value is:") && value.equals(86));
    }

    @Test
    public void testMinIndex() {
        ArrayList<int[]> input = new ArrayList<>(1);
        input.add(new int[]{1, 5, -7, 54, 3, 7, 3, 1, 45, 86, 25});
        Model model = new Model(FOURTH, input, null);
        Controller controller = new Controller();
        controller.minIndex(model);
        String name1 = model.getOutput().get(0).getName();
        Integer value1 = (Integer) model.getOutput().get(0).getValue();
        String name2 = model.getOutput().get(1).getName();
        Integer value2 = (Integer) model.getOutput().get(1).getValue();
        assertTrue(name1.equals("index of min value is:") && value1.equals(2));
        assertTrue(name2.equals("min value is:") && value2.equals(-7));
    }

    @Test
    public void testEvenCountAndSum() {
        ArrayList<int[]> input = new ArrayList<>(1);
        input.add(new int[]{1, 5, -17, 54, 3, 7, 35, 1, 46, 86, 25});
        Model model = new Model(FIFTH, input, null);
        Controller controller = new Controller();
        controller.evenCountAndSum(model);
        String name1 = model.getOutput().get(0).getName();
        Integer value1 = (Integer) model.getOutput().get(0).getValue();
        String name2 = model.getOutput().get(1).getName();
        Integer value2 = (Integer) model.getOutput().get(1).getValue();
        assertTrue(name1.equals("number of evens is:") && value1.equals(3));
        assertTrue(name2.equals("sum of evens is:") && value2.equals(186));
    }

    @Test
    public void testEvenCountAndSum2030() {
        ArrayList<int[]> input = new ArrayList<>(1);
        input.add(new int[]{1, 5, 22, -54, 3, 7, 35, 1, 46, 26, 25});
        Model model = new Model(SIXTH, input, null);
        Controller controller = new Controller();
        controller.evenCountAndSum2030(model);
        String name1 = model.getOutput().get(0).getName();
        Integer value1 = (Integer) model.getOutput().get(0).getValue();
        String name2 = model.getOutput().get(1).getName();
        Integer value2 = (Integer) model.getOutput().get(1).getValue();
        assertTrue(name1.equals("number of evens 20<e<30 is:") && value1.equals(2));
        assertTrue(name2.equals("sum of evens 20<e<30 is:") && value2.equals(48));
    }

    @Test
    public void testMinOddMaxEven() {
        ArrayList<int[]> input = new ArrayList<>(1);
        input.add(new int[]{1, 5, 22, -54, 3, 7, 35, 1, 46, 26, 25});
        Model model = new Model(SEVENTH, input, null);
        Controller controller = new Controller();
        controller.minOddMaxEven(model);

        String name1 = model.getOutput().get(0).getName();
        Integer value1 = (Integer) model.getOutput().get(0).getValue();
        String name2 = model.getOutput().get(1).getName();
        Integer value2 = (Integer) model.getOutput().get(1).getValue();
        assertTrue(name1.equals("min odd number is:") && value1.equals(1));
        assertTrue(name2.equals("max even number is:") && value2.equals(46));
    }

    @Test
    public void testMakePositive() {
        ArrayList<int[]> input = new ArrayList<>(1);
        input.add(new int[]{1, 5, 22, -54, 3, -7, 35, 1, -46, 26, 25});
        Model model = new Model(EIGHTH, input, null);
        Controller controller = new Controller();
        controller.makePositive(model);

        String name1 = model.getOutput().get(0).getName();

        int[] expectedMass = new int[]{1, 5, 22, 54, 3, 7, 35, 1, 46, 26, 25};
        int[] value1 = (int[]) model.getOutput().get(0).getValue();
        assertTrue(name1.equals("Array without negatives :"));
        assertTrue(value1.length == expectedMass.length);
        for (int i = 0; i < expectedMass.length; i++) {
            assertTrue(expectedMass[i] == value1[i]);
        }
    }

    @Test
    public void testIncPasDecNeg() {
        ArrayList<int[]> input = new ArrayList<>(1);
        input.add(new int[]{1, 5, 22, -54, 3, -7, 35, 1, -46, 26, 25});
        Model model = new Model(NINTH, input, null);
        Controller controller = new Controller();
        controller.incPosDecNeg(model);

        String name1 = model.getOutput().get(0).getName();

        int[] expectedMass = new int[]{2, 6, 23, -55, 4, -8, 36, 2, -47, 27, 26};
        int[] value1 = (int[]) model.getOutput().get(0).getValue();
        assertTrue(name1.equals("Array with negative-- positive++:"));
        assertTrue(value1.length == expectedMass.length);
        for (int i = 0; i < expectedMass.length; i++) {
            assertTrue(expectedMass[i] == value1[i]);
        }
    }

    @Test
    public void testMeanAndNumOfBigger() {
        ArrayList<int[]> input = new ArrayList<>(1);
        input.add(new int[]{1, 5, 22, -54, 3, -7, 35, 1, -46, 26, 25});
        Model model = new Model(TENTH, input, null);
        Controller controller = new Controller();
        controller.meanAndNumOfBigger(model);

        String name1 = model.getOutput().get(0).getName();
        Double value1 = (Double) model.getOutput().get(0).getValue();
        String name2 = model.getOutput().get(1).getName();
        Integer value2 = (Integer) model.getOutput().get(1).getValue();
        assertTrue(name1.equals("mean value is:") );
        assertEquals(value1,1.0,0.0001);
        assertTrue(name2.equals("Number of elements bigger than mean:") && value2.equals(6));
    }


    @Test
    public void testSumOfMass() {
        ArrayList<int[]> input = new ArrayList<>(1);
        input.add(new int[]{1, 5, 22, -54, 3, -7, 35, 1, -46, 26, 25});
        input.add(new int[]{-1, 3, 2, 5, 3, 5, 3, 12, 16, 26, -25});
        Model model = new Model(ELEVENTH, input, null);
        Controller controller = new Controller();
        controller.sumOfMass(model);

        String name1 = model.getOutput().get(0).getName();

        int[] expectedMass = new int[]{0, 8, 24, -49, 6, -2, 38, 13, -30, 52, 0};
        int[] value1 = (int[]) model.getOutput().get(0).getValue();
        assertTrue(name1.equals("sum of each element:"));
        assertTrue(value1.length == expectedMass.length);
        for (int i = 0; i < expectedMass.length; i++) {
            assertTrue(expectedMass[i] == value1[i]);
        }
    }
}