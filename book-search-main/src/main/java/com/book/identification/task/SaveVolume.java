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

package com.book.identification.task;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.book.identification.dao.DAOFactory;
import com.book.identification.dao.VolumeDAO;
import com.book.identification.model.Volume;
import com.book.identification.task.base.ProducerThread;

class SaveVolume extends ProducerThread<Volume>{

	private Logger logger = LogManager.getLogger(SaveVolume.class);
	/**
	 * 
	 */
	private Volume volume;

	public SaveVolume(Volume volume) {
		super("SaveVolume");
		this.volume = volume;
	}

	@Override
	public void run() {
		VolumeDAO volumeDAO = DAOFactory.getInstance().getVolumeDAO();
		try{
				volumeDAO.getSession().getTransaction().begin();
				logger.info("Save volume ->" + volume.getVolumeInfo().getTitle());
				volumeDAO.makePersistent(volume);
				volumeDAO.getSession().getTransaction().commit();
		}catch (Exception e) {
			logger.error(e.getMessage());
			volumeDAO.getSession().getTransaction().rollback();
		}finally{
			logger.debug("Session close");
			volumeDAO.getSession().close();
		}
	}
	
	
	
}