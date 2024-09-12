package srp.solution;

public class PasswordHash {
    private final Repository repository;
    public PasswordHash(Repository repository) {
        this.repository = repository;
    }
    public void hashPassword(String password) {
        repository.save(password);
    }
}
