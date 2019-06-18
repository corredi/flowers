package com.accenture.flowershop.be.business;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.castor.CastorMarshaller;

public class UserMarshgallingServiceImpl {
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;
    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }
    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }
}
