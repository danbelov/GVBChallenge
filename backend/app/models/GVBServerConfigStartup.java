package models;

import io.ebean.config.*;
import org.avaje.datasource.DataSourceConfig;

import io.ebean.event.ServerConfigStartup;

public class GVBServerConfigStartup implements ServerConfigStartup {

    public String status;

    public Double fraudScore;
    public String policeNr;
    public String name;
    public String email;

    public Long damageDate;

    public String damageSource;
    public String damagedItems;
    public String damageDescription;
    public String otherInformations;

    public Boolean offerExists;
    public Double costs;
    public Boolean selfEstimated;
    public Boolean billExists;

    private void generateMockReport(){

        EbeanServer server = Ebean.getDefaultServer();

        Event event = new Event();
        event.type = EventType.EMAIL;
        event.time = new DateTime().getMillis();
        event.text = form.get("msg");

        DamageReport report = new DamageReport();
        report.fraudScore = 1.57;
        report.policeNr = "1113984-3994824";
        report.name = "Schadenmeldung 0012";
        report.damageSource = "Vandalismus";
        report.damagedItems = "Fenster";
        report.status = "Waiting for customer";
        report.email = form.get("sender");
        report.offerExists = true;
        report.costs = 2779.95;
        report.selfEstimated = true;
        report.billExists = false;
        report.damageDate = new DateTime().getMillis();
        report.events.add(event);
        server.save(report);
    }

    public void onStart(ServerConfig serverConfig) {
        serverConfig.setDatabaseSequenceBatchSize(1);
        serverConfig.setJsonDateTime(JsonConfig.DateTime.ISO8601);

        generateMockReport();
        /*DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:h2:mem:play");
        serverConfig.setDataSourceConfig(dataSourceConfig);*/
    }

}
