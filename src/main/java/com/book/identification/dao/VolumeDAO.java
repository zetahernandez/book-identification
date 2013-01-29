package com.book.identification.dao;

import com.book.identification.model.Volume;
import java.util.List;

public interface VolumeDAO extends GenericDAO<Volume,Long> {

	List<Volume> volumesWithCategory(Long categoryId);
       /**
	 * Obtenemos la x volumenes por pagina, por el momento se traen siempre 10.
	 * @param page
	 * @return List<Volume>
	 * */
	List<Volume> retrievesVolumesPerPage( int page );
	
	/**
	 * Devolvemos los volumenes filtrados por categoria y por pagina
	 * @param categoryId
	 * @param page
	 * @return List<Volume>
	 */
	List<Volume> retrieveVolumesWithCategoryPerPage( Long categoryId , int page );
}
