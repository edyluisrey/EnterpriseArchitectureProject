package edu.mum.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.mum.dao.GenericDao;
import edu.mum.dao.MemberDao;


/*@SuppressWarnings("unchecked")
@Repository*/
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	@PersistenceContext
    protected EntityManager entityManager;

    protected Class<T> daoType;

	public void setDaoType(Class<T> type) {
			daoType = type;
	}
   
    @Override
    public void save( T entity ){
        entityManager.persist( entity );
     }

    public void delete( T entity ){
        entityManager.remove( entity );
     }

	@Override
	public void delete(Long id) {
        T entity = findOne( id );
        delete( entity );  
    }

	@Override
	public T findOne( Long id ){
	    return (T) entityManager.find( daoType, id );
	 }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(){
		      return entityManager.createQuery( "from " + daoType.getName() )
		       .getResultList();
		   }
	
	@Override
	public T update( T entity ){
	      return entityManager.merge( entity );
	   }

 	@Override
	public List<T> findAll(String s,Object  hint ){
 	    return (List<T>)  entityManager.createQuery("SELECT m FROM Member AS m") 
 	    		.setHint(s,hint).getResultList();
  	}
	

 }