package mx.com.bankaya.sample.application;

import static org.assertj.core.api.Assertions.*;
import static mx.com.bankaya.sample.domain.beer.BeersFixture.*;
import static mx.com.bankaya.shared.kipe.application.TestAuthentications.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import mx.com.bankaya.UnitTest;
import mx.com.bankaya.shared.kipe.application.AccessContext;
import mx.com.bankaya.shared.kipe.application.ChallengeAuthorizations;

@UnitTest
class BeerToCreateAccessCheckerTest {

  private static final BeerToCreateAccessChecker checker = new BeerToCreateAccessChecker(
    new ChallengeAuthorizations(List.of(new BeersAccessesConfiguration().beersAccesses()))
  );

  @Test
  void shouldNotAuthorizedUnauthorizedAction() {
    assertThat(checker.can(AccessContext.of(admin(), "unauthorized", beerToCreate()))).isFalse();
  }

  @Test
  void shouldAuthorizedAuthorizedAction() {
    assertThat(checker.can(AccessContext.of(admin(), "create", beerToCreate()))).isTrue();
  }
}
