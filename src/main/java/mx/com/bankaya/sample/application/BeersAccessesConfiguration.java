package mx.com.bankaya.sample.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import mx.com.bankaya.shared.authentication.domain.Role;
import mx.com.bankaya.shared.kipe.domain.RolesAccesses;

@Configuration
class BeersAccessesConfiguration {

  @Bean
  RolesAccesses beersAccesses() {
    return RolesAccesses.builder()
      .role(Role.ADMIN)
      .allAuthorized("create", BeerResource.BEERS)
      .allAuthorized("remove", BeerResource.BEERS)
      .and()
      .build();
  }
}
