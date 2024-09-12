package srp.violation;
public class PasswordHash {

    public void hashAndSavePassword(String password) {
        hashPassword(password);
        savePassword(password);
    }
    public void hashPassword(String password) {
        //hashing implementation
    }

    public void savePassword(String password) {
        //save to the db
    }
}
