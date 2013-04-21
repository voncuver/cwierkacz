package com.pk.cwierkacz.model.service;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;

import com.pk.cwierkacz.exception.StartException;
import com.pk.cwierkacz.model.HibernateUtil;

public class ServiceRepo
{

    @SuppressWarnings( "rawtypes" )
    private final Map<Class, AbstractService> instances;

    private final HibernateUtil hibernateUtil;

    @SuppressWarnings( "rawtypes" )
    private ServiceRepo() {
        instances = new HashMap<Class, AbstractService>();

        hibernateUtil = new HibernateUtil();
        try {
            hibernateUtil.start();
        }
        catch ( StartException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static class InstanceHolder
    {
        public static ServiceRepo serviceRepo = new ServiceRepo();
    }

    public static ServiceRepo getInstance( ) {
        return InstanceHolder.serviceRepo;
    }

    @SuppressWarnings( {"rawtypes", "unchecked"} )
    public < T > T getService( Class classDef ) {
        if ( instances.containsKey(classDef) ) {
            return (T) instances.get(classDef);
        }
        else {
            T t = getServiceInstance(classDef);
            instances.put(classDef, (AbstractService) t);
            return t;
        }
    }

    @SuppressWarnings( {"unchecked", "rawtypes"} )
    private < T > T getServiceInstance( Class classDef ) {
        try {
            return (T) classDef.getConstructor(SessionFactory.class)
                               .newInstance(hibernateUtil.getSessionFactory());
        }
        catch ( InstantiationException | IllegalAccessException | IllegalArgumentException |
                InvocationTargetException | NoSuchMethodException | SecurityException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
