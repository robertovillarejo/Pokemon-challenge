package mx.com.bankaya.sample.application;

import org.springframework.stereotype.Component;
import mx.com.bankaya.sample.domain.BeerId;
import mx.com.bankaya.shared.kipe.application.AccessChecker;
import mx.com.bankaya.shared.kipe.application.AccessContext;
import mx.com.bankaya.shared.kipe.application.ChallengeAuthorizations;

@Component
class BeerIdAccessChecker implements AccessChecker<BeerId> {

  private final ChallengeAuthorizations authorizations;

  public BeerIdAccessChecker(ChallengeAuthorizations authorizations) {
    this.authorizations = authorizations;
  }

  @Override
  public boolean can(AccessContext<BeerId> access) {
    return authorizations.allAuthorized(access.authentication(), access.action(), BeerResource.BEERS);
  }
}
