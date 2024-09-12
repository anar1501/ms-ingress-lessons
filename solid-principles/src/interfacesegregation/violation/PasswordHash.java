package interfacesegregation.violation;

public interface PasswordHash {
    String hashPassword(String password);

    String decodePasswordFromHash(String hash);
}