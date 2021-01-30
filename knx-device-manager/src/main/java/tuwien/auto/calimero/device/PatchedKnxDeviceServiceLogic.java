package tuwien.auto.calimero.device;

import java.util.Arrays;

import tuwien.auto.calimero.ReturnCode;

/**
 * Only needed to give access to the device memory to subclasses and overwrite readMemory().
 */
public abstract class PatchedKnxDeviceServiceLogic extends KnxDeviceServiceLogic {

	protected byte[] getMemory() {
		return getDeviceMemory();
	}

	/*
	 * The method from the super class doesn't return the last written memory to the
	 * groupAddressTable but constructs it from the datapoint model instead. This will break the
	 * programming process.
	 */
	@Override
	public ServiceResult readMemory(final int startAddress, final int bytes) {
		final byte[] mem = getDeviceMemory();
		if (startAddress >= mem.length) return ServiceResult.error(ReturnCode.AddressVoid);
		if (startAddress + bytes >= mem.length) return ServiceResult.error(ReturnCode.AccessDenied);

		return new ServiceResult(
				Arrays.copyOfRange(getDeviceMemory(), startAddress, startAddress + bytes));
	}
}
