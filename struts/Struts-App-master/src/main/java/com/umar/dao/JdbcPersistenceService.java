package com.umar.dao;

import com.umar.jdbc.ResultSetMapper;

import java.util.List;

public interface JdbcPersistenceService<T> {

    List<T> select(String sql, ResultSetMapper<T> rowMapper, Object... params);

    int save(final String sql, final Object... params);

    int delete(final String sql, final Object... params);

    T find(Long id);

    T find(T t);

    List<T> getAll();
}
