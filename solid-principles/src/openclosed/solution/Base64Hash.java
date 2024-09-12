package openclosed.solution;

public class Base64Hash implements PasswordHash {
    @Override
    public String hashPassword(String password) {
        return "hashed with 64";
    }
}