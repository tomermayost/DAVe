//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.02 at 05:29:10 PM CET 
//


package com.opnfi.risk.model.jaxb;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for PartyRiskLimitsUpdateGrp_Block_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PartyRiskLimitsUpdateGrp_Block_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{}PartyRiskLimitsUpdateGrpElements"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}PartyRiskLimitsUpdateGrpAttributes"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartyRiskLimitsUpdateGrp_Block_t", propOrder = {
    "ptyDetl",
    "riskLmt"
})
public class PartyRiskLimitsUpdateGrpBlockT {

    @XmlElement(name = "PtyDetl")
    protected List<PartyDetailGrpBlockT> ptyDetl;
    @XmlElement(name = "RiskLmt")
    protected List<RiskLimitsGrpBlockT> riskLmt;
    @XmlAttribute(name = "ListUpdActn")
    protected ListUpdateActionEnumT listUpdActn;
    @XmlAttribute(name = "ID")
    protected String id;

    /**
     * Gets the value of the ptyDetl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ptyDetl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPtyDetl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartyDetailGrpBlockT }
     * 
     * 
     */
    public List<PartyDetailGrpBlockT> getPtyDetl() {
        if (ptyDetl == null) {
            ptyDetl = new ArrayList<PartyDetailGrpBlockT>();
        }
        return this.ptyDetl;
    }

    /**
     * Gets the value of the riskLmt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the riskLmt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRiskLmt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RiskLimitsGrpBlockT }
     * 
     * 
     */
    public List<RiskLimitsGrpBlockT> getRiskLmt() {
        if (riskLmt == null) {
            riskLmt = new ArrayList<RiskLimitsGrpBlockT>();
        }
        return this.riskLmt;
    }

    /**
     * Gets the value of the listUpdActn property.
     * 
     * @return
     *     possible object is
     *     {@link ListUpdateActionEnumT }
     *     
     */
    public ListUpdateActionEnumT getListUpdActn() {
        return listUpdActn;
    }

    /**
     * Sets the value of the listUpdActn property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListUpdateActionEnumT }
     *     
     */
    public void setListUpdActn(ListUpdateActionEnumT value) {
        this.listUpdActn = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

}
