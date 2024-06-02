package ma.eai.idev.conf;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KaptchaProducer {
  @Bean
  public DefaultKaptcha captchaProducer(KaptchaConfigurations kaptchaConfigurations) {
    // Création d'un producteur de Kaptcha avec configuration personnalisée
    DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
    Properties properties = new Properties();

    // Configuration des propriétés de Kaptcha
    properties.setProperty("kaptcha.border", kaptchaConfigurations.getUseBorder());
    properties.setProperty("kaptcha.textproducer.font.color", kaptchaConfigurations.getTextColor());
    properties.setProperty("kaptcha.image.width", kaptchaConfigurations.getImageWidth());
    properties.setProperty("kaptcha.image.height", kaptchaConfigurations.getImageHeight());
    properties.setProperty("kaptcha.textproducer.font.size", kaptchaConfigurations.getTextProducerFontSize());
    properties.setProperty("kaptcha.session.key", "captchaCode");
    properties.setProperty("kaptcha.textproducer.char.length", kaptchaConfigurations.getTextProducerCharLength());
    properties.setProperty("kaptcha.textproducer.font.names", kaptchaConfigurations.getTextProducerFontNames());

    // Application de la configuration au producteur de Kaptcha
    Config config = new Config(properties);
    defaultKaptcha.setConfig(config);
    return defaultKaptcha;
  }

}
