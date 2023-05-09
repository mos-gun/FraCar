package com.fracar.generic;

import javafx.collections.ObservableList;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface GenericService<T extends Object> {

    T saveEntity(T entity);

    T updateEntity(T entity);

    void deleteEntity(T entity);

    void deleteEntityById(Long id);

    void deleteInBatch(List<T> entities);

    T findEntityById(Long id);

    List<T> findAll();

    boolean existsById(Long id);

    T getOneReferenceById(Long id);

    ObservableList<T>observableListView();
}
