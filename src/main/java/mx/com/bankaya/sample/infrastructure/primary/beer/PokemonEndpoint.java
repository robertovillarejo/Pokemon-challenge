package mx.com.bankaya.sample.infrastructure.primary.beer;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.pokeapi_co.docs.v2.GetPokemonRequest;
import https.pokeapi_co.docs.v2.GetPokemonResponse;
import https.pokeapi_co.docs.v2.Pokemon;

@Endpoint
public class PokemonEndpoint {
  private static final String NAMESPACE_URI = "https://pokeapi.co/docs/v2";

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonRequest")
  @ResponsePayload
  public GetPokemonResponse getCountry(@RequestPayload GetPokemonRequest request) {
    GetPokemonResponse response = new GetPokemonResponse();
    Pokemon pokemon = new Pokemon();
    pokemon.setName(request.getName());
    response.setPokemon(pokemon);
    return response;
  }
}
