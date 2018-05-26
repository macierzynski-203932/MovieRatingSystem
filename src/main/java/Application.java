import loginregister.DataFormValidator;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {
    public static void main(String [] args){
        SpringApplication.run(Application.class, args);
    }
    @Bean
    public DataFormValidator dataFormValidator(){
        return new DataFormValidator();
    }

    @Bean
    public EmailValidator emailValidator(){return new EmailValidator();}
}
