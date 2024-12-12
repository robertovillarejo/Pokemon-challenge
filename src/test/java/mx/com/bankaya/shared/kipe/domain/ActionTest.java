package mx.com.bankaya.shared.kipe.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import mx.com.bankaya.UnitTest;

@UnitTest
class ActionTest {

  @Test
  void shouldGetActionAsToString() {
    assertThat(new Action("act")).hasToString("act");
  }
}
