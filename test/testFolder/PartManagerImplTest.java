package test.testFolder;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import src.partPOJO.*;

public class PartManagerImplTest {
	PartManagerImpl partImpl = new PartManagerImpl();

	@Test
	public void testImportPartStore() {

		int countParts = 0;
		
      
		String filePath="C:\\Users\\peaceemilienne4\\Desktop\\projectsPeace\\billOfMaterials\\src\\partPOJO\\bom.json";
		countParts = partImpl.importPartStore(filePath);
		assertThat(79, is(countParts));
	}

	@Test
	public void testRetrievePart() {

		String partNumber = "40-0067";
		Part partReturned = partImpl.retrievePart(partNumber);
		Part partExpected = PartManagerImpl.getPartStore().get(partNumber);

		String partNumberNull = "2";
		Part partReturnedNull = partImpl.retrievePart(partNumberNull);
		Part partExpectedNull = null;

		assertThat(partExpected, is(partReturned));
		assertThat(partExpectedNull, is(partReturnedNull));

	}

	@Test
	public void testGetFinalAssemblies() {

		List<Part> finalAssembliesExpected = null;

		List<Part> finalAssembliesReturned = partImpl.getFinalAssemblies();

		assertThat(finalAssembliesExpected, is(not(finalAssembliesReturned)));

	}

	@Test
	public void testGetPurchasePartsByPrice() {

		List<Part> purchasedPartsExpected = null;
		List<Part> purchasePartsReturned = partImpl.getPurchasePartsByPrice();
		assertThat(purchasedPartsExpected, is(not(purchasePartsReturned)));

	}

	@Test
	public void testCostPart() {

		String partNumber = "290B7266J1";
		float costExpected = (float) 415.16;

		Part partCost = partImpl.costPart(partNumber);
		float costReturned = partCost.getPrice();

		assertThat(costExpected, is(costReturned));

		String partNumber1 = "290B7266J2";
		float costExpected1 = (float) 532.20;

		Part partCost1 = partImpl.costPart(partNumber1);
		float costReturned1 = partCost1.getPrice();

		assertThat(costExpected1, is(costReturned1));

		String partNumber2 = "290B7266J6";
		float costExpected2 = (float) 334.10;

		Part partCost2 = partImpl.costPart(partNumber2);
		float costReturned2 = partCost2.getPrice();

		assertThat(costExpected2, is(costReturned2));

		String partNumber3 = "20-0001";
		float costExpected3 = (float) 96.39;

		Part partCost3 = partImpl.costPart(partNumber3);
		float costReturned3 = partCost3.getPrice();

		assertThat(costExpected3, is(costReturned3));

		String partNumber4 = "20-0015";
		float costExpected4 = (float) 70.46;

		Part partCost4 = partImpl.costPart(partNumber4);
		float costReturned4 = partCost4.getPrice();

		assertThat(costExpected4, is(costReturned4));

	}

}
