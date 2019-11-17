package com.jacek.projekt.validators;

import com.jacek.projekt.product.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class NewProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> cls) {
        return Product.class.equals(cls);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Product p = (Product) obj;

        ValidationUtils.rejectIfEmpty(errors, "name", "error.productName.empty");
        ValidationUtils.rejectIfEmpty(errors, "price_per_pack", "error.pricePerPack.empty");
        ValidationUtils.rejectIfEmpty(errors, "quantity_per_pack", "error.quantityPerPack.empty");
        ValidationUtils.rejectIfEmpty(errors, "description", "error.description.empty");
    }
}
