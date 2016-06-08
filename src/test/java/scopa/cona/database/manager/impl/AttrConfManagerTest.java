package scopa.cona.database.manager.impl;


import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import scopa.cona.database.model.AttrConf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AttrConfManagerTest {

	public static final Logger logger = Logger.getLogger(AttrConfManagerTest.class);

	@Autowired
	private scopa.cona.database.manager.AttrConfManager AttrConfManager;

	@Test
	public void testAttrConfCUR() {

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test");

		AttrConf attrConf = new AttrConf();
		attrConf.setAttrConfId(1);
		attrConf.setAttrName("是否UniqueKey");
		attrConf.setColumnType("Boolean");
		attrConf.setConfDictId(2);
		attrConf.setConfParam("true");
		attrConf.setIsOptional(false);
		attrConf.setIsType(false);

		AttrConfManager.insertAttrConf(attrConf);
		AttrConf insertAttrConf = AttrConfManager.selectAttrConfById(attrConf.getAttrConfId());

		assert (insertAttrConf != null);
		assert (insertAttrConf.getAttrName().equals("是否UniqueKey"));
		assert (insertAttrConf.getIsType().equals(false));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass insert select");


		insertAttrConf.setConfParam("false");

		AttrConfManager.updateAttrConf(insertAttrConf);

		AttrConf updateAttrConf = AttrConfManager.selectAttrConfById(insertAttrConf.getAttrConfId());

		assert (null != updateAttrConf);
		assert (updateAttrConf.getConfParam().equals("false"));

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass update");


	}


	@Test
	public void testAttrConfD(){

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"begin test delete");

		AttrConf attrConf = new AttrConf();
		attrConf.setAttrConfId(1);
		attrConf.setAttrName("是否UniqueKey");
		attrConf.setColumnType("Boolean");
		attrConf.setConfDictId(2);
		attrConf.setConfParam("true");
		attrConf.setIsOptional(false);
		attrConf.setIsType(false);

		AttrConfManager.insertAttrConf(attrConf);
		AttrConf planDeleteAttrConf = AttrConfManager.selectAttrConfById(attrConf.getAttrConfId());
		assert (null != planDeleteAttrConf);

		AttrConfManager.deleteAttrConf(attrConf.getAttrConfId());
		AttrConf deleteAttrConf = AttrConfManager.selectAttrConfById(attrConf.getAttrConfId());
		assert (null == deleteAttrConf);

		logger.info(this.getClass().getSimpleName() + " ==== " +
				Thread.currentThread().getStackTrace()[1].getMethodName() + " ==== " +
				"pass delete");
	}

}
