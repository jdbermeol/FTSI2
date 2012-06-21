package org.xtremeware.testapp.entity;

import java.io.Serializable;
import org.xtremeware.testapp.vo.ValueObject;

public interface Entity<E extends ValueObject> extends Serializable {
    
    public E toVo();
}
