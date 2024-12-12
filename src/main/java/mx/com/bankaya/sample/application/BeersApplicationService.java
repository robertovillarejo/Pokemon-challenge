package mx.com.bankaya.sample.application;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import mx.com.bankaya.sample.domain.BeerId;
import mx.com.bankaya.sample.domain.beer.Beer;
import mx.com.bankaya.sample.domain.beer.BeerToCreate;
import mx.com.bankaya.sample.domain.beer.Beers;
import mx.com.bankaya.sample.domain.beer.BeersCreator;
import mx.com.bankaya.sample.domain.beer.BeersRemover;
import mx.com.bankaya.sample.domain.beer.BeersRepository;

@Service
public class BeersApplicationService {

  private final BeersRepository beers;
  private final BeersCreator creator;
  private final BeersRemover remover;

  public BeersApplicationService(BeersRepository beers) {
    this.beers = beers;

    creator = new BeersCreator(beers);
    remover = new BeersRemover(beers);
  }

  @PreAuthorize("can('create', #beerToCreate)")
  public Beer create(BeerToCreate beerToCreate) {
    return creator.create(beerToCreate);
  }

  @PreAuthorize("can('remove', #beer)")
  public void remove(BeerId beer) {
    remover.remove(beer);
  }

  public Beers catalog() {
    return beers.catalog();
  }
}
