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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.xml.bind.annotation.XmlRootElement;

import myhealtylife.optimalparamters.model.dao.OptimalParametersDao;

/**
 * This object represent an optimal parameter for an age range
 * @author stefano
 *
 */
@Entity
@Table(name="parameters")
@NamedQuery(name="Parameter.findAll", query="SELECT p FROM Parameter p")
@XmlRootElement(name="parameter")
public class Parameter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id // defines this attributed as the one that identifies the entity
    @GeneratedValue(strategy=GenerationType.AUTO) 
	private long idParameter;
	
	private String parameterName;
	
	private String sex;
	
	private Double value;
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private AgeRange ageRange;

	public long getIdParameter() {
		return idParameter;
	}

	public void setIdParameter(long idParameter) {
		this.idParameter = idParameter;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public AgeRange getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(AgeRange ageRange) {
		this.ageRange = ageRange;
	}
	
	public static List<Parameter> getAll() {
        EntityManager em = OptimalParametersDao.instance.createEntityManager();
        List<Parameter> list = em.createNamedQuery("Parameter.findAll", Parameter.class)
            .getResultList();
        OptimalParametersDao.instance.closeConnections(em);
        return list;
    }
	
	public static List<Parameter> getAllByAgeAndSex(String sex, int age) {
        EntityManager em = OptimalParametersDao.instance.createEntityManager();
        /*filtering results by age and sex*/
        TypedQuery<Parameter> query=em.createQuery("SELECT p FROM Parameter p, AgeRange a WHERE p.ageRange.idRange=a.idRange AND p.sex=?1 AND a.fromAge <= ?2 AND a.toAge>=?2", Parameter.class);
        query.setParameter(1, sex);
        query.setParameter(2, age);
        List<Parameter> list=query.getResultList();
        OptimalParametersDao.instance.closeConnections(em);
        return list;
    }
	
	public static List<Parameter> getAllByAgeRangeAndSex(String sex, int ageFrom, int ageTo) {
        EntityManager em = OptimalParametersDao.instance.createEntityManager();
        /*filtering results by age and sex*/
        TypedQuery<Parameter> query=em.createQuery("SELECT p FROM Parameter p, AgeRange a WHERE p.ageRange.idRange=a.idRange AND p.sex=?1 AND a.fromAge >= ?2 AND a.toAge<=?3"
        		, Parameter.class);
        query.setParameter(1, sex);
        query.setParameter(2, ageFrom);
        query.setParameter(3, ageTo);
        List<Parameter> list=query.getResultList();
        OptimalParametersDao.instance.closeConnections(em);
        return list;
    }
	
	public static List<Parameter> getAllByAgeSexName(String sex, String parameterName, int age) {
        EntityManager em = OptimalParametersDao.instance.createEntityManager();
        /*filtering results by age, sex and parameter name*/
        TypedQuery<Parameter> query=em.createQuery("SELECT p FROM Parameter p, AgeRange a WHERE p.ageRange.idRange=a.idRange AND p.sex=?1 AND a.fromAge <= ?2 AND a.toAge>=?2"
        		+ " AND p.parameterName=?3", Parameter.class);
        query.setParameter(1, sex);
        query.setParameter(2, age);
        query.setParameter(3, parameterName);
        List<Parameter> list=query.getResultList();
        OptimalParametersDao.instance.closeConnections(em);
        return list;
    }
	
	public static List<Parameter> getAllBySex(String sex) {
        EntityManager em = OptimalParametersDao.instance.createEntityManager();
        /*filtering parameters bt sex*/
        TypedQuery<Parameter> query=em.createQuery("SELECT p FROM Parameter p WHERE p.sex=?1", Parameter.class);
        query.setParameter(1, sex);
        List<Parameter> list=query.getResultList();
        OptimalParametersDao.instance.closeConnections(em);
        return list;
    }
	
	public static Parameter getParameterById(long personId) {
        EntityManager em = OptimalParametersDao.instance.createEntityManager();
        Parameter p = em.find(Parameter.class, personId);
        OptimalParametersDao.instance.closeConnections(em);
        return p;
    }
	
	public static Parameter saveParameter(Parameter p) {
        EntityManager em = OptimalParametersDao.instance.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(p);
        tx.commit();
        OptimalParametersDao.instance.closeConnections(em);
        return p;
    } 

    public static Parameter updateParameter(Parameter p) {
        EntityManager em = OptimalParametersDao.instance.createEntityManager(); 
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        p=em.merge(p);
        tx.commit();
        OptimalParametersDao.instance.closeConnections(em);
        return p;
    }
    
    public static void removeParameter(long id) {
    	Parameter p=getParameterById(id);
    	
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
