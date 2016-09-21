package com.client.service2;

/**
 * Created by a.bogdanov on 09.09.2016.
 * ������ ���������� ���������������� ������� (������������ �����������)
 */
public class ClientRecord {

	final String userName;
	final String botName;

	/**
	 * ������ ���������� ���������������� ������� (������������ �����������)
	 * @param _name ���
	 * @param _botName ��� ���� � �������� ������
	 */
	public ClientRecord(String _name, String _botName) {
		userName = _name;
		botName = _botName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ClientRecord)) return false;

		ClientRecord that = (ClientRecord) o;
		return !(userName != null ? !userName.equals(that.userName) : that.userName != null) && !(botName != null ? !botName.equals(that.botName) : that.botName != null);
	}

	@Override
	public int hashCode() {
		int result = userName != null ? userName.hashCode() : 0;
		result = 31 * result + (botName != null ? botName.hashCode() : 0);
		return result;
	}

}
