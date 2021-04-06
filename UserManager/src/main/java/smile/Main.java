package smile;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.*;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.mongodb.client.model.Updates.*;

public class Main {
    public static void main(String[] args) {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        String connectionString = "mongodb+srv://mongoDB:mongoDB@testcluster.dfote.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";

        while (true){
            try (MongoClient mongoClient = MongoClients.create(connectionString)){
                MongoCollection<Document> users = mongoClient.getDatabase("javausers").getCollection("user");
                Scanner scanner = new Scanner(System.in);
                System.out.println("1.create user, 2.update user, 3.delete user, 4.find a user, 5.see all users, 6.escape");
                System.out.print("Please choose your operation: ");
                try {
                    int operationChoose = scanner.nextInt();

                    switch (operationChoose) {
                        case 1:
                            createUsers(users);
                            break;
                        case 2:
                            updateUsers(users);
                            break;
                        case 3:
                            deleteUsers(users);
                            break;
                        case 4:
                            findUsers(users);
                            break;
                        case 5:
                            seeAllUsers(users);
                            break;
                        case 6:
                            System.out.println("----- system will be stoped.");
                            System.exit(0);
                            break;
                    }
                }catch (Exception e){
                    System.out.println("choose a number of operation");
                }
            }
        }
    }

    private static void seeAllUsers(MongoCollection<Document> users) {
        List<Document> dbDocuments = users.find().into(new ArrayList<>());
        dbDocuments.forEach(document -> System.out.println(document.toJson()));
        System.out.println("\t" + "------- end list.");
    }

    private static void updateUsers(MongoCollection<Document> users) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which user do you want to update:");
        String userName = StringUtils.capitalize(scanner.nextLine());

        List<Document> userList = users.find(Filters.gte("name", userName)).into(new ArrayList<>());
        userList.forEach(d -> System.out.println(d.toJson()));

        System.out.print("typ the new name: ");
        String userNameTo = StringUtils.capitalize(scanner.nextLine());
        users.findOneAndUpdate(new Document("name", userName), set("name", userNameTo));
    }

    private static void deleteUsers(MongoCollection<Document> users) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Which user do you want to delete:");
            String userName = StringUtils.capitalize(scanner.nextLine());

            users.findOneAndDelete(new Document("name", userName));
    }

    private static void findUsers(MongoCollection<Document> users) {
        System.out.print("Typ the nema you want to find: ");
        Scanner scanner = new Scanner(System.in);
        String userNameFind = StringUtils.capitalize(scanner.nextLine());
        System.out.println("see all users");
        List<Document> userList = users.find(Filters.gte("name", userNameFind)).into(new ArrayList<>());
        if(userList.contains(userNameFind) == true){
            System.out.println("user exist");
        };
        userList.forEach(d -> System.out.println(d.toJson()));
    }

    public static void createUsers(MongoCollection<Document> users){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Firstname is: ");
        String newusername = StringUtils.capitalize(scanner.next());
        System.out.print("Lastname is: ");
        String newpassword = StringUtils.capitalize(scanner.next());
        Document user = new Document("name", newusername).append("lastname", newpassword);
        users.insertOne(user);
        System.out.println("Finish.");

    };
}
