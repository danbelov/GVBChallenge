package models;

import io.ebean.config.ServerConfig;
import org.avaje.datasource.DataSourceConfig;

import io.ebean.event.ServerConfigStartup;

public class GVBServerConfigStartup implements ServerConfigStartup {

    public void onStart(ServerConfig serverConfig) {
        serverConfig.setDatabaseSequenceBatchSize(1);

        /*DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:h2:mem:play");
        serverConfig.setDataSourceConfig(dataSourceConfig);*/
    }

}
