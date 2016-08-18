//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.02 at 05:29:10 PM CET 
//


package com.opnfi.risk.model.jaxb;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ComplexEvents_Block_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComplexEvents_Block_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{}ComplexEventsElements"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}ComplexEventsAttributes"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComplexEvents_Block_t", propOrder = {
    "evntDts"
})
public class ComplexEventsBlockT {

    @XmlElement(name = "EvntDts")
    protected List<ComplexEventDatesBlockT> evntDts;
    @XmlAttribute(name = "Typ")
    protected BigInteger typ;

    /**
     * Gets the value of the evntDts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the evntDts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEvntDts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComplexEventDatesBlockT }
     * 
     * 
     */
    public List<ComplexEventDatesBlockT> getEvntDts() {
        if (evntDts == null) {
            evntDts = new ArrayList<ComplexEventDatesBlockT>();
        }
        return this.evntDts;
    }

    /**
     * Gets the value of the typ property.
     * 
     * @return
     *     possible object is
     *     {@link java.math.BigInteger }
     *
     */
    public BigInteger getTyp() {
        return typ;
    }

    /**
     * Sets the value of the typ property.
     *
     * @param value
     *     allowed object is
     *     {@link java.math.BigInteger }
     *     
     */
    public void setTyp(BigInteger value) {
        this.typ = value;
    }

}
