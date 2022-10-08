package runner;

import java.lang.reflect.Constructor;

public class ReflectionProvider
{
	public Class<?> getReflectionClass(String className) throws ClassNotFoundException
	{
		Class<?> cls = Class.forName(className);     //ClassName in the format package.ClassName
		return cls;
	}
	public Constructor<?> getDefaultConstructor(Class<?> cls) throws NoSuchMethodException, SecurityException
	{
		Constructor<?> defaultConst = cls.getConstructor();
		return defaultConst;
	}
}
