import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] operation = {"добавить", "показать", "удалить", "найти"};
        System.out.println("Доступны операции: ");
        for (int i = 0; i < operation.length; i++) {
            System.out.println((i + 1) + ". " + operation[i]);
        }
        List<String> shoppingList = new ArrayList<>();

        while (true) {
            System.out.println("Выберите операцию:");
            String input = scanner.nextLine();

            if (input.equals("1")) {
                System.out.println("Какую покупку хотите добавить? Введите название: ");
                input = scanner.nextLine();
                shoppingList.add(input);
                System.out.println("Итого в списке покупок: " + shoppingList.size());
            } else if (input.equals("2")) {
                System.out.println("Список покупок: ");
                for (int i = 0; i < shoppingList.size(); i++) {
                    System.out.println((i + 1) + " : " + shoppingList.get(i));
                }
            } else if (input.equals("3")) {
                try {
                    System.out.println("Список покупок: ");
                    for (int i = 0; i < shoppingList.size(); i++) {
                        System.out.println((i + 1) + " : " + shoppingList.get(i));
                    }
                    System.out.println("Какую покупку хотите удалить? Введите номер или название: ");
                    input = scanner.nextLine();
                    int product = Integer.parseInt(input) - 1;
                    System.out.println("Покупка " + shoppingList.get(product) + " - удалено, список продуктов: ");
                    shoppingList.remove(product);
                } catch (NumberFormatException s) {
                    System.out.println("Покупка " + input + "- удалено, список покупок: ");
                    shoppingList.remove(input);
                }
                for (int i = 0; i < shoppingList.size(); i++) {
                    System.out.println((i + 1) + " :" + shoppingList.get(i));
                }
            } else if (input.equals("4")) {
                System.out.println("Введите текст для поиска: ");
                input = scanner.nextLine();
                System.out.println("Найдено: ");
                for (int i = 0; i < shoppingList.size(); i++) {
                    String itemLower = shoppingList.get(i).toLowerCase();
                    String queryLower = input.toLowerCase();
                    if (itemLower.contains(queryLower)) {
                        System.out.println((i + 1) + " : " + shoppingList.get(i));
                    }
                }
            }
        }
    }
}
