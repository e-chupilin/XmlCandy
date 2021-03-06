//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.03 at 01:00:44 AM MSK 
//


package com.example.candy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.example.ingredient.IngredientType;


/**
 * <p>Java class for candyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="candyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="caloric-value">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="10000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="type">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="CHOCOLATE"/>
 *               &lt;enumeration value="IRIS"/>
 *               &lt;enumeration value="CARAMEL"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ingredients" type="{http://www.example.com/ingredient}ingredientType"/>
 *         &lt;element name="nutritional-value">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="proteins" type="{http://www.example.com/candy}nutritionalType"/>
 *                   &lt;element name="fats" type="{http://www.example.com/candy}nutritionalType"/>
 *                   &lt;element name="carbohydrates" type="{http://www.example.com/candy}nutritionalType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="venture-manufacturer">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="([1-9]|[A-Z]).*"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "candyType", propOrder = {
    "name",
    "caloricValue",
    "type",
    "ingredients",
    "nutritionalValue",
    "ventureManufacturer"
})
public class CandyType {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(name = "caloric-value")
    protected int caloricValue;
    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected IngredientType ingredients;
    @XmlElement(name = "nutritional-value", required = true)
    protected CandyType.NutritionalValue nutritionalValue;
    @XmlElement(name = "venture-manufacturer", required = true)
    protected String ventureManufacturer;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the caloricValue property.
     * 
     */
    public int getCaloricValue() {
        return caloricValue;
    }

    /**
     * Sets the value of the caloricValue property.
     * 
     */
    public void setCaloricValue(int value) {
        this.caloricValue = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the ingredients property.
     * 
     * @return
     *     possible object is
     *     {@link IngredientType }
     *     
     */
    public IngredientType getIngredients() {
        return ingredients;
    }

    /**
     * Sets the value of the ingredients property.
     * 
     * @param value
     *     allowed object is
     *     {@link IngredientType }
     *     
     */
    public void setIngredients(IngredientType value) {
        this.ingredients = value;
    }

    /**
     * Gets the value of the nutritionalValue property.
     * 
     * @return
     *     possible object is
     *     {@link CandyType.NutritionalValue }
     *     
     */
    public CandyType.NutritionalValue getNutritionalValue() {
        return nutritionalValue;
    }

    /**
     * Sets the value of the nutritionalValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link CandyType.NutritionalValue }
     *     
     */
    public void setNutritionalValue(CandyType.NutritionalValue value) {
        this.nutritionalValue = value;
    }

    /**
     * Gets the value of the ventureManufacturer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVentureManufacturer() {
        return ventureManufacturer;
    }

    /**
     * Sets the value of the ventureManufacturer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVentureManufacturer(String value) {
        this.ventureManufacturer = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="proteins" type="{http://www.example.com/candy}nutritionalType"/>
     *         &lt;element name="fats" type="{http://www.example.com/candy}nutritionalType"/>
     *         &lt;element name="carbohydrates" type="{http://www.example.com/candy}nutritionalType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "proteins",
        "fats",
        "carbohydrates"
    })
    public static class NutritionalValue {

        @XmlElement(required = true)
        protected String proteins;
        @XmlElement(required = true)
        protected String fats;
        @XmlElement(required = true)
        protected String carbohydrates;

        /**
         * Gets the value of the proteins property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProteins() {
            return proteins;
        }

        /**
         * Sets the value of the proteins property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProteins(String value) {
            this.proteins = value;
        }

        /**
         * Gets the value of the fats property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFats() {
            return fats;
        }

        /**
         * Sets the value of the fats property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFats(String value) {
            this.fats = value;
        }

        /**
         * Gets the value of the carbohydrates property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCarbohydrates() {
            return carbohydrates;
        }

        /**
         * Sets the value of the carbohydrates property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCarbohydrates(String value) {
            this.carbohydrates = value;
        }

    }

}
