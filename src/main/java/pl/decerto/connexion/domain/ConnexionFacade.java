package pl.decerto.connexion.domain;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.decerto.connexion.domain.exceptions.ConnectHandlerNotFound;
import pl.decerto.connexion.domain.handlers.ConnectHandler;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class ConnexionFacade {

    private final List<ConnectHandler> handlers;

    public <T> T connect(T t1, T t2) {
        Objects.requireNonNull(t1);
        Objects.requireNonNull(t2);
        Class<?> clazz = t1.getClass();

        return handlers.stream()
                .filter(handler -> {
                    Class handles = handler.handles();
                    return clazz.equals(handles);
                })
                .findFirst()
                .map(handler -> (T) handler.connect(t1, t2))
                .orElseThrow(ConnectHandlerNotFound::new);
    }
}
