package guru.springframework.sfgdi.config;

import guru.springframework.sfgdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingServiceConfig {

    @Profile({"EN", "default"})
    @Bean("i18nService")
    I18nEnglishGreetingService i18nEnglishGreetingService() {
        return new I18nEnglishGreetingService();
    }

    @Profile("ES")
    @Bean("i18nService") // if override the Service name in the @Bean then "i18nService" would be the Service name
    I18nSpanishGreetingService i18nSpanishGreetingService() {
        return new I18nSpanishGreetingService();
    }

    @Bean // Spring would use the method name as the Service name like constructorInjectedGreetingService
    public ConstructorInjectedGreetingService constructorInjectedGreetingService() {
        return new ConstructorInjectedGreetingService();
    }

    @Bean
    public PropertyInjectedGreetingService propertyInjectedGreetingService() {
        return new PropertyInjectedGreetingService();
    }

    @Bean
    public SetterInjectedGreetingService setterInjectedGreetingService() {
        return new SetterInjectedGreetingService();
    }
}
