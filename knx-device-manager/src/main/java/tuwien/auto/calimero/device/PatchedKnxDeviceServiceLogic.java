package tuwien.auto.calimero.device;

import tuwien.auto.calimero.ReturnCode;
import tuwien.auto.calimero.device.KnxDevice.Memory;

/**
 * Only needed to give access to the device memory to subclasses and overwrite readMemory().
 */
public abstract class PatchedKnxDeviceServiceLogic extends KnxDeviceServiceLogic {

	protected Memory getMemory() {
		return device.deviceMemory();
	}

	protected byte[] getMemoryBytes() {
		return device.deviceMemory().get(0, device.deviceMemory().size() - 1);
	}

	/*
	 * The method from the super class doesn't return the last written memory to the
	 * groupAddressTable but constructs it from the datapoint model instead. This will break the
	 * programming process.
	 */
	@Override
	public ServiceResult<byte[]> readMemory(final int startAddress, final int bytes) {
		final Memory memory = device.deviceMemory();
		if (startAddress >= memory.size()) return ServiceResult.error(ReturnCode.AddressVoid);
		if (startAddress + bytes >= memory.size())
			return ServiceResult.error(ReturnCode.AccessDenied);

		return new ServiceResult<byte[]>(memory.get(startAddress, bytes));
	}
}
