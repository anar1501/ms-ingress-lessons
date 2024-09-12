package dependencyinversion.solution;

import openclosed.solution.PasswordHash;

public class PasswordService {
    private PasswordHash passwordHash;

    public PasswordService(PasswordHash passwordHash) {
        this.passwordHash = passwordHash;
    }

    void hashPassword(String password) {
        this.passwordHash.hashPassword(password);
    }
}