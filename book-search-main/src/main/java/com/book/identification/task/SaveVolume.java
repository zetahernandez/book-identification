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