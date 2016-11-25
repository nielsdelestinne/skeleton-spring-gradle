package be.cegeka.starter.infrastructure.test;

import be.cegeka.starter.StarterTestApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@WebIntegrationTest({"server.port:9000"})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StarterTestApplication.class)
@TestPropertySource(locations="classpath:test.application.properties")
public abstract class IntegrationTest extends AbstractTransactionalJUnit4SpringContextTests{

    public static final String APP_BASE_URL = "http://localhost:9000";

}
