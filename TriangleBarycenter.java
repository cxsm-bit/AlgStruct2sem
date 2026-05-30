import java.util.Scanner;

public class TriangleBarycenter {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ввод координат 
        System.out.print("Введите координату x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Введите координату y1: ");
        double y1 = scanner.nextDouble();
        
        System.out.print("Введите координату x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Введите координату y2: ");
        double y2 = scanner.nextDouble();
        
        System.out.print("Введите координату x3: ");
        double x3 = scanner.nextDouble();
        System.out.print("Введите координату y3: ");
        double y3 = scanner.nextDouble();
        
        double[] vertex1 = {x1, y1};
        double[] vertex2 = {x2, y2};
        double[] vertex3 = {x3, y3};
        
        // Вычисление барицентра
        double[] barycenter = calculateBarycenter(vertex1, vertex2, vertex3);
        
        // Вывод 
        System.out.printf("Барицентр треугольника: {%.4f, %.4f}%n", barycenter[0], barycenter[1]);
        
        scanner.close();
    }

    public static double[] calculateBarycenter(double[] v1, double[] v2, double[] v3) {
        double x = (v1[0] + v2[0] + v3[0]) / 3.0;
        double y = (v1[1] + v2[1] + v3[1]) / 3.0;
        
        return new double[]{x, y};
    }
}
//ЗИТ-251 Сущенко Д.С. Номер зачётки 257453, вариант 3