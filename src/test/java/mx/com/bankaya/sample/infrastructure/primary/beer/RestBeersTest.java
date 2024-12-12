package mx.com.bankaya.sample.infrastructure.primary.beer;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import mx.com.bankaya.JsonHelper;
import mx.com.bankaya.UnitTest;
import mx.com.bankaya.sample.domain.beer.Beers;
import mx.com.bankaya.sample.domain.beer.BeersFixture;

@UnitTest
class RestBeersTest {

  @Test
  void shouldSerializeToJson() {
    assertThat(JsonHelper.writeAsString(RestBeers.from(new Beers(List.of(BeersFixture.beer()))))).isEqualTo(json());
  }

  private String json() {
    return "{\"beers\":[" + RestBeerTest.json() + "]}";
  }
}
