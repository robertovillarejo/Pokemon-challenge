package mx.com.bankaya.sample.domain.order;

import static org.assertj.core.api.Assertions.*;
import static mx.com.bankaya.sample.domain.order.BeerOrderFixture.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import mx.com.bankaya.UnitTest;
import mx.com.bankaya.sample.domain.Amount;
import mx.com.bankaya.shared.error.domain.MissingMandatoryValueException;

@UnitTest
class BeerOrderTest {

  @Test
  void shouldNotBuildEmptyOrder() {
    assertThatThrownBy(() -> BeerOrder.builder().build()).isExactlyInstanceOf(MissingMandatoryValueException.class);
  }

  @Test
  void shouldGetConsolidatedOrderLines() {
    BeerOrder order = beerOrder();

    assertThat(order.lines()).containsExactlyInAnyOrder(
      new BeerOrderLine(orderedCloakOfFeather(), 2),
      new BeerOrderLine(orderedAnteMeridiem(), 3)
    );
  }

  @Test
  void shouldGetOrderTotal() {
    assertThat(beerOrder().total()).isEqualTo(new Amount(new BigDecimal("33.44")));
  }
}
