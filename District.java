import java.io.Serializable;

public class District implements Serializable {
    private static final long serialVersionUID = General.getSerialVersionUID();


    private int id;
    private String name;


    public District() {
        this.id = 0;
        this.name = "";
    }
    public District(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String toString() {
        return "District: {"
                + "\n\t" + "id: " + this.id
                + ",\n\t" + "name: " + this.name
                + ",\n" + "}"
                ;
    }


    public static District getData(int id) {
        District tmpObject = new District();
        tmpObject.setId(id);

        System.out.println("Escreva os dados do distrito:");
        General.divider();

        System.out.print("Nome: ");
        tmpObject.setName(Ler.umaString());

        System.out.println();

        return tmpObject;
    }
}
