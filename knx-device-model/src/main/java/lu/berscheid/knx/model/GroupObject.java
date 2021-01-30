package lu.berscheid.knx.model;

import java.util.Collection;

public interface GroupObject<T> {

	public void write(T value) throws KnxException;

	public T read() throws KnxException;

	public T getValue();

	public void setValue(T value);

	public Collection<String> getGroupAddresses();
}
