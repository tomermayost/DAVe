//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.02 at 05:29:10 PM CET 
//


package ers.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UnderlyingStipulations_Block_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UnderlyingStipulations_Block_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{}UnderlyingStipulationsElements"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}UnderlyingStipulationsAttributes"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnderlyingStipulations_Block_t")
public class UnderlyingStipulationsBlockT {

    @XmlAttribute(name = "Typ")
    protected StipulationTypeEnumT typ;

    /**
     * Gets the value of the typ property.
     * 
     * @return
     *     possible object is
     *     {@link StipulationTypeEnumT }
     *     
     */
    public StipulationTypeEnumT getTyp() {
        return typ;
    }

    /**
     * Sets the value of the typ property.
     * 
     * @param value
     *     allowed object is
     *     {@link StipulationTypeEnumT }
     *     
     */
    public void setTyp(StipulationTypeEnumT value) {
        this.typ = value;
    }

}