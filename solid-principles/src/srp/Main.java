package srp;


import srp.solution.MysqlRepository;
import srp.solution.PasswordHash;
import srp.solution.Repository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new MysqlRepository();
        PasswordHash passwordHash = new PasswordHash(repository);
        passwordHash.hashPassword("hello");
    }

}