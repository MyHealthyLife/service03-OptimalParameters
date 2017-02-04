package myhealtylife.optimalparamters.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="parameters")
@NamedQuery(name="Parameter.findAll", query="SELECT p FROM parameters p")
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
	
	private String value;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private AgeRange ageRange;

}
