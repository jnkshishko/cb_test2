package common;

import common.exceptions.ValidationException;
import owner.model.Owner;

import java.util.Arrays;
import java.util.List;

public abstract class ValidationUtils {

    public static void ifNullOrEmpty(String value, String name) throws ValidationException {
        if (value == null || value.isEmpty()) {
            throw new ValidationException(String.format("%s cannot be null or empty", name));
        }
    }

    public static boolean isOwnerExists(String fullName, Owner owner) {

        boolean result = false;
        List<String> partsOfName = Arrays.asList(fullName.split(" "));
        for (String part:partsOfName){
            if(part.equals(owner.getLastname()) || part.equals(owner.getFirstname()) || part.equals(owner.getMiddlename())){
                result = true;
            }
        }
        return result;
    }

}
