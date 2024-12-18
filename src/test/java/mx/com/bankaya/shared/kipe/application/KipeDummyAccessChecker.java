package mx.com.bankaya.shared.kipe.application;

import org.springframework.stereotype.Component;
import mx.com.bankaya.shared.kipe.domain.KipeDummy;

@Component
class KipeDummyAccessChecker implements AccessChecker<KipeDummy> {

  @Override
  public boolean can(AccessContext<KipeDummy> access) {
    return access.authentication() != null && access.element().value().equals("authorized");
  }
}
