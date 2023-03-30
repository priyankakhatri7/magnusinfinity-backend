package com.magnusinfinity.magnusinfinitybackend.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

public class CustomizeBeanUtils {
    /**
     * Copies properties from one object to another
     * @param source
     * @destination
     * @return
     */
    public static void copyNonNullProperties(Object source, Object destination){
        BeanUtils.copyProperties(source, destination,
                getNullPropertyNames(source));
    }

    /**
     * Returns an array of null properties of an object
     * @param source
     * @return
     */
    private static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for(java.beans.PropertyDescriptor pd : pds) {
            //check if value of this property is null then add it to the collection
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
