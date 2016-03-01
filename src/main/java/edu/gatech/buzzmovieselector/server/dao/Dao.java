package edu.gatech.buzzmovieselector.server.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * The definition of the Database Access Objects that handle the reading and
 * writing a class from the database.
 *
 * @param <T>  The class that the code will be operating on.
 * @param <ID> The class of the ID column associated with the class. The T
 *             class does not require an ID field.
 *             The class needs an ID parameter however so you can use Void or
 *             Object to satisfy the compiler.
 */
public interface Dao<T, ID extends Serializable> {

    /**
     * Retrieves an object associated with a specific ID.
     *
     * @param id Identifier that matches a specific row in the database to
     *           find and return.
     * @return The object that has the ID field which equals id or null if no
     * matches.
     */
    T findById(ID id) throws SQLException;

    /**
     * Query for all of the items in the object table.
     *
     * @return A list of all of the objects in the table.
     */
    List<T> findAll() throws SQLException;

    /**
     * Create a new row in the database from an object.
     *
     * @param data The data item that we are creating in the database.
     */
    void create(T data) throws SQLException;

    /**
     * Store the fields from an object to the database row corresponding to
     * the id from the data parameter. If you have
     * made changes to an object, this is how you persist those changes to
     * the database. You cannot use this method to
     * update the id field.
     * <p>
     * <p>
     * NOTE: This will not save changes made to foreign objects or to foreign
     * collections.
     * </p>
     *
     * @param data The data item that we are updating in the database.
     */
    void update(T data) throws SQLException;

    /**
     * This is a convenience method for creating an item in the database if
     * it does not exist. The id is extracted from
     * the data parameter and a query-by-id is made on the database. If a row
     * in the database with the same id exists
     * then all of the columns in the database will be updated from the
     * fields in the data parameter. If the id is null
     * (or 0 or some other default value) or doesn't exist in the database
     * then the object will be created in the
     * database. This also means that your data item <i>must</i> have an id
     * field defined.
     */
    void createOrUpdate(T data) throws SQLException;

    /**
     * Delete the database row corresponding to the id from the data parameter.
     *
     * @param data The data item that we are deleting from the database.
     */
    void delete(T data) throws SQLException;
}
