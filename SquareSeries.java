//ЗИТ-251 Сущенко Д.С. Номер зачётки 257453, вариант 3
import java.util.Scanner;

public class SquareSeries {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ввод
        System.out.print("Введите первое число: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Введите второе число: ");
        int num2 = scanner.nextInt();
        
        // Определяем наименьшее и максимальное
        int start = Math.min(num1, num2);
        int end = Math.max(num1, num2);
        
        // Вывод квадратов чисел от start до end с шагом start
        boolean first = true;
        System.out.print("Квадраты чисел: ");
        
        for (int i = start; i <= end; i += start) {
            if (!first) {
                System.out.print(", ");
            }
            System.out.print(i * i);
            first = false;
        }
        
        System.out.println();
        
        scanner.close();
    }
}
