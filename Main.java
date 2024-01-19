public class Main {
    public static DB db;
    // ID && IsAdmin && Email && Password && Name


    public static void main(String[] args) {
        db = new DB();
        General.clearScreen();

        // Logging IN
        //screen_login();
         screen_mainMenu();

        // Next Menu Screen
        if (db.getCurrentUser().getIsAdmin()) {
            screen_mainMenu();
        } else {
            screen_manageRentals();
        }
    }

    public static void screen_login() {
        System.out.print("\n\nAluger De Carros\n");
        System.out.println("Seja bem vindo ou melhor sitio para alugar carros!!!\n");
        General.divider();

        db.login();
    }


    public static void screen_mainMenu() {
        System.out.println("1 - Gerir utilizadores");
        System.out.println("2 - Gerir distritos");
        System.out.println("3 - Gerir classes de viatura");
        System.out.println("4 - Gerir carros");
        System.out.println("5 - Gerir alugueres");
        System.out.println();
        System.out.println();
        System.out.println("0 - Sair");
        System.out.println();


        int option = General.readOption(0, 5);


        switch(option) {
            case 0: screen_login();

            case 1: screen_manageUsers(); break;
            case 2: screen_manageDistricts(); break;
            case 3: screen_manageCarClasses(); break;
            case 4: screen_manageCars(); break;
            case 5: screen_manageRentals(); break;
            default: System.out.println("Opção inválida!");
        }
    }


    public static void goBack() {
        if (db.getCurrentUser().getIsAdmin()) {
            screen_mainMenu();
        } else {
            System.exit(1);
        }
    }

    public static void screen_manageUsers() {
        int option = 0;

        do {
            // Print Table Rows
            db.listUsers();
            System.out.println();
            General.divider();

            System.out.println("1 - Adicionar utilizador");
            System.out.println("2 - Eliminar utilizador");
            System.out.println("3 - Alterar utilizador");
            System.out.println();
            System.out.println();
            System.out.println("0 - Voltar atraz");
            System.out.println();


            // Asking for Input & Restricting Input Options
            option = General.readOption(0, 3);

            String askIdMessage = "Escreva o ID do Utiilzador abaixo:";


            // Execute Option
            switch(option) {
                case 0:  goBack();
                case 1: db.addUser(); break;
                case 2: db.deleteUser(readId(askIdMessage)); break;
                case 3: db.updateUser(User.getData(readId(askIdMessage))); break;
            }

            General.spacing();
        } while (option != 0);
    }

    public static void screen_manageDistricts() {
        int option = 0;

        do {
            General.divider();

            System.out.println("1 - Listar distritos");
            System.out.println("2 - Adicionar distrito");
            System.out.println("3 - Eliminar distrito");
            System.out.println("4 - Alterar distrito");
            System.out.println();
            System.out.println();
            System.out.println("0 - Voltar atraz");
            System.out.println();


            // Asking for Input & Restricting Input Options
            option = General.readOption(0, 3);


            String askIdMessage = "Escreva o ID do Distrito abaixo:";
            // Execute Option
            switch(option) {
                case 0: goBack();
                case 1: db.listDistricts(); break;
                case 2: db.addDistrict(); break;
                case 3: db.deleteDistrict(readId(askIdMessage)); break;
                case 4: db.updateDistrict(District.getData(readId(askIdMessage))); break;
            }

            General.spacing();
        } while (option != 0);
    }

    public static void screen_manageCarClasses() {
        int option = 0;

        do {
            General.divider();

            System.out.println("1 - Listar classes de carros");
            System.out.println("2 - Adicionar classe");
            System.out.println("3 - Eliminar classe");
            System.out.println("4 - Alterar classe");
            System.out.println();
            System.out.println();
            System.out.println("0 - Voltar atraz");
            System.out.println();


            // Asking for Input & Restricting Input Options
            option = General.readOption(0, 3);


            String askIdMessage = "Escreva o ID da Classe abaixo:";
            // Execute Option
            switch(option) {
                case 0: goBack();
                case 1: db.listCarClasses(); break;
                case 2: db.addCarClass(); break;
                case 3: db.deleteCarClass(readId(askIdMessage)); break;
                case 4: db.updateCarClass(CarClass.getData(readId(askIdMessage))); break;
            }

            General.spacing();
        } while (option != 0);
    }

    public static void screen_manageCars() {
        int option = 0;

        do {
            General.divider();

            System.out.println("1 - Listar carros");
            System.out.println("2 - Adicionar carro");
            System.out.println("3 - Eliminar carro");
            System.out.println("4 - Alterar carro");
            System.out.println();
            System.out.println();
            System.out.println("0 - Voltar atraz");
            System.out.println();


            // Asking for Input & Restricting Input Options
            option = General.readOption(0, 3);


            String askIdMessage = "Escreva o ID do carro abaixo:";
            // Execute Option
            switch(option) {
                case 0: goBack();
                case 1: db.listCars(50.00); break;
                case 2: db.addCar(); break;
                case 3: db.deleteCar(readId(askIdMessage)); break;
                case 4: db.updateCar(Car.getData(
                        readId(askIdMessage),
                        db.getIds_ofCarClasses()
                )); break;
            }

            General.spacing();
        } while (option != 0);
    }

    public static void screen_manageRentals() {
        int option = 0;

        do {
            General.divider();

            System.out.println("1 - Listar alugueres");
            System.out.println("2 - Adicionar aluguer");
            System.out.println("3 - Eliminar aluguer");
            System.out.println("4 - Alterar aluguer");
            System.out.println();
            System.out.println();
            System.out.println("0 - Voltar atrás");
            System.out.println();


            // Asking for Input & Restricting Input Options
            option = General.readOption(0, 3);


            String askIdMessage = "Escreva o ID do aluguer:";

            // Execute Option
            switch(option) {
                case 0: goBack();
                case 1: db.listRentals(); break;
                case 2: db.addRental(); break;
                case 3: db.deleteRental(readId(askIdMessage)); break;
                case 4: db.updateRental(Rental.getData(
                        readId(askIdMessage),
                        db.getIds_ofCars()
                )); break;
            }

            General.spacing();
        } while (option != 0);
    }




    public static int readId(String message) {
        System.out.println(message);

        int userId = 0;

        System.out.print("ID: ");
        userId = Ler.umInt();
        System.out.println();

        return userId;
    }

}
