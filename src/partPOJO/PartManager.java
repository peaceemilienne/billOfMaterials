package src.partPOJO;

import java.util.List;

/**
 * 
 * Defines a family of classes that manage parts in a part store
 * 
 */

public interface PartManager {

	/**
	 * 
	 * Imports the part store from an external file.
	 * 
	 * @param Accepts the file path to the file which contains the parts to import.
	 * @return Returns the number of parts imported.
	 * 
	 */

	public int importPartStore(String filePath);

	/**
	 * 
	 * Computes the cost to manufacture the part associated with the supplied part
	 * number.
	 * 
	 * @param Accepts a part number which identifies the part to compute the cost
	 *                for.
	 * 
	 */

	public Part costPart(String partNumber);

	/**
	 * 
	 * Retrieves the part associated with the supplied part number from the part
	 * store.
	 * 
	 * @param Accepts a part number which identifies the part to retrieve.
	 * @return Returns the Part instance associated with the supplied part number or
	 *         null if not found
	 * 
	 */
	public Part retrievePart(String partNumber);

	/**
	 * Final assemblies have a part type of �ASSEMBLY�
	 * 
	 * @return Returns all final assembly parts sorted alphabetically by their part
	 *         number.
	 */
	public List<Part> getFinalAssemblies();

	/**
	 * Purchase parts have a part type of �PURCHASE�.
	 * 
	 * @return Returns all purchased parts sorted by their price, highest price to
	 *         lowest.
	 */
	public List<Part> getPurchasePartsByPrice();
}
