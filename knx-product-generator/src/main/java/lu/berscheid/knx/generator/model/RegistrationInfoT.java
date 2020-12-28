package lu.berscheid.knx.generator.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegistrationInfo_t")
@Data
public class RegistrationInfoT {

	@XmlAttribute(name = "RegistrationStatus", required = true)
	protected RegistrationStatusT registrationStatus;
	@XmlAttribute(name = "RegistrationNumber")
	protected String registrationNumber;
	@XmlAttribute(name = "OriginalRegistrationNumber")
	protected String originalRegistrationNumber;
	@XmlAttribute(name = "RegistrationDate")
	@XmlSchemaType(name = "date")
	protected XMLGregorianCalendar registrationDate;
	@XmlAttribute(name = "RegistrationSignature")
	protected byte[] registrationSignature;
	@XmlAttribute(name = "RegistrationKey")
	protected String registrationKey;
}
