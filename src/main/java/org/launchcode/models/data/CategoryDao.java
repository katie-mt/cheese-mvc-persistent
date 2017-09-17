package org.launchcode.models.data;

import org.launchcode.models.Category;
import org.launchcode.models.Cheese;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

//DAO - Data Access Object
//An interface that will allow us to access cheese classes and will be the
//interface by which we interact with the database.

/**
 * Created by LaunchCode
 */
//@Repository used to make SpringBoot aware of this CrudRepository (data access object).  @Repository tells Spring that this interface is a repository
// and that it should manage it for us - it is what enables Spring to create a concrete class that implements this interface
@Repository
//@Transactional specifies that all hte methods specified in this interface should be wrapped by a database transaction.
@Transactional
//Interface should extend the CrudRepository which is an interface that is part of the Spring framework data package.
//CrudRepository is a parameterized interfaced that will store cheese objects and the keys of these cheese objects are integers.
//CheeseDao interface will allow us to retrieve objects from the database and place objects in the database
public interface CategoryDao extends CrudRepository<Category, Integer> {
}

