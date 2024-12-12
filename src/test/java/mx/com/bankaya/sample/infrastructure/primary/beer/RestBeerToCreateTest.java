package mx.com.bankaya.sample.infrastructure.primary.beer;

import static org.assertj.core.api.Assertions.*;
import static mx.com.bankaya.BeanValidationAssertions.*;

import org.junit.jupiter.api.Test;
import mx.com.bankaya.JsonHelper;
import mx.com.bankaya.UnitTest;
import mx.com.bankaya.sample.domain.beer.BeersFixture;

@UnitTest
class RestBeerToCreateTest {

  @Test
  void shouldDeserializeFromJson() {
    assertThat(JsonHelper.readFromJson(json(), RestBeerToCreate.class).toDomain())
      .usingRecursiveComparison()
      .isEqualTo(BeersFixture.beerToCreate());
  }

  private String json() {
    return """
    {
      "name": "Cloak of feathers",
      "unitPrice": 8.53
    }
    """;
  }

  @Test
  void shouldNotValidateEmptyBean() {
    assertThatBean(new RestBeerToCreate(null, null)).hasInvalidProperty("name").and().hasInvalidProperty("unitPrice");
  }
}
