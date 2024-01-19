import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = General.getSerialVersionUID();


    private int id;
    private String name;
    private String email;
    private String password;
    private boolean isAdmin;


    public User() {
        this.id = 0;
        this.name = "";
        this.email = "";
        this.password = "";
        this.isAdmin = false;
    }
    public User(int id, String name, String email, String password, boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }


    public int getId()  {
        return this.id;
    }
    public String getName()  {
        return this.name;
    }
    public String getEmail()  {
        return this.email;
    }
    public String getPassword()  {
        return this.password;
    }
    public boolean getIsAdmin()  {
        return this.isAdmin;
    }


    public void setId(int id)  {
        this.id = id;
    }
    public void setName(String name)  {
        this.name = name;
    }
    public void setEmail(String email)  {
        this.email = email;
    }
    public void setPassword(String password)  {
        this.password = password;
    }
    public void setIsAdmin(boolean isAdmin)  {
        this.isAdmin = isAdmin;
    }


    public String toString() {
        return "User: {"
            + "\n\t" + "id: " + this.id
            + ",\n\t" + "name: " + this.name
            + ",\n\t" + "email: " + this.email
            + ",\n\t" + "password: " + this.password
            + ",\n\t" + "isAdmin: " + this.isAdmin
            + ",\n" + "}"
        ;
    }


    public static User getData(int id) {
        User tmpObject = new User();
        tmpObject.setId(id);

        System.out.println("Escreva os dados do utilizador:");
        General.divider();

        System.out.print("Nome: ");
        tmpObject.setName(Ler.umaString());

        System.out.print("Email: ");
        tmpObject.setEmail(Ler.umaString());

        System.out.print("Password: ");
        tmpObject.setPassword(Ler.umaString());

        System.out.print("Is Admin: ");
        tmpObject.setIsAdmin(Ler.umBoolean());

        System.out.println();

        return tmpObject;
    }
}
