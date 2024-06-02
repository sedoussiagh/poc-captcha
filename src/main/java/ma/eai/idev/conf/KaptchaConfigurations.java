package ma.eai.idev.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix="kaptcha.config")
public class KaptchaConfigurations{
  private String imageWidth;
  private String imageHeight;
  private String textProducerCharLength;
  private String useBorder;
  private String textColor;
  private String textProducerFontNames;
  private String textProducerFontSize;
}
