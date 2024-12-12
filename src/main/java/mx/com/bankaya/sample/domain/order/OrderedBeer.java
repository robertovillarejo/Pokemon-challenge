package mx.com.bankaya.sample.domain.order;

import mx.com.bankaya.sample.domain.Amount;
import mx.com.bankaya.sample.domain.BeerId;
import mx.com.bankaya.shared.error.domain.Assert;

public record OrderedBeer(BeerId beer, Amount unitPrice) {
  public OrderedBeer {
    Assert.notNull("beer", beer);
    Assert.notNull("unitPrice", unitPrice);
  }
}
