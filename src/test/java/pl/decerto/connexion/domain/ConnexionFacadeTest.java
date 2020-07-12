package pl.decerto.connexion.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.decerto.connexion.domain.exceptions.ConnectHandlerNotFound;
import pl.decerto.connexion.domain.handlers.ConnectHandler;

import java.util.ArrayList;
import java.util.List;

public class ConnexionFacadeTest {

    ConnexionFacade connexionFacade;

    @BeforeEach
    public void beforeEach() {
        List<ConnectHandler> handlers = new ArrayList<>();
        handlers.add(new ConnectHandler<Integer>() {
            @Override
            public Class handles() {
                return Integer.class;
            }

            @Override
            public Integer connect(Integer t1, Integer t2) {
                return t1 + t2;
            }
        });
        connexionFacade = new ConnexionFacade(handlers);
    }

    @Test()
    public void shoultThrowNullPointerException() {
        // given
        Integer t1 = null;
        Integer t2 = null;

        // when
        Assertions.assertThrows(NullPointerException.class, () -> {
            connexionFacade.connect(t1, t2);
        });
    }

    @Test
    public void shouldThrowConnexionHandlerNotFoundException() {
        // given
        Object t1 = "aaa";
        Object t2 = "bbb";

        // when
        Assertions.assertThrows(ConnectHandlerNotFound.class, () -> {
            connexionFacade.connect(t1, t2);
        });
    }

    @Test
    public void shouldConnectValueForExistingHandler() {
        // given
        Integer t1 = 11;
        Integer t2 = 22;
        Integer expected = 33;

        // when
        Integer result = connexionFacade.connect(t1, t2);

        // then
        Assertions.assertEquals(expected, result);
    }
}
