import java.io.*;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class DB implements Serializable {
    private final String pathToDbFolder;

    private final String pathUsers;
    private final String pathCars;
    private final String pathCarClasses;
    private final String pathDistricts;
    private final String pathRentals;


    private ArrayList<User> users;
    private ArrayList<Car> cars;
    private ArrayList<CarClass> carClasses;
    private ArrayList<District> districts;
    private ArrayList<Rental> rentals;

    private User currentUser;


    public DB() {
        // Initialize Db Location
        this.pathToDbFolder = "C:\\POO-CarsAgency";

        // Initialize Db Files Paths
        this.pathUsers = pathToDbFolder + "\\users.dat";
        this.pathCars = pathToDbFolder + "\\cars.dat";
        this.pathCarClasses = pathToDbFolder + "\\car-classes.dat";
        this.pathDistricts = pathToDbFolder + "\\districts.dat";
        this.pathRentals = pathToDbFolder + "\\rentals.dat";

        // Miscellaneous
        this.currentUser = new User();

        this.users = new ArrayList<User>();
        this.cars = new ArrayList<Car>();
        this.carClasses = new ArrayList<CarClass>();
        this.districts = new ArrayList<District>();
        this.rentals = new ArrayList<Rental>();


        // Create Database Folder if it does Not Exist
        createDbFolder();


        // Reading DB Data - Users & Cars & Car Classes & Districts
        if (fileExists(this.pathUsers)) {
            this.users = readFile(this.pathUsers);
        }

        if (fileExists(this.pathCars)) {
            this.cars = readFile(this.pathCars);
        }

        if (fileExists(this.pathCarClasses)) {
            this.carClasses = readFile(this.pathCarClasses);
        }

        if (fileExists(this.pathDistricts)) {
            this.districts = readFile(this.pathDistricts);
        }

        if (fileExists(this.pathRentals)) {
            this.rentals = readFile(this.pathRentals);
        }
    }


    public User getCurrentUser() {
        return this.currentUser;
    }


    public static boolean fileExists(String pathOfFile) {
        File tmpFile = new File(pathOfFile);
        return tmpFile.exists();
    }

    public void createDbFolder() {
        File dbFolder = new File(pathToDbFolder);

        if (!dbFolder.exists()) {
            if (dbFolder.mkdir()) {
                System.out.println("Pasta da base de dados foi criada com sucesso!");
            } else {
                System.out.println("Erro ao criar pasta da base de dados!");
            }
            System.out.println("");
        }
    }

    public <T> ArrayList<T> readFile(String pathDbFile) {

        try {
            ObjectInputStream InputStream = new ObjectInputStream(new FileInputStream(pathDbFile));

            return (ArrayList<T>) InputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return new ArrayList<T>();
    }

    public <T> void writeFile(String pathDbFile, ArrayList<T> tmpObject) {
        try {
            ObjectOutputStream OutputStream = new ObjectOutputStream(new FileOutputStream(pathDbFile));

            OutputStream.writeObject(tmpObject);
            OutputStream.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public int userIndex(int id) {
        for (int i = 0; i < this.users.size(); ++i) {
            User singleUser = this.users.get(i);

            if (id == singleUser.getId()) {
                return i;
            }
        }

        return -1;
    }

    public int userIndex(String email, String password) {
        for (int i = 0; i < this.users.size(); ++i) {
            User singleUser = this.users.get(i);

            if (email.equals(singleUser.getEmail()) && password.equals(singleUser.getPassword())) {
                return i;
            }
        }

        return -1;
    }

    public int districtIndex(int id) {
        for (int i = 0; i < this.districts.size(); ++i) {
            District singleOne = this.districts.get(i);

            if (id == singleOne.getId()) {
                return i;
            }
        }

        return -1;
    }

    public int carClassIndex(int id) {
        for (int i = 0; i < this.carClasses.size(); ++i) {
            CarClass singleOne = this.carClasses.get(i);

            if (id == singleOne.getId()) {
                return i;
            }
        }

        return -1;
    }

    public int carIndex(int id) {
        for (int i = 0; i < this.cars.size(); ++i) {
            Car singleOne = this.cars.get(i);

            if (id == singleOne.getId()) {
                return i;
            }
        }

        return -1;
    }

    public int rentalIndex(int id) {
        for (int i = 0; i < this.rentals.size(); ++i) {
            Rental singleOne = this.rentals.get(i);

            if (id == singleOne.getId()) {
                return i;
            }
        }

        return -1;
    }


    public void fillUserData(String email, String password) {
        User singleUser = this.users.get(userIndex(email, password));

        currentUser = new User(singleUser.getId(), singleUser.getName(), email, password, singleUser.getIsAdmin());
    }

    public boolean userExists(int id) {
        return userIndex(id) > -1;
    }

    public boolean userExists(String email, String password) {
        return userIndex(email, password) > -1;
    }

    public boolean districtExists(int id) {
        return districtIndex(id) > -1;
    }

    public boolean carClassExists(int id) {
        return carClassIndex(id) > -1;
    }

    public boolean carExists(int id) {
        return carIndex(id) > -1;
    }

    public boolean rentalExists(int id) {
        return rentalIndex(id) > -1;
    }


    public int getBiggest(ArrayList<Integer> numbers) {
        int biggestNumber = -1;

        if (!numbers.isEmpty()) {
            for (int i = 0; i < numbers.size(); ++i) {
                int tmpId = (int) numbers.get(i);
                if (biggestNumber < tmpId) {
                    biggestNumber = tmpId;
                }
            }
        }

        return biggestNumber;
    }


    public ArrayList<Integer> getIds_ofUsers() {
        ArrayList<Integer> tmpArray = new ArrayList<>();

        for (User user : this.users) {
            tmpArray.add(user.getId());
        }

        return tmpArray;
    }

    public ArrayList<Integer> getIds_ofDistricts() {
        ArrayList<Integer> tmpArray = new ArrayList<>();

        for (District district : this.districts) {
            tmpArray.add(district.getId());
        }

        return tmpArray;
    }

    public ArrayList<Integer> getIds_ofCarClasses() {
        ArrayList<Integer> tmpArray = new ArrayList<>();

        for (CarClass carClass : this.carClasses) {
            tmpArray.add(carClass.getId());
        }

        return tmpArray;
    }

    public ArrayList<Integer> getIds_ofCars() {
        ArrayList<Integer> tmpArray = new ArrayList<>();

        for (Car car : this.cars) {
            tmpArray.add(car.getId());
        }

        return tmpArray;
    }

    public ArrayList<Integer> getIds_ofRentals() {
        ArrayList<Integer> tmpArray = new ArrayList<>();

        for (Rental rental : this.rentals) {
            tmpArray.add(rental.getId());
        }

        return tmpArray;
    }


    public void listUsers() {
        String tableFormat_title_manageUsers = "%-6s | %-9s | %-40s | %-30s | %-100s";
        String tableFormat_manageUsers = "%-6d | %-9b | %-40s | %-30s | %-100s";


        // Print Table Title
        General.divider();
        System.out.format(tableFormat_title_manageUsers, "ID", "Admin", "Email", "Password", "Nome");
        System.out.println();



        if (!this.users.isEmpty()) {
            General.divider();

            for (User user : this.users) {
                System.out.printf(tableFormat_manageUsers,
                        user.getId(),
                        user.getIsAdmin(),
                        user.getEmail(),
                        user.getPassword(),
                        user.getName()
                );
                System.out.println();
            }
        }
    }

    public void listDistricts() {
        String tableFormat_title = "%-6s | %-100s";
        String tableFormat = "%-6d | %-100s";


        General.divider();
        System.out.format(tableFormat_title, "ID", "Distrito");
        System.out.println();


        if (!this.districts.isEmpty()) {
            General.divider();

            for (District singleOne : this.districts) {
                System.out.printf(tableFormat, singleOne.getId(), singleOne.getName());
                System.out.println();
            }
        }
    }

    public void listCarClasses() {
        String tableFormat_title = "%-6s | %-80s | %-40s";
        String tableFormat = "%-6d | %-80s | %-40f";


        General.divider();
        System.out.format(tableFormat_title, "ID", "Classe de Carro", "Preço por dia");
        System.out.println();


        if (!this.carClasses.isEmpty()) {
            General.divider();

            for (CarClass singleOne : this.carClasses) {
                System.out.printf(tableFormat,
                        singleOne.getId(),
                        singleOne.getName(),
                        singleOne.getPrice()
                );
                System.out.println();
            }
        }
    }

    public void listCars(Double value) {
        String tableFormat_title = "%-6s | %-60s | %-60s | %-60s";
        String tableFormat = "%-6d | %-60s | %-60s | %-60f";


        General.divider();
        System.out.format(tableFormat_title, "ID", "Carro", "Classe", "Preço");
        System.out.println();


        if (!this.cars.isEmpty()) {
            General.divider();

            for (Car singleOne : this.cars) {

                if (value != null && !classLessThan(singleOne, value)) { continue; }

                if (!carClassExists(singleOne.getCarClassId())
                ) { continue; }


                int carClasseIndex = carClassIndex(singleOne.getCarClassId());


                System.out.printf(tableFormat,
                        singleOne.getId(),
                        singleOne.getName(),
                        this.carClasses.get(carClasseIndex).getName(),
                        this.carClasses.get(carClasseIndex).getPrice()
                );
                System.out.println();
            }
        }
    }

    public void listRentals() {
        String tableFormat_title = "%-6s | %-30s | %-30s | %-30s | %-30s";
        String tableFormat = "%-6d | %-30s | %-30s | %-30s | %-30f";


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        General.divider();
        System.out.format(tableFormat_title, "ID", "Desde", "Até", "Carro", "Preço");
        System.out.println();


        if (!this.rentals.isEmpty()) {
            General.divider();

            for (Rental singleOne : this.rentals) {
                if (!carExists(singleOne.getCarId())) {
                    continue;
                } else if (!carClassExists(
                        this.cars.get(carIndex(singleOne.getCarId())).getCarClassId())
                ) { continue; }


                double tmpPrice = (double) General.countDays(
                        singleOne.getFromDate(),
                        singleOne.getToDate()
                ) * this.carClasses.get(
                        carClassIndex(
                                this.cars.get(singleOne.getCarId()).getCarClassId()
                        )
                ).getPrice();

                System.out.printf(tableFormat,
                        singleOne.getId(),
                        dateFormat.format(singleOne.getFromDate()),
                        dateFormat.format(singleOne.getToDate()),
                        this.cars.get(singleOne.getCarId()).getName(),
                        tmpPrice
                );
                System.out.println();
            }
        }
    }

    public void addUser() {
        ArrayList<Integer> ids = getIds_ofUsers();

        int biggestNumber = getBiggest(ids);

        User userData = User.getData(1 + biggestNumber);

        this.users.add(userData);

        writeFile(this.pathUsers, this.users);
    }

    public void addDistrict() {
        this.districts.add(District.getData(1 + getBiggest(getIds_ofDistricts())));
        writeFile(this.pathDistricts, this.districts);
    }

    public void addCarClass() {
        this.carClasses.add(CarClass.getData(1 + getBiggest(getIds_ofCarClasses())));
        writeFile(this.pathCarClasses, this.carClasses);
    }

    public void addCar() {
        this.listCarClasses();
        this.cars.add(Car.getData(1 + getBiggest(getIds_ofCars()), getIds_ofCarClasses()));
        writeFile(this.pathCars, this.cars);
    }

    public void addRental() {
        this.listRentals();
        this.rentals.add(Rental.getData(1 + getBiggest(getIds_ofRentals()), getIds_ofCars()));
        writeFile(this.pathRentals, this.rentals);
    }


    public void updateUser(User user) {
        int id = user.getId();

        if (userExists(id)) {
            this.users.set(
                    userIndex(user.getId()),
                    user
            )
            ;
            writeFile(this.pathUsers, this.users);
        } else {
            System.out.println("O utilizador de id " + id + " não existe!");
        }
    }

    public void updateDistrict(District district) {
        int id = district.getId();

        if (districtExists(id)) {
            this.districts.set(districtIndex(district.getId()), district);
            writeFile(this.pathDistricts, this.districts);
        } else {
            System.out.println("O distrito de id " + id + " não existe!");
        }
    }

    public void updateCarClass(CarClass carClass) {
        int id = carClass.getId();

        if (carClassExists(id)) {
            this.carClasses.set(carClassIndex(carClass.getId()), carClass);
            writeFile(this.pathCarClasses, this.carClasses);
        } else {
            System.out.println("A classe de id " + id + " não existe!");
        }
    }

    public void updateCar(Car car) {
        int id = car.getId();

        if (carExists(id)) {
            this.cars.set(carIndex(car.getId()), car);
            writeFile(this.pathCars, this.cars);
        } else {
            System.out.println("O carro de id " + id + " não existe!");
        }
    }

    public void updateRental(Rental rental) {
        int id = rental.getId();

        if (rentalExists(id)) {
            this.rentals.set(carIndex(rental.getId()), rental);
            writeFile(this.pathRentals, this.rentals);
        } else {
            System.out.println("O aluguer de id " + id + " não existe!");
        }
    }


    public void deleteUser(int id) {
        if (userExists(id)) {
            this.users.remove(userIndex(id));
            writeFile(this.pathUsers, this.users);
        } else {
            System.out.println("O utilizador de id " + id + " não existe!");
        }
    }

    public void deleteDistrict(int id) {
        if (districtExists(id)) {
            this.districts.remove(districtIndex(id));
            writeFile(this.pathDistricts, this.districts);
        } else {
            System.out.println("O distrito de id " + id + " não existe!");
        }
    }

    public void deleteCarClass(int id) {
        if (carClassExists(id)) {
            this.carClasses.remove(carClassIndex(id));
            deleteCars(id);
            writeFile(this.pathCarClasses, this.carClasses);
        } else {
            System.out.println("A classe de id " + id + " não existe!");
        }
    }

    public void deleteCar(int id) {
        if (carExists(id)) {
            this.cars.remove(carIndex(id));
            deleteRentals(id);
            writeFile(this.pathCars, this.cars);
        } else {
            System.out.println("O carro de id " + id + " não existe!");
        }
    }
    public void deleteCars(int carClassId) {
        for (Car singleOne : this.cars) {
            if (singleOne.getCarClassId() == carClassId) {

                deleteCar(singleOne.getId());
            }
        }
        writeFile(this.pathRentals, this.rentals);
    }


    public void deleteRental(int id) {
        if (rentalExists(id)) {
            this.rentals.remove(rentalIndex(id));
            writeFile(this.pathRentals, this.rentals);
        } else {
            System.out.println("O aluguer de id " + id + " não existe!");
        }
    }
    public void deleteRentals(int carId) {
        for (Rental singleOne : this.rentals) {
            if (singleOne.getCarId() == carId) {

                deleteRental(singleOne.getId());
            }
        }
        writeFile(this.pathRentals, this.rentals);
    }


    public void login() {
        boolean loggedIn = false;
        System.out.println("Escreva os seus dados abaixo:");


        do {
            General.divider();

            System.out.print("Email: ");
            String email = Ler.umaString();
            System.out.println();

            System.out.print("Password: ");
            String password = Ler.umaString();
            System.out.println();

            loggedIn = userExists(email, password);

            if (loggedIn) {
                fillUserData(email, password);
            } else {
                System.out.println("O email ou password que colocou são inválidos.");
            }

        } while (!loggedIn);
    }


    public boolean classLessThan(Car car, Double value) {
        CarClass carClass = this.carClasses.get(carClassIndex(car.getCarClassId()));

        return carClass.getPrice() < value;
    }
}
