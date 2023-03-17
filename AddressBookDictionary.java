package AddressBookUsingStreams;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AddressBookDictionary {
    public static AddressBook addressBookMain=new AddressBook();
    public static Map<String,AddressBook> addressBookMainMap = new HashMap<>();
    public static Scanner scanner=new Scanner(System.in);

    //Method to add address book
    public static void addAddressBook(){
        AddressBook addressBookMain = new AddressBook();
        System.out.println("Enter the name to add address book");
        String newBookName = scanner.next();
        addressBookMainMap.put(newBookName,addressBookMain);
    }
    public static void display(){                   //Method to show address book
        for (String string: addressBookMainMap.keySet()) {
            System.out.println(string);
        }
    }
    public static void selectAddressBookMap() throws IOException {      //Method to select address book and perform operations add,delete,update etc
        display();
        System.out.println("Enter the name of address book you want to select");
        String addressBookName = scanner.next();
        for (String key: addressBookMainMap.keySet()) {
            if(addressBookName.equals(key)){
                addressBookMainMap.get(addressBookName).addContactsMain(addressBookMainMap.get(addressBookName));
            }
            else {
                System.out.println("Provided name not found");
            }
        }
    }

    public static void deleteAddressBook(){            //Method to delete address book
        display();
        System.out.println("Kindly enter the name of address book you want to delete");
        String deleteBookName = scanner.next();
        for (String key: addressBookMainMap.keySet()) {
            if(deleteBookName.equals(key)){
                addressBookMainMap.remove(deleteBookName);
            }
            else {
                System.out.println("Provided name not found");
            }
        }
    }
    //method to search person across address books
    public static void searchPerson(){
        System.out.println("Enter the name of city");
        String inputCity= scanner.next();
        addressBookMainMap.get(addressBookMain).person.stream()
                .filter(city -> inputCity.equals(city.getCity()))
                .forEach(element -> System.out.println(element));
    }
    public  static void overWriteIntoFile() throws IOException {
        Map<String, AddressBook> addressBookMainMap = new HashMap<>();
        Properties properties = new Properties();
        for (Map.Entry<String, AddressBook> entry : addressBookMainMap.entrySet())
            properties.put(entry.getKey(), entry.getKey());
    properties.store(new FileOutputStream("data.properties"),null);
    }

    public static void main(String[] args) throws IOException {
        int flag = 0;
        while (flag == 0) {
            System.out.println("Kindly select the options to \n1. Add\n2. View\n3. Delete\n4. Select\n5. Search according to city or state\n6. Exit");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    AddressBookDictionary.addAddressBook();
                    break;
                case 2:
                    AddressBookDictionary.display();
                    break;
                case 3:
                    AddressBookDictionary.deleteAddressBook();
                    break;
                case 4:
                    AddressBookDictionary.selectAddressBookMap();
                    break;
                case 5:
                    AddressBookDictionary.searchPerson();
                case 6:
                    flag = 1;

                  overWriteIntoFile();
            }
        }
    }
}