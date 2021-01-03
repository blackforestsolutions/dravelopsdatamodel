package de.blackforestsolutions.dravelopsdatamodel.hazelcast.classdefinition;

import com.hazelcast.nio.serialization.ClassDefinition;
import com.hazelcast.nio.serialization.ClassDefinitionBuilder;

import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.DravelOpsPortableFactory.DRAVEL_OPS_FACTORY_ID;
import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.DravelOpsPortableFactory.POINT_CLASS_ID;

public class PointClassDefinition {

    public static final String X_FIELD = "x";
    public static final String Y_FIELD = "y";

    public static ClassDefinition buildPointClassDefinition() {
        return new ClassDefinitionBuilder(DRAVEL_OPS_FACTORY_ID, POINT_CLASS_ID)
                .addDoubleField(X_FIELD)
                .addDoubleField(Y_FIELD)
                .build();
    }
}
