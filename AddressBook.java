package AddressBookUsingStreams;

import java.util.ArrayList;
import java.util.Scanner;

//Address book program
public class AddressBook extends ContactDetails{
    public static void main(String[] args) {
        AddressBook newPerson = new AddressBook();
        ArrayList<AddressBook> person = new ArrayList<>();
        System.out.println("Welcome to Address Book Program");
        Scanner scanner =new Scanner(System.in);
        //Add person address
        System.out.println("Enter first name");
        newPerson.setFirstName(scanner.nextLine());
        System.out.println("Enter last name");
        newPerson.setLastName(scanner.nextLine());
        System.out.println("Enter address");
        newPerson.setAddress(scanner.nextLine());
        System.out.println("Enter city");
        newPerson.setCity(scanner.nextLine());
        System.out.println("Enter state");
        newPerson.setState(scanner.nextLine());
        System.out.println("Enter zip code");
        newPerson.setZip(scanner.nextInt());
        System.out.println("Enter phone number");
        newPerson.setPhoneNumber(scanner.nextInt());
        System.out.println("Enter Email");
        newPerson.setEmail(scanner.nextLine());
        person.add(newPerson);

        System.out.println(person);
    }
}
