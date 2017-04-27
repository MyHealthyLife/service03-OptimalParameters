package myhealtylife.optimalparamters.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import myhealtylife.optimalparamters.model.entity.AgeRange;

/**
 * this class is used for encaspulate a list of AgeRange
 * @author stefano
 *
 */
@XmlRootElement(name="AgeRangeList")
public class AgeRangeList {

	private List<AgeRange> ageRanges;

	public List<AgeRange> getAgeRanges() {
		return ageRanges;
	}

	public void setAgeRanges(List<AgeRange> ageRanges) {
		this.ageRanges = ageRanges;
	}
}
