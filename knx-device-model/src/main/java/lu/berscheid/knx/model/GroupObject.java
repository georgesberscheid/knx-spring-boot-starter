package lu.berscheid.knx.model;

public interface GroupObject<T> {

	public void write(T value) throws KnxException;

	public T getValue();

	public void setValue(T value);
}
