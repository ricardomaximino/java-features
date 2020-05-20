package reflection;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MethodInvocation {

    @Test
    public void class_for_name() throws Exception{
        String str = "My String";
        ContainerTest containerTest = (ContainerTest) Class.forName("reflection.ContainerTest").newInstance();
        containerTest.setObjectString(str);

        assertEquals(str, containerTest.getObjectString());

    }

    @Test
    public void invoke_method_on_one_object() throws Exception{
        String str = "Hello";
        ContainerTest containerTest = new ContainerTest();
        Method[] methods = containerTest.getClass().getMethods();
        Method strMethod = Arrays.stream(methods).filter(method -> method.getName().equals("setObjectString")).findFirst().orElseThrow(() -> new RuntimeException("method not found"));
        strMethod.invoke(containerTest,str);

        assertEquals(str, containerTest.getObjectString());
    }

    @Test
    public void invoke_method_on_one_object_and_create_the_parameter_on_the_fly_with_reflection() throws Exception{
        String str = "Hello";
        ContainerTest containerTest = new ContainerTest();
        Method[] methods = containerTest.getClass().getMethods();
        Method strMethod = Arrays.stream(methods).filter(method -> method.getName().equals("setObjectString")).findFirst().orElseThrow(() -> new RuntimeException("method not found"));
        Class[] parameters = strMethod.getParameterTypes();
        Object[] parametersObject = Arrays.stream(parameters).map(checkedExceptionWrapper(clazz -> Class.forName(clazz.getName()).newInstance())).collect(Collectors.toList()).toArray();

        strMethod.invoke(containerTest,parametersObject);

        System.out.println(containerTest.getObjectString());
        assertNotNull(containerTest.getObjectString());
    }

    @Test
    public void invoke_all_the_methods_on_one_object_and_create_the_parameters_on_the_fly_with_reflection() throws Exception{
        String str = "Hello";
        ContainerTest containerTest = new ContainerTest();
        List<Method> setMethods = Arrays.stream(containerTest.getClass().getMethods()).filter(method -> method.getName().startsWith("set") || method.getName().startsWith("is")).collect(Collectors.toList());
        setMethods.stream().forEach(method -> invokeTheMethod(containerTest, method, method.getParameterTypes().length > 0? new Object[]{defaultValue(method.getParameterTypes()[0])} : new Object[]{}));

        assertNotNull(containerTest.getObjectString());
        assertNotNull(containerTest.getObjectBoolean());
        assertNotNull(containerTest.isPrimitiveBoolean());
    }

    private void invokeTheMethod(ContainerTest containerTest, Method method, Object[] parametersObject) {
        try {
            method.invoke(containerTest, parametersObject);
        } catch (IllegalAccessException e) {
            System.err.println(method.getName());
        } catch (InvocationTargetException e) {
            System.err.println(method.getName());
        }
    }


    public <T,R> Function<T,R> checkedExceptionWrapper(CheckedFunction<T,R> checkedFunction) {
        return t -> {
            try {
                return checkedFunction.apply(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
    public Object defaultValue(Class clazz) {
        if (clazz == Boolean.TYPE) {
            return Boolean.TRUE;
        } else if (clazz == String.class) {
            return "hello";
        }
        if (clazz == Boolean.class) {
            return Boolean.TRUE;
        }else {
            return null;
        }
    }

}

@FunctionalInterface
interface CheckedFunction<T,R> {
    R apply(T t) throws Exception;
}

class ContainerTest{
    private boolean primitiveBoolean;
    private Boolean objectBoolean;
    private String objectString;

    public boolean isPrimitiveBoolean() {
        return primitiveBoolean;
    }

    public void setPrimitiveBoolean(boolean primitiveBoolean) {
        this.primitiveBoolean = primitiveBoolean;
    }

    public Boolean getObjectBoolean() {
        return objectBoolean;
    }

    public void setObjectBoolean(Boolean objectBoolean) {
        this.objectBoolean = objectBoolean;
    }

    public String getObjectString() {
        return objectString;
    }

    public void setObjectString(String objectString) {
        this.objectString = objectString;
    }


}