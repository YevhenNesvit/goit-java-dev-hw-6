package converter;

import java.util.List;

public interface Converter<E, T> {

    E from(T entity);

    T to(E entity);

    List<E> fromList(List<T> list);
}
