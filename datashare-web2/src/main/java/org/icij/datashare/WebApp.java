package org.icij.datashare;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.codestory.http.Configuration;
import net.codestory.http.WebServer;

public class WebApp {
    public static void main(String[] args) {
        new WebServer().configure(getConfiguration()).start();
    }

    static Configuration getConfiguration() {
        Injector injector = Guice.createInjector(new ServiceModule());
        return routes -> routes
                .get("/", "Datashare REST API")
                .add(new ProcessResource(null));
    }
}