package server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;


@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class);
        System.out.println("http://localhost:8080");
    }

//    //from Code.i-harness Q&A about templates resolver error with Springboot
//    //https://code.i-harness.com/en/q/f0be91
//    //from StackOverflow to try to resolve my templates error:
//    //https://stackoverflow.com/questions/43710326/spring-boot-cannot-change-thymeleaf-template-directory-with-java-config
//    @Bean
//    public ClassLoaderTemplateResolver yourTemplateResolver() {
//        ClassLoaderTemplateResolver yourTemplateResolver = new ClassLoaderTemplateResolver();
//        yourTemplateResolver.setPrefix("yourTemplates/");
//        yourTemplateResolver.setSuffix(".html");
//        yourTemplateResolver.setTemplateMode(TemplateMode.HTML);
//        yourTemplateResolver.setCharacterEncoding("UTF-8");
//        // this is important. This way spring
//        //boot will listen to both places 0
//        //and 1
//        yourTemplateResolver.setOrder(0);
//        yourTemplateResolver.setCheckExistence(true);
//
//        return yourTemplateResolver;
//    }
}
