package com.deedef.Constante;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.text.SimpleDateFormat;
import java.util.Locale;


/**
 * Created by birame ndiaye on 31/05/2015.
 */
@Provider
public class JacksonMapperProvider implements ContextResolver<ObjectMapper> {


    @Override
    public ObjectMapper getContext(Class<?> aClass) {
        ObjectMapper mapper=new ObjectMapper();
        SimpleDateFormat ISODATEFORMAT=new SimpleDateFormat("yyyy-MM-dd'T'MM:mm:ss.SSSZ", Locale.FRANCE);
        mapper.setDateFormat(ISODATEFORMAT);
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL).configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false).configure(SerializationConfig.Feature.USE_ANNOTATIONS,true).configure(SerializationConfig.Feature.WRITE_ENUMS_USING_TO_STRING,true).configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,false).configure(JsonParser.Feature.ALLOW_COMMENTS,true);
        return mapper;
    }
}
