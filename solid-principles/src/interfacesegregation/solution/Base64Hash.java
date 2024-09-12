package interfacesegregation.solution;

import openclosed.solution.PasswordHash;

public class Base64Hash implements PasswordHash, Decryptable {
    @Override
    public String hashPassword(String password) {
        return "hashed with base64";
    }

    @Override
    public String decodePasswordFromHash(String hash) {
        return "decoded from base64";
    }
}