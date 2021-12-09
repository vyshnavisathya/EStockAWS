package com.cts.estock;
        import com.mongodb.ConnectionString;
        import com.mongodb.MongoClientSettings;
        import com.mongodb.client.MongoClient;
        import com.mongodb.client.MongoClients;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.core.env.Environment;
        import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@Configuration
@EnableMongoRepositories(basePackages = "com.cts.estock.repository")
public class MongoConfiguration {
    @Autowired
    private Environment env;
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString(env.getProperty("mongodb.connection.string"));
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }
}