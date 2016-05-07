package br.com.spd.transformer.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.spd.domain.Domain;
import br.com.spd.exception.TransformerException;
import br.com.spd.model.Model;
import br.com.spd.transformer.Transformer;

public abstract class AbstractTransformer implements Transformer {

	@Override
	public void transform(Object objectFrom, Object objectTo) throws TransformerException{
		try {
			
			Class<?> clazzTo = getClass(objectTo);
	        Class<?> clazzFrom = getClass(objectFrom);
	
	        for (Field fieldFrom : getAllFields(clazzFrom)) {
	            fieldFrom.setAccessible(true);
	            if(!Modifier.isStatic(fieldFrom.getModifiers())) {
		            for (Field fieldTo : getAllFields(clazzTo)) {
		                fieldTo.setAccessible(true);
		                if(isSettable(fieldFrom, fieldTo)) {
			                if (fieldTo.getName().equals(fieldFrom.getName())) {
			                    Object fieldFromObject = convertObjectToSameTypeIfNecessary(fieldTo, fieldFrom,
			                            objectFrom);
			                    transformObjectType(objectTo, fieldTo,
			                            fieldFromObject);
			                }
		                }
		            }
	            }
	        }
	        
		} catch(IllegalArgumentException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
			throw new TransformerException("Houve um erro inesperado ao retornar os dados", e);
		}
    }

	private void setToObject(Object objectTo, Field fieldTo, Object fieldFromObject)
			throws IllegalArgumentException, IllegalAccessException {
		fieldTo.set(objectTo, fieldFromObject);
	}

	private void transformObjectType(Object objectTo, Field fieldTo, Object fieldFromObject)
			throws IllegalArgumentException, IllegalAccessException, InstantiationException, InvocationTargetException, TransformerException {
		if (isDomainOrModel(fieldTo.getType())) {

			setTransformedObjectIfNotNull(objectTo, fieldTo, fieldFromObject);

		} else {
			setToObject(objectTo, fieldTo, fieldFromObject);
		}
	}

	private boolean isDomainOrModel(Class<?> clazz) {
		return isDomain(clazz) || isModel(clazz);
	}

	private boolean isModel(Class<?> clazz) {
		return Model.class.isAssignableFrom(clazz);
	}

	private boolean isDomain(Class<?> clazz) {
		return Domain.class.isAssignableFrom(clazz);
	}

	private void setTransformedObjectIfNotNull(Object objectTo, Field fieldTo, Object fieldFromObject)
			throws IllegalAccessException, InvocationTargetException, TransformerException {
		if (!isNull(fieldFromObject)) {
			try {
				Object objTo = createNewInstanceIfObjectIsNull(objectTo, fieldTo);

				if (objTo != null) {
					transform(fieldFromObject, objTo);
				} else {
					setToObject(objectTo, fieldTo, objTo);
				}
			} catch (InstantiationException ie) {
				setToObject(objectTo, fieldTo, null);
			}
		}
	}

	private Object createNewInstanceIfObjectIsNull(Object objectTo, Field fieldTo)
			throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
		Object fieldToObject = fieldTo.get(objectTo);
		if (fieldToObject == null) {
			Constructor<?> constructor = fieldTo.getType().getConstructors()[0];
			fieldToObject = constructor.newInstance();
			setToObject(objectTo, fieldTo, fieldToObject);
		}
		return fieldToObject;
	}

	private Field[] getAllFields(Class<?> clazz) {
		List<Field> fields = new ArrayList<Field>();
		fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
		if (clazz.getSuperclass() != null) {
			fields.addAll(Arrays.asList(getAllFields(clazz.getSuperclass())));
		}
		return fields.toArray(new Field[] {});
	}

	private Object convertObjectToDateTimeIfNecessary(Field fieldTo, Object stObject) {
		if (fieldTo.getType().getName().equals("org.joda.time.DateTime") && stObject != null) {
			stObject = new org.joda.time.DateTime(Long.parseLong((String) stObject));
		}
		return stObject;
	}

	private Object convertObjectIfNecessary(String className, Object value) {
		Class<?> clazz;

		Object convertedObject = null;

		try {
			clazz = Class.forName(className);

			Constructor<?> cons = clazz.getConstructor(new Class<?>[] { value.getClass() });

			convertedObject = cons.newInstance(new Object[] { value });

		} catch (Exception e) {
			convertedObject = null;
		}

		return convertedObject;
	}

	private Object convertObjectToSameTypeIfNecessary(Field fieldTo, Field fieldFrom, Object objectFrom)
			throws IllegalArgumentException, IllegalAccessException {
		Object actualObject = null;
		Object convertedObject = null;

		actualObject = fieldFrom.get(objectFrom);
		if (!isSameType(fieldTo, fieldFrom)) {
			convertedObject = convertToSameTypeIfNecessary(fieldTo, actualObject);
		}

		return convertedObject == null ? actualObject : convertedObject;
	}

	private Object convertToSameTypeIfNecessary(Field fieldTo, Object actualObject) {
		Object convertedObject = null;
		convertedObject = convertObjectIfNecessary(fieldTo.getType().getName(), actualObject);
		if (isNull(convertedObject)) {
			convertedObject = convertObjectToDateTimeIfNecessary(fieldTo, actualObject);
		}
		return convertedObject;
	}

	private boolean isNull(Object object) {
		return object == null;
	}

	private Class<?> getClass(Object object) {
		return object.getClass();
	}

	private boolean isSameType(Field fieldTo, Field fieldFrom) {
		return fieldTo.getType().equals(fieldFrom.getType());
	}

	private boolean isSettable(Field fieldFrom, Field fieldTo) {
		return !Modifier.isStatic(fieldFrom.getModifiers()) && !isEnums(fieldFrom, fieldTo);
	}

	private boolean isEnums(Field... fields) {
		boolean isEnum = false;
		for (Field f : fields) {
			if (isEnum(f)) {
				isEnum = true;
			}
		}
		return isEnum;
	}

	private boolean isEnum(Field f) {
		return f.getType().isEnum();
	}

}