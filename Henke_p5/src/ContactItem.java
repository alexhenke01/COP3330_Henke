public class ContactItem {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public ContactItem(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        if(!isContactValid(firstName, lastName, phone, email)) {
            throw new IllegalArgumentException("Empty contact");
        }
    }

    public String getFirst() {
        return this.firstName;
    }

    public String getLast() {
        return this.lastName;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getEmail() { return this.email; }

    public String setContact(String firstName, String lastName, String phone, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        if(!isContactValid(firstName, lastName, phone, email))
            throw new IllegalArgumentException("Empty contact");
        else
            return this.firstName + " " + this.lastName + " " + this.phone + " " + this.email;
    }

    private boolean isContactValid(String firstName, String lastName, String phone, String email) {
        return firstName.length() + lastName.length() + phone.length() + email.length() > 0;
    }
}
