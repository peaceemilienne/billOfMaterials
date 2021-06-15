package src.partPOJO;

import java.util.List;

public class Part {

	private String partNumber;
	private String name;
	private String partType;
	private float price;
	private List<BomEntry> billOfMaterial;

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPartType() {
		return partType;
	}

	public void setPartType(String partType) {
		this.partType = partType;
	}

	public float getPrice() {

		return price;

	}

	public void setPrice(float price) {

		this.price = price;
	}

	public List<BomEntry> getBillOfMaterial() {
		return billOfMaterial;
	}

	public void setBillOfMaterial(List<BomEntry> billOfMaterial) {
		this.billOfMaterial = billOfMaterial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((partNumber == null) ? 0 : partNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Part other = (Part) obj;
		if (partNumber == null) {
			if (other.partNumber != null)
				return false;
		} else if (!partNumber.equals(other.partNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Part [partNumber=" + partNumber + ", name=" + name + ", partType=" + partType + ", price=" + price
				+ ", billOfMaterial=" + billOfMaterial + "]";
	}

}
