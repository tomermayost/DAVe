//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.02 at 05:29:10 PM CET 
//


package com.opnfi.risk.model.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;


/**
 * <p>Java class for MarginReqmtInqQualGrp_Block_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MarginReqmtInqQualGrp_Block_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{}MarginReqmtInqQualGrpElements"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}MarginReqmtInqQualGrpAttributes"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MarginReqmtInqQualGrp_Block_t")
public class MarginReqmtInqQualGrpBlockT {

    @XmlAttribute(name = "Qual")
    protected BigInteger qual;

    /**
     * Gets the value of the qual property.
     * 
     * @return
     *     possible object is
     *     {@link java.math.BigInteger }
     *
     */
    public BigInteger getQual() {
        return qual;
    }

    /**
     * Sets the value of the qual property.
     *
     * @param value
     *     allowed object is
     *     {@link java.math.BigInteger }
     *     
     */
    public void setQual(BigInteger value) {
        this.qual = value;
    }

}
