package by.halubovich.trial.exchange.coindesk.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

class JacksonCustomization {

  @Bean
  Jackson2ObjectMapperBuilderCustomizer jacksonCustomizeWithGuava() {
    return builder -> builder.modules(new GuavaModule());
  }

  @Bean
  HttpMessageConverter<Object> javascriptMessageConverter(final ObjectMapper mapper) {
    class JavaScriptMessageConverter extends AbstractJackson2HttpMessageConverter {

      public JavaScriptMessageConverter(final ObjectMapper objectMapper) {
        super(objectMapper, new MediaType("application", "javascript"));
      }
    }

    return new JavaScriptMessageConverter(mapper);
  }
}
