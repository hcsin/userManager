package smile;

public class User {
    private String firstName;
    private String lastName;
//    private String password;
//    private String emailAddress;
//    private int phoneNumber;
//    private String notes;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

/*    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }*/

    public User(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

//    @Override
//    public String toString() {
////        return "User [id=" + id + ", Name=" + userName + ", email=" + email
////                + ", password=" + password + "]";
//    };
}

/*
2.UserManger.java: An interface that specifies the methods to be used to Find, Create, Update and Delete a user. Provide also a method to retrieve users matching a certain String pattern. example starting with a certain letter or all users if the pattern is null!
Please note that A UserManager is an Interface and not class!
Explain what is an Interface in Java what is the difference between an interface and a class.
Optional: try to explain what is an abstract class. The explanation can be put in the UserManager.java file as a description
3.Create a MemoryUserManager.java implementation of the UserManager class. This class uses saves the user info only in memory. Once the application stops all user data will be lost.
4.Create a IOUserManager.java implementation of the UserManager.java interface that saves the user data to file. This will make assure that the user data will be persistent. Persistence is when a data or a state is being stored and retrieved. A restart of the application will not affect the data.
5.Optional: MongoDB implementation. Create a MongoDBUserManager.java implementation of the UserManager.java interface. This one saves the user data to a mongoDB database.
6.Main.java: This is the main entry point to the program. The main class should provide a command line interface or optional a GUI interface.
When the Main class is being started, the user is welcomed by to the UserManager program. The user has to select which implementation if the UserManager that has to be used.
1- MemoryUserManager.
2- IOUserManager: User data has to be saved in this case to ManicMonday.txt
3- DBUserManager: User data has to be stored to ManicMonday database. The database details bellow can be used for your program.
final String username = "avans_plus_student_01";
final String password = "ut57XVuAiQhE8Van";
final String url = "valhalla.tblhf.mongodb.net";
final String dbName = "ManicMonday";
final String connectionString = "mongodb+srv://avans_plus_student_01:ut57XVuAiQhE8Van@valhalla.tblhf.mongodb.net/ManicMonday?retryWrites=true&w=majority"
* Please note that the connectionString should be sufficient to connect to the database.

After the selection of the previous step, a short description how to use the program has to be printed to the interface. Example

1- Find all users or users matching a certain criteria. Example by name. The program should print all the users retrieved to the screen
2- Find for a certain user by name. The program should print the user details to the screen.
3- Create a new user by providing the required details. A feedback message should be displayed to the user
4- Delete a user by providing a valid user id. A feedback message should be displayed to the user
5- Update a user by providing a valid user id and the new user details. A feedback message should be displayed to the user*/