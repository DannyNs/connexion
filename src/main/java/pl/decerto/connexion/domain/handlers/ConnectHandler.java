package pl.decerto.connexion.domain.handlers;

public interface ConnectHandler<T> {

    Class<T> handles();

    T connect(T t1, T t2);
}
