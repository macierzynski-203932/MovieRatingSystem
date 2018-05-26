package loginregister;

import dao.User;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import service.UserService;

public class DataFormValidator {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailValidator emailValidator;

    public ValidationResult validate(LoginDataForm form) {

        ValidationResult result = new ValidationResult();

        User user = userService.get(form.getUsername());

        if (user == null) {
            result.getResults().put("incorrect-username", "");
        } else if (!passwordEncoder.matches(form.getPassword(), user.getPassword())) {
            result.getResults().put("incorrect-password", "");
        }

        return result;
    }

    public ValidationResult validate(RegisterDataForm form) {

        ValidationResult result = new ValidationResult();

        User tmp = userService.get(form.getUsername());
        if (tmp != null) {
            result.getResults().put("user-exists", "");
        } else {
            if (form.getFirstname().length() < 2 || form.getFirstname().length() > 50) {
                result.getResults().put("incorrect-firstname", "");
            }
            if (form.getLastname().length() < 2 || form.getLastname().length() > 50) {
                result.getResults().put("incorrect-lastname", "");
            }
            if(!emailValidator.isValid(form.getUsername(),null)){
                result.getResults().put("incorrect-email","");
            }
            if(!form.getPassword().equals(form.getConfirmpassword())){
                result.getResults().put("passwords-not-same","");
            }
            if(form.getPassword().length()<8){
                result.getResults().put("incorrect-password","");
            }
        }

        return result;
    }
}
