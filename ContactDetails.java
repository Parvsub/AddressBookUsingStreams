package AddressBookUsingStreams;


public class ContactDetails{
    String firstName = new String();
    String lastName = new String();
    String address = new String();
    String city = new String();
    String state = new String();
    int zip;
    long phoneNumber;
    String email = new String();
    private String FirstName;
    private String LastName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLastName(String LastName) {
        this.lastName = LastName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public ContactDetails(String FirstName, String LastName, String address, String city, String state, int zip, int phoneNumber ){
        this.FirstName=FirstName;
        this.LastName=LastName;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.phoneNumber=phoneNumber;

    }
    public ContactDetails(){
        super();
    }
    @Override
     public String toString() {
        return "Employee [name=" + this.FirstName +" "+ this.LastName + ", Address=" + this.address + ", City="
                + this.city + ", state=" + this.state + ", zip=" + this.zip
                + ", phone=" + this.phoneNumber + "]";
    }
}