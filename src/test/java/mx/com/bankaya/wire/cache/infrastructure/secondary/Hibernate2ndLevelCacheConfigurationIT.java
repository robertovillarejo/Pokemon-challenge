package mx.com.bankaya.wire.cache.infrastructure.secondary;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.assertj.core.api.Assertions;
import org.hibernate.cache.internal.EnabledCaching;
import org.junit.jupiter.api.Test;
import mx.com.bankaya.IntegrationTest;

@IntegrationTest
class Hibernate2ndLevelCacheConfigurationIT {

  @PersistenceUnit
  private EntityManagerFactory factory;

  @Test
  void shouldEnableHibernateCaching() {
    Assertions.assertThat(factory.getCache()).isInstanceOf(EnabledCaching.class);
  }
}
