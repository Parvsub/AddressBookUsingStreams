package AddressBookUsingStreams;

import com.employeeserviceproblem.CreateEmployeeDetailsinFiles;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//Address book program
public class AddressBook extends ContactDetails{
   public static AddressBook newPerson = new AddressBook();
   public static ArrayList<ContactDetails> person = new ArrayList<>();
   public static void add(){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter first name");
      String firstname = scanner.nextLine();
      Optional<ContactDetails> isEmpty=person.stream()
              .filter(name -> firstname.equals(name.getFirstName()))
              .findAny();
      if(!isEmpty.isEmpty()){
         System.out.println("name already exist");
         return;
      }
      newPerson.setFirstName(firstname);
      System.out.println("Enter last name");
      newPerson.setLastName(scanner.nextLine());
      System.out.println("Enter address");
      newPerson.setAddress(scanner.nextLine());
      System.out.println("Enter city");
      newPerson.setCity(scanner.nextLine());
      System.out.println("Enter state");
      newPerson.setState(scanner.nextLine());
      System.out.println("Enter zip code");
      newPerson.setZip(Integer.parseInt(scanner.nextLine()));
      System.out.println("Enter phone number");
      newPerson.setPhoneNumber(scanner.nextLine());
      System.out.println("Enter Email");
      newPerson.setEmail(scanner.nextLine());
      ContactDetails contactPerson = new ContactDetails(newPerson.getFirstName(),newPerson.getLastName(), newPerson.getAddress(), newPerson.getCity(), newPerson.getState(), newPerson.getZip(), newPerson.getPhoneNumber(),newPerson.getEmail());
      person.add(contactPerson);
      person.forEach(System.out::println);
//        System.out.println(person);
   }

   public static void modify(){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter the first name whose contact to be edited");
      String name = scanner.nextLine();
      boolean found=false;
      ListIterator<ContactDetails> iterator = person.listIterator();
      while (iterator.hasNext()){
         ContactDetails contact= iterator.next();
         if (name.equals(contact.getFirstName()))
         {
            System.out.println("Edit first name");
            newPerson.setFirstName(scanner.nextLine());
            System.out.println("Edit last name");
            newPerson.setLastName(scanner.nextLine());
            System.out.println("Edit address");
            newPerson.setAddress(scanner.nextLine());
            System.out.println("Edit city");
            newPerson.setCity(scanner.nextLine());
            System.out.println("Edit state");
            newPerson.setState(scanner.nextLine());
            System.out.println("Edit zip code");
            newPerson.setZip(Integer.parseInt(scanner.nextLine()));
            System.out.println("Edit phone number");
            newPerson.setPhoneNumber(scanner.nextLine());
            System.out.println("Edit Email");
            newPerson.setEmail(scanner.nextLine());
            iterator.set(new ContactDetails(newPerson.getFirstName(),newPerson.getLastName(), newPerson.getAddress(), newPerson.getCity(), newPerson.getState(), newPerson.getZip(), newPerson.getPhoneNumber(),newPerson.getEmail()));
            found=true;
         }

      }
      if (found){
         System.out.println("record is update");
         System.out.println(person);
      }else {
         System.out.println("record not found");
      }
   }
   public static void delete(){
      Scanner scanner = new Scanner(System.in);
      boolean found=false;
      System.out.println("Enter the first name of contact to delete");
      String nameDelete;
      nameDelete = scanner.nextLine();
      ListIterator<ContactDetails> iterator = person.listIterator();
      while (iterator.hasNext()) {
         ContactDetails contact = iterator.next();
         if (nameDelete.equals(contact.getFirstName())) {
            iterator.remove();
            found=true;
         }
      }
      if (found){
         System.out.println("record is deleted");
         System.out.println(person);
      }else {
         System.out.println("record not found");
      }
   }
   public static void countByCity(){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter city name");
      String inputCity = scanner.next();
      long count = person.stream()
              .filter(city -> inputCity.equals(city.getCity()))
              .count();
      System.out.println("Total details as per city "+inputCity+ " are: "+count);
   }
   //count details as per city
   public static void countByState(){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter city name");
      String inputState = scanner.next();
      long count = person.stream()
              .filter(state -> inputState.equals(state.getState()))
              .count();
      System.out.println("Total details as per state "+inputState+ " are: "+count);
   }
   //sort details as per name
   public static void sortByName(){
      System.out.println("Sorted list is\n");
      person.stream()
              .sorted(Comparator.comparing(ContactDetails::getFirstName))
              .forEach(System.out::println);
   }
   //sort details as per city
   public static void sortByCity() {
      System.out.println("Sorted list is\n");
      person.stream()
              .sorted(Comparator.comparing(ContactDetails::getCity))
              .forEach(System.out::println);
   }
   //sort details as per state
   public static void sortByState() {
      System.out.println("Sorted list is\n");
      person.stream()
              .sorted(Comparator.comparing(ContactDetails::getState))
              .forEach(System.out::println);
   }
   public void overWriteIntoFile() throws IOException{
      FileWriter fileWritrObj =
              new FileWriter("C:\\Users\\bodap\\OneDrive\\Desktop\\Praveen");
      fileWritrObj.write("Sudheer1");

      fileWritrObj.flush();//
      fileWritrObj.close();
   }

   public void addContactsMain(AddressBook addressBookMain) {
      Scanner scanner = new Scanner(System.in);
      int flag = 0;
      int choice;
      System.out.println("Welcome to Address Book Program");
      while (flag != 1) {
         System.out.println("Enter 1 to add contact details");
         System.out.println("Enter 2 to edit details");
         System.out.println("Enter 3 to delete contact");
         System.out.println("Enter 4 to exit");
         System.out.println("Enter 5 to count detail by city");
         System.out.println("Enter 6 to count detail by state");
         System.out.println("Enter 7 to count sort by name");
         System.out.println("Enter 8 to count detail by city");
         System.out.println("Enter 9 to count detail by state");
         choice = scanner.nextInt();
         scanner.nextLine();
         switch (choice) {
            case 1: add();
               break;
            case 2: modify();
               break;
            case 3: delete();
               break;
            case 4: flag = 1;
               break;
            case 5: countByCity();
               break;
            case 6: countByState();
               break;
            case 7: sortByName();
               break;
            case 8: sortByCity();
               break;
            case 9: sortByState();
               break;
         }
      }
   }
}