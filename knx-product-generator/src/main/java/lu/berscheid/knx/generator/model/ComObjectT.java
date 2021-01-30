package lu.berscheid.knx.generator.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComObject_t")
@XmlSeeAlso({ lu.berscheid.knx.generator.model.ModuleDefStaticT.ComObjects.ComObject.class })
@Data
public class ComObjectT {

	@XmlAttribute(name = "Id", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String id;
	@XmlAttribute(name = "Name", required = true)
	protected String name;
	@XmlAttribute(name = "Text", required = true)
	protected String text;
	@XmlAttribute(name = "Number", required = true)
	@XmlSchemaType(name = "unsignedInt")
	protected long number;
	@XmlAttribute(name = "FunctionText", required = true)
	protected String functionText;
	@XmlAttribute(name = "Priority")
	protected ComObjectPriorityT priority;
	@XmlAttribute(name = "ObjectSize", required = true)
	protected String objectSize;
	@XmlAttribute(name = "ReadFlag", required = true)
	protected EnableT readFlag;
	@XmlAttribute(name = "WriteFlag", required = true)
	protected EnableT writeFlag;
	@XmlAttribute(name = "CommunicationFlag", required = true)
	protected EnableT communicationFlag;
	@XmlAttribute(name = "TransmitFlag", required = true)
	protected EnableT transmitFlag;
	@XmlAttribute(name = "UpdateFlag", required = true)
	protected EnableT updateFlag;
	@XmlAttribute(name = "ReadOnInitFlag", required = true)
	protected EnableT readOnInitFlag;
	@XmlAttribute(name = "DatapointType")
	protected List<String> datapointType = new ArrayList<String>();
	@XmlAttribute(name = "InternalDescription")
	protected String internalDescription;
	@XmlAttribute(name = "SecurityRequired")
	protected ComObjectSecurityRequirementsT securityRequired;
	@XmlAttribute(name = "MayRead")
	protected Boolean mayRead;
	@XmlAttribute(name = "ReadFlagLocked")
	protected Boolean readFlagLocked;
	@XmlAttribute(name = "WriteFlagLocked")
	protected Boolean writeFlagLocked;
	@XmlAttribute(name = "TransmitFlagLocked")
	protected Boolean transmitFlagLocked;
	@XmlAttribute(name = "UpdateFlagLocked")
	protected Boolean updateFlagLocked;
	@XmlAttribute(name = "ReadOnInitFlagLocked")
	protected Boolean readOnInitFlagLocked;

	private EnableT toEnableT(boolean value) {
		return value ? EnableT.ENABLED : EnableT.DISABLED;
	}

	public void setCommunication(boolean flag) {
		setCommunicationFlag(toEnableT(flag));
	}

	public void setRead(boolean flag) {
		setReadFlag(toEnableT(flag));
	}

	public void setWrite(boolean flag) {
		setWriteFlag(toEnableT(flag));
	}

	public void setTransmit(boolean flag) {
		setTransmitFlag(toEnableT(flag));
	}

	public void setUpdate(boolean flag) {
		setUpdateFlag(toEnableT(flag));
	}
}