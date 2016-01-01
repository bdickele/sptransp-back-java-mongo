package org.bdickele.sptransp.testdata;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.bdickele.sptransp.configuration.DatabaseInfo;
import org.bdickele.sptransp.configuration.IntegrationTestConfig;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.UnknownHostException;

/**
 * Created by Bertrand DICKELE
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = IntegrationTestConfig.class)
public abstract class AbstractCreateTestData {

    private DatabaseInfo databaseInfo;

    private MongoClient mongoClient;

    @Autowired
    public void setDatabaseInfo(DatabaseInfo databaseInfo) throws UnknownHostException {
        this.databaseInfo = databaseInfo;
        this.mongoClient = new MongoClient(databaseInfo.getHost());
    }


    protected DB getDB() {
        return mongoClient.getDB(databaseInfo.getDbName());
    }

    protected MongoCollection getCollection(String collectionName) {
        Jongo jongo = new Jongo(getDB());
        return jongo.getCollection(collectionName);
    }
}
