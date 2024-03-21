package uncg.marketplace.entity.email;

import java.util.function.Predicate;

public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
    //    TODO: Regex to validate
        return true;
    }

}
