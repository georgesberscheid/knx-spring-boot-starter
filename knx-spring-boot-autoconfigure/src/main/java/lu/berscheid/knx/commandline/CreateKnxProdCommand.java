package lu.berscheid.knx.commandline;

import java.util.List;

import org.springframework.stereotype.Component;

import com.github.rvesse.airline.annotations.Command;
import com.github.rvesse.airline.annotations.Option;

import lombok.extern.slf4j.Slf4j;
import lu.berscheid.knx.generator.KnxProductGenerator;
import lu.berscheid.knx.model.KnxDeviceConfig;

@Component
@Slf4j
@Command(name = "createKnxProd", description = "Create .knxprod files from the device configurations")
public class CreateKnxProdCommand implements KnxRunnable {

	@Option(name = { "-o", "--output" },
			description = "Set the output folder for the product file(s). Defaults to ${user.home}\\.knx")
	private String outputDir = System.getProperty("user.home") + "\\.knx\\";

	@Option(name = { "-e", "--etsDir" },
			description = "Set the ETS4|5 installation directory. Defaults to { C:\\Program Files (x86)\\ETS4, C:\\Program Files (x86)\\ETS5\\CV\\4.0.1997.50261 }")
	private String[] etsDirs = { "C:\\Program Files (x86)\\ETS5\\CV\\4.0.1997.50261", "C:\\Program Files (x86)\\ETS4" };

	@Option(name = { "-t", "--tempDir" },
			description = "Set the folder for temporary files during product file creation. Defaults to ${java.io.tmpdir}\\knx-product-generator")
	private String tempDir = System.getProperty("java.io.tmpdir") + "knx-product-generator";

	@Override
	public void run(List<KnxDeviceConfig> configs) {
		KnxProductGenerator generator = new KnxProductGenerator(outputDir, etsDirs, tempDir);
		for (KnxDeviceConfig config : configs) {
			try {
				generator.createProductFile(config);
			} catch (Exception e) {
				log.error("Product file generation failed: " + e.getMessage(), e);
			}
		}
	}
}
