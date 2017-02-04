package myhealtylife.optimalparamters.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="age_range")
@NamedQuery(name="age_range.findAll", query="SELECT a FROM age_range a")
@XmlRootElement(name="person")
public class AgeRange implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer fromAge;
	
	private Integer toAge;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL,mappedBy="ageRange")
	private List<Parameter> parameter;

}
