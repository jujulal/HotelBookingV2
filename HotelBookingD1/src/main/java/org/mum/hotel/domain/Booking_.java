package org.mum.hotel.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel( Booking.class )
public class Booking_ {
    public static volatile SingularAttribute<Booking, Integer> bookingNo;
}
