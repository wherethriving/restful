package scopa.cona.database.manager.impl;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scopa.cona.database.model.OriginTable;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class OriginTableManagerTest {

	public static final Logger logger = Logger.getLogger(OriginTableManagerTest.class);

	@Autowired
	private scopa.cona.database.manager.OriginTableManager OriginTableManager;

	@Test
	public void testOriginTableCUR() {

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		OriginTable originTable = new OriginTable();
		originTable.setDataSourceInfoId(1);
		originTable.setIsIncremental(true);
		originTable.setTbName("HKSJZ");
		originTable.setDescription("石家庄户口");
		originTable.setIncreColName("incremental");
		originTable.setIncreColType(1);

		OriginTableManager.insertOriginTable(originTable);
		OriginTable insertOriginTable = OriginTableManager.selectOriginTableById(originTable.getOriginTableId());

		assert (null != insertOriginTable);
		assert (insertOriginTable.getDataSourceInfoId().equals(1));
		assert (insertOriginTable.getIsIncremental().equals(true));
		assert (insertOriginTable.getTbName().equals("HKSJZ"));
		assert (insertOriginTable.getDescription().equals("石家庄户口"));
		assert (insertOriginTable.getIncreColName().equals("incremental"));
		assert (insertOriginTable.getIncreColType().equals(1));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass insert select");

		insertOriginTable.setTbName("NJZCP");
		OriginTableManager.updateOriginTable(insertOriginTable);

		OriginTable updatedOriginTable = OriginTableManager.selectOriginTableById(originTable.getOriginTableId());

		assert (null != updatedOriginTable);
		assert (updatedOriginTable.getTbName().equals("NJZCP"));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass update");
	}

	@Test
	public void testOriginTableD() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		OriginTable originTable = new OriginTable();
		originTable.setDataSourceInfoId(1);
		originTable.setIsIncremental(true);
		originTable.setTbName("HKSJZ");
		originTable.setDescription("石家庄户口");
		originTable.setIncreColName("incremental");
		originTable.setIncreColType(1);

		OriginTableManager.insertOriginTable(originTable);
		OriginTable insertOriginTable = OriginTableManager.selectOriginTableById(originTable.getOriginTableId());

		assert (null != insertOriginTable);

		OriginTableManager.deleteOriginTable(originTable.getOriginTableId());
		OriginTable deletedOriginTable = OriginTableManager.selectOriginTableById(originTable.getOriginTableId());

		assert (null == deletedOriginTable);

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass delete");
	}

	@Test
	public void testSelectOTableByName() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		OriginTable originTable = new OriginTable();
		originTable.setDataSourceInfoId(1);
		originTable.setIsIncremental(true);
		originTable.setTbName("HKSJZNAME");
		originTable.setDescription("石家庄户口");
		originTable.setIncreColName("incremental");
		originTable.setIncreColType(1);

		OriginTableManager.insertOriginTable(originTable);

		String originTableName = "HKSJZNAME";
		OriginTable selectOriginTable = OriginTableManager.
				selectOriginTableByName(originTableName);

		assert (selectOriginTable.getTbName().equals("HKSJZNAME"));
		assert (selectOriginTable.getDescription().equals("石家庄户口"));
	}

	@Test
	public void testSelectOriginTableByDataSourceInfoId() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		OriginTable originTable = new OriginTable();
		originTable.setDataSourceInfoId(1);
		originTable.setIsIncremental(true);
		originTable.setTbName("HKSJZNAME");
		originTable.setDescription("石家庄");
		originTable.setIncreColName("incremental");
		originTable.setIncreColType(1);

		OriginTableManager.insertOriginTable(originTable);

		OriginTable originTable1 = new OriginTable();
		originTable1.setDataSourceInfoId(1);
		originTable1.setIsIncremental(true);
		originTable1.setTbName("HKSJZ");
		originTable1.setDescription("石家庄户口");
		originTable1.setIncreColName("incremental");
		originTable1.setIncreColType(1);

		OriginTableManager.insertOriginTable(originTable1);

		Integer dataSourceInfoId = 1;
		List<OriginTable> selectedOriginTables = OriginTableManager.
					getOriginTableByDataSourceInfoId(dataSourceInfoId);

		int size = selectedOriginTables.size();
		for (int i = size - 1; i > size - 3; i--) {
			OriginTable tAttr = selectedOriginTables.get(i);
			if (i == size - 2) {
				assert (tAttr.getTbName().equals("HKSJZNAME"));
			} else if (i == size - 1) {
				assert (tAttr.getDescription().equals("石家庄户口"));
			}
		}
	}



}
