import java.io.Serializable;
import java.util.ArrayList;

public class CarClass implements Serializable {
    private static final long serialVersionUID = General.getSerialVersionUID();


    private int id;
    private String name;
    private Double price;


    public CarClass() {
        this.id = 0;
        this.name = "";
        this.price = 0.0;
    }
    public CarClass(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    public int getId() {
        return this.id;
    }
    public String getName() {
        return name;
    }
    public Double getPrice() {
        return price;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(Double price) {
        this.price = price;
    }


    public String toString() {
        return "CarClass: {"
                + "\n\t" + "id: " + this.id
                + ",\n\t" + "name: " + this.name
                + ",\n\t" + "email: " + this.price
                + ",\n" + "}"
                ;
    }


    public static CarClass getData(int id) {
        CarClass tmpObject = new CarClass();
        tmpObject.setId(id);

        System.out.println("Escreva os dados da classe:");
        General.divider();

        System.out.print("Nome: ");
        tmpObject.setName(Ler.umaString());

        System.out.print("Preço: ");
        tmpObject.setPrice(Ler.umDouble());

        System.out.println();

        return tmpObject;
    }
}
