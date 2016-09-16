//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.02 at 05:29:10 PM CET 
//


package com.deutscheboerse.risk.dave.model.jaxb;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * PartyRiskLimitsRequest can be found in Volume 3 of the
 * 						specification
 * 
 * <p>Java class for PartyRiskLimitsRequest_message_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PartyRiskLimitsRequest_message_t">
 *   &lt;complexContent>
 *     &lt;extension base="{}Abstract_message_t">
 *       &lt;sequence>
 *         &lt;group ref="{}PartyRiskLimitsRequestElements"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}PartyRiskLimitsRequestAttributes"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartyRiskLimitsRequest_message_t", propOrder = {
    "reqPty",
    "pty",
    "reqR",
    "reqRiskLmtTyp",
    "instrmtScope"
})
public class PartyRiskLimitsRequestMessageT
    extends AbstractMessageT
{

    @XmlElement(name = "ReqPty")
    protected List<RequestingPartyGrpBlockT> reqPty;
    @XmlElement(name = "Pty")
    protected List<PartiesBlockT> pty;
    @XmlElement(name = "ReqR")
    protected List<RequestedPartyRoleGrpBlockT> reqR;
    @XmlElement(name = "ReqRiskLmtTyp")
    protected List<RequestedRiskLimitTypesGrpBlockT> reqRiskLmtTyp;
    @XmlElement(name = "InstrmtScope")
    protected List<RiskInstrumentScopeGrpBlockT> instrmtScope;
    @XmlAttribute(name = "ReqID", required = true)
    protected String reqID;
    @XmlAttribute(name = "ReqTyp")
    protected BigInteger reqTyp;
    @XmlAttribute(name = "SubReqTyp")
    protected String subReqTyp;
    @XmlAttribute(name = "Txt")
    protected String txt;

    /**
     * Gets the value of the reqPty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reqPty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReqPty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RequestingPartyGrpBlockT }
     * 
     * 
     */
    public List<RequestingPartyGrpBlockT> getReqPty() {
        if (reqPty == null) {
            reqPty = new ArrayList<RequestingPartyGrpBlockT>();
        }
        return this.reqPty;
    }

    /**
     * Gets the value of the pty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartiesBlockT }
     * 
     * 
     */
    public List<PartiesBlockT> getPty() {
        if (pty == null) {
            pty = new ArrayList<PartiesBlockT>();
        }
        return this.pty;
    }

    /**
     * Gets the value of the reqR property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reqR property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReqR().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RequestedPartyRoleGrpBlockT }
     * 
     * 
     */
    public List<RequestedPartyRoleGrpBlockT> getReqR() {
        if (reqR == null) {
            reqR = new ArrayList<RequestedPartyRoleGrpBlockT>();
        }
        return this.reqR;
    }

    /**
     * Gets the value of the reqRiskLmtTyp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reqRiskLmtTyp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReqRiskLmtTyp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RequestedRiskLimitTypesGrpBlockT }
     * 
     * 
     */
    public List<RequestedRiskLimitTypesGrpBlockT> getReqRiskLmtTyp() {
        if (reqRiskLmtTyp == null) {
            reqRiskLmtTyp = new ArrayList<RequestedRiskLimitTypesGrpBlockT>();
        }
        return this.reqRiskLmtTyp;
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

    /**
     * Gets the value of the reqID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReqID() {
        return reqID;
    }

    /**
     * Sets the value of the reqID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReqID(String value) {
        this.reqID = value;
    }

    /**
     * Gets the value of the reqTyp property.
     * 
     * @return
     *     possible object is
     *     {@link java.math.BigInteger }
     *
     */
    public BigInteger getReqTyp() {
        return reqTyp;
    }

    /**
     * Sets the value of the reqTyp property.
     *
     * @param value
     *     allowed object is
     *     {@link java.math.BigInteger }
     *     
     */
    public void setReqTyp(BigInteger value) {
        this.reqTyp = value;
    }

    /**
     * Gets the value of the subReqTyp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubReqTyp() {
        return subReqTyp;
    }

    /**
     * Sets the value of the subReqTyp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubReqTyp(String value) {
        this.subReqTyp = value;
    }

    /**
     * Gets the value of the txt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxt() {
        return txt;
    }

    /**
     * Sets the value of the txt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxt(String value) {
        this.txt = value;
    }

}