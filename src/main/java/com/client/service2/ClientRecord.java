package com.client.service2;

/**
 * Created by a.bogdanov on 09.09.2016.
 * Объект однозначно идентифицирующий клиента (пользователя мессенджера)
 */
public class ClientRecord {

	final String name;
	final String surname;

	/**
	 * Объект однозначно идентифицирующий клиента (пользователя мессенджера)
	 * @param _name имя
	 * @param _surname фамилия
	 */
	public ClientRecord(String _name, String _surname) {
		name = _name;
		surname = _surname;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ClientRecord)) return false;

		ClientRecord that = (ClientRecord) o;
		return !(name != null ? !name.equals(that.name) : that.name != null) && !(surname != null ? !surname.equals(that.surname) : that.surname != null);
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (surname != null ? surname.hashCode() : 0);
		return result;
	}

}
