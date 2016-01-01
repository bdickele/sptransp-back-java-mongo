package org.bdickele.sptransp.service;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.bdickele.sptransp.configuration.DatabaseInfo;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.UnknownHostException;

/**
 * Created by Bertrand DICKELE
 */
public class AbstractService {

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
