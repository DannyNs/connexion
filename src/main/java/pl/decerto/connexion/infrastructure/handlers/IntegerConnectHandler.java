package pl.decerto.connexion.infrastructure.handlers;

import org.springframework.stereotype.Component;
import pl.decerto.connexion.domain.handlers.ConnectHandler;

@Component
class IntegerConnectHandler implements ConnectHandler<Integer> {

    @Override
    public Class<Integer> handles() {
        return Integer.class;
    }

    @Override
    public Integer connect(Integer t1, Integer t2) {
        return t1 + t2;
    }
}
