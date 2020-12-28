package lu.berscheid.knx.generator.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoadProcedure_t", propOrder = { "ldCtrlUnloads", "ldCtrlLoads", "ldCtrlMaxLengths",
		"ldCtrlClearCachedObjectTypes", "ldCtrlLoadCompleted", "ldCtrlAbsSegment", "ldCtrlRelSegment", "ldCtrlTaskSegment",
		"ldCtrlTaskPtr", "ldCtrlTaskCtrl1", "ldCtrlTaskCtrl2", "ldCtrlWriteProp", "ldCtrlCompareProp",
		"ldCtrlLoadImageProp", "ldCtrlInvokeFunctionProp", "ldCtrlReadFunctionProp", "ldCtrlWriteMem",
		"ldCtrlCompareMem", "ldCtrlLoadImageMem", "ldCtrlWriteRelMem", "ldCtrlCompareRelMem", "ldCtrlLoadImageRelMem",
		"ldCtrlConnect", "ldCtrlDisconnect", "ldCtrlRestart", "ldCtrlMasterReset", "ldCtrlDelay",
		"ldCtrlSetControlVariable", "ldCtrlMapError", "ldCtrlProgressText", "ldCtrlDeclarePropDesc",
		"ldCtrlClearLCFilterTable", "ldCtrlMerge", "ldCtrlBaseChoose" })
@Data
public class LoadProcedureT {

	@XmlElement(name = "LdCtrlUnload")
	protected List<LdCtrlUnloadT> ldCtrlUnloads;

	@XmlElement(name = "LdCtrlLoad")
	protected List<LdCtrlLoadT> ldCtrlLoads;

	@XmlElement(name = "LdCtrlMaxLength")
	protected List<LdCtrlMaxLengthT> ldCtrlMaxLengths;

	@XmlElement(name = "LdCtrlClearCachedObjectTypes")
	protected List<LdCtrlClearCachedObjectTypesT> ldCtrlClearCachedObjectTypes;

	@XmlElement(name = "LdCtrlLoadCompleted")
	protected List<LdCtrlLoadCompletedT> ldCtrlLoadCompleted;

	@XmlElement(name = "LdCtrlAbsSegment")
	protected List<LdCtrlAbsSegmentT> ldCtrlAbsSegment;

	@XmlElement(name = "LdCtrlRelSegment")
	protected List<LdCtrlRelSegmentT> ldCtrlRelSegment = new ArrayList<LdCtrlRelSegmentT>();

	@XmlElement(name = "LdCtrlTaskSegment")
	protected List<LdCtrlTaskSegmentT> ldCtrlTaskSegment;

	@XmlElement(name = "LdCtrlTaskPtr")
	protected List<LdCtrlTaskPtrT> ldCtrlTaskPtr;

	@XmlElement(name = "LdCtrlTaskCtrl1")
	protected List<LdCtrlTaskCtrl1T> ldCtrlTaskCtrl1;

	@XmlElement(name = "LdCtrlTaskCtrl2")
	protected List<LdCtrlTaskCtrl2T> ldCtrlTaskCtrl2;

	@XmlElement(name = "LdCtrlWriteProp")
	protected List<LdCtrlWritePropT> ldCtrlWriteProp;

	@XmlElement(name = "LdCtrlCompareProp")
	protected List<LdCtrlComparePropT> ldCtrlCompareProp;

	@XmlElement(name = "LdCtrlLoadImageProp")
	protected List<LdCtrlLoadImagePropT> ldCtrlLoadImageProp;

	@XmlElement(name = "LdCtrlInvokeFunctionProp")
	protected List<LdCtrlInvokeFunctionPropT> ldCtrlInvokeFunctionProp;

	@XmlElement(name = "LdCtrlReadFunctionProp")
	protected List<LdCtrlReadFunctionPropT> ldCtrlReadFunctionProp;

	@XmlElement(name = "LdCtrlWriteMem")
	protected List<LdCtrlWriteMemT> ldCtrlWriteMem;

	@XmlElement(name = "LdCtrlCompareMem")
	protected List<LdCtrlCompareMemT> ldCtrlCompareMem;

	@XmlElement(name = "LdCtrlLoadImageMem")
	protected List<LdCtrlLoadImageMemT> ldCtrlLoadImageMem;

	@XmlElement(name = "LdCtrlWriteRelMem")
	protected List<LdCtrlWriteRelMemT> ldCtrlWriteRelMem = new ArrayList<LdCtrlWriteRelMemT>();

	@XmlElement(name = "LdCtrlCompareRelMem")
	protected List<LdCtrlCompareRelMemT> ldCtrlCompareRelMem;

	@XmlElement(name = "LdCtrlLoadImageRelMem")
	protected List<LdCtrlLoadImageRelMemT> ldCtrlLoadImageRelMem;

	@XmlElement(name = "LdCtrlConnect")
	protected List<LdCtrlConnectT> ldCtrlConnect;

	@XmlElement(name = "LdCtrlDisconnect")
	protected List<LdCtrlDisconnectT> ldCtrlDisconnect;

	@XmlElement(name = "LdCtrlRestart")
	protected List<LdCtrlRestartT> ldCtrlRestart;

	@XmlElement(name = "LdCtrlMasterReset")
	protected List<LdCtrlMasterResetT> ldCtrlMasterReset;

	@XmlElement(name = "LdCtrlDelay")
	protected List<LdCtrlDelayT> ldCtrlDelay;

	@XmlElement(name = "LdCtrlSetControlVariable")
	protected List<LdCtrlSetControlVariableT> ldCtrlSetControlVariable;

	@XmlElement(name = "LdCtrlMapError")
	protected List<LdCtrlMapErrorT> ldCtrlMapError;

	@XmlElement(name = "LdCtrlProgressText")
	protected List<LdCtrlProgressTextT> ldCtrlProgressText;

	@XmlElement(name = "LdCtrlDeclarePropDesc")
	protected List<LdCtrlDeclarePropDescT> ldCtrlDeclarePropDesc;

	@XmlElement(name = "LdCtrlClearLCFilterTable")
	protected List<LdCtrlClearLCFilterTableT> ldCtrlClearLCFilterTable;

	@XmlElement(name = "LdCtrlMerge")
	protected List<LdCtrlMergeT> ldCtrlMerge;

	@XmlElement(name = "choose")
	protected List<LdCtrlBaseChooseT> ldCtrlBaseChoose;
}
