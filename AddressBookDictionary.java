package AddressBookUsingStreams;

import java.util.*;

public class AddressBookDictionary {
        public static Map<String,AddressBook> addressBookMainMap = new HashMap<>();
        public static Scanner scanner=new Scanner(System.in);
        public static void addAddressBook(){            //Method to add address book
            AddressBook addressBook = new AddressBook();
            System.out.println("Enter the name to add address book");
            String newBookName = scanner.next();
            addressBookMainMap.put(newBookName,addressBook);
        }
        public static void display(){                   //Method to show address book
            for (String string: addressBookMainMap.keySet()) {
                System.out.println(string);
            }
        }
        public static void selectAddressBookMap(){      //Method to select address book and perform operations add,delete,update etc
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

        public static void main(String[] args) {
            int flag = 0;
            while (flag == 0) {
                System.out.println("Kindly select the options to \n1. Add\n2. View\n3. Delete\n4. Select\n5. Exit");
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
                        flag = 1;
                }
            }
        }
    }