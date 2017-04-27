package myhealtylife.optimalparamters.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import myhealtylife.optimalparamters.model.dao.OptimalParametersDao;

/**
 * This class represents a range of range and contais the starting age and ending age for the range.
 * @author stefano
 *
 */
@Entity
@Table(name="age_range")
@NamedQuery(name="AgeRange.findAll", query="SELECT a FROM AgeRange a")
@XmlRootElement(name="age_range")
public class AgeRange implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id // defines this attributed as the one that identifies the entity
    @GeneratedValue(strategy=GenerationType.AUTO) 
	private long idRange;
	
	private Integer fromAge;
	
	private Integer toAge;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL,mappedBy="ageRange")
	private List<Parameter> parameter;

	public long getIdRange() {
		return idRange;
	}

	public void setIdRange(long idRange) {
		this.idRange = idRange;
	}

	public Integer getFromAge() {
		return fromAge;
	}

	public void setFromAge(Integer fromAge) {
		this.fromAge = fromAge;
	}

	public Integer getToAge() {
		return toAge;
	}

	public void setToAge(Integer toAge) {
		this.toAge = toAge;
	}

	@XmlTransient
	public List<Parameter> getParameter() {
		return parameter;
	}

	public void setParameter(List<Parameter> parameter) {
		this.parameter = parameter;
	}
	
	public static List<AgeRange> getAll() {
        EntityManager em = OptimalParametersDao.instance.createEntityManager();
        List<AgeRange> list = em.createNamedQuery("AgeRange.findAll", AgeRange.class)
            .getResultList();
        OptimalParametersDao.instance.closeConnections(em);
        return list;
    }

	
	public static AgeRange getAgeRangeById(long personId) {
        EntityManager em = OptimalParametersDao.instance.createEntityManager();
        AgeRange p = em.find(AgeRange.class, personId);
        OptimalParametersDao.instance.closeConnections(em);
        return p;
    }
	
	public static AgeRange saveAgeRange(AgeRange p) {
        EntityManager em = OptimalParametersDao.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(p);
        tx.commit();
        OptimalParametersDao.instance.closeConnections(em);
        return p;
    } 

    public static AgeRange updateAgeRange(AgeRange p) {
        EntityManager em = OptimalParametersDao.instance.createEntityManager(); 
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        p=em.merge(p);
        tx.commit();
        OptimalParametersDao.instance.closeConnections(em);
        return p;
    }
    
    public static void removeAgeRange(long id) {
    	AgeRange p=getAgeRangeById(id);
    	
    	if(p==null)
    		return;
    	
        EntityManager em = OptimalParametersDao.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        p=em.merge(p);
        em.remove(p);
        tx.commit();
        OptimalParametersDao.instance.closeConnections(em);
    }

}
