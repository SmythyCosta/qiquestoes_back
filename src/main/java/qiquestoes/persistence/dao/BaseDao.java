package qiquestoes.persistence.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseDao<T> extends JpaRepository<T, Serializable> {

}
