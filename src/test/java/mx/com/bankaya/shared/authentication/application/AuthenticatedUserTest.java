package mx.com.bankaya.shared.authentication.application;

import static org.assertj.core.api.Assertions.*;
import static mx.com.bankaya.shared.authentication.application.AuthenticatedUser.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import mx.com.bankaya.UnitTest;
import mx.com.bankaya.shared.authentication.domain.Role;
import mx.com.bankaya.shared.authentication.domain.Username;

@UnitTest
class AuthenticatedUserTest {

  @BeforeEach
  @AfterEach
  void cleanup() {
    SecurityContextHolder.clearContext();
  }

  @Nested
  @DisplayName("Username")
  class AuthenticatedUserUsernameTest {

    @Test
    void shouldNotGetNotAuthenticatedUserUsername() {
      assertThatThrownBy(AuthenticatedUser::username).isExactlyInstanceOf(NotAuthenticatedUserException.class);
    }

    @Test
    void shouldNotGetUsernameForUnknownAuthentication() {
      authenticate(new TestingAuthenticationToken(null, null));

      assertThatThrownBy(AuthenticatedUser::username).isExactlyInstanceOf(UnknownAuthenticationException.class);
    }

    @ParameterizedTest
    @MethodSource("allValidAuthentications")
    void shouldGetAuthenticatedUserUsername(Authentication authentication) {
      authenticate(authentication);

      assertThat(username()).isEqualTo(new Username("admin"));
    }

    @Test
    void shouldGetEmptyAuthenticatedUsernameForNotAuthenticatedUser() {
      assertThat(optionalUsername()).isEmpty();
    }

    @ParameterizedTest
    @MethodSource("allValidAuthentications")
    void shouldGetOptionalAuthenticatedUserUsername(Authentication authentication) {
      authenticate(authentication);

      assertThat(optionalUsername()).contains(new Username("admin"));
    }

    @Test
    void shouldNotGetOptionalUsernameForUnknownAuthentication() {
      authenticate(new TestingAuthenticationToken(null, null));

      assertThatThrownBy(AuthenticatedUser::optionalUsername).isExactlyInstanceOf(UnknownAuthenticationException.class);
    }

    private static Stream<Arguments> allValidAuthentications() {
      return Stream.of(
        Arguments.of(usernamePasswordAuthenticationToken()),
        Arguments.of(new UsernamePasswordAuthenticationToken("admin", "admin"))
      );
    }
  }

  @Nested
  @DisplayName("Roles")
  class AuthenticatedUserRolesTest {

    @Test
    void shouldGetEmptyRolesForNotAuthenticatedUser() {
      assertThat(roles().hasRole()).isFalse();
    }

    @Test
    void shouldGetRolesFromClaim() {
      authenticate(usernamePasswordAuthenticationToken());

      assertThat(roles().get()).containsExactly(Role.ADMIN);
    }
  }

  private static UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken() {
    Collection<GrantedAuthority> authorities = adminAuthorities();
    User user = new User("admin", "admin", authorities);

    return new UsernamePasswordAuthenticationToken(user, "admin", authorities);
  }

  private static List<GrantedAuthority> adminAuthorities() {
    return List.of(new SimpleGrantedAuthority(Role.ADMIN.key()));
  }

  private void authenticate(Authentication token) {
    SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
    securityContext.setAuthentication(token);
    SecurityContextHolder.setContext(securityContext);
  }
}
