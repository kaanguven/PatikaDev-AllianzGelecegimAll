
import java.util.Date;
import java.util.TreeSet;

public class AccountManager {
    private TreeSet<Account> accounts;

    public AccountManager() {
        accounts = new TreeSet<>();
        accounts.add(new Enterprise(new User("Ufuk","GÜVEN","ufukkaanguven","123","student",26,new Date())));
    }

    public Account login(String email, String password) {
        Account account=null;
        for(Account acc : accounts){
            if(acc.getUser().getEmail().equals(email))
                account = acc;
        }

        try {
            account.login(email, password);
        } catch (InvalidAuthenticationException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }catch (NullPointerException e){
            System.out.println("Böyle bir kullanıcı bulunmamaktadır!");
            System.exit(0);
        }

        return account;
    }
}
