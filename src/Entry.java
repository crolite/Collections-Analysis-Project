public class Entry {
    private String surname;
    private String initials;
    private String number;

    public Entry(String surname, String initials, String number) {
        this.surname = surname;
        this.initials = initials;
        this.number = number;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

