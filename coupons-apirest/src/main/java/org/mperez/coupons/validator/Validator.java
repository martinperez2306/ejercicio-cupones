package org.mperez.coupons.validator;

import java.util.List;

/**
 * Mediante esta interfaz se validan que las entidades cumplan un cierto
 * conjunto de reglas o que posean todos los datos necesarios.
 * 
 * Cada Validador conoce las reglas que los objetos deben cumplir y los datos
 * que deben poseer.
 * 
 * Un Validador puede delegar la validacion a otros validadores en caso de que
 * no conozca todas las validaciones que la entidad debe cumplir
 * 
 * @author Martin Nicolas Perez
 *
 * @param <T>
 */
public interface Validator<T> {

	public List<ValidationError> validate(T data);

}
