//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.02 at 05:29:10 PM CET 
//


package com.opnfi.risk.model.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for RiskLimitsGrp_Block_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RiskLimitsGrp_Block_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{}RiskLimitsGrpElements"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}RiskLimitsGrpAttributes"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RiskLimitsGrp_Block_t", propOrder = {
    "riskLmtTyp",
    "instrmtScope"
})
public class RiskLimitsGrpBlockT {

    @XmlElement(name = "RiskLmtTyp")
    protected List<RiskLimitTypesGrpBlockT> riskLmtTyp;
    @XmlElement(name = "InstrmtScope")
    protected List<RiskInstrumentScopeGrpBlockT> instrmtScope;

    /**
     * Gets the value of the riskLmtTyp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the riskLmtTyp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRiskLmtTyp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RiskLimitTypesGrpBlockT }
     * 
     * 
     */
    public List<RiskLimitTypesGrpBlockT> getRiskLmtTyp() {
        if (riskLmtTyp == null) {
            riskLmtTyp = new ArrayList<RiskLimitTypesGrpBlockT>();
        }
        return this.riskLmtTyp;
    }

    /**
     * Gets the value of the instrmtScope property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instrmtScope property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstrmtScope().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RiskInstrumentScopeGrpBlockT }
     * 
     * 
     */
    public List<RiskInstrumentScopeGrpBlockT> getInstrmtScope() {
        if (instrmtScope == null) {
            instrmtScope = new ArrayList<RiskInstrumentScopeGrpBlockT>();
        }
        return this.instrmtScope;
    }

}
