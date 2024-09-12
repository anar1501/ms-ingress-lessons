package openclosed.solution;

public class MD5Hash implements PasswordHash {
    @Override
    public String hashPassword(String password) {
        return "hashed with SHA256";
    }
}