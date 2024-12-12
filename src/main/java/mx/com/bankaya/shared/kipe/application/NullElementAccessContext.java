package mx.com.bankaya.shared.kipe.application;

import org.springframework.security.core.Authentication;
import mx.com.bankaya.shared.error.domain.Assert;
import mx.com.bankaya.shared.generation.domain.ExcludeFromGeneratedCodeCoverage;

@ExcludeFromGeneratedCodeCoverage(reason = "Untested null object structure")
record NullElementAccessContext<T>(Authentication authentication, String action) implements AccessContext<T> {
  public NullElementAccessContext {
    Assert.notNull("authentication", authentication);
    Assert.notBlank("action", action);
  }

  @Override
  public T element() {
    return null;
  }
}
