package util;

public enum DB_DataTypes
{
	A("BIT"),B("TINYINT"),C("SMALLINT"),D("INT"),E("REAL"),F("BIGINT"),
	G("FLOAT"),H("NCHAR"),I("NVARCHAR"),J("BINARY"),K("VARBINARY"),
	L("UNIQUEIDENTIFIER"),M("CHAR"),N("VARCHAR"),O("DATE"),P("NUMERIC"),
	Q("DECIMAL"),R("MONEY"),S("SMALLMONEY"),T("SMALLDATETIME"),
	U("DATETIME"),V("DATETIME2");
	
	private final String value;
	
	DB_DataTypes(String value)
	{
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}
}
