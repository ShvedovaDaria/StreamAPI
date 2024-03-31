import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IntegerListProcessor {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("1. Додати число до списку");
            System.out.println("2. Знайти суму всіх парних чисел у списку");
            System.out.println("3. Помножити кожне число у списку на 2 та вивести результат");
            System.out.println("4. Знайти максимальне число у списку");
            System.out.println("5. Вивести непарні числа у вигляді рядка, розділені комою");
            System.out.println("6. Знайти середнє арифметичне всіх чисел у списку");
            System.out.println("7. Завершити програму");
            System.out.print("Виберіть опцію: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline character
            } catch (InputMismatchException e) {
                System.out.println("Будь ласка, введіть коректне ціле число.");
                scanner.nextLine(); // clear the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Введіть число: ");
                    try {
                        int number = scanner.nextInt();
                        numbers.add(number);
                    } catch (InputMismatchException e) {
                        System.out.println("Будь ласка, введіть коректне ціле число.");
                        scanner.nextLine(); // clear the invalid input
                    }
                    break;
                case 2:
                    int sumOfEven = numbers.stream()
                            .filter(n -> n % 2 == 0)
                            .mapToInt(Integer::intValue)
                            .sum();
                    System.out.println("Сума всіх парних чисел: " + sumOfEven);
                    break;
                case 3:
                    List<Integer> doubledNumbers = numbers.stream()
                            .map(n -> n * 2)
                            .collect(Collectors.toList());
                    System.out.println("Результат множення кожного числа на 2: " + doubledNumbers);
                    break;
                case 4:
                    int maxNumber = numbers.stream()
                            .mapToInt(Integer::intValue)
                            .max()
                            .orElseThrow(() -> new RuntimeException("Список порожній"));
                    System.out.println("Максимальне число: " + maxNumber);
                    break;
                case 5:
                    String oddNumbers = numbers.stream()
                            .filter(n -> n % 2 != 0)
                            .map(Object::toString)
                            .collect(Collectors.joining(", "));
                    System.out.println("Непарні числа: " + oddNumbers);
                    break;
                case 6:
                    double average = numbers.stream()
                            .mapToInt(Integer::intValue)
                            .average()
                            .orElse(0);
                    System.out.println("Середнє арифметичне: " + average);
                    break;
                case 7:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Некоректний вибір опції. Спробуйте ще раз.");
            }
        }
        scanner.close();
    }
}