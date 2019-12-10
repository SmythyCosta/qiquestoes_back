package qiquestoes.persistence.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/*
 * Bug: spring-data: Not an managed type: class java.lang.Object 
 * https://stackoverflow.com/questions/23812458/spring-data-not-an-managed-type-class-java-lang-object
 * 
 * */
@NoRepositoryBean
public interface IBaseCustomRepository<T> extends JpaRepository<T, Serializable> {

}
