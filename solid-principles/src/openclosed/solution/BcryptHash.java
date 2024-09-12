package openclosed.solution;

public class BcryptHash implements PasswordHash {
    @Override
    public String hashPassword(String password) {
        return "hashed with BCRYPT";
    }
}