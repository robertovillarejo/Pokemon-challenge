package mx.com.bankaya.sample.application;

import org.springframework.stereotype.Component;
import mx.com.bankaya.sample.domain.beer.BeerToCreate;
import mx.com.bankaya.shared.kipe.application.AccessChecker;
import mx.com.bankaya.shared.kipe.application.AccessContext;
import mx.com.bankaya.shared.kipe.application.ChallengeAuthorizations;

@Component
class BeerToCreateAccessChecker implements AccessChecker<BeerToCreate> {

  private final ChallengeAuthorizations authorizations;

  public BeerToCreateAccessChecker(ChallengeAuthorizations authorizations) {
    this.authorizations = authorizations;
  }

  @Override
  public boolean can(AccessContext<BeerToCreate> access) {
    return authorizations.allAuthorized(access.authentication(), access.action(), BeerResource.BEERS);
  }
}
