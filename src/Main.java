import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.NativeString.toLowerCase;

public class Main {
    public static void showList(ArrayList<String> shoppingList) {
        System.out.println("Список покупок: ");
        for (int i = 0; i < shoppingList.size(); i++) {
            System.out.println((i + 1) + " : " + shoppingList.get(i));
        }
    }

    public static void main(String[] args) {
        ArrayList<String> shoppingList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Доступны операции: ");
            System.out.println("\t 1 - Добавить. 2 - Показать. 3 - Удалить. 4 - Найти.");
            String input = scanner.nextLine();
            System.out.println("Выберите операцию:");

            int operation = Integer.parseInt(input);
            if (operation == 1) {
                addProduct(shoppingList, scanner);
            }
            if (operation == 2) {
                showList(shoppingList);
            }
            if (operation == 3) {
                delProduct(shoppingList, scanner);
            }
            if (operation == 4) {
                searchProduct(shoppingList, scanner);
            }
            System.out.println();
        }
    }

    private static void addProduct(ArrayList<String> shoppingList, Scanner scanner) {
        System.out.println("Какую покупку хотите добавить? Введите номер или название: ");
        String product = scanner.nextLine();
        shoppingList.add(product);
        System.out.println("Итого в списке покупок: " + shoppingList.size());
    }

    private static void delProduct(ArrayList<String> shoppingList, Scanner scanner) {
        System.out.println("Какую покупку хотите удалить? Введите номер или название: ");
        String input = scanner.nextLine();
        int product = Integer.parseInt(input) - 1;
        System.out.println("Покупка " + shoppingList.get(product) + " - удалено, список продуктов: ");
        shoppingList.remove(product);
        try {
            System.out.println("Список покупок: ");
            for (int i = 0; i < shoppingList.size(); i++) {
                System.out.println((i + 1) + " : " + shoppingList.get(i));
            }
        } catch (NumberFormatException e) {
            System.out.println("Покупка " + input + "- удалено, список покупок: ");
            shoppingList.remove(input);
        }
    }

    private static void searchProduct(ArrayList<String> shoppingList, Scanner scanner) {
        System.out.println("Введите текст для поиска: ");
        String input = scanner.nextLine();
        String itemLower = toLowerCase(input);
        System.out.println("\t Найдено: ");
        for (int i = 0; i < shoppingList.size(); i++) {
            String queryLower = toLowerCase(shoppingList.get(i));
            if (queryLower.contains(itemLower)) {
                System.out.println((i + 1) + " : " + shoppingList.get(i));

            }
        }
    }
}

