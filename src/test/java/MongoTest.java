import com.mongodb.client.*;
import org.bson.Document;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MongoTest {
    private MongoDatabase database;

    @BeforeClass
    public void init() {
        MongoClient mongoClient = MongoClients.create("mongodb://techno:ee4CvCRPhor5@185.97.114.201:27118/?authSource=cloud-school");
        database = mongoClient.getDatabase("cloud-school");
    }

    @Test
    public void test() {
        MongoCollection<Document> collection = database.getCollection("school_city");
        System.out.println(collection.countDocuments());
    }

    @Test
    public void findOne() {
        MongoCollection<Document> collection = database.getCollection("school_city");
        Document actual = collection.find().first();
        System.out.println(actual);
    }

    @Test
    public void findAll() {
        MongoCollection<Document> collection = database.getCollection("school_city");
        MongoCursor<Document> cursor = collection.find().iterator();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
        cursor.close();
    }
}
