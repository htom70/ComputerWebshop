package hu.tom.webshop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Processor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String type;
    private String vendor;
    private String cpuSocket;
    private String cpuFamily;
    private double clock;
    private int numberOfCores;
    private int cacheSize;
    private String vgaType;
    private String architectureType;
    private int power;

    public Processor() {
    }


}
