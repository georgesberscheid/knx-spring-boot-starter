package lu.berscheid.knx.device.sonos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;
//import lu.berscheid.knx.annotations.KnxDevice;

@Slf4j
@SpringBootApplication
@EnableFeignClients
// @KnxDevice(productName = "Sonos",
// hardwareName = "Sonos virtual device",
// applicationName = "Sonos Control",
// applicationVersion = 25,
// applicationNumber = 25,
// hardwareSerialNumber = "HW0001",
// productOrderNumber = "PO0001")
public class SonosDevice {

	public static void main(String[] args) {
		SpringApplication.run(SonosDevice.class, args);
	}

}
