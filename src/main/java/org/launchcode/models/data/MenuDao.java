package org.launchcode.models.data;

import org.launchcode.models.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
//@Transactional specifies that all hte methods specified in this interface should be wrapped by a database transaction.
@Transactional
//Enables us to access Menu objects via the data layer from within our controllers
public interface MenuDao extends CrudRepository<Menu, Integer> {
}