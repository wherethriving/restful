package scopa.cona.database.manager.impl;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scopa.cona.database.model.TargetTable;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TargetTableManagerTest {

	public static final Logger logger = Logger.getLogger(TargetTableManagerTest.class);

	@Autowired
	private scopa.cona.database.manager.TargetTableManager TargetTableManager;

	@Test
	public void testTargetTableCUR() {

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");


		TargetTable targetTable = new TargetTable();
		targetTable.setLabelCn("案件");
		targetTable.setLabelEn("case");
		targetTable.setVersion(Float.valueOf("1"));
		targetTable.setDescription("案件统一视图");
		targetTable.setTbType("entity");

		TargetTableManager.insertTargetTable(targetTable);
		TargetTable insertTargetTable = TargetTableManager.selectTargetTableById(targetTable.getTargetTableId());

		assert (null != insertTargetTable);
		assert (insertTargetTable.getLabelCn().equals("案件"));
		assert (insertTargetTable.getLabelEn().equals("case"));
		assert (insertTargetTable.getTbType().equals("entity"));
		assert (insertTargetTable.getVersion().equals(Float.valueOf("1")));
		assert (insertTargetTable.getDescription().equals("案件统一视图"));

		TargetTable updateTargetTable = TargetTableManager.selectTargetTableById(targetTable.getTargetTableId());

		updateTargetTable.setLabelCn("户口");
		logger.info("updateTargetTable ==== " + updateTargetTable.getLabelCn());
		TargetTableManager.updateTargetTable(updateTargetTable);
		logger.info("updateTargetTable ==== " + updateTargetTable.getLabelCn());

		assert (null != updateTargetTable);
		assert (updateTargetTable.getLabelCn().equals("户口"));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass insert select");

	}

	@Test
	public void testTargetTableD() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		TargetTable targetTable = new TargetTable();
		targetTable.setLabelCn("监护人");
		targetTable.setLabelEn("parent");
		targetTable.setVersion(Float.valueOf("1"));
		targetTable.setDescription("监护人统一视图");
		targetTable.setTbType("人");
		targetTable.setTbNumber(1);

		TargetTableManager.insertTargetTable(targetTable);
		TargetTable insertTargetTable = TargetTableManager.selectTargetTableById(targetTable.getTargetTableId());

		assert (null != insertTargetTable);

		TargetTableManager.deleteTargetTable(targetTable.getTargetTableId());
		TargetTable dTargetTable = TargetTableManager.selectTargetTableById(targetTable.getTargetTableId());

		assert (null == dTargetTable);

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass delete");
	}

	@Test
	public void testSelectTargetTableByLabelEn() {
		String labelEn = "people";

		TargetTable selectedTargetTable = TargetTableManager.getTargetTableByLabelEn(labelEn);
		assert (null != selectedTargetTable);
		assert (selectedTargetTable.getLabelEn().equals("people"));
	}

}
