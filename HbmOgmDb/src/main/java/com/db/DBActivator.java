package com.db;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class DBActivator implements BundleActivator {
	
    public void start(BundleContext context) {
        System.out.println("Starting HBM OGM DB bundle");
    }

    public void stop(BundleContext context) {
        System.out.println("Stopping HBM OGM DB bundle");
    }
}