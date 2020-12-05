package com.seniorsteps.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.PersistenceUnitUtil;

import org.hibernate.proxy.HibernateProxy;



public abstract class AbstractModelMapper<E extends DomainModel, D extends UserModel> implements ModelMapper<E, D>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6887769527441182844L;
	
	@PersistenceUnit
	private EntityManagerFactory entityMangerFactory;

	protected <T> boolean isConvertable(T target) {
		
		if (target != null) {
			if(HibernateProxy.class.isInstance(target)){
				HibernateProxy proxy = HibernateProxy.class.cast(target);				
				if (!proxy.getHibernateLazyInitializer().isUninitialized()) {
					return true;
				}
			}else{
				return true;
			}
		}
		return false;
	}
	
	protected <T> boolean isConvertable(Collection<T> collection) {
		
		if(collection != null && !collection.isEmpty()){
			return true;
		}
		return false;
	}
	
	protected <T> boolean isConvertable(Object entity, String attributeName){
		
		if(entity == null) return false;
		
		PersistenceUnitUtil unitUtil = entityMangerFactory.getPersistenceUnitUtil();
		return unitUtil.isLoaded(entity, attributeName);
	}
	
	@Override
	public Set<D> convertToDto(Set<E> es){
		Set<D> ds = null;
		if(isConvertable(es)){
			ds = new HashSet<D>();
			for(E e : es){
				ds.add(convertToDto(e));
			}
		}
		return ds;
		
	}
	
	@Override
	public List<D> convertToDto(List<E> es){
		List<D> ds = null;
		if(isConvertable(es)){
			ds = new ArrayList<D>();
			for(E e : es){
				ds.add(convertToDto(e));
			}
		}
		return ds;
		
	}
	
	@Override
	public Set<E> convertToEntity(Set<D> ds, boolean nullId){
		Set<E> es = null;
		if(isConvertable(ds)){
			es = new HashSet<E>();
			for(D d : ds){
				es.add(convertToEntity(d, nullId));
			}
		}
		return es;
	}
	
	@Override
	public List<E> convertToEntity(List<D> ds, boolean nullId){
		List<E> es = null;
		if(isConvertable(ds)){
			es = new ArrayList<E>();
			for(D d : ds){
				es.add(convertToEntity(d, nullId));
			}
		}
		return es;
	}
	
	public E convertToEntity(D d){
		return convertToEntity(d, false);
	}
	public List<E> convertToEntity(List<D> ds){
		return convertToEntity(ds, false);
	}
	public Set<E> convertToEntity(Set<D> ds){
		return convertToEntity(ds, false);
	}
	
	public E convertToNewEntity(D d){
		return convertToEntity(d, true);
		
	}
	public List<E> convertToNewEntity(List<D> ds){
		return convertToEntity(ds, true);
	}
	public Set<E> convertToNewEntity(Set<D> ds){
		return convertToEntity(ds, true);
	}
}
