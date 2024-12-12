package mx.com.bankaya.sample.domain.beer;

import mx.com.bankaya.sample.domain.Amount;
import mx.com.bankaya.sample.domain.BeerId;
import mx.com.bankaya.shared.error.domain.Assert;

public record BeerToCreate(BeerName name, Amount unitPrice) {
  public BeerToCreate {
    Assert.notNull("name", name);
    Assert.notNull("unitPrice", unitPrice);
  }

  public Beer create() {
    return Beer.builder().id(BeerId.newId()).name(name()).unitPrice(unitPrice()).sellingState(BeerSellingState.SOLD).build();
  }
}
