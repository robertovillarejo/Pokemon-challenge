package mx.com.bankaya.sample.domain.beer;

import mx.com.bankaya.shared.error.domain.Assert;

public class BeersCreator {

  private final BeersRepository beers;

  public BeersCreator(BeersRepository beers) {
    Assert.notNull("beers", beers);

    this.beers = beers;
  }

  public Beer create(BeerToCreate beerToCreate) {
    Beer createdBeer = beerToCreate.create();

    beers.save(createdBeer);

    return createdBeer;
  }
}
