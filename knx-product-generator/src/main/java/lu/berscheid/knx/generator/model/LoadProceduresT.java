package lu.berscheid.knx.generator.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadProcedures_t", propOrder = { "loadProcedure" })
@Data
public class LoadProceduresT {

	@XmlElement(name = "LoadProcedure", required = true)
	protected List<LoadProceduresT.LoadProcedure> loadProcedure = new ArrayList<LoadProceduresT.LoadProcedure>();

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "")
	@Data
	@EqualsAndHashCode(callSuper = true)
	public static class LoadProcedure extends LoadProcedureT {

		@XmlAttribute(name = "MergeId")
		@XmlSchemaType(name = "unsignedByte")
		protected Short mergeId;
	}
}
