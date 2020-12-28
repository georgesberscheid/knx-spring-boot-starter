package lu.berscheid.knx.generator.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Hardware2Program_t", propOrder = { "applicationProgramRef", "registrationInfo" })
@Data
public class Hardware2ProgramT {

	@XmlElement(name = "ApplicationProgramRef")
	protected List<ApplicationProgramRefT> applicationProgramRef = new ArrayList<ApplicationProgramRefT>();

	@XmlElement(name = "RegistrationInfo")
	protected RegistrationInfoT registrationInfo;

	@XmlAttribute(name = "Id", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String id;

	@XmlAttribute(name = "MediumTypes")
	protected List<String> mediumTypes = new ArrayList<String>();

	@XmlAttribute(name = "Hash")
	protected byte[] hash;

	@XmlAttribute(name = "CheckSums")
	protected byte[] checkSums;

	@XmlAttribute(name = "LoadedImage")
	protected byte[] loadedImage;

	@XmlAttribute(name = "CouplerCapabilities")
	protected List<CouplerCapabilityT> couplerCapabilities;
}
