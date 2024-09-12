package dependencyinversion.violation;

import interfacesegregation.solution.Base64Hash;

public class PasswordService {
    //violation due to in the following code statement
    private Base64Hash hasher = new Base64Hash();

    void hashPassword(String password) {
        hasher.hashPassword(password);
    }
}