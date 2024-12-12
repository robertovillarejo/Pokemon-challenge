package mx.com.bankaya.sample.domain.beer;

import java.util.Optional;
import mx.com.bankaya.sample.domain.BeerId;

public interface BeersRepository {
  void save(Beer beer);

  Beers catalog();

  Optional<Beer> get(BeerId beer);
}
