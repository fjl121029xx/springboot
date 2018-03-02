package com.li.cn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;

@Configuration
public class ExportConfiguration {

    /*@Bean
    @ExportMetricWriter
    public MetricWriter createMetricWriter(MBeanExporter exporter) {

        return new JmxMetricsWriter(exporter);
    }*/
}
