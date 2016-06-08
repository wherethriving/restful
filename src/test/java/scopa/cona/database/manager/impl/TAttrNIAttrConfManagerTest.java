package scopa.cona.database.manager.impl;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scopa.cona.database.model.TAttrNAttrConf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TAttrNIAttrConfManagerTest {

	public static final Logger logger = Logger.getLogger(TAttrNIAttrConfManagerTest.class);

	@Autowired
	private scopa.cona.database.manager.TAttrNAttrConfManager TAttrNAttrConfManager;

	@Test
	public void testTAttrNattrConfCUR() {

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		TAttrNAttrConf tAttrNAttrConf = new TAttrNAttrConf();
		tAttrNAttrConf.setAttrConfId(3);
		tAttrNAttrConf.setTargetAttrId(2);

		TAttrNAttrConfManager.insertTAttrNAttrConf(tAttrNAttrConf);
		TAttrNAttrConf insertTAttrNConf = TAttrNAttrConfManager.selectTAttrNAttrConfById(
				tAttrNAttrConf.getAttrConfMappingId());

		assert (null != insertTAttrNConf);
		assert (insertTAttrNConf.getAttrConfId().equals(3));
		assert (insertTAttrNConf.getTargetAttrId().equals(2));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass insert select");

		tAttrNAttrConf.setTargetAttrId(3);
		TAttrNAttrConfManager.updateTAttrNAttrConf(tAttrNAttrConf);

		TAttrNAttrConf uTAttrNConf = TAttrNAttrConfManager.selectTAttrNAttrConfById(
				tAttrNAttrConf.getAttrConfMappingId());

		assert (null != uTAttrNConf);
		assert (uTAttrNConf.getTargetAttrId().equals(3));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass update");
	}

	@Test
	public void testTAttrNattrConfD() {
		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		TAttrNAttrConf tAttrNAttrConf = new TAttrNAttrConf();
		tAttrNAttrConf.setAttrConfId(3);
		tAttrNAttrConf.setTargetAttrId(2);

		TAttrNAttrConfManager.insertTAttrNAttrConf(tAttrNAttrConf);
		TAttrNAttrConf insertTAttrNConf = TAttrNAttrConfManager.selectTAttrNAttrConfById(
				tAttrNAttrConf.getAttrConfMappingId());

		assert (null != insertTAttrNConf);

		TAttrNAttrConfManager.deleteTAttrNAttrConf(tAttrNAttrConf.getAttrConfMappingId());
		TAttrNAttrConf dTAttrNConf = TAttrNAttrConfManager.selectTAttrNAttrConfById(
				tAttrNAttrConf.getAttrConfMappingId());

		assert (null == dTAttrNConf);

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass delete");
	}


}
