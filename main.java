import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Toy toy1 = new Toy(1, "Спиннер", 20, 20);
        Toy toy2 = new Toy(2, "Лизун", 20, 20);
        Toy toy3 = new Toy(3, "Прилипала", 20, 30);
        Toy toy4 = new Toy(4, "ЛОЛ", 5, 10);
        Toy toy5 = new Toy(5, "Машинка", 10, 20);

        toy_shop toyShop = new toy_shop();

        toyShop.addToy(toy1);
        toyShop.addToy(toy2);
        toyShop.addToy(toy3);
        toyShop.addToy(toy4);
        toyShop.addToy(toy5);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit){
            System.out.println("1. Add new toy");
            System.out.println("2. Change Frequency");
            System.out.println("3. Save toys to file");
            System.out.println("4. Load toys from file");
            System.out.println("5. Raffle Toy");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter ID");
                    int id = scanner.nextInt();
                    System.out.println("Enter Name");
                    String name = scanner.next();
                    System.out.println("Enter quantity");
                    int quantity = scanner.nextInt();
                    System.out.println("Enter frequency");
                    double frequancy = scanner.nextDouble();
                    toyShop.addToy(new Toy(id, name, quantity, frequancy));
                    break;
                case 2:
                    System.out.println("Enter ID");
                    int toyid = scanner.nextInt();
                    System.out.println("Enter new frequency");
                    double newFrequancy = scanner.nextDouble();
                    toyShop.setToyFrequency(toyid, newFrequancy);
                    break;
                case 3:
                    String savefile = "file";
                    toyShop.saveToFile(savefile);
                case 4:
                    String loadfile = "file";
                    toyShop.loadFromFile(loadfile);
                case 5:
                    toyShop.getPrizeToy();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    break;
            }
        }
        scanner.close();
        }
    }
