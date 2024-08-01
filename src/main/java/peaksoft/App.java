package peaksoft;

import peaksoft.config.HibernateConfig;
import peaksoft.entity.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println(HibernateConfig.getEntityManager());
    }
}
//  configuration.setProperties(properties);
//        configuration.addAnnotatedClass(Address.class);
//        configuration.addAnnotatedClass(Customer.class);
//        configuration.addAnnotatedClass(House.class);
//        configuration.addAnnotatedClass(RentInfo.class);
//        configuration.addAnnotatedClass(Owner.class);