package openclosed.violation;

public class PasswordHash {

    public String hashPassword(String password, HashingType hashingType) {
        if (HashingType.BASE64.equals(hashingType)) {
            password = "hashed with Base64";
        } else if (HashingType.MD5.equals(hashingType)) {
            password = "hashed with MD5";
        }else if (HashingType.BCRYPT.equals(hashingType)) {
            password = "hashed with BCRYPT";
        }
        return password;
    }
}
