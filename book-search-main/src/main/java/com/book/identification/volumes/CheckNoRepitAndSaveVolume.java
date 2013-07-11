package com.book.identification.volumes;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;

import com.book.identification.dao.DAOFactory;
import com.book.identification.dao.VolumeDAO;
import com.book.identification.model.Volume;
import com.book.identification.work.exceptions.NotPersistExeption;
import com.book.identification.work.exceptions.VolumeExistExeption;

public class CheckNoRepitAndSaveVolume {
	
	Logger logger = LogManager.getLogger(CheckNoRepitAndSaveVolume.class);

	
	public void checNoRepeatAndSave(Volume toSave) throws NotPersistExeption, VolumeExistExeption{
		List<Volume> volumes = DAOFactory.getInstance().getVolumeDAO().findByCriteria(Restrictions.eq("hashSH1", toSave.getHashSH1()));
		if(volumes.size()==0){
			saveNewVolume(toSave);
		}else{
			throw new VolumeExistExeption();
		}
	}
	
	private void saveNewVolume(Volume toSave) throws NotPersistExeption {
		VolumeDAO volumeDAO = DAOFactory.getInstance().getVolumeDAO();
		try{
				volumeDAO.getSession().getTransaction().begin();
				logger.info("Save volume ->" + toSave.getVolumeInfo().getTitle());
				volumeDAO.makePersistent(toSave);
				volumeDAO.getSession().getTransaction().commit();
		}catch (Exception e) {
			logger.error(e.getMessage());
			volumeDAO.getSession().getTransaction().rollback();
			throw new NotPersistExeption(e);
		}
	}
	
	
}
