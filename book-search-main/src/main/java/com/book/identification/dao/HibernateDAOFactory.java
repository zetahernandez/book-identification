// Copyright 2013 fernando.hernandez

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

//   http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.book.identification.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class HibernateDAOFactory extends DAOFactory {
    private static Logger logger = LogManager.getLogger(HibernateDAOFactory.class);
	
    @Override
	public VolumeDAO getVolumeDAO() {
		return instantiateDAO(VolumeDAOHibernate.class);
	}


	private <T> T instantiateDAO(Class<T> class1) {
		T result = null;
		try {
			result =  class1.newInstance();
		} catch (InstantiationException e) {
			logger.error(e.getMessage());
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage());
		}
		return result;
	}


	@Override
	public VolumeInfoDAO getVolumeInfoDAO() {
		return instantiateDAO(VolumeInfoDAOHibernate.class);
	}


	@Override
	public CategoryDAO getCategoryDAO() {
		return instantiateDAO(CategoryDAOHibernate.class);
	}


//	@Override
//	public <T, S extends Serializable> GenericDAO<T, S> getGenericDAO(
//			Class<T> class1, S s) {
//	
//		Class<GenericHibernateDAO<T, Serializable>> genericHibernateDAOClazz = null;
//		
//		return (GenericDAO<T, S>) instantiateDAO(genericHibernateDAOClazz);
//	}


}
