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


public abstract class DAOFactory {
	 private static Object initLock = new Object();   
	   
	    private static DAOFactory factory = null;   
	   
	    public static DAOFactory getInstance() {   
	        if (factory == null) {   
	            synchronized (initLock) {   
	                if (factory == null) {   
	                        factory = (DAOFactory) new HibernateDAOFactory();   
	                }   
	            }   
	        }   
	        return factory;   
	    }   
	   
	    public abstract VolumeDAO getVolumeDAO();   
	    public abstract VolumeInfoDAO getVolumeInfoDAO();   
	    public abstract CategoryDAO getCategoryDAO();   
}
