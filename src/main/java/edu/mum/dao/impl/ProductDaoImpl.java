package edu.mum.dao.impl;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.domain.Member;
import edu.mum.domain.Product;

import edu.mum.dao.ProductDao;

	@Repository
	public class ProductDaoImpl extends GenericDaoImpl<Product> implements ProductDao
	{
		
		public ProductDaoImpl() {
			super.setDaoType(Product.class );
			}


  
	}

