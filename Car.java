import java.io.Serializable;
import java.util.ArrayList;

public class Car implements Serializable {
    private static final long serialVersionUID = General.getSerialVersionUID();


    private int id;
    private String name;
    private int carClassId;


    public Car() {
        this.id = 0;
        this.name = "";
        // this.carClassId = null;
    }
    public Car(int id, String name, int carClassId) {
        this.id = id;
        this.name = name;
        this.carClassId = carClassId;
    }


    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public int getCarClassId() { return this.carClassId; }


    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCarClassId(int carClassId) {
        this.carClassId = carClassId;
    }


    public String toString() {
        return "Car: {"
                + "\n\t" + "id: " + this.id
                + ",\n\t" + "name: " + this.name
                + ",\n\t" + "carClassId: " + this.carClassId
                + ",\n" + "}"
                ;
    }


    public static Car getData(int id, ArrayList<Integer> carClassesIds) {
        Car tmpObject = new Car();
        tmpObject.setId(id);

        System.out.println("Escreva os dados do carro:");
        General.divider();

        System.out.print("Nome: ");
        tmpObject.setName(Ler.umaString());

        System.out.print("ID da classe do carro: ");
        tmpObject.setCarClassId(General.readSelect(carClassesIds, "Não existe nenhuma classe com este id."));

        System.out.println();

        return tmpObject;
    }
}
