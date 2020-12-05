package com.seniorsteps.util;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface ModelMapper<E extends DomainModel, D extends UserModel> extends Serializable{
	
	public D convertToDto(E e);
	public List<D> convertToDto(List<E> e);
	public Set<D> convertToDto(Set<E> e);
	
	public E convertToEntity(D d, boolean nullId);
	public List<E> convertToEntity(List<D> d, boolean nullId);
	public Set<E> convertToEntity(Set<D> d, boolean nullId);
	
	public E convertToEntity(D d);
	public List<E> convertToEntity(List<D> d);
	public Set<E> convertToEntity(Set<D> d);
	
	public E convertToNewEntity(D d);
	public List<E> convertToNewEntity(List<D> d);
	public Set<E> convertToNewEntity(Set<D> d);
	
	
}
