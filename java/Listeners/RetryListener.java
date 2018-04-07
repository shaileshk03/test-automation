package Listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation arg0, Class testClass,
			Constructor testConstructor, Method testMethod) {
		
		IRetryAnalyzer retry = arg0.getRetryAnalyzer();	
		if(retry == null){
		arg0.setRetryAnalyzer(Retry.class);
		}
	}

}
