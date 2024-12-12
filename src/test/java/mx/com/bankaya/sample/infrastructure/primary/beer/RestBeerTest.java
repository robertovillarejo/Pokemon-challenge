package mx.com.bankaya.sample.infrastructure.primary.beer;

import static org.assertj.core.api.Assertions.*;
import static mx.com.bankaya.sample.domain.beer.BeersFixture.*;

import org.junit.jupiter.api.Test;
import mx.com.bankaya.JsonHelper;
import mx.com.bankaya.UnitTest;

@UnitTest
class RestBeerTest {

  @Test
  void shouldSerializeToJson() {
    assertThat(JsonHelper.writeAsString(RestBeer.from(beer()))).isEqualTo(json());
  }

  static String json() {
    return """
    {\
    "id":"5ea9bbb1-3a55-4701-9006-3bbd2878f241",\
    "name":"Cloak of feathers",\
    "unitPrice":8.53\
    }\
    """;
  }
}
