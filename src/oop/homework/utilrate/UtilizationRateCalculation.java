package oop.homework.utilrate;

import java.util.ArrayList;

public class UtilizationRateCalculation {
    public static void calculate() {
        Input input = new Input("C:\\Users\\10929\\eclipse-workspace\\oop\\src\\oop\\homework\\utilrate\\data.txt");
        ArrayList<String> data = input.getInput();
        String[] steelPlateData = data.get(0).split(" "); data.remove(0);
        SteelPlate steelPlate = new SteelPlate(Double.parseDouble(steelPlateData[0]),  Double.parseDouble(steelPlateData[1]));
        ArrayList<Shape2D> shapes = new ArrayList<>();
        for (String line : data) {
            switch (line.charAt(0)) {
                case 'A':
                    String[] aData = line.split(" ");
                    A a = new A(Double.parseDouble(aData[1]), Double.parseDouble(aData[2]));
                    shapes.add(a);
                    break;
                case 'B':
                    String[] bData = line.split(" ");
                    B b = new B(Double.parseDouble(bData[1]));
                    shapes.add(b);
                    break;
                case 'C':
                    String[] cData = line.split(" ");
                    C c = new C(Double.parseDouble(cData[1]), Double.parseDouble(cData[2]), Double.parseDouble(cData[3]));
                    shapes.add(c);
                    break;
                default: System.out.println("出现未知类型"); System.exit(0);
            }
        }
        System.out.println("钢板的利用率为：" + steelPlate.getUtilizationRate(shapes));
    }
}
