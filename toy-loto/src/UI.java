import java.io.IOException;
import java.util.Scanner;


public class UI {
    private Scanner scan = GlobalScaner.getInput();
    final String MENU = "1. Добавить игрушку.\n" +
            "2. Показать список игрушек.\n" +
            "3. Изменить 'вес' игрушки.\n" +
            "4. Разыграть игрушку.\n" +
            "5. Выход.\n";

    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception E) {
            System.out.println(E);
        }
    }

    public void menu() throws IOException {
        String name;
        int quantity;
        double freaquency;
        int lineNumber;
        Double newFreaquency;
        FileRW csv = new FileRW("Toys.csv");
        Db db = new Db();
        db.toys = csv.readFile();
        cls();
        while (true) {
            System.out.println("\n");
            System.out.println("Выбирите действие: ");
            System.out.println(MENU);
            String user_choose = scan.nextLine();
            
            if (user_choose.equals("1")) {
                System.out.println("Введите данные новой игрушки");
                while (true) {
                    System.out.println("Введете название игрушки: ");
                    name = scan.nextLine();
                    if (Checker.isNotEmpty(name)) {
                        break;
                    } else {
                        System.out.println("Вы ввели пустую строку. Попробуйте сновва.");
                    }
                }
                while (true) {
                    System.out.println("Введите количество игрушек: ");
                    String quant = scan.nextLine();
                    if (Checker.isNumeric(quant)) {
                        quantity = Integer.parseInt(quant);
                        break;
                    } else {
                        System.out.println("Вы ввели не число. Поробуйте снова.");
                    }
                }
                while (true) {
                    System.out.println("Введите частоту выпадения игрушки (от 0 до 100): ");
                    String freaquecyTemp = scan.nextLine();
                    if (Checker.isReal(freaquecyTemp) && Checker.isCorrectValue(freaquecyTemp)) {
                        freaquency = Double.parseDouble(freaquecyTemp);
                        break;
                    } else {
                        System.out.println("Вы ввели не число. Поробуйте снова.");
                    }
                }
                int len = db.toys.size() + 1;
                Toy toy = new Toy(len, name, quantity, freaquency);
                Game game = new Game();
                game.addToy(db.toys, toy);
                cls();

            } else if (user_choose.equals("2")) {
                cls();
                if (db.toys.size() != 0) {
                    
                    db.printToys();
                } else {
                    System.out.println("Нет доступных игрушек. Необходимо добавить игрушки.");
                }

            } else if (user_choose.equals("3")) {
                if (db.toys.size() != 0) {
                    while (true) {
                        System.out.println("Введите номер записи, которую хотите изменить: ");
                        String lineNumb = scan.nextLine();
                        if (Checker.isNumeric(lineNumb) && Integer.parseInt(lineNumb) <= db.toys.size()) {
                            lineNumber = Integer.parseInt(lineNumb);
                            break;
                        } else {
                            System.out.println("Не корректный ввод. Поробуйте снова.");
                        }
                    }
                    while (true) {
                        System.out.println("Введите новое значение частоты выпадания игрушки в процентах от 0 до 100: ");
                        String freaquecyTemp1 = scan.nextLine();
                        if (Checker.isReal(freaquecyTemp1) && Checker.isCorrectValue(freaquecyTemp1)) {
                            newFreaquency = Double.parseDouble(freaquecyTemp1);
                            break;
                        } else {
                            System.out.println("Вы ввели не число. Поробуйте снова.");
                        }
                    }
                    db.toys.get(lineNumber - 1).setFreaquecy(newFreaquency);
                } else {
                    System.out.println("Нет игрушек для изменения. Создайте игрушку.");
                }
                cls();

            } else if (user_choose.equals("4")) {
                cls();
                Game game = new Game();
                game.elementWeight(db.toys);

            } else if (user_choose.equals("5")) {
                System.out.println("Программа завершила свою работу.");
                if (db.toys.size() != 0) {
                    // SaveCSV csv = new SaveCSV();
                    csv.writeResult(db.toys.get(0), false);
                    db.toys.remove(0);
                    for (Toy item : db.toys) {
                        csv.writeResult(item, true);
                    }
                    break;
                } else {
                    break;
                }
                
            } else {
                cls();
                System.out.println("Некорректный ввод. Попробуйте еще раз");
            }
        }
    }
}
