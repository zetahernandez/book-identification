package com.book.identification.dao;

import com.book.identification.model.Volume;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VolumeDAOHibernate extends GenericHibernateDAO<Volume, Long>
        implements VolumeDAO {
    
     private static final int AMOUNT_OF_ROWS_ON_PAGE = 10;
    
    @SuppressWarnings("unchecked")
    public List<Volume> volumesWithCategory(Long categoryId) {
        String q = "Select distinct v From Volume v JOIN v.volumeInfo vi JOIN vi.categoriess c LEFT OUTER JOIN c.parent cp WHERE c.id = :categoryId OR cp.id = :categoryId";
        return (List<Volume>) getSession().createQuery(q).setParameter("categoryId", categoryId).list();
    }

     @SuppressWarnings("unchecked")
	public List<Volume> retrievesVolumesPerPage( int page ) {
        String q = "Select v From Volume v ";
        String qCount = "Select count(v.id) From Volume v ";
        List<Volume> result = new ArrayList<Volume>();
        int initialPage = (page -1) * AMOUNT_OF_ROWS_ON_PAGE;
        int qCountResult = getCantOfRows( qCount,initialPage,AMOUNT_OF_ROWS_ON_PAGE );
        int cantPages = qCountResult/AMOUNT_OF_ROWS_ON_PAGE;
         if ( qCountResult != 0 ){
            if ( page >= cantPages){
                initialPage = cantPages;
            }
            result = (List<Volume>) getSession().createQuery(q).setFirstResult(initialPage).setMaxResults( AMOUNT_OF_ROWS_ON_PAGE ).list();
         }
         return result;
    }
    
    @SuppressWarnings("unchecked")
	public List<Volume> retrieveVolumesWithCategoryPerPage(Long categoryId,
			int page) {
    	List<Volume> result = new ArrayList<Volume>();
    	Session session = getSession();
        
        Transaction tx = session.beginTransaction();
        
            StringBuilder qCount = new StringBuilder ("Select count(v.id) From Volume v ");
            qCount.append(" JOIN v.volumeInfo vi JOIN vi.categoriess c ");
            qCount.append(" LEFT OUTER JOIN c.parent cp WHERE c.id = "+categoryId + " OR cp.id = "+categoryId+"");

            int initialPage = (page -1) * AMOUNT_OF_ROWS_ON_PAGE;
            int qCountResult = getCantOfRows( qCount.toString() ,initialPage, AMOUNT_OF_ROWS_ON_PAGE);
            if ( qCountResult != 0 ){
                int cantPages = qCountResult/AMOUNT_OF_ROWS_ON_PAGE;

                if ( page >= cantPages){
                    initialPage = cantPages;
                }

                String q = "Select distinct v From Volume v JOIN v.volumeInfo vi JOIN vi.categoriess c LEFT OUTER JOIN c.parent cp WHERE c.id = :categoryId OR cp.id = :categoryId";
                result =  (List<Volume>) session.createQuery(q).
                                                                                        setParameter("categoryId", categoryId).
                                                                                        setFirstResult(initialPage).
                                                                                        setMaxResults( AMOUNT_OF_ROWS_ON_PAGE ).
                                                                                        list();
            }
            
          tx.rollback();
        return result;
    }
}
