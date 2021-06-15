package src.partPOJO;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;

public class PartManagerImpl implements PartManager {

	private static Map<String, Part> partStore = new HashMap<String, Part>();
	
	
	@Override
	public int importPartStore(String filePath) {

		

		// reading data from bom.json file.
		String jsonData = null;
		try {
			jsonData = new String(Files.readAllBytes(Paths.get(filePath)));

		} catch (IOException e) {
			System.out.println("File not found!");
		}

		if (jsonData == null || jsonData.isEmpty()) {

			System.out.println(
					"Your file path has an empty file, restart the program and insert another valid file path!");
			System.exit(0); 
		}
		// Converting data from JSON file format in array of parts
		Gson gson = new Gson();
		Part[] parts = gson.fromJson(jsonData, Part[].class);

		// Scanning the array of parts and storing data in a HashMap while removing
		// duplicates

		for (Part partDetails : parts) {
			if (!PartManagerImpl.partStore.containsKey(partDetails.getPartNumber())) {
				PartManagerImpl.partStore.put(partDetails.getPartNumber(), partDetails);

			}
		}

		// System.out.println(jsonData);

		// for (Map.Entry<String, Part> entry : partStore.entrySet()) {
		// System.out.println("Key = " + entry.getKey() + ", Value = " +
		// entry.getValue());
		// }

		return partStore.size();
	}

	@Override
	public Part costPart(String partNumber) {

		Part part = retrievePart(partNumber);
		if (part == null) {
			System.out.println(
					"Your part number doesn't correspond to any part hence it's cost can't be calculated , restart the program and insert another valid part number!");
			System.exit(0);

		}

		// First checking if that part have sub component parts , if yes then
		// calculating it's price and set its price
		if (part.getBillOfMaterial() != null) {
			float cost = getTotalCost(part.getBillOfMaterial());
			part.setPrice(cost);
		}

		return part;
	}

	public float getTotalCost(List<BomEntry> billOfCost) {
		float result = 0;
		for (int i = 0; i < billOfCost.size(); i++) {
			BomEntry entry = billOfCost.get(i);
			Part part = retrievePart(entry.getPartNumber());

			if (part.getBillOfMaterial() != null) {
				float tempCost = getTotalCost(part.getBillOfMaterial());
				part.setPrice(tempCost);
			}

			float finalCost = roundForMoney(part.getPrice() * entry.getQuantity());

			result += finalCost;

		}

		return roundForMoney(result);
	}

	private float roundForMoney(float value) {
		return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).floatValue();
	}

	@Override
	public Part retrievePart(String partNumber) {

		if (PartManagerImpl.partStore.containsKey(partNumber)) {

			// Returns a part associated with the partNumber provided
			return PartManagerImpl.partStore.get(partNumber);

		} else
			return null;

	}

	@Override
	public List<Part> getFinalAssemblies() {
		List<Part> finalAssemblies = new ArrayList<>();

		// Adding assembly type parts in a list
		for (Part assembly : PartManagerImpl.partStore.values()) {

			if (assembly.getPartType().equals("ASSEMBLY")) {
				finalAssemblies.add(assembly);

			}

		}

		// Sorting the list of parts with type "ASSEMBLY" by their part number
		Collections.sort(finalAssemblies, new Comparator<Part>() {
			@Override
			public int compare(Part part1, Part part2) {
				int compare = 0;
				if (part1 == null || part2 == null) {
					try {
						throw new Exception("One of the part's credentials is null!");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

				compare = part1.getPartNumber().compareToIgnoreCase(part2.getPartNumber());
				if (compare == 0) {
					compare = part1.getName().compareToIgnoreCase(part2.getName());
				}

				return compare;
			}
		});

		// for (Part parA : finalAssemblies) {
		// System.out.println(parA);
		// System.out.println("\n");

		// }

		return finalAssemblies;
	}

	@Override
	public List<Part> getPurchasePartsByPrice() {

		List<Part> purchasedParts = new ArrayList<>();
		// Adding assembly type parts in a list
		for (Part purchased : PartManagerImpl.partStore.values()) {

			if (purchased.getPartType().equals("PURCHASE")) {
				purchasedParts.add(purchased);

			}

		}
		// Sorting the list of parts with type "PURCHASE" by their part price in
		// descending order
		Collections.sort(purchasedParts, new Comparator<Part>() {
			@Override
			public int compare(Part part1, Part part2) {
				int compare = 0;
				if (part1 == null || part2 == null) {
					try {
						throw new Exception("One of the part's credentials is null!");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

				if (part1.getPrice() > part2.getPrice()) {
					compare = -1;
				} else if (part1.getPrice() == part2.getPrice()) {
					compare = part1.getPartNumber().compareToIgnoreCase(part2.getPartNumber());
				} else {
					compare = 1;
				}
				return compare;
			}

		});

		// for (Part parA : purchasedParts) {
		// System.out.println(parA);
		// System.out.println("\n");

		// }

		return purchasedParts;
	}

	public static Map<String, Part> getPartStore() {
		return partStore;
	}

}
