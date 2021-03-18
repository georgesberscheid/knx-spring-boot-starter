package lu.berscheid.knx.generator;

import static lu.berscheid.knx.utils.KnxTypeUtils.isBoolean;
import static lu.berscheid.knx.utils.KnxTypeUtils.isEnum;
import static lu.berscheid.knx.utils.KnxTypeUtils.isFloat;
import static lu.berscheid.knx.utils.KnxTypeUtils.isDouble;
import static lu.berscheid.knx.utils.KnxTypeUtils.isInteger;
import static lu.berscheid.knx.utils.KnxTypeUtils.isString;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.FileUtils;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lu.berscheid.knx.generator.model.ApplicationProgramDynamicT;
import lu.berscheid.knx.generator.model.ApplicationProgramRefT;
import lu.berscheid.knx.generator.model.ApplicationProgramStaticT;
import lu.berscheid.knx.generator.model.ApplicationProgramStaticT.ComObjectRefs;
import lu.berscheid.knx.generator.model.ApplicationProgramStaticT.ComObjectTable;
import lu.berscheid.knx.generator.model.ApplicationProgramStaticT.Parameters.ParameterT;
import lu.berscheid.knx.generator.model.ApplicationProgramT;
import lu.berscheid.knx.generator.model.ApplicationProgramTypeT;
import lu.berscheid.knx.generator.model.CatalogSectionT;
import lu.berscheid.knx.generator.model.ChannelIndependentBlockT;
import lu.berscheid.knx.generator.model.ComObjectParameterBlockT;
import lu.berscheid.knx.generator.model.ComObjectPriorityT;
import lu.berscheid.knx.generator.model.ComObjectRefRefT;
import lu.berscheid.knx.generator.model.ComObjectRefT;
import lu.berscheid.knx.generator.model.ComObjectT;
import lu.berscheid.knx.generator.model.EnableT;
import lu.berscheid.knx.generator.model.Hardware2ProgramT;
import lu.berscheid.knx.generator.model.HardwareT;
import lu.berscheid.knx.generator.model.KNX;
import lu.berscheid.knx.generator.model.LdCtrlProcTypeT;
import lu.berscheid.knx.generator.model.LdCtrlRelSegmentT;
import lu.berscheid.knx.generator.model.LdCtrlWriteRelMemT;
import lu.berscheid.knx.generator.model.LoadProcedureStyleT;
import lu.berscheid.knx.generator.model.LoadProceduresT.LoadProcedure;
import lu.berscheid.knx.generator.model.ManufacturerDataT;
import lu.berscheid.knx.generator.model.MemoryParameterT;
import lu.berscheid.knx.generator.model.ParameterRefRefT;
import lu.berscheid.knx.generator.model.ParameterRefT;
import lu.berscheid.knx.generator.model.ParameterTypeT;
import lu.berscheid.knx.generator.model.ParameterTypeT.TypeFloat;
import lu.berscheid.knx.generator.model.ParameterTypeT.TypeNumber;
import lu.berscheid.knx.generator.model.ParameterTypeT.TypeRestriction;
import lu.berscheid.knx.generator.model.ParameterTypeT.TypeRestriction.Enumeration;
import lu.berscheid.knx.generator.model.ParameterTypeT.TypeText;
import lu.berscheid.knx.generator.model.RegistrationInfoT;
import lu.berscheid.knx.generator.model.RegistrationStatusT;
import lu.berscheid.knx.model.KnxDeviceConfig;
import lu.berscheid.knx.model.KnxGroupObjectConfig;
import lu.berscheid.knx.model.KnxParameterConfig;
import lu.berscheid.knx.model.KnxParameterTypeConfig;
import lu.berscheid.knx.utils.KnxTypeUtils;

@Slf4j
@AllArgsConstructor
public class KnxProductGenerator {

	private static final String KNX_CREATED_BY = "KNX MT";
	private static final String KNX_TOOL_VERSION = "5.1.255.16695";

	private String outputDir;
	private String[] etsDirs;
	private String tempDir;

	@SuppressWarnings("unchecked")
	public void createProductFile(KnxDeviceConfig device) throws Exception {
		KNX knx = new KNX();

		ManufacturerDataT manufacturerData = new ManufacturerDataT();
		ManufacturerDataT.Manufacturer manufacturer = new ManufacturerDataT.Manufacturer();
		manufacturerData.getManufacturer().add(manufacturer);
		knx.setManufacturerData(manufacturerData);

		ApplicationProgramT applicationProgram = new ApplicationProgramT();
		HardwareT hardware = new HardwareT();
		CatalogSectionT catalogSection = new CatalogSectionT();
		HardwareT.Products.Product product = new HardwareT.Products.Product();
		Hardware2ProgramT hardwareProgram = new Hardware2ProgramT();
		ApplicationProgramRefT applicationProgramRef = new ApplicationProgramRefT();
		CatalogSectionT.CatalogItem catalogItem = new CatalogSectionT.CatalogItem();

		manufacturer.getCatalog().getCatalogSection().add(catalogSection);
		manufacturer.getApplicationPrograms().getApplicationProgram().add(applicationProgram);
		manufacturer.getHardware().getHardware().add(hardware);
		hardware.setName(device.getHardwareName());
		hardware.setSerialNumber(device.getHardwareSerialNumber());
		hardware.setVersionNumber(device.getHardwareVersionNumber());
		hardware.getProducts().getProduct().add(product);
		hardware.getHardware2Programs().getHardware2Program().add(hardwareProgram);
		hardwareProgram.getApplicationProgramRef().add(applicationProgramRef);
		catalogSection.getCatalogItem().add(catalogItem);

		knx.setCreatedBy(KNX_CREATED_BY);
		knx.setToolVersion(KNX_TOOL_VERSION);

		manufacturer.setRefId(device.getManufacturerRefId());

		applicationProgram.setName(device.getApplicationName());
		applicationProgram.setApplicationNumber(device.getApplicationNumber());
		applicationProgram.setApplicationVersion((short) device.getApplicationVersion());
		applicationProgram.setProgramType(ApplicationProgramTypeT.APPLICATION_PROGRAM);
		applicationProgram.setMaskVersion("MV-07B0"); // for TP medium type
		applicationProgram.setLoadProcedureStyle(LoadProcedureStyleT.MERGED_PROCEDURE);
		applicationProgram.setPeiType((short) 0);
		applicationProgram.setDefaultLanguage("en");
		applicationProgram.setDynamicTableManagement(false);
		applicationProgram.setLinkable(false);
		applicationProgram.setMinEtsVersion("4.0");
		applicationProgram.setId(String.format("%s_A-%04d-%02d-0000", manufacturer.getRefId(),
				applicationProgram.getApplicationNumber(), applicationProgram.getApplicationVersion()));

		applicationProgramRef.setRefId(applicationProgram.getId());

		ApplicationProgramStaticT appStatic = new ApplicationProgramStaticT();
		applicationProgram.setAppStatic(appStatic);

		ApplicationProgramDynamicT appDynamic = new ApplicationProgramDynamicT();
		applicationProgram.setDynamic(appDynamic);

		ComObjectParameterBlockT parameterBlock = new ComObjectParameterBlockT();
		parameterBlock.setName("ParameterPage");
		parameterBlock.setText("Parameters");
		parameterBlock.setId(String.format("%s_PB-1", applicationProgram.getId()));

		ChannelIndependentBlockT channel = new ChannelIndependentBlockT();
		channel.getParameterBlocks().add(parameterBlock);
		appDynamic.getChannelIndependentBlocks().add(channel);

		ApplicationProgramStaticT.Code code = new ApplicationProgramStaticT.Code();
		appStatic.setCode(code);

		ApplicationProgramStaticT.Code.RelativeSegment codeSegment = new ApplicationProgramStaticT.Code.RelativeSegment();
		codeSegment.setName("Parameters");
		codeSegment.setOffset(0L);
		codeSegment.setLoadStateMachine((short) 4);
		codeSegment.setId(String.format("%s_RS-%02d-%05d", applicationProgram.getId(),
				codeSegment.getLoadStateMachine(), codeSegment.getOffset()));
		code.getRelativeSegment().add(codeSegment);

		ApplicationProgramStaticT.ParameterTypes parameterTypes = new ApplicationProgramStaticT.ParameterTypes();
		appStatic.setParameterTypes(parameterTypes);

		ApplicationProgramStaticT.Parameters parameters = new ApplicationProgramStaticT.Parameters();
		ApplicationProgramStaticT.ParameterRefs parameterRefs = new ApplicationProgramStaticT.ParameterRefs();
		int offset = 0;
		int size = 0;
		int count = 0;
		for (KnxParameterConfig parameterConfig : device.getParameters()) {
			count++;

			// Create a parameter type for this parameter
			KnxParameterTypeConfig typeConfig = parameterConfig.getTypeConfig();
			ParameterTypeT parameterType = new ParameterTypeT();
			parameterType.setName(String.format("PT-%d", count));
			parameterType.setId(String.format("%s_PT-%d", applicationProgram.getId(), count));
			String parameterDefaultValue = parameterConfig.getValue() != null
					? parameterConfig.getValue().toString()
					: "";
			// TODO deal with all parameter types
			if (isBoolean(parameterConfig.getType())) {
				TypeNumber typeNumber = new TypeNumber();
				typeNumber.setSizeInBit(8);
				typeNumber.setType("signedInt");
				typeNumber.setMinInclusive(0);
				typeNumber.setMaxInclusive(1);
				typeNumber.setUiHint("CheckBox");
				parameterType.setTypeNumber(typeNumber);
				parameterDefaultValue = ((boolean) parameterConfig.getValue()) ? "1" : "0";
			} else if (isInteger(parameterConfig.getType())) {
				TypeNumber typeNumber = new TypeNumber();
				typeNumber.setSizeInBit(typeConfig.getSizeInBit());
				typeNumber.setType("signedInt");
				typeNumber.setMinInclusive((long) typeConfig.getMinInclusive());
				typeNumber.setMaxInclusive((long) typeConfig.getMaxInclusive());
				parameterType.setTypeNumber(typeNumber);
			} else if (isFloat(parameterConfig.getType()) || isDouble(parameterConfig.getType())) {
				TypeFloat typeFloat = new TypeFloat();
				typeFloat.setMinInclusive(typeConfig.getMinInclusive());
				typeFloat.setMaxInclusive(typeConfig.getMaxInclusive());
				parameterType.setTypeFloat(typeFloat);
			} else if (isString(parameterConfig.getType())) {
				TypeText typeText = new TypeText();
				typeText.setSizeInBit(typeConfig.getSizeInBit());
				parameterType.setTypeText(typeText);
			} else if (isEnum(parameterConfig.getType())) {
				TypeRestriction typeRestriction = new TypeRestriction();
				typeRestriction.setBase("Value");
				typeRestriction.setSizeInBit(8);
				for (Enum<?> en : ((Class<? extends Enum<?>>) parameterConfig.getType())
						.getEnumConstants()) {
					Enumeration e = new Enumeration();
					e.setText(en.toString());
					e.setValue(en.ordinal());
					e.setId(parameterType.getId() + "_EN-" + e.getValue());
					typeRestriction.getEnumeration().add(e);
				}
				parameterType.setTypeRestriction(typeRestriction);
				parameterDefaultValue = String
						.valueOf(((Enum<?>) parameterConfig.getValue()).ordinal());
			}
			parameterTypes.getParameterType().add(parameterType);

			// Create parameters
			ParameterT parameter = new ParameterT();
			parameter.setName(parameterConfig.getName());
			parameter.setText(parameterConfig.getText());
			parameter.setValue(parameterDefaultValue);
			parameter.setParameterType(parameterType.getId());
			MemoryParameterT memoryParameter = new MemoryParameterT();
			memoryParameter.setCodeSegment(codeSegment.getId());
			memoryParameter.setOffset(offset);
			memoryParameter.setBitOffset((short) 0);
			int sizeInBytes = parameterConfig.getTypeConfig().getSizeInBit() / 8;
			offset += sizeInBytes;
			size += sizeInBytes;
			parameter.setMemory(memoryParameter);
			parameter.setId(String.format("%s_P-%d", applicationProgram.getId(), count));
			parameters.getParameter().add(parameter);

			// Create parameter references
			ParameterRefT parameterRef = new ParameterRefT();
			parameterRef.setId(String.format("%s_R-%d", parameter.getId(), count));
			parameterRef.setRefId(parameter.getId());
			parameterRefs.getParameterRef().add(parameterRef);

			// Create parameter reference references in the parameter block
			ParameterRefRefT parameterRefRef = new ParameterRefRefT();
			parameterRefRef.setRefId(parameterRef.getId());
			parameterBlock.getParameterRefRefs().add(parameterRefRef);
		}
		codeSegment.setSize(size);
		appStatic.setParameters(parameters);
		appStatic.setParameterRefs(parameterRefs);

		appStatic.setAddressTable(new ApplicationProgramStaticT.AddressTable());
		appStatic.getAddressTable().setMaxEntries(Short.MAX_VALUE);

		appStatic.setAssociationTable(new ApplicationProgramStaticT.AssociationTable());
		appStatic.getAssociationTable().setMaxEntries(Short.MAX_VALUE);

		ComObjectTable comObjectTable = new ApplicationProgramStaticT.ComObjectTable();
		ComObjectRefs comObjectRefs = new ApplicationProgramStaticT.ComObjectRefs();
		count = 1;
		for (KnxGroupObjectConfig groupObjectConfig : device.getGroupObjects()) {
			ComObjectT comObject = new ComObjectT();
			comObject.setName(groupObjectConfig.getName());
			comObject.setText(groupObjectConfig.getText());
			comObject.setFunctionText(groupObjectConfig.getFunctionText());
			comObject.setObjectSize(groupObjectConfig.getObjectSize());
			comObject.getDatapointType().add(
					KnxTypeUtils.convertDatapointTypeToKnxProd(groupObjectConfig.getDataPointType()));
			comObject.setCommunication(groupObjectConfig.isCommunicationFlag());
			comObject.setRead(groupObjectConfig.isReadFlag());
			comObject.setWrite(groupObjectConfig.isWriteFlag());
			comObject.setTransmit(groupObjectConfig.isTransmitFlag());
			comObject.setUpdate(groupObjectConfig.isUpdateFlag());
			comObject.setNumber(count++);
			comObject
					.setPriority(ComObjectPriorityT.valueOf(groupObjectConfig.getPriority().toString()));
			comObject.setReadOnInitFlag(EnableT.DISABLED);
			comObject
					.setId(String.format("%s_O-%d", applicationProgram.getId(), comObject.getNumber()));
			comObjectTable.getComObject().add(comObject);

			ComObjectRefT comObjectRef = new ComObjectRefT();
			comObjectRef.setId(String.format("%s_R-%d", comObject.getId(), comObject.getNumber()));
			comObjectRef.setRefId(comObject.getId());
			comObjectRefs.getComObjectRef().add(comObjectRef);

			ComObjectRefRefT comObjectRefRef = new ComObjectRefRefT();
			comObjectRefRef.setRefId(comObjectRef.getId());
			parameterBlock.getComObjectRefRefs().add(comObjectRefRef);
		}

		appStatic.setComObjectTable(comObjectTable);
		appStatic.setComObjectRefs(comObjectRefs);

		appStatic.setOptions(new ApplicationProgramStaticT.Options());

		hardware.setHasIndividualAddress(true);
		hardware.setHasApplicationProgram(true);
		hardware.setIsIPEnabled(Boolean.TRUE);
		hardware.setBusCurrent(null); // IP
		hardware.setSerialNumber(device.getHardwareSerialNumber());
		hardware.setVersionNumber(device.getHardwareVersionNumber());
		hardware.setId(String.format("%s_H-%s-%d", manufacturer.getRefId(),
				hardware.getSerialNumber(), hardware.getVersionNumber()));

		product.setText(device.getProductName());
		product.setRailMounted(false);
		product.setDefaultLanguage("en");
		product.setOrderNumber(device.getProductOrderNumber());
		RegistrationInfoT productRegistrationInfo = new RegistrationInfoT();
		productRegistrationInfo.setRegistrationStatus(RegistrationStatusT.REGISTERED);
		product.setRegistrationInfo(productRegistrationInfo);
		product.setId(String.format("%s_P-%s", hardware.getId(), product.getOrderNumber()));

		hardwareProgram.getMediumTypes().add("MT-0"); // Medium type TP
		hardwareProgram.getMediumTypes().add("MT-5"); // Medium type IP
		RegistrationInfoT hardwareRegistrationInfo = new RegistrationInfoT();
		hardwareRegistrationInfo.setRegistrationStatus(RegistrationStatusT.REGISTERED);
		hardwareRegistrationInfo.setRegistrationNumber(
				"0001/" + hardware.getVersionNumber() + applicationProgram.getApplicationVersion());
		hardwareProgram.setRegistrationInfo(hardwareRegistrationInfo);
		hardwareProgram.setId(String.format("%s_HP-%04d-%02d-0000", hardware.getId(),
				applicationProgram.getApplicationNumber(), applicationProgram.getApplicationVersion()));

		catalogSection.setName("Devices");
		catalogSection.setNumber("1");
		catalogSection.setDefaultLanguage("en");
		catalogSection
				.setId(String.format("%s_CS-%s", manufacturer.getRefId(), catalogSection.getNumber()));

		catalogItem.setName(device.getProductName());
		catalogItem.setNumber(1);
		catalogItem.setProductRefId(product.getId());
		catalogItem.setHardware2ProgramRefId(hardwareProgram.getId());
		catalogItem.setDefaultLanguage("en");
		catalogItem.setId(String.format("%s_CI-%s-%d", hardwareProgram.getId(),
				product.getOrderNumber(), catalogItem.getNumber()));

		// Create load procedures
		LoadProcedure loadProcedure1 = new LoadProcedure();
		loadProcedure1.setMergeId((short) 2);

		LdCtrlRelSegmentT ldCtrlRelSegment = new LdCtrlRelSegmentT();
		ldCtrlRelSegment.setLsmIdx((short) 4);
		ldCtrlRelSegment.setMode((short) 0);
		ldCtrlRelSegment.setFill((short) 0);
		ldCtrlRelSegment.setAppliesTo(LdCtrlProcTypeT.FULL);
		ldCtrlRelSegment.setSize(codeSegment.getSize());
		loadProcedure1.getLdCtrlRelSegment().add(ldCtrlRelSegment);

		LoadProcedure loadProcedure2 = new LoadProcedure();
		loadProcedure2.setMergeId((short) 4);

		LdCtrlWriteRelMemT ldCtrlWriteRelMem = new LdCtrlWriteRelMemT();
		ldCtrlWriteRelMem.setObjIdx((short) 4);
		ldCtrlWriteRelMem.setOffset(0);
		ldCtrlWriteRelMem.setVerify(true);
		ldCtrlWriteRelMem.setSize(codeSegment.getSize());
		loadProcedure2.getLdCtrlWriteRelMem().add(ldCtrlWriteRelMem);

		appStatic.getLoadProcedures().getLoadProcedure().add(loadProcedure1);
		appStatic.getLoadProcedures().getLoadProcedure().add(loadProcedure2);

		String knxProductDirectory = outputDir + device.getHardwareName() + "\\";
		String knxProductFilename = hardware.getId() + ".xml";

		// Check if we already have a previous version of the KNX product file. If we
		// do, create a backup and increment the applicationNumber.
		File knxProductFile = new File(knxProductDirectory + knxProductFilename);
		if (knxProductFile.exists()) {
			log.info("Previous product file found at " + knxProductDirectory + knxProductFilename);
			JAXBContext context = JAXBContext.newInstance(KNX.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			KNX oldKnx = (KNX) unmarshaller.unmarshal(knxProductFile);
			if (oldKnx.equals(knx)) {
				log.info(
						"Product file has remained unchanged. Doing nothing. If you still want to regenerate the "
								+ ".knxprod file, consider deleting " + knxProductDirectory
								+ knxProductFilename);
				return;
			} else {
				int oldApplicationNumber = oldKnx.getManufacturerData().getManufacturer().get(0)
						.getApplicationPrograms().getApplicationProgram().get(0).getApplicationNumber();
				int newApplicationNumber = knx.getManufacturerData().getManufacturer().get(0)
						.getApplicationPrograms().getApplicationProgram().get(0).getApplicationNumber();
				if (oldApplicationNumber == newApplicationNumber) {
					// If both application numbers are the same, increment the new one
					knx.getManufacturerData().getManufacturer().get(0).getApplicationPrograms()
							.getApplicationProgram().get(0).setApplicationNumber(newApplicationNumber + 1);
				}
				// Create a backup of the old file
				FileUtils.moveFile(knxProductFile, new File(
						knxProductDirectory + hardware.getId() + "_v" + oldApplicationNumber + ".xml"));
			}
		}

		try {
			// Create the .xml file for the product in the default user home directory
			new File(knxProductDirectory).mkdirs();

			JAXBContext context = JAXBContext.newInstance(KNX.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			OutputStream os = new FileOutputStream(knxProductDirectory + knxProductFilename);
			marshaller.marshal(knx, os);
			os.close();

			// Sign the .xml file using the native application to turn it into a .knxprod
			// file that can be imported into ETS5.
			signProductFile(knxProductDirectory, hardware.getId());
		} catch (Exception e) {
			log.error("Unable to create product XML file " + knxProductDirectory + knxProductFilename,
					e);
		}
	}

	private void signProductFile(String knxProductDirectory, String knxProductName) {
		// Before we can do any signing, we need the native application to be extracted
		// into a temp folder so we can run it. This application will only run if it can
		// find a proper ETS5 installation on the Windows machine. We'll look into the
		// default ETS5 installation directory.

		if (System.getProperty("os.name").contains("Windows")) {
			String etsDirectory = null;
			for (String dir : etsDirs) {
				File d = new File(dir);
				if (d.exists() && d.isDirectory()) {
					etsDirectory = dir;
					break;
				}
			}

			if (etsDirectory == null) {
				log.error("Unable to find an ETS5 installation in " + etsDirs
						+ ". Cannot sign the product file.");
				return;
			}

			// Unpack the native application into the default temporary folder.
			String tempFolder = tempDir + "\\";
			new File(tempFolder).mkdirs();

			String[] filesToCopy = { "KnxProdSigner.exe", "KnxProdSigner.exe.config" };
			try {
				for (String file : filesToCopy) {
					Files.copy(KnxProductGenerator.class.getResourceAsStream("/bin/" + file),
							Paths.get(tempFolder + file), StandardCopyOption.REPLACE_EXISTING);
				}
			} catch (IOException e) {
				log.error("Unable to unpack native signing application to " + tempFolder, e);
				return;
			}

			// Now sign the file
			try {
				String inputFile = knxProductDirectory + knxProductName + ".xml";
				String outputFile = knxProductDirectory + knxProductName + ".knxprod";
				log.debug("Calling " + tempFolder + "\\KnxProdSigner.exe " + etsDirectory + " "
						+ outputFile + " " + inputFile);
				Process process = new ProcessBuilder().directory(new File(tempFolder))
						.command(tempFolder + "\\KnxProdSigner.exe", etsDirectory, outputFile, inputFile)
						.redirectErrorStream(true).inheritIO().start();
				if (process.waitFor(10, TimeUnit.SECONDS)) {
					if (process.exitValue() == 0) {
						log.info("KNX Product file written to " + outputFile);
					} else {
						log.error("Unable to write the KNX output file to " + outputFile
								+ ". Process exited with error " + process.exitValue());
					}
				}
			} catch (IOException | InterruptedException e) {
				log.error("Signing process failed: " + e.getMessage(), e);
			} finally {
				try {
					FileUtils.deleteDirectory(new File(tempFolder));
				} catch (IOException e) {
					log.warn("Unable to delete temporary folder" + tempFolder);
				}
			}
		} else {
			log.error(
					"Signing a product file needs a proper installation of ETS5 to be found. ETS5 is not available on "
							+ System.getProperty("os.name"));
		}
	}
}
