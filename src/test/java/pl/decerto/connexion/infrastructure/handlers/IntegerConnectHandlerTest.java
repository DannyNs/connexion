package pl.decerto.connexion.infrastructure.handlers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.decerto.connexion.domain.handlers.ConnectHandler;

public class IntegerConnectHandlerTest {

    ConnectHandler<Integer> connectHandler;

    @BeforeEach
    public void beaforeEach() {
        connectHandler = new IntegerConnectHandler();
    }

    @Test
    public void shouldAddTwoIntegers() {
        // given
        Integer i1 = 220;
        Integer i2 = 320;
        Integer expected = 540;

        // when
        Integer result = connectHandler.connect(i1, i2);

        // then
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void shouldReturnIntegerAsHandlingClass() {
        // given
        Class<Integer> integerClass = Integer.class;

        // when
        Class<Integer> handlerClass = connectHandler.handles();

        // then
        Assertions.assertEquals(integerClass, handlerClass);
    }
}
