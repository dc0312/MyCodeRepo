package designPatterns.dp07AdapterFactoryPattern;

/**
 * Target interface required by new client code
 */
public interface Customer {

	String getName();
	
	String getDesignation();
	
	String getAddress();
}
