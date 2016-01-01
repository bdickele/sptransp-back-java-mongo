package org.bdickele.sptransp.repository;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.bdickele.sptransp.configuration.DatabaseInfo;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bdickele
 */
public class SpTranspRepository {

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

    protected <T> List<T> getList(MongoCursor<T> cursor) {
        List<T> list = new ArrayList<>();
        try {
            while (cursor.hasNext()) {
                list.add(cursor.next());
            }
        } finally {
            try {
                cursor.close();
            } catch (IOException ioe) {}
        }
        return list;
    }
}
