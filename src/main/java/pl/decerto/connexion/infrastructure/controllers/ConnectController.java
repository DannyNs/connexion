package pl.decerto.connexion.infrastructure.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.decerto.connexion.domain.ConnexionFacade;

import java.util.Random;

@AllArgsConstructor
@RestController("/connect")
class ConnectController {

    private final ConnexionFacade connexionFacade;

    @GetMapping
    public String connect() {
        Integer firstRandomInt = new Random().nextInt();
        Integer secondRandomInt = getIntegerFromRandomOrg();
        Integer result = connexionFacade.connect(firstRandomInt, secondRandomInt);

        return firstRandomInt + " + " + secondRandomInt + " = " + result;
    }

    private Integer getIntegerFromRandomOrg() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate
                .getForEntity("https://www.random.org/integers/?num=1&min=1&max=9999&col=1&base=10&format=plain&rnd=new", String.class);
        return Integer.parseInt(response.getBody().trim());
    }
}
