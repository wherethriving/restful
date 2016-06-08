package scopa.cona.database.manager.impl;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scopa.cona.database.model.OTTableMapping;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class OTTableMappingManagerTest {

	public static final Logger logger = Logger.getLogger(OTTableMappingManagerTest.class);

	@Autowired
	private scopa.cona.database.manager.OTTableMappingManager OTTableMappingManager;

	@Test
	public void testOTTableMapperCUR() {

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");


		OTTableMapping otTableMapping = new OTTableMapping();
		otTableMapping.setOriginTableId(1);
		otTableMapping.setTargetTableId(1);

		OTTableMappingManager.insertOTTableMapping(otTableMapping);
		OTTableMapping insertOTTableMapping = OTTableMappingManager.selectOTTableMappingById(otTableMapping.getTbMappingId());

		assert (null != insertOTTableMapping);
		assert (insertOTTableMapping.getOriginTableId().equals(1));
		assert (insertOTTableMapping.getTargetTableId().equals(1));


		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass insert select");

		insertOTTableMapping.setOriginTableId(2);
		OTTableMappingManager.updateOTTableMapping(insertOTTableMapping);

		OTTableMapping updatedOTTableMapping = OTTableMappingManager.selectOTTableMappingById(otTableMapping.getTbMappingId());
		assert (null != insertOTTableMapping);
		assert (updatedOTTableMapping.getOriginTableId().equals(2));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass update");
	}

	@Test
	public void testOTTableMappingD() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		OTTableMapping otTableMapping = new OTTableMapping();
		otTableMapping.setOriginTableId(1);
		otTableMapping.setTargetTableId(1);

		OTTableMappingManager.insertOTTableMapping(otTableMapping);
		OTTableMapping insertOTTableMapping = OTTableMappingManager.selectOTTableMappingById(
				otTableMapping.getTbMappingId());

		assert (null != insertOTTableMapping);

		OTTableMappingManager.deleteOTTableMapping(insertOTTableMapping.getTbMappingId());
		OTTableMapping deletedOTTableMapping = OTTableMappingManager.selectOTTableMappingById(
				otTableMapping.getTbMappingId());

		assert (null == deletedOTTableMapping);

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass delete");
	}

}
