package mx.com.bankaya;

import static mx.com.bankaya.cucumber.rest.CucumberRestAssertions.*;

import io.cucumber.java.en.Then;
import org.springframework.http.HttpStatus;

public class HttpSteps {

  @Then("I should be forbidden")
  public void shouldBeForbidden() {
    assertThatLastResponse().hasHttpStatus(HttpStatus.FORBIDDEN);
  }
}
