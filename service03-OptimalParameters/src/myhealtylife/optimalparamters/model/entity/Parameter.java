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
import javax.xml.bind.annotation.XmlRootElement;

import myhealtylife.optimalparamters.model.dao.OptimalParametersDao;

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
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
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
	
	public static Parameter getPersonById(long personId) {
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
    	Parameter p=getPersonById(id);
    	
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
