package it.univpm.marcolini.model;

/**
 * @author Alessandro Marcolini
 * @version 1.0
 * @see Point
 * @see Bound
 */
public class Record {

    /**
     * Crea un oggetto di tipo Record
     * @param placeType specifica il tipo di località
     * @param name nome della località
     * @param region nome della regione
     * @param country nome dello stato di cui fa parte
     * @param container <code>Record</code> della provincia a cui appartiene
     * @param centro coordinate del centro della località
     * @param boundingBox <code>Bound</code> che definisce l'estensione della località
     */
    public Record(String placeType, String name, String region,
    		String country, Record container, Point centro, Bound boundingBox) {
		this.placeType = placeType;
		this.name = name;
		this.region = region;
		this.country = country;
		this.container = container;
		this.centro = centro;
		this.boundingBox = boundingBox;
	}

    /**
     * Indica il tipo di località, se si tratta di comune(=city) o di provincia(=admin)
     */
    protected String placeType;

    /**
     * nome della località
     */
    protected String name;

    /**
     * nome della regione
     */
    protected String region;

    /**
     * nome dello Stato
     */
    protected String country;

    /**
     * <code>Record</code> della provincia a cui appartiene
     */
    protected Record container;

    /**
     * <code>Point</code> che rappresenta le coordinate del centro della località
     */
    protected Point centro;

    /**
     * <code>Bound</code> che rappresenta i confini della località
     */
    protected Bound boundingBox;



    /**
     * @return il nome della località
     */
    public String getName() {
        
        return this.name;
    }

    /**
     * @return il centro della località
     */
    public Point getCentro() {

        return this.centro;
    }

    /**
     * @return un <code>Record</code> contenente la provincia della località
     */
    public Record getContainer() {
        
        return this.container;
    }

}