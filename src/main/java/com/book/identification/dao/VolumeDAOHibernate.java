package com.book.identification.dao;

import java.util.List;

import com.book.identification.model.Volume;

public class VolumeDAOHibernate extends GenericHibernateDAO<Volume, Long>
        implements VolumeDAO {
    
    int amountOfRows = 10;
    
    @SuppressWarnings("unchecked")
    public List<Volume> volumesWithCategory(Long categoryId) {
        String q = "Select distinct v From Volume v JOIN v.volumeInfo vi JOIN vi.categoriess c LEFT OUTER JOIN c.parent cp WHERE c.id = :categoryId OR cp.id = :categoryId";
        return (List<Volume>) getSession().createQuery(q).setParameter("categoryId", categoryId).list();
    }

    @SuppressWarnings("unchecked")
	public List<Volume> retrievesVolumesPerPage( int page ) {
        String q = "Select v From Volume v ";
        String qCount = "Select count(v.id) From Volume v ";
        int qCountResult = ((Long)getSession().createQuery(qCount).uniqueResult()).intValue();
        int cantPages = qCountResult/amountOfRows;
        int initialPage = (page -1) * amountOfRows;
        
        if ( page >= cantPages){
            initialPage = page;
        }
        return (List<Volume>) getSession().createQuery(q).setFirstResult(initialPage).setMaxResults( amountOfRows ).list();
    }
}
