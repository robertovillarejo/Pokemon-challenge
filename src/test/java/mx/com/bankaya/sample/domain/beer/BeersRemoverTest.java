package mx.com.bankaya.sample.domain.beer;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import mx.com.bankaya.UnitTest;
import mx.com.bankaya.sample.domain.BeersIdentityFixture;

@UnitTest
@ExtendWith(MockitoExtension.class)
class BeersRemoverTest {

  @Mock
  private BeersRepository beers;

  @InjectMocks
  private BeersRemover remover;

  @Test
  void shouldNotRemoveUnknownBeerFromCatalog() {
    assertThatThrownBy(() -> remover.remove(BeersIdentityFixture.cloackOfFeathersId())).isExactlyInstanceOf(UnknownBeerException.class);
  }
}
