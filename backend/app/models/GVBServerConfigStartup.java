package models;

import io.ebean.config.*;
import org.avaje.datasource.DataSourceConfig;

import io.ebean.event.ServerConfigStartup;

import io.ebean.Ebean;
import io.ebean.EbeanServer;

import enums.*;
import org.joda.time.*;

public class GVBServerConfigStartup implements ServerConfigStartup {

    public void onStart(ServerConfig serverConfig) {
        serverConfig.setDatabaseSequenceBatchSize(1);
        serverConfig.setJsonDateTime(JsonConfig.DateTime.ISO8601);

        /*DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:h2:mem:play");
        serverConfig.setDataSourceConfig(dataSourceConfig);*/
    }

}
