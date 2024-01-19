import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDateTime;

public class Rental implements Serializable {
    private static final long serialVersionUID = General.getSerialVersionUID();


    private int id;
    private int userId;
    private int carId;
    private Date fromDate;
    private Date toDate;


    public Rental() {
        this.id = 0;
        this.carId = 0;
        this.fromDate = new Date();
        this.toDate = new Date();
        // this.carClassId = null;
    }
    public Rental(int id, int carId, Date fromDate, Date toDate) {
        this.id = 0;
        this.carId = 0;
        this.fromDate = new Date();
        this.toDate = new Date();
    }


    public int getId() {
        return this.id;
    }
    public int getUserId() {
        return this.id;
    }
    public int getCarId() {
        return this.carId;
    }
    public Date getFromDate() { return this.fromDate; }
    public Date getToDate() { return this.toDate; }


    public void setId(int id) {
        this.id = id;
    }
    public void setUserId(int id) {
        this.id = id;
    }
    public void setCarId(int carId) {
        this.carId = carId;
    }
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }
    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }


    public String toString() {
        return "Rental: {"
                + "\n\t" + "id: " + this.id
                + "\n\t" + "userId: " + this.userId
                + ",\n\t" + "carId: " + this.carId
                + ",\n\t" + "fromDate: " + this.fromDate
                + ",\n\t" + "toDate: " + this.toDate
                + ",\n" + "}"
                ;
    }


    public static Rental getData(int id, ArrayList<Integer> carsIds) {
        Rental tmpObject = new Rental();
        tmpObject.setId(id);

        System.out.println("Escreva os dados do carro:");
        General.divider();

        System.out.print("ID do carro: ");
        tmpObject.setCarId(General.readSelect(carsIds, "Não existe nenhum carro com este id."));

        System.out.print("Data de começo (dd-MM-yyyy): ");
        tmpObject.setFromDate(Ler.umaData());

        System.out.print("Data de fim (dd-MM-yyyy): ");
        tmpObject.setToDate(Ler.umaData());

        System.out.println();

        return tmpObject;
    }
}
